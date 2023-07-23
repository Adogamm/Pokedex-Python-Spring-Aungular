import requests
import json

class Pokemon:

    def __init__(self) -> None:
        pass

    """
    def getPokemonList(self):
        url = "https://pokeapi.co/api/v2/pokemon/?limit=50"
        response = requests.get(url)
        raw_data = response.json()
        data = raw_data["results"]
        for pokemon in data:
            print(pokemon["name"])
    """

    def getPokemonInfo(self,pokemonId: int):
        base_url = "https://pokeapi.co/api/v2/pokemon/"
        url = f"{base_url}{pokemonId}"      
        try:
            response = requests.get(url)
            response.raise_for_status()
            data = response.json()
            
            peso = self.formatWeight(data["weight"])
            altura = self.formatHeight(data["height"])

            pokemon_data = {
                "Id" : data["id"],
                "Nombre" : data["name"].capitalize(),
                "Peso" : peso+" kgs",
                "Estatura" : altura+" mts"
            }
        except requests.exceptions.RequestException as e:
            print(f"Error al obtener el nombre del Pokémon: {e}")
            return None
        except KeyError as e:
            print(f"Error en la respuesta de la API: {e}")
            return None
        return pokemon_data

    def formatWeight(self,value: int):
        value = str(value)
        
        if(len(value) == 1):
            formatedData = "0."+value
        elif(len(value) == 2):
            formatedData = "0."+value
        elif(len(value) == 3):
            formatedData = value[:2]+"."+value[2:]
        elif(len(value) == 4):
            formatedData = value[:3]+"."+value[3:]
        
        return formatedData

    def formatHeight(self,value: int):
        value = str(value)

        if(len(value) == 1): 
            formatedData = "0."+value
        elif(len(value) == 2):
            formatedData = value[:1]+"."+value[1:]
        
        return formatedData
