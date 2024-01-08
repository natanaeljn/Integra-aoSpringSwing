package com.EdgeSistemas.Teste.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.EdgeSistemas.Teste.Model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	
	List<Produto> findByNomeAllIgnoringCase(String nome);
	List<Produto> findByMarcaAllIgnoringCase(String marca);
}
