package com.twlghtzn.bankofsimba.models;

public class BankAccount {
  private String name;
  private double balance;
  private String animalType;
  private boolean isKing;
  private boolean isGoodGuy;

  public BankAccount(String name, double balance, String animalType, boolean isKing,
                     boolean isGoodGuy) {
    this.name = name;
    this.balance = balance;
    this.animalType = animalType;
    this.isKing = isKing;
    this.isGoodGuy = isGoodGuy;
  }

  public String getName() {
    return name;
  }

  public String getBalance() {
    return getBalanceTwoDecimals();
  }

  public double getDoubleBalance() {
    return balance;
  }

  public String getBalanceTwoDecimals() {
    return String.format("%.2f", balance);
  }

  public String getAnimalType() {
    return animalType;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void setAnimalType(String animalType) {
    this.animalType = animalType;
  }

  public boolean isKing() {
    return isKing;
  }

  public void setKing(boolean isKing) {
    this.isKing = isKing;
  }

  public boolean isGoodGuy() {
    return isGoodGuy;
  }

  public void setGoodGuy(boolean isGoodGuy) {
    this.isGoodGuy = isGoodGuy;
  }
}
