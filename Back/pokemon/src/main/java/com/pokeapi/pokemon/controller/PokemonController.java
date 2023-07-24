package com.pokeapi.pokemon.controller;

import com.pokeapi.pokemon.PokemonInfo;
import com.pokeapi.pokemon.service.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class PokemonController {
    private final PokemonService pokemonService;
    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    /*@GetMapping(value = "/pokemon/{pokemonId}", produces = "application/json")
    public ResponseEntity<?> getPokemonInfo(@PathVariable int pokemonId) {
        PokemonInfo pokemonInfo = pokemonService.getPokemonInfo(pokemonId);
        log.info(">>>>> Obteniendo los datos del Pokemon "+pokemonId);
        if (pokemonInfo !=  null) {
            log.info("El pokemon es: "+pokemonInfo.getNombre());
            return ResponseEntity.ok(pokemonInfo);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping(value = "/pokemon", produces = "application/json")
    public String getPokemon(@RequestParam(name = "pokemonId", required = true) int pokemonId, Model model) {
        PokemonInfo pokemonInfo = pokemonService.getPokemonInfo(pokemonId);
        model.addAttribute("pokemonInfo",pokemonInfo);
        return "pokemon";
    }
}
