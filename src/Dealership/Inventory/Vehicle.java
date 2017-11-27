package Dealership.Inventory;

import Dealership.Inventory.VehicleFeatures.VehicleColor;
import Dealership.Inventory.VehicleFeatures.VehicleMake;
import Dealership.Inventory.VehicleFeatures.VehicleSize;

/**
 * Vehicle
 *
 * Created by manishgajare
 */
public class Vehicle {

  private int id;
  private VehicleMake make;
  private String model;
  private int year;
  private double price;
  private VehicleColor color;
  private VehicleSize size;

  protected Vehicle(int id, VehicleMake make, String model, int year, double price, VehicleSize size, VehicleColor color) {
    this.id = id;
    this.make = make;
    this.model = model;
    this.year = year;
    this.price = price;
    this.size = size;
    this.color = color;
  }

  public int getId() {
    return id;
  }

  public VehicleMake getMake() {
    return make;
  }

  public String getModel() {
    return model;
  }

  public int getYear() {
    return year;
  }

  public double getPrice() {
    return price;
  }

  protected void setPrice(double price) {
    this.price = price;
  }

  public VehicleSize getSize() {
    return size;
  }

  public VehicleColor getColor() {
    return color;
  }

  @Override
  public String toString() {
    return System.lineSeparator() +
      "Vehicle id: " + id +
      ", make: " + make +
      ", model: " + model +
      ", year: " + year +
      ", price: " + price +
      ", color: " + color +
      ", size: " + size;
  }
}
