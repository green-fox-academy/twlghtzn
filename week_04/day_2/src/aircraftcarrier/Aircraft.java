package aircraftcarrier;

public class Aircraft {
  int ammunition;
  int maxAmmo;
  int baseDamage;
  boolean isPriority;

  public Aircraft() {
    this.ammunition = 0;
  }

  public int fight() {
    int allDamage = this.baseDamage * this.ammunition;
    this.ammunition = 0;
    return allDamage;
  }

  public int refill(int availableAmmo) {
    int remainingAmmo = availableAmmo - (this.maxAmmo - this.ammunition);
    this.ammunition = this.maxAmmo;
    return remainingAmmo;
  }

  public String getType() {
    return this.getClass().getSimpleName();
  }

  public String getStatus() {
    String status = "Type " + this.getType() + ", Ammo" + this.ammunition + ", Base Damage: " +
        this.baseDamage + ", All Damage: " +
        (this.baseDamage * this.ammunition);
    return status;
  }

  public boolean isPriority() {
    return this.isPriority;
  }
}
