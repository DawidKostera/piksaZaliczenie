package pl.piksaZaliczenie.Pokedex.Model;

public class Pokemon {

    private String name;
    private pokemonType pokemonType;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public pl.piksaZaliczenie.Pokedex.Model.pokemonType getPokemonType() {
        return pokemonType;
    }

    public void setPokemonType(pl.piksaZaliczenie.Pokedex.Model.pokemonType pokemonType) {
        this.pokemonType = pokemonType;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}