package counter;

public class Counter {
  int field;

  public Counter() {
    this.field = 0;
  }

  public Counter(int field) {
    this.field = field;
  }

  public void add(int a) {
    this.field = field + a;
  }

  public void add() {
    this.field++;
  }

  public int get() {
    return field;

  }

  public void reset() {
    this.field = 0;
  }
}
