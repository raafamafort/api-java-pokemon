package br.com.fiap.pokemon.model.dto;

import br.com.fiap.pokemon.model.entity.Categoria;
import br.com.fiap.pokemon.model.entity.Pokemon;

public record DadosListagemPokemon(
		Long id,
		String nome,
		Categoria categoria

	) {
	
	public DadosListagemPokemon(Pokemon pokemon) {
		this(
				pokemon.getId(),
				pokemon.getNome(),
				pokemon.getCategoria()
			);
	}

}
