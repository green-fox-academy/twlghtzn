package com.twlghtzn.webshop.models;

public class ShopItem {
  private String name;
  private Type type;
  private String description;
  private float price;
  private int quantityOfStock;

  public ShopItem(String name, Type type, String description, float price, int quantityOfStock) {
    this.name = name;
    this.type = type;
    this.description = description;
    this.price = price;
    this.quantityOfStock = quantityOfStock;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public float getPrice() {
    return price;
  }

  public int getQuantityOfStock() {
    return quantityOfStock;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setPrice(float price) {
    this.price = price;
  }

  public void setQuantityOfStock(int quantityOfStock) {
    this.quantityOfStock = quantityOfStock;
  }

  public Type getType() {
    return this.type;
  }

  public void setType(Type type) {
    this.type = type;
  }

  public String typeToString() {
    if (this.type == Type.CLOTHES) {
      return "Clothes";
    } else if (this.type == Type.ELECTRONICS) {
      return "Electronics";
    }
    return "Food";
  }

  public float priceToEuro() {
    return this.getPrice() / 3;
  }
}
