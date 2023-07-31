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

import java.util.List;


@Controller
public class PokemonController {
    private final PokemonService pokemonService;
    private static final Logger log = LoggerFactory.getLogger(PokemonController.class);

    public PokemonController(PokemonService pokemonService) {
        this.pokemonService = pokemonService;
    }

    @GetMapping(value = "/", produces = "application/json")
    public String redirectToPokedex() {
        return "redirect:/pokedex";
    }


    @GetMapping(value = "/pokemon/{pokemonId}", produces = "application/json")
    public String getPokemon(@PathVariable(name = "pokemonId") int pokemonId, Model model) {
        PokemonInfo pokemonInfo = pokemonService.getPokemonInfo(pokemonId);
        model.addAttribute("pokemonInfo", pokemonInfo);
        log.info(">>>>>>>> " + pokemonInfo);
        return "pokemon";
    }
    @GetMapping(value = "/pokedex", produces = "application/json")
    public String getPokedex(@RequestParam(name = "offset", defaultValue = "0") int offset,
                             @RequestParam(name = "limit", defaultValue = "12") int limit,
                             Model model) {
        offset = Math.max(offset, 0);
        List<PokemonInfo> pokemonInfoList = pokemonService.getPokemonInfoList(offset, limit);
        model.addAttribute("pokemonInfoList", pokemonInfoList);
        model.addAttribute("offset", offset);
        model.addAttribute("limit", limit);
        return "pokedex";
    }
}
