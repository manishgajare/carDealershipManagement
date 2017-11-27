package Dealership.Profiles.Customer;

import Dealership.Profiles.Person.Person;

/**
 * Customer
 *
 * Created by manishgajare
 */
public class Customer {

  private int id;
  private Person person;

  public Customer(int id, Person person) {
    this.id = id;
    this.person = person;
  }

  public int getId() {
    return id;
  }

  public Person getPerson() {
    return person;
  }

  @Override
  public String toString() {
    return "id: " + id +
      ", person: " + person;
  }

}
