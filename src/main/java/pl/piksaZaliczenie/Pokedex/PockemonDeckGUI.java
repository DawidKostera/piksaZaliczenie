package pl.piksaZaliczenie.Pokedex;

import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.piksaZaliczenie.Pokedex.Model.Pokemon;
import pl.piksaZaliczenie.Pokedex.Model.pokemonType;

import java.util.List;
import java.util.stream.Collectors;

@Route
public class PockemonDeckGUI extends VerticalLayout {

    @Autowired
    public PockemonDeckGUI(PokemonDeck pokemonDeck) {

        ComboBox<pokemonType> pokemonTypeComboBox = new ComboBox<>("PokemonTyp:", pokemonType.values());

        pokemonTypeComboBox.addValueChangeListener(click ->{
            removeAll();
            add(pokemonTypeComboBox);

            List<Pokemon> pokemons = pokemonDeck.getPokemons();
            List<Pokemon> collection = pokemons.stream().filter(pokemon -> pokemon.getPokemonType() == pokemonTypeComboBox.getValue()).collect(Collectors.toList());

            Grid<Pokemon> grid = new Grid<>(Pokemon.class);
            grid.setItems(collection);

            grid.removeColumnByKey("image");
            grid.addColumn(new ComponentRenderer<>(pokemon -> {
                Image image = new Image(pokemon.getImage(), pokemon.getImage());
                return image;
            })).setHeader("Image");

            add(grid);
        });

        add(pokemonTypeComboBox);
    }
}
