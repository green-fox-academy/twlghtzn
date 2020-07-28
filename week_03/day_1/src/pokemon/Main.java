package pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
  public static void main(String[] args) {
    List<Pokemon> pokemonOfAsh = initializePokemons();

    // Every pokemon has a name and a type.
    // Certain types are effective against others, e.g. water is effective against fire.

    // Ash has a few pokemon.
    // A wild pokemon appeared!

    Pokemon wildPokemon = new Pokemon("Oddish", "leaf", "water");

    // Which pokemon should Ash use?

    try {
      Pokemon chosenPokemon = findEffectivePokemon(pokemonOfAsh, wildPokemon);
      System.out.println("I choose you, " + chosenPokemon.name);
    } catch (NoEffectivePokemonFoundException e) {
      System.out.println(e.getMessage());
    }

    Optional<Pokemon> effectivePokemon = getFirstEffectivePokemon(pokemonOfAsh, wildPokemon);
    if (effectivePokemon.isPresent()) {
      System.out.println("I choose you, " + effectivePokemon.get().name);
    } else {
      System.out.println("No effective pokemon found");
    }
  }
  private static Optional<Pokemon> getFirstEffectivePokemon(List<Pokemon> pokemonOfAsh, Pokemon wildPokemon) {
    return pokemonOfAsh.stream().filter(pokemon -> pokemon.isEffectiveAgainst(wildPokemon)).findFirst();
  }

  private static List<Pokemon> initializePokemons() {
    List<Pokemon> pokemon = new ArrayList<>();

    pokemon.add(new Pokemon("Balbasaur", "leaf", "water"));
    pokemon.add(new Pokemon("Pikatchu", "electric", "water"));
    pokemon.add(new Pokemon("Charizard", "fire", "leaf"));
    pokemon.add(new Pokemon("Balbasaur", "water", "fire"));
    pokemon.add(new Pokemon("Kingler", "water", "fire"));

    return pokemon;
  }
  private static Pokemon findEffectivePokemon(List<Pokemon> pokemons, Pokemon wildPokemon) {
    for (Pokemon pokemon : pokemons) {
      if (pokemon.isEffectiveAgainst(wildPokemon)) {
        return pokemon;
      }
    }
    throw new NoEffectivePokemonFoundException();
  }
}