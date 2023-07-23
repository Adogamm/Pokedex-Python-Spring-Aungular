import json
from flask import Flask, jsonify
from Pokedex import Pokedex

app = Flask(__name__)

# Ruta para seleccionar un pokemon especifico
@app.route("/Pokedex/<int:pokemon_id>", methods=["GET"])
def get_pokemon(pokemon_id):
    pokedex = Pokedex()
    pokemon_info = pokedex.getPokemon(pokemon_id)
    if pokemon_info is not None:
        return jsonify(pokemon_info)
    else:
        return jsonify({"message": "No se encontró el Pokémon"}), 404

if __name__ == '__main__':
    app.run(debug=True)
