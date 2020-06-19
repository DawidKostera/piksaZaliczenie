package pl.piksaZaliczenie.Pokedex;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import pl.piksaZaliczenie.Pokedex.Model.Pokemon;
import pl.piksaZaliczenie.Pokedex.Model.pokemonType;

@Route
public class PokemonAdderGUI extends VerticalLayout {

    @Autowired
    public PokemonAdderGUI(PokemonDeck pokemonDeck) {

        TextField textFieldName = new TextField("name");
        TextField textFieldImage =  new TextField("image");
        ComboBox<pokemonType> pokemonTypeComboBox = new ComboBox<>("PokemonTyp:", pokemonType.values());
        Button buttonAdd = new Button("Add new Pokemon!");



        buttonAdd.addClickListener(ClickEvent ->{
        Pokemon pokemon = new Pokemon();
        pokemon.setName(textFieldName.getValue());
        pokemon.setImage(textFieldImage.getValue());
        pokemon.setPokemonType(pokemonTypeComboBox.getValue());
        pokemonDeck.getPokemons().add(pokemon);
        Notification notification = new Notification(
                "Pokemon Added !", 3000);
        notification.open();
        });


        add(textFieldName, textFieldImage, pokemonTypeComboBox, buttonAdd);
    }
}
