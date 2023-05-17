package br.com.fiap.pokemon.model.dto;

import br.com.fiap.pokemon.model.entity.Categoria;
import jakarta.validation.constraints.*;

public record DadosAtualizacaoPokemon(
		@NotNull
		Long id,

		String nome,

		@DecimalMin(value = "0.4")
		@DecimalMax(value = "9.9")
		double altura,

		@Digits(integer = 3, fraction = 1)
		double peso,
		Categoria categoria,

		String habilidades
	) {

}
