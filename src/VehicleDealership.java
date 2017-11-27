import Dealership.Inventory.InventoryCatalog;
import Dealership.Inventory.InventoryItem;
import Dealership.Inventory.Vehicle;
import Dealership.Inventory.VehicleCatalog;
import Dealership.Inventory.VehicleFeatures.VehicleColor;
import Dealership.Inventory.VehicleFeatures.VehicleMake;
import Dealership.Inventory.VehicleFeatures.VehicleSize;
import Dealership.Profiles.Person.Person;
import Dealership.Profiles.Person.PersonDirectory;
import Dealership.Profiles.SalesPerson.SalesPersonDirectory;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;

/**
 * VehicleDealership - main class
 *
 * Created by manishgajare
 */
public class VehicleDealership {

  public static void main(String args[]) throws IOException {
    Config.populateInitialData();
    getRecommendation(26, 'm', 90000);
  }

  public static InventoryItem addInventory(int quantityToAdd, VehicleMake vehicleMake, String model, int year, double price, VehicleSize vehicleSize, VehicleColor vehicleColor) {
    VehicleCatalog vehicleCatalog = VehicleCatalog.getInstance();
    InventoryCatalog inventoryCatalog = InventoryCatalog.getInstance();
    Vehicle v = vehicleCatalog.addVehicle(vehicleMake, model, year, price, vehicleSize, vehicleColor);
    return inventoryCatalog.addInventoryItem(v, quantityToAdd);
  }

  public static Person createProfile(String firstName, String lastName, LocalDate birthDate, int income, Character gender,
                                     String streetName, String blockNumber, String city, String state, String country, int zipcode,
                                     String phoneNumber, String email, String SSN, String passportId, String citizenshipCountry, HashSet<Vehicle> vehicleList) {
    PersonDirectory personDirectory = PersonDirectory.getInstance();
    Person person = personDirectory.checkIfExists(SSN);
    if (person == null) {
      person = personDirectory.addPerson(firstName, lastName, birthDate, income, gender,
        streetName, blockNumber, city, state, country, zipcode,
        phoneNumber, email, SSN, passportId, citizenshipCountry, vehicleList);
    }
    return person;
  }

  public static void getRecommendation(int age, Character gender, double income) {
    SalesPersonDirectory salesPersonDirectory = SalesPersonDirectory.getInstance();
    System.out.println("Recommendations:");
    System.out.println(salesPersonDirectory.getRecommendations(age, gender, income));
  }


}
