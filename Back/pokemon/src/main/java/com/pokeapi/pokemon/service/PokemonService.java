package com.pokeapi.pokemon.service;


import com.pokeapi.pokemon.PokemonInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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

    /*public List<PokemonInfo> getPokemonInfoList(int offset, int limit) {
        String url = POKEDEX_API+"/PokemonList/"+offset+"/"+limit;
        return Collections.singletonList(restTemplate.getForObject(url, PokemonInfo.class));
    }*/

    public List<PokemonInfo> getPokemonInfoList(int offset, int limit) {
        String url = POKEDEX_API + "/PokemonList/" + offset + "/" + limit;
        ResponseEntity<List<PokemonInfo>> responseEntity = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<PokemonInfo>>() {});
        return responseEntity.getBody();
    }

}
