package com.pokeapi.pokemon;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PokemonInfo {
    private int Id;
    private String Nombre;
    private String Peso;
    private String Estatura;

    @JsonCreator
    public PokemonInfo(@JsonProperty("Id") int Id,
                       @JsonProperty("Nombre") String Nombre,
                       @JsonProperty("Peso") String Peso,
                       @JsonProperty("Estatura") String Estatura) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Peso = Peso;
        this.Estatura = Estatura;
    }
}
