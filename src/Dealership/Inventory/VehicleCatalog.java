package Dealership.Inventory;

import Dealership.Inventory.VehicleFeatures.VehicleColor;
import Dealership.Inventory.VehicleFeatures.VehicleMake;
import Dealership.Inventory.VehicleFeatures.VehicleSize;

import java.util.HashSet;

/**
 * Vehicle Catalog
 *
 * Created by manishgajare
 */
public class VehicleCatalog {

  private static volatile VehicleCatalog instance;
  private static Object mutex = new Object();
  private HashSet<Vehicle> vehicleList;
  private int vehicleCountForID;

  protected VehicleCatalog() {
    vehicleList = new HashSet<Vehicle>();
    vehicleCountForID = 1;
  }

  public static VehicleCatalog getInstance() {
    VehicleCatalog result = instance;
    if (result == null) {
      synchronized (mutex) {
        result = instance;
        if (result == null) {
          instance = result = new VehicleCatalog();
        }
      }
    }
    return result;
  }

  public HashSet<Vehicle> getVehicleList() {
    return vehicleList;
  }

  /**
   * Adding new Vehicle to VehicleCatalog
   */
  public Vehicle addVehicle(VehicleMake make, String model, int year, double price, VehicleSize size, VehicleColor color) {
    Vehicle existingVehicle = checkIfExist(make, size, color, year, model);
    if (existingVehicle != null) {
      if (existingVehicle.getPrice() != price) {
        existingVehicle.setPrice(price);
        InventoryCatalog.getInstance().checkIfExist(existingVehicle).setPrice(price);
        System.out.println("Updated Price of existing vehicle -> " + existingVehicle);
      }
      return existingVehicle;
    }

    Vehicle v = new Vehicle(vehicleCountForID++, make, model, year, price, size, color);
    vehicleList.add(v);
    System.out.println("Vehicle added to Vehicle Catalog");
    return v;
  }

  /**
   * Checking if Vehicle aready exist in VehicleCatalog
   */
  public Vehicle checkIfExist(VehicleMake vehicleMake, VehicleSize vehicleSize, VehicleColor vehicleColor, int year, String model) {

    for (Vehicle vehicle : vehicleList) {
      if (vehicle.getMake().equals(vehicleMake)
        && vehicle.getSize().equals(vehicleSize)
        && vehicle.getColor().equals(vehicleColor)
        && vehicle.getModel().equals(model)
        && vehicle.getYear() == year) {
        return vehicle;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "VehicleCatalog -> " + vehicleList;
  }
}
