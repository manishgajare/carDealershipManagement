package Dealership.Invoice.Order;

import Dealership.Inventory.InventoryItem;

/**
 * Order Item
 *
 * Created by manishgajare
 */
public class OrderItem {

  private int id;
  private InventoryItem inventoryItem;
  private double price;

  protected OrderItem(int id, InventoryItem inventoryItem, double price) {
    this.id = id;
    this.inventoryItem = inventoryItem;
    this.price = price;
  }

  public int getId() {
    return id;
  }

  public InventoryItem getInventoryItem() {
    return inventoryItem;
  }

  public double getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "OrderItem -> " +
      "Dealership id: " + inventoryItem +
      ", price: " + price + System.lineSeparator();
  }
}
