package br.com.fiap.pokemon.model.entity;

import br.com.fiap.pokemon.model.dto.DadosAtualizacaoPokemon;
import br.com.fiap.pokemon.model.dto.DadosCadastroPokemon;
import jakarta.persistence.*;

@Table(name = "pokemon")
@Entity(name = "Pokemon")
public class Pokemon {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private double altura;

	private double peso;

	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	private String habilidades;

	private Boolean ativo;
	
	public Pokemon() {}

	public Pokemon(DadosCadastroPokemon dados) {
		this.ativo = true;
		this.nome = dados.nome();
		this.altura = dados.altura();
		this.peso = dados.peso();
		this.categoria = dados.categoria();
		this.habilidades = dados.habilidades();
	}
	
	public void atualizarInformacoes(DadosAtualizacaoPokemon dados) {
		if (dados.nome() != null) {
			this.nome = dados.nome();
		}
		if (dados.altura() != 0) {
			this.altura = dados.altura();
		}
		if (dados.peso() != 0) {
			this.peso = dados.peso();
		}
		if (dados.categoria() != null) {
			this.categoria = dados.categoria();
		}
		if (dados.habilidades() != null){
			this.habilidades = dados.habilidades();
		}
	}

	public void excluir() {
		this.ativo = false;
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

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getHabilidades() {
		return habilidades;
	}

	public void setHabilidades(String habilidades) {
		this.habilidades = habilidades;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}
}
