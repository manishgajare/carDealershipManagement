package Dealership.Profiles.Customer;

import Dealership.Profiles.Person.Person;

import java.util.HashSet;

/**
 *
 * Customer Directory
 *
 * Created by manishgajare
 */
public class CustomerDirectory {

  private static volatile CustomerDirectory instance;
  private static Object mutex = new Object();
  private HashSet<Customer> customerList;
  private int customerCountForID;

  protected CustomerDirectory() {
    customerList = new HashSet<Customer>();
    customerCountForID = 1;
  }

  public static CustomerDirectory getInstance() {
    CustomerDirectory result = instance;
    if (result == null) {
      synchronized (mutex) {
        result = instance;
        if (result == null) {
          instance = result = new CustomerDirectory();
        }
      }
    }
    return result;
  }

  public HashSet<Customer> getCustomerList() {
    return customerList;
  }

  /**
   * Add Person as Customer in Customer Directory
   */
  public Customer addCustomer(Person person) {
    Customer existingCustomer = checkIfExists(person);
    if (existingCustomer != null) {
      return existingCustomer;
    }

    Customer customer = new Customer(customerCountForID++, person);
    customerList.add(customer);
    return customer;
  }

  /**
   * Check if Customer already exist
   */
  public Customer checkIfExists(Person person) {
    for (Customer customer : customerList) {
      if (person.equals(customer.getPerson())) {
        return customer;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "CustomerDirectory -> " + customerList;
  }

}
