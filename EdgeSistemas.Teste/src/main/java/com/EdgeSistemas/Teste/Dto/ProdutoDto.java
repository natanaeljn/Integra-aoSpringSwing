package com.EdgeSistemas.Teste.Dto;

import com.EdgeSistemas.Teste.Model.Produto;

public record ProdutoDto(Long id , String nome , Double preco ,  String marca) {

	public ProdutoDto(Produto produto) {
		this(produto.getId(),produto.getNome(),produto.getPreco(),produto.getMarca());
}
}