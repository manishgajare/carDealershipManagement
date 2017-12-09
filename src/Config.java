import Dealership.Inventory.InventoryCatalog;
import Dealership.Inventory.InventoryItem;
import Dealership.Inventory.Vehicle;
import Dealership.Inventory.VehicleCatalog;
import Dealership.Inventory.VehicleFeatures.VehicleColor;
import Dealership.Inventory.VehicleFeatures.VehicleMake;
import Dealership.Inventory.VehicleFeatures.VehicleSize;
import Dealership.Invoice.InvoiceCatalog;
import Dealership.Invoice.Order.Order;
import Dealership.Invoice.Order.OrderCatalog;
import Dealership.Profiles.Customer.Customer;
import Dealership.Profiles.Customer.CustomerDirectory;
import Dealership.Profiles.Person.Person;
import Dealership.Profiles.SalesPerson.SalesPerson;
import Dealership.Profiles.SalesPerson.SalesPersonDirectory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;

/**
 * Congig class for initializing values in objects
 *
 * Created by manishgajare
 */
public class Config {

  public static void populateInitialData() {

    OrderCatalog orderCatalog = OrderCatalog.getInstance();
    InvoiceCatalog invoiceCatalog = InvoiceCatalog.getInstance();
    SalesPersonDirectory salesPersonDirectory = SalesPersonDirectory.getInstance();
    CustomerDirectory customerDirectory = CustomerDirectory.getInstance();
    InventoryCatalog inventoryCatalog = InventoryCatalog.getInstance();
    VehicleCatalog vehicleCatalog = VehicleCatalog.getInstance();

    VehicleDealership.addInventory(30, VehicleMake.TOYOTA, "Corolla", 2015, 16500, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(30, VehicleMake.TOYOTA, "Corolla", 2015, 16500, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.TOYOTA, "Corolla", 2016, 17500, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.TOYOTA, "Corolla", 2017, 19500, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.TOYOTA, "Corolla", 2017, 19000, VehicleSize.MEDIUM, VehicleColor.WHITE);
    VehicleDealership.addInventory(3, VehicleMake.TOYOTA, "Camry", 2015, 21000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.TOYOTA, "Camry", 2016, 22000, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.TOYOTA, "Camry", 2017, 24500, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.TOYOTA, "Camry", 2017, 24000, VehicleSize.MEDIUM, VehicleColor.WHITE);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Civic", 2015, 15500, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Civic", 2016, 16500, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Civic", 2017, 18500, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Civic", 2017, 18000, VehicleSize.MEDIUM, VehicleColor.WHITE);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Accord", 2015, 22000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Accord", 2016, 23000, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Accord", 2017, 26500, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.HONDA, "Accord", 2017, 26000, VehicleSize.MEDIUM, VehicleColor.WHITE);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A3", 2017, 35000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A4", 2017, 38000, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A5", 2017, 42000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A6", 2017, 45000, VehicleSize.MEDIUM, VehicleColor.WHITE);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A7", 2017, 52000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A3", 2015, 30000, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A3", 2016, 27000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.AUDI, "A4", 2016, 35000, VehicleSize.MEDIUM, VehicleColor.WHITE);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Challenger", 2017, 35000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Charger", 2017, 38000, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Caliber", 2017, 42000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Journey", 2017, 45000, VehicleSize.MEDIUM, VehicleColor.WHITE);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Lancer", 2017, 52000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Dynasty", 2015, 30000, VehicleSize.MEDIUM, VehicleColor.BLUE);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Interpid", 2016, 27000, VehicleSize.MEDIUM, VehicleColor.BLACK);
    VehicleDealership.addInventory(3, VehicleMake.DODGE, "Avenger", 2016, 35000, VehicleSize.MEDIUM, VehicleColor.WHITE);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    HashSet<Vehicle> vehicleList;
    Person person;
    Customer customer;
    InventoryItem inventoryItem = null;
    Order order;
    Vehicle vehicle = null;
    int count;

    vehicleList = new HashSet<Vehicle>();
    person = VehicleDealership.createProfile("Riti", "Bahlani", LocalDate.parse("05/15/1975", formatter), 45000, 'f',
      "40 Newport Parkway", "2505", "Jersey City", "NJ", "USA", 07310,
      "", "riti@gmail.com", "543-125-6738", "KLM291HM", "IND", vehicleList);
    SalesPerson salesPerson = salesPersonDirectory.addSalesPerson(person);

    vehicleList = new HashSet<Vehicle>();
    for (Vehicle v : vehicleCatalog.getVehicleList()) {
      if (v.getId() == 1 || v.getId() == 10 || v.getId() == 15 || v.getId() == 25) {
        vehicleList.add(v);
        if (v.getId() == 1) {
          vehicle = v;
        }
      }
    }
    person = VehicleDealership.createProfile("Manish", "Gajare", LocalDate.parse("05/15/1991", formatter), 85000, 'm',
      "114 Longwood Avenue", "5", "Brookline", "MA", "USA", 02446,
      "2028305422", "manishgajare@gmail.com", "543-857-9012", "KLM1041G", "IND", vehicleList);
    customer = customerDirectory.addCustomer(person);
    for (InventoryItem i : inventoryCatalog.getInventoryList()) {
      if (i.getVehicle().equals(vehicle)) {
        inventoryItem = i;
      }
    }
    order = orderCatalog.addOrder(customer, salesPerson, inventoryItem, inventoryItem.getPrice());
    invoiceCatalog.addInvoice(order);

    vehicleList = new HashSet<Vehicle>();
    for (Vehicle v : vehicleCatalog.getVehicleList()) {
      if (v.getId() == 1 || v.getId() == 2 || v.getId() == 17 || v.getId() == 15) {
        vehicleList.add(v);
        if (v.getId() == 1) {
          vehicle = v;
        }
      }
    }
    person = VehicleDealership.createProfile("Yash", "Kochar", LocalDate.parse("05/15/1989", formatter), 80000, 'm',
      "114 Longwood Avenue", "5", "Brookline", "MA", "USA", 02446,
      "7583276666", "yash@gmail.com", "543-857-7436", "KLM456HM", "IND", vehicleList);
    customer = customerDirectory.addCustomer(person);
    for (InventoryItem i : inventoryCatalog.getInventoryList()) {
      if (i.getVehicle().equals(vehicle)) {
        inventoryItem = i;
      }
    }
    order = orderCatalog.addOrder(customer, salesPerson, inventoryItem, inventoryItem.getPrice());
    invoiceCatalog.addInvoice(order);

    vehicleList = new HashSet<Vehicle>();
    for (Vehicle v : vehicleCatalog.getVehicleList()) {
      if (v.getId() == 7 || v.getId() == 9 || v.getId() == 8 || v.getId() == 2) {
        vehicleList.add(v);
        if (v.getId() == 7) {
          vehicle = v;
        }
      }
    }
    person = VehicleDealership.createProfile("Ronak", "Massand", LocalDate.parse("05/15/1992", formatter), 90000, 'm',
      "114 Longwood Avenue", "5", "Brookline", "MA", "USA", 02446,
      "8473620986", "ronak@gmail.com", "543-857-1025", "KLM34HLL", "IND", vehicleList);
    customer = customerDirectory.addCustomer(person);
    for (InventoryItem i : inventoryCatalog.getInventoryList()) {
      if (i.getVehicle().equals(vehicle)) {
        inventoryItem = i;
      }
    }
    order = orderCatalog.addOrder(customer, salesPerson, inventoryItem, inventoryItem.getPrice());
    invoiceCatalog.addInvoice(order);

    vehicleList = new HashSet<Vehicle>();
    for (Vehicle v : vehicleCatalog.getVehicleList()) {
      if (v.getId() == 13 || v.getId() == 23 || v.getId() == 19 || v.getId() == 30) {
        vehicleList.add(v);
        if (v.getId() == 13) {
          vehicle = v;
        }
      }
    }
    person = VehicleDealership.createProfile("Prashant", "Iyer", LocalDate.parse("05/15/1991", formatter), 85000, 'm',
      "114 Longwood Avenue", "5", "Brookline", "MA", "USA", 02446,
      "9286772351", "prashant@gmail.com", "543-857-6734", "KLM97G3J", "IND", vehicleList);
    customer = customerDirectory.addCustomer(person);
    for (InventoryItem i : inventoryCatalog.getInventoryList()) {
      if (i.getVehicle().equals(vehicle)) {
        inventoryItem = i;
      }
    }
    order = orderCatalog.addOrder(customer, salesPerson, inventoryItem, inventoryItem.getPrice());
    invoiceCatalog.addInvoice(order);

  }


}
