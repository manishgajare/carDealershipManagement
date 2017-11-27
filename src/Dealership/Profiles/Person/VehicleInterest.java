package Dealership.Profiles.Person;

import Dealership.Inventory.Vehicle;

import java.util.HashSet;

/**
 * Interest of person in vehicles
 *
 * Created by manishgajare
 */
public class VehicleInterest {

  private HashSet<Vehicle> vehicleList;

  public VehicleInterest() {
    this.vehicleList = new HashSet<Vehicle>();
  }

  public HashSet<Vehicle> getVehicleList() {
    return vehicleList;
  }

  public void setVehicleList(HashSet<Vehicle> vehicleList) {
    this.vehicleList = vehicleList;
  }

  @Override
  public String toString() {
    return "VehicleInterest -> " + vehicleList;
  }
}
