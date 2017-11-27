package Dealership.Profiles.Person;

import Dealership.Inventory.Vehicle;

import java.time.LocalDate;
import java.util.HashSet;

/**
 * Person Directory
 *
 * Created by manishgajare
 */
public class PersonDirectory {

  private static volatile PersonDirectory instance;
  private static Object mutex = new Object();
  private HashSet<Person> personList;
  private int personCountForID;

  protected PersonDirectory() {
    personList = new HashSet<Person>();
    personCountForID = 1;
  }

  public static PersonDirectory getInstance() {
    PersonDirectory result = instance;
    if (result == null) {
      synchronized (mutex) {
        result = instance;
        if (result == null) {
          instance = result = new PersonDirectory();
        }
      }
    }
    return result;
  }

  public HashSet<Person> getPersonList() {
    return personList;
  }

  /**
   * Create Person and add to PersonDeirectory
   */
  public Person addPerson(String firstName, String lastName, LocalDate birthDate, int income, Character gender,
                          String streetName, String blockNumber, String city, String state, String country, int zipcode,
                          String phoneNumber, String email, String SSN, String passportId, String citizenshipCountry, HashSet<Vehicle> vehicleList) {

    Person existingPerson = checkIfExists(SSN);
    if (existingPerson != null) {
      return existingPerson;
    }

    Address address = new Address(streetName, blockNumber, city, state, country, zipcode);
    ContactDetails contactDetails = new ContactDetails(phoneNumber, email);
    SensitiveInformation sensitiveInformation = new SensitiveInformation(SSN, passportId, citizenshipCountry);
    VehicleInterest vehicleInterest = new VehicleInterest();
    vehicleInterest.setVehicleList(vehicleList);
    Person person = new Person(personCountForID++, firstName, lastName, birthDate, income, gender, address, contactDetails, sensitiveInformation, vehicleInterest);
    personList.add(person);
    return person;
  }

  /**
   * Check if person already exist in PersonDirectory based on SSN - which is unique for all
   */
  public Person checkIfExists(String SSN) {
    for (Person person : personList) {
      if (SSN.equals(person.getSensitiveInformation().getSSN())) {
        return person;
      }
    }
    return null;
  }

  @Override
  public String toString() {
    return "PersonDirectory -> " + personList;
  }
}
