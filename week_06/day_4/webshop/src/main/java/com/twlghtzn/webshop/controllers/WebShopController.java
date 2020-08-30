package com.twlghtzn.webshop.controllers;
import com.twlghtzn.webshop.models.ShopItem;
import com.twlghtzn.webshop.models.Type;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebShopController {
  List<ShopItem> shopItems;




  public WebShopController() {
    this.shopItems = new ArrayList<>();
    ShopItem item1 = new ShopItem(
        "Running shoes", Type.CLOTHES,
        "Nike running shoes",
        1000,
        5);

    ShopItem item2 = new ShopItem(
        "Printer",
        Type.ELECTRONICS,
        "HP printer",
        3000,
        2);

    ShopItem item3 = new ShopItem(
        "Coca cola",
        Type.FOOD,
        "0,5l standard coke",
        25,
        0);

    ShopItem item4 = new ShopItem(
        "Wokin",
        Type.FOOD,
        "Chicken with fried rice",
        119,
        100);

    ShopItem item5 = new ShopItem(
        "T-shirt",
        Type.CLOTHES,
        "Blue with a corgi on a bike",
        300,
        1);
    shopItems.add(item1);
    shopItems.add(item2);
    shopItems.add(item3);
    shopItems.add(item4);
    shopItems.add(item5);
  }

  @GetMapping("/")
  public String getWebShopItems(Model model) {
    model.addAttribute("shopItems", shopItems);
    return "index";
  }

  @GetMapping("/only-available")
  public String getOnlyAvailable(Model model) {
  model.addAttribute("shopItems", findAvailableShopItems());
  return "index";
  }

  @GetMapping("/cheapest-first")
  public String getCheapestFirst(Model model) {
    List<ShopItem> filteredList = new ArrayList<>(sortCheapestFirst());
    model.addAttribute("shopItems", filteredList);
    return "index";
  }

@GetMapping("/contains/nike")
  public String searchWebShopForNike(Model model) {
    model.addAttribute("shopItems",
        findSearchedShopItems("nike"));
    return "index";
  }

  @GetMapping("/average-stock")
  public String getAverageStock(Model model) {
    String displayText = "Average stock: " + getAverageStock();
    model.addAttribute("displayText", displayText);
    return "custom";
  }

  @GetMapping("/most-expensive")
  public String searchWebShopForMostExpensive(Model model) {
    List<ShopItem> filteredList = new ArrayList<>(sortCheapestFirst());
    String nameOfMostExpensive = filteredList.get(filteredList.size() - 1).getName();
    String displayText = "Most expensive item: " + nameOfMostExpensive;
      model.addAttribute("displayText", displayText);
    return "custom";
  }

  @PostMapping("/search")
  public String searchWebShop(String searchedText, Model model) {
    model.addAttribute("shopItems", findSearchedShopItems(searchedText));
    return "index";
  }

  @GetMapping("/filter-by-type/{type}")
  public String getItemsByType(@PathVariable String type, Model model) {
    List<ShopItem> filteredList = sortItemsByType(type);
    model.addAttribute("shopItems", filteredList);
    return "morefilters";
  }

  @GetMapping("/filter-by-type")
  public String getFilterByTypeMain(Model model) {
    model.addAttribute("shopItems", shopItems);
    return "morefilters";
  }

  @GetMapping("/price-in-eur")
  public String getWebShopPricesInEuro(Model model) {
    List<ShopItem> modifiedList = getPricesInEuro();
    model.addAttribute("shopItems", modifiedList);
    return "morefilters";
  }

  private List<ShopItem> getPricesInEuro() {
    List<ShopItem> modifiedList = shopItems;
    for (ShopItem item : modifiedList) {
      item.setPrice(item.priceToEuro());
    }
    return modifiedList;
  }

  private List<ShopItem> sortItemsByType(String type) {
    List<ShopItem> filteredList = new ArrayList<>();
    switch (type) {
      case "clothes":
        filteredList = findShopItemsByType(Type.CLOTHES);
        break;
      case "electronics":
        filteredList = findShopItemsByType(Type.ELECTRONICS);
        break;
      case "foods":
        filteredList = findShopItemsByType(Type.FOOD);
        break;
    }
    return filteredList;
  }

  private List<ShopItem> findShopItemsByType(Type type) {
    return shopItems.stream()
        .filter(item -> item.getType().equals(type))
        .collect(Collectors.toList());
  }

  private List<ShopItem> findAvailableShopItems() {
    return shopItems.stream()
        .filter(item -> item.getQuantityOfStock() > 0)
        .collect(Collectors.toList());
  }

  private List<ShopItem> findSearchedShopItems(String searchedText) {
    return shopItems.stream()
        .filter(item -> item.getName().toLowerCase().contains(searchedText.toLowerCase()) ||
            item.getDescription().toLowerCase().contains(searchedText.toLowerCase()))
        .collect(Collectors.toList());
  }

  public List<ShopItem> sortCheapestFirst() {
    return shopItems.stream()
        .sorted(Comparator.comparing(ShopItem::getPrice))
        .collect(Collectors.toList());
  }

  private float getAverageStock() {
    float quantity = shopItems.stream()
        .mapToInt(ShopItem::getQuantityOfStock)
        .sum();
    float itemsCount = shopItems.size();
    return quantity/itemsCount;
  }


}
