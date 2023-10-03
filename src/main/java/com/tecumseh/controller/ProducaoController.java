package com.tecumseh.controller;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tecumseh.dao.DadosDAO;
import com.tecumseh.model.Producao;


@Controller
public class ProducaoController {

    @Autowired
    private DadosDAO dao;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/index");      
        mv.addObject("listaProducaoRG", listaProducao("RG", "RG MONTAGEM ", 10000));
        mv.addObject("listaProducaoTA", listaProducao("TA", "TA S2 MONTAGEM ", 10000));
        mv.addObject("listaProducaoAK", listaProducao("AK/TY", "AK/TY MONTAGEM ", 10000));
        mv.addObject("listaProducaoAL", listaProducao("AZ/TH S3", "AZ/TH S3 MONTAGEM ", 10000));
        mv.addObject("listaProducaoAZ", listaProducao("AZ/TH S2", "AZ/TH S2 MONTAGEM ", 10000));
        mv.addObject("listaProducaoAE", listaProducao("AE2", "AE2 MONTAGEM", 4500));
        return mv;
    }

	private List<Producao> listaProducao(String modelo, String descricao, int valorProducao) {
		List<Producao> lista = new ArrayList<>();
        Map<String, Producao> producaoMap = new LinkedHashMap<>();
	    double soma = 0;
	    for (Producao p : dao.findByWorkCenterContaining(modelo)) {
	        if (p.getWorkCenter().equals(descricao)) {
	            double valor = p.getQnt_restante();
	            soma += valor;
	            if (soma <= valorProducao) {
	                lista.add(p);
	            }
	        }
	    }
        for (Producao i : lista) {
            String item = i.getItem();
            double qntRestante = i.getQnt_restante();
            if (producaoMap.containsKey(item)) {
                Producao producaoExistente = producaoMap.get(item);
                double qntExistente = producaoExistente.getQnt_restante();
                producaoExistente.setQnt_restante(qntExistente + qntRestante);
            } else {
                producaoMap.put(item, i);
            }
        }
        return new ArrayList<>(producaoMap.values());
	}
   
}
