package pokemon;

public class NoEffectivePokemonFoundException extends RuntimeException {
  @Override
  public String getMessage() {
    return "No effective pokemon found";
  }
}
