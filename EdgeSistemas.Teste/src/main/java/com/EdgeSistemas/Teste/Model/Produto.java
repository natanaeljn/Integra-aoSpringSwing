package com.EdgeSistemas.Teste.Model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@NotNull(message = "Nome nao pode ser Nulo")
	@NotBlank(message = "Nome nao pode estar Vazio")
	private String nome;
	@NotNull(message = "Preço do produto esta Nulo")
	private Double preco;
	@NotNull(message = "Marca do produto esta Nulo")
	@NotBlank(message = "Marca nao pode estar Vazio")
	private String marca;
	
	
	public Produto(Long id,
			@NotNull(message = "Nome nao pode ser Nulo") @NotBlank(message = "Nome nao pode estar Vazio") String nome,
			@NotNull(message = "Preço do produto esta Nulo")  Double preco,
			@NotNull(message = "Marca do produto esta Nulo") @NotBlank(message = "Marca nao pode estar Vazio") String marca) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.marca = marca;
	}
	public Produto() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, marca, nome, preco);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id) && Objects.equals(marca, other.marca) && Objects.equals(nome, other.nome)
				&& Objects.equals(preco, other.preco);
	}
	
	

}
