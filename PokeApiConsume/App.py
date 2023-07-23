import json
from flask import Flask, jsonify
from Pokedex import Pokedex

app = Flask(__name__)

@app.route("/")
def hello_world():
    return "<p>Hello, World!</p>"

@app.route("/Pokedex/<int:pokemon_id>", methods=["GET"])
def get_pokemon(pokemon_id):
    pokedex = Pokedex()
    pokemon_info = pokedex.getPokemon(pokemon_id)
    if pokemon_info is not None:
        # Devolver la respuesta como JSON con el encabezado Content-Type adecuado
        return jsonify(pokemon_info)
    else:
        # Si no se encontró el Pokémon, devolver una respuesta con el código de estado 404
        return jsonify({"message": "No se encontró el Pokémon"}), 404

if __name__ == '__main__':
    app.run(debug=True)
