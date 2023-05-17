package br.com.fiap.pokemon.model;

import br.com.fiap.pokemon.model.entity.Pokemon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
	
	Page<Pokemon> findAllByAtivoTrue(Pageable paginacao);

}
