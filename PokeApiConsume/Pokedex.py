from Pokemon import Pokemon

class Pokedex:

    def __init__(self) -> None:
        # Instancia de la clase de Pokemon
        self.poke = Pokemon()

    # Obtener pokemon especifico
    def getPokemon(self,pokemonId: int):
        pokemon = self.poke.getPokemonInfo(pokemonId)
        return pokemon
