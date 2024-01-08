package com.EdgeSistemas.Teste.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.EdgeSistemas.Teste.Dto.ProdutoDto;
import com.EdgeSistemas.Teste.Exception.ProdutoException;
import com.EdgeSistemas.Teste.Model.Produto;
import com.EdgeSistemas.Teste.Repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public Produto criarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}
	

	public List<ProdutoDto> listarTodos() {
		return produtoRepository.findAll().stream().map(ProdutoDto::new).toList();
	}
	

	public Produto buscarPorCodigo(Long id) {
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			Produto prod = produtoRepository.findById(id).get();
			return prod;
		} else {
			throw new ProdutoException(",Produto não encontrado com o ID: " + id);
		}
	}

	
	public Produto alterarProduto(Long idProdutoEditavel, Produto produtoEditado) {
		Optional<Produto> optionalProduto = produtoRepository.findById(idProdutoEditavel);
		if (optionalProduto.isPresent()) {
			Produto prod = produtoRepository.findById(idProdutoEditavel).get();
			prod.setNome(produtoEditado.getNome());
			prod.setPreco(produtoEditado.getPreco());
			prod.setMarca(produtoEditado.getMarca());
			produtoRepository.save(prod);
			return prod;
		} else {
			throw new ProdutoException(",Produto não encontrado com o ID: " + idProdutoEditavel);
		}
	}

	
	public String deletarProduto(Long id) {
		Optional<Produto> optionalProduto = produtoRepository.findById(id);
		if (optionalProduto.isPresent()) {
			produtoRepository.deleteById(id);
			return "deletado";
		} else {
			throw new ProdutoException(",ID Invalido , verifique novamente");
		}
	}

	
	public List<ProdutoDto> buscarPorNome(String nome) {
		if (!nome.isBlank()) {
			return produtoRepository.findByNomeAllIgnoringCase(nome).stream().map(ProdutoDto::new).toList();
		} else {
			throw new ProdutoException(",nome vazio ou nulo");
		}
	}

	
	public List<ProdutoDto> buscarPorMarca(String marca) {
		if (!marca.isBlank()) {
			return produtoRepository.findByMarcaAllIgnoringCase(marca).stream().map(ProdutoDto::new).toList();
		} else {
			throw new ProdutoException(",marca esta  vazia ou nula");
		}
	}

}
