package Dealership.Inventory;

import Dealership.Inventory.VehicleFeatures.VehicleSize;

import java.util.HashSet;

/**
 * Inventory Catalog
 *
 * Created by manishgajare
 */
public class InventoryCatalog {

  // setting values for the capacity of Inventory according to size of Vehicle
  private static final int smallTotalInventorySpace = 180;
  private static final int mediumTotalInventorySpace = 170;
  private static final int largeTotalInventorySpace = 150;

  // setting initial available spaces for filling up inventory - which changes as per new inventory items are added
  // or removed during placing orders and adding supplies
  private static int smallAvailableInventorySpace = smallTotalInventorySpace;
  private static int mediumAvailableInventorySpace = mediumTotalInventorySpace;
  private static int largeAvailableInventorySpace = largeTotalInventorySpace;

  private static volatile InventoryCatalog instance;
  private static Object mutex = new Object();
  private HashSet<InventoryItem> inventoryList;
  private int inventoryCountForID;

  protected InventoryCatalog() {
    inventoryList = new HashSet<InventoryItem>();
    inventoryCountForID = 1;
  }

  public static InventoryCatalog getInstance() {
    InventoryCatalog result = instance;
    if (result == null) {
      synchronized (mutex) {
        result = instance;
        if (result == null) {
          instance = result = new InventoryCatalog();
        }
      }
    }
    return result;
  }

  public static int getSmallTotalInventorySpace() {
    return smallTotalInventorySpace;
  }

  public static int getMediumTotalInventorySpace() {
    return mediumTotalInventorySpace;
  }

  public static int getLargeTotalInventorySpace() {
    return largeTotalInventorySpace;
  }

  public static int getSmallAvailableInventorySpace() {
    return smallAvailableInventorySpace;
  }

  public static int getMediumAvailableInventorySpace() {
    return mediumAvailableInventorySpace;
  }

  public static int getLargeAvailableInventorySpace() {
    return largeAvailableInventorySpace;
  }

  public HashSet<InventoryItem> getInventoryList() {
    return inventoryList;
  }

  /**
   * Add vehicle to the Inventory
   */
  public InventoryItem addInventoryItem(Vehicle vehicle, int quantityToAdd) {
    InventoryItem existingItem = checkIfExist(vehicle);
    if (existingItem != null) {
      System.out.println("Inventory Item already exist.");
      if (checkIfEnoughSpaceToAddInventory(vehicle.getSize(), quantityToAdd)) {
        incrementInventoryQuantity(existingItem, quantityToAdd);
        System.out.println("Updated Quantity in Inventory Catalog");
        return existingItem;
      }
    }
    if (checkIfEnoughSpaceToAddInventory(vehicle.getSize(), quantityToAdd)) {
      InventoryItem inventoryItem = new InventoryItem(inventoryCountForID++, vehicle, vehicle.getPrice(), quantityToAdd);
      decrementAvailableSpace(inventoryItem.getVehicle().getSize(), quantityToAdd);
      inventoryList.add(inventoryItem);
      System.out.println("Item added to Inventory Catalog");
      return inventoryItem;
    }

    System.out.println("Not Enough Space to add in Inventory");
    return existingItem;
  }

  public void removeInventoryItem(InventoryItem inventoryItem, int quantity) {
    this.decrementInventoryQuantity(inventoryItem, quantity);
  }

  /**
   * Check if Inventory Item already exist
   */
  public InventoryItem checkIfExist(Vehicle vehicle) {

    for (InventoryItem item : inventoryList) {
      if (item.getVehicle().equals(vehicle)) {
        return item;
      }
    }
    return null;
  }

  /**
   * Check if enough space available to add inventory
   */
  public boolean checkIfEnoughSpaceToAddInventory(VehicleSize vehicleSize, int quantityToAdd) {
    boolean isAvailable = false;
    if ((vehicleSize.equals(VehicleSize.SMALL) && quantityToAdd <= smallAvailableInventorySpace) ||
      (vehicleSize.equals(VehicleSize.MEDIUM) && quantityToAdd <= mediumAvailableInventorySpace) ||
      (vehicleSize.equals(VehicleSize.LARGE) && quantityToAdd <= largeAvailableInventorySpace)) {
      isAvailable = true;
    }
    return isAvailable;
  }

  /**
   * Increment available space in Inventory once an order is placed or inventory items are removed
   */
  protected void incrementAvailableSpace(VehicleSize vehicleSize, int quantity) {
    if (vehicleSize.equals(VehicleSize.SMALL)) {
      smallAvailableInventorySpace += quantity;
    } else if (vehicleSize.equals(VehicleSize.MEDIUM)) {
      mediumAvailableInventorySpace += quantity;
    } else if (vehicleSize.equals(VehicleSize.LARGE)) {
      largeAvailableInventorySpace += quantity;
    }
  }

  /**
   * Decrement available space in Inventory when inventory items are added
   */
  protected void decrementAvailableSpace(VehicleSize vehicleSize, int quantity) {
    if (vehicleSize.equals(VehicleSize.SMALL)) {
      smallAvailableInventorySpace -= quantity;
    } else if (vehicleSize.equals(VehicleSize.MEDIUM)) {
      mediumAvailableInventorySpace -= quantity;
    } else if (vehicleSize.equals(VehicleSize.LARGE)) {
      largeAvailableInventorySpace -= quantity;
    }
  }

  /**
   * Increment Inventory Quantity and decrement Inventory space
   */
  protected void incrementInventoryQuantity(InventoryItem inventoryItem, int quantityToAdd) {
    boolean checkIfSpaceAvailable = checkIfEnoughSpaceToAddInventory(inventoryItem.getVehicle().getSize(), quantityToAdd);
    if (checkIfSpaceAvailable) {
      inventoryItem.incrementQuantityAvailable(quantityToAdd);
      decrementAvailableSpace(inventoryItem.getVehicle().getSize(), quantityToAdd);
    }
  }

  /**
   * Decrement Inventory Quantity and increment Inventory space
   */
  protected void decrementInventoryQuantity(InventoryItem inventoryItem, int quantityToRemove) {
      inventoryItem.decrementQuantityAvailable(quantityToRemove);
      incrementAvailableSpace(inventoryItem.getVehicle().getSize(), quantityToRemove);
  }

  @Override
  public String toString() {
    return "InventoryCatalog -> " + inventoryList;
  }
}
