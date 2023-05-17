package br.com.fiap.pokemon.controller;

import br.com.fiap.pokemon.model.PokemonRepository;
import br.com.fiap.pokemon.model.dto.DadosAtualizacaoPokemon;
import br.com.fiap.pokemon.model.dto.DadosCadastroPokemon;
import br.com.fiap.pokemon.model.dto.DadosListagemPokemon;
import br.com.fiap.pokemon.model.entity.Pokemon;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
	
	@Autowired
	private PokemonRepository repository;
	
	@PostMapping
	@Transactional
	public void cadastrar(@RequestBody @Valid DadosCadastroPokemon dados) {
		repository.save(new Pokemon(dados));
	}
	
	@GetMapping
	public Page<DadosListagemPokemon> listar(
			@PageableDefault(size=3, sort= {"nome"}) Pageable paginacao){
		return repository.findAllByAtivoTrue(paginacao).map(DadosListagemPokemon:: new);
	}
	
	@PutMapping
	@Transactional
	public void atualizar(@RequestBody @Valid DadosAtualizacaoPokemon dados) {
		Pokemon pokemon = new Pokemon();
		pokemon = repository.getReferenceById(dados.id());
		pokemon.atualizarInformacoes(dados);
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void excluir(@PathVariable Long id) {
		Pokemon pokemon = new Pokemon();
		pokemon = repository.getReferenceById(id);
		pokemon.excluir();
	}

}










