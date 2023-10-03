package com.tecumseh.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.tecumseh.dao.DadosDAO;
import com.tecumseh.model.Producao;

@Controller
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    private DadosDAO dao;

    @GetMapping("/carregar")
    public ModelAndView carregar() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dados/carregar");
        mv.addObject("listaProducao", dao.findAll());
        return mv;
    }

    @PostMapping("/carregar")
    public ModelAndView carregar(@RequestParam("file") MultipartFile file) {
        ModelAndView mv = new ModelAndView();
        List<Producao> listaProducao = new ArrayList<>();

        if (!file.isEmpty()) {
            try (InputStreamReader reader = new InputStreamReader(file.getInputStream());
                 BufferedReader br = new BufferedReader(reader)) {
                String linha;
                int linhaAtual = 0;
                while ((linha = br.readLine()) != null) {
                    linhaAtual++;
                    if (linhaAtual <= 3) {
                        continue;
                    }
                    String[] dados = linha.split(";", -1);
                    if (dados.length == 13) { 
                        if ("Work Center".equals(dados[0]) || dados[0].isEmpty()) {
                            continue;
                        } else {
                            String workCenter = dados[0];
                            String porcento = dados[1];
                            String ordem = dados[2];
                            String item = dados[3];
                            String descricao = dados[4];                           
                            double qnt_original = parseDoubleWithComma(dados[5]);
                            double qnt_restante = parseDoubleWithComma(dados[6]);
                            double fgexp = parseDoubleWithComma(dados[7]);
                            double saldo_t1 = parseDoubleWithComma(dados[8]);
                            double saldo_t2 = parseDoubleWithComma(dados[9]);
                            double saldo_t3 = parseDoubleWithComma(dados[10]);
                            Producao producao = new Producao(workCenter, porcento, item, descricao, ordem, qnt_original, qnt_restante, fgexp, saldo_t1, saldo_t2, saldo_t3);
                            listaProducao.add(producao);
                        }
                    } else {
                        mv.addObject("errorMessage",
                                "Formato de arquivo inválido. Certifique-se de que o arquivo CSV tem 11 colunas separadas por vírgula.");
                        mv.setViewName("dados/carregar");
                        return mv;
                    }
                }
                dao.saveAll(listaProducao);
                mv.addObject("successMessage", "Dados carregados com sucesso.");
            } catch (Exception e) {
                mv.addObject("errorMessage", "Ocorreu um erro ao carregar os dados do arquivo.");
                e.printStackTrace();
            }
        } else {
            mv.addObject("errorMessage", "O arquivo está vazio.");
        }

        mv.setViewName("redirect:/"); 
        return mv;
    }

     private double parseDoubleWithComma(String value) {
        try {
            return Double.parseDouble(value.replace(',', '.'));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    @GetMapping("/lancamentoProducao")
    public ModelAndView lancamentoProducao(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("dados/lancamentoProducao");
        return mv;
    }


}
