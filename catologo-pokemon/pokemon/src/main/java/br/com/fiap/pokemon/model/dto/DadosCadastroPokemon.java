package br.com.fiap.pokemon.model.dto;

import br.com.fiap.pokemon.model.entity.Categoria;
import jakarta.validation.constraints.*;

public record DadosCadastroPokemon(
		@NotBlank 
		String nome,

		@NotNull
		@DecimalMin(value = "0.4")
		@DecimalMax(value = "9.9")
		double altura,

		@NotNull
		@Digits(integer = 3, fraction = 1)
		double peso,

		@NotNull
        Categoria categoria,

		String habilidades
	) {
}
