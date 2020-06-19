package pl.piksaZaliczenie.Pokedex;

import org.springframework.stereotype.Repository;
import pl.piksaZaliczenie.Pokedex.Model.Pokemon;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PokemonDeck {

    private List<Pokemon> pokemons;

    public PokemonDeck() {
        this.pokemons = new ArrayList<>();
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }
}
