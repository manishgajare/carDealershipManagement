package Dealership.Profiles.SalesPerson;

import Dealership.Inventory.Vehicle;
import Dealership.Invoice.Order.Order;
import Dealership.Invoice.Order.OrderCatalog;
import Dealership.Invoice.Order.OrderItem;
import Dealership.Profiles.Person.Person;
import Dealership.Profiles.Person.PersonDirectory;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

/**
 * SalesPerson Directory
 *
 * Created by manishgajare
 */
public class SalesPersonDirectory {

  private static volatile SalesPersonDirectory instance;
  private static Object mutex = new Object();
  private HashSet<SalesPerson> salesPersonList;
  private int salesPersonCountForID;

  protected SalesPersonDirectory() {
    salesPersonList = new HashSet<SalesPerson>();
    salesPersonCountForID = 1;
  }

  public static SalesPersonDirectory getInstance() {
    SalesPersonDirectory result = instance;
    if (result == null) {
      synchronized (mutex) {
        result = instance;
        if (result == null) {
          instance = result = new SalesPersonDirectory();
        }
      }
    }
    return result;
  }

  public HashSet<SalesPerson> getSalesPersonList() {
    return salesPersonList;
  }

  /**
   * Add person as a SalesPerson
   *
   * @param person - person to set as Sales Person
   * @return SalesPerson
   */
  public SalesPerson addSalesPerson(Person person) {

    SalesPerson existingSalesPerson = checkIfExists(person);
    if (existingSalesPerson != null) {
      return existingSalesPerson;
    }

    SalesPerson salesPerson = new SalesPerson(salesPersonCountForID++, person);
    salesPersonList.add(salesPerson);
    return salesPerson;

  }

  public SalesPerson checkIfExists(Person person) {
    for (SalesPerson salesPerson : salesPersonList) {
      if (person.equals(salesPerson.getPerson())) {
        return salesPerson;
      }
    }
    return null;
  }

  /**
   * Get recommendations of vehicles based on person's interest or previously bought vehicles
   *
   * @param ageOfPotentialCustomer - age of person for whom we require recommendations
   * @param genderOfPotentialCustomer - gender of person for whom we require recommendations
   * @param incomeOfPotentialCustomer - income of person for whom we require recommendations
   * @return ArrayList of recommended vehicles
   */
  public ArrayList<Vehicle> getRecommendations(int ageOfPotentialCustomer, Character genderOfPotentialCustomer, double incomeOfPotentialCustomer) {
    PersonDirectory personDirectory = PersonDirectory.getInstance();
    OrderCatalog orderCatalog = OrderCatalog.getInstance();

    // considering bracket of 3 on either side for age
    int floorValueForAge = ageOfPotentialCustomer - 3;
    int ceilingValueForAge = ageOfPotentialCustomer + 3;

    // considering bracket of $15k on either side of income
    double floorValueForIncome = incomeOfPotentialCustomer - 15000;
    double ceilingValueForIncome = incomeOfPotentialCustomer + 15000;

    Map<Vehicle, Integer> vehicleRecommendations = new HashMap<Vehicle, Integer>();
    ArrayList<Vehicle> recommendationList = new ArrayList<Vehicle>();

    // adding 10 points for the vehicle if person is interested in that vehicle
    for (Person person : personDirectory.getPersonList()) {
      if (checkIfPersonFallsInCriteria(person, floorValueForAge, ceilingValueForAge, floorValueForIncome, ceilingValueForIncome, genderOfPotentialCustomer)) {
        for (Vehicle vehicle : person.getVehicleInterest().getVehicleList()) {
          if (vehicleRecommendations.containsKey(vehicle)) {
            vehicleRecommendations.put(vehicle, vehicleRecommendations.get(vehicle) + 10);
          } else {
            vehicleRecommendations.put(vehicle, 10);
          }
        }
      }
    }

    // adding 20 points for the vehicle if customer has bought that vehicle
    for (Order order : orderCatalog.getOrderList()) {
      Person person = order.getCustomer().getPerson();
      if (checkIfPersonFallsInCriteria(person, floorValueForAge, ceilingValueForAge, floorValueForIncome, ceilingValueForIncome, genderOfPotentialCustomer)) {
        for (OrderItem orderItem : order.getOrderItemList()) {
          Vehicle vehicle = orderItem.getInventoryItem().getVehicle();
          if (vehicleRecommendations.containsKey(vehicle)) {
            vehicleRecommendations.put(vehicle, vehicleRecommendations.get(vehicle) + 20);
          } else {
            vehicleRecommendations.put(vehicle, 20);
          }
        }
      }
    }

    // sorting by points using comparator
    Map<Vehicle, Integer> vehicleRecommendationsSorted = sortByComparator(vehicleRecommendations, false);

    int count = 5;
    for (Map.Entry<Vehicle, Integer> entry : vehicleRecommendationsSorted.entrySet()) {
      count--;
      recommendationList.add(entry.getKey());
      if (count == 0) {
        break;
      }
    }

    // sorting by the price of the vehicles
    Collections.sort(recommendationList, (v1, v2) -> (int) (v2.getPrice() - v1.getPrice()));

    return recommendationList;

  }

  /**
   * Checking if the person falls under the criteria of potential customer, depending upon age/income brackets and
   * gender
   *
   * @param person - person whom we want to compare with potential customer
   * @param floorValueForAge - minimum age of the person (on basis of potential customer)
   * @param ceilingValueForAge - maximum age of the person (on basis of potential customer)
   * @param floorValueForIncome - minimum income of the person (on basis of potential customer)
   * @param ceilingValueForIncome - maximum income of the person (on basis of potential customer)
   * @param genderOfPotentialCustomer - gender of the potential customer
   * @return boolean
   */
  private boolean checkIfPersonFallsInCriteria(Person person, int floorValueForAge, int ceilingValueForAge, double floorValueForIncome, double ceilingValueForIncome, Character genderOfPotentialCustomer) {
    int ageOfPerson = Period.between(person.getBirthDate(), LocalDate.now()).getYears();
    double incomeOPerson = person.getIncome();
    if (genderOfPotentialCustomer.equals(person.getGender())
      && incomeOPerson <= ceilingValueForIncome
      && incomeOPerson >= floorValueForIncome
      && ageOfPerson >= floorValueForAge
      && ageOfPerson <= ceilingValueForAge) {
      return true;
    }
    return false;
  }

  /**
   * Sorting Map according to the values (in this case, scores assigned to the vehicles)
   */
  private Map<Vehicle, Integer> sortByComparator(Map<Vehicle, Integer> vehicleRecommendations, final boolean order) {

    List<Map.Entry<Vehicle, Integer>> list = new LinkedList<Map.Entry<Vehicle, Integer>>(vehicleRecommendations.entrySet());

    // Sorting the list based on values
    Collections.sort(list, new Comparator<Map.Entry<Vehicle, Integer>>() {
      public int compare(Map.Entry<Vehicle, Integer> o1,
                         Map.Entry<Vehicle, Integer> o2) {
        if (order) {
          return o1.getValue().compareTo(o2.getValue());
        } else {
          return o2.getValue().compareTo(o1.getValue());

        }
      }
    });

    // Maintaining insertion order with the help of LinkedList
    Map<Vehicle, Integer> sortedMap = new LinkedHashMap<Vehicle, Integer>();
    for (Map.Entry<Vehicle, Integer> entry : list) {
      sortedMap.put(entry.getKey(), entry.getValue());
    }

    return sortedMap;
  }

  @Override
  public String toString() {
    return "SalesPersonDirectory -> " + salesPersonList;
  }

}
