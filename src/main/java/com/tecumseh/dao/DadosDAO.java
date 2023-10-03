package com.tecumseh.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.tecumseh.model.Producao;

@Repository
public interface DadosDAO extends JpaRepository<Producao, Integer> {

	public List<Producao> findByItemContainingIgnoreCase(String item);

	List<Producao> findByWorkCenterContaining(String keyword);

}
