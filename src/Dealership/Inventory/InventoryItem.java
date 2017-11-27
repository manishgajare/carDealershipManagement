package Dealership.Inventory;

/**
 * Inventory Item
 *
 * Created by manishgajare
 */
public class InventoryItem {

  private int id;
  private Vehicle vehicle;
  private double price;
  private int quantityAvailable;

  protected InventoryItem(int id, Vehicle vehicle, double price, int quantityAvailable) {
    this.id = id;
    this.vehicle = vehicle;
    this.price = price * 1.1;
    this.quantityAvailable = quantityAvailable;
  }

  public Vehicle getVehicle() {
    return vehicle;
  }

  public double getPrice() {
    return price;
  }

  protected void setPrice(double price) {
    this.price = price * 1.1;
  }

  public int getId() {
    return id;
  }

  public int getQuantityAvailable() {
    return quantityAvailable;
  }

  protected void incrementQuantityAvailable(int quantityToBeAdded) {
    this.quantityAvailable += quantityToBeAdded;
  }

  protected void decrementQuantityAvailable(int quantityToBeRemoved) {
    this.quantityAvailable -= quantityToBeRemoved;
  }

  @Override
  public String toString() {
    return "InventoryItem -> " +
      "id: " + id +
      vehicle +
      ", price: " + price +
      ", Available Quantity: " + quantityAvailable;
  }
}
