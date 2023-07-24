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
    private String Imagen;

    @JsonCreator
    public PokemonInfo(@JsonProperty("Id") int Id,
                       @JsonProperty("Nombre") String Nombre,
                       @JsonProperty("Peso") String Peso,
                       @JsonProperty("Estatura") String Estatura,
                       @JsonProperty("Imagen") String Imagen) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Peso = Peso;
        this.Estatura = Estatura;
        this.Imagen = Imagen;
    }
}
