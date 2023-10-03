package com.tecumseh.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.tecumseh.dao.DadosDAO;
import com.tecumseh.model.Producao;

@Service
public class ProducaoService {

	@Autowired
	private final DadosDAO dao;

	public ProducaoService(DadosDAO dao) {
		this.dao = dao;
	}

	public List<Producao> buscarPorPalavraChave(String keyword) {
		return dao.findByWorkCenterContaining(keyword);
	}
}
