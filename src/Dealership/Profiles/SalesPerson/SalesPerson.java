package Dealership.Profiles.SalesPerson;

import Dealership.Profiles.Person.Person;

/**
 * SalesPerson
 *
 * Created by manishgajare
 */
public class SalesPerson {

  private int id;
  private Person person;

  public SalesPerson(int id, Person person) {
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
