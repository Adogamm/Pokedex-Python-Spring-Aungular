from Pokemon import Pokemon

class Pokedex:

    def __init__(self) -> None:
        self.poke = Pokemon()

    def selectPokemon(slef):
        pokemonId = int(input("Ingrese el número de Pókemon: "))
        return pokemonId

    def getPokemon(self,pokemonId: int):
        pokemon = self.poke.getPokemonInfo(pokemonId)
        return pokemon
