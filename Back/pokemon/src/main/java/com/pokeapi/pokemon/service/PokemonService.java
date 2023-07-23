package com.pokeapi.pokemon.service;


import com.pokeapi.pokemon.PokemonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PokemonService {

    private final String POKEDEX_API = "http://localhost:5000";
    private final RestTemplate restTemplate;

    @Autowired
    public PokemonService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public PokemonInfo getPokemonInfo(int pokemonId) {
        String url = POKEDEX_API+"/Pokedex/"+pokemonId;
        return restTemplate.getForObject(url, PokemonInfo.class);
    }

}
