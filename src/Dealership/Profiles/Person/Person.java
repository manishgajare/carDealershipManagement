package Dealership.Profiles.Person;

import java.time.LocalDate;

/**
 * Person
 *
 * Created by manishgajare
 */
public class Person {

  private int id;
  private String firstName;
  private String lastName;
  private LocalDate birthDate;
  private int income;
  private Character gender;
  private Address address;
  private ContactDetails contactDetails;
  private SensitiveInformation sensitiveInformation;
  private VehicleInterest vehicleInterest;

  public Person(int id, String firstName, String lastName, LocalDate birthDate, int income, Character gender,
                Address address, ContactDetails contactDetails, SensitiveInformation sensitiveInformation,
                VehicleInterest vehicleInterest) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.birthDate = birthDate;
    this.income = income;
    this.gender = gender;
    this.address = address;
    this.contactDetails = contactDetails;
    this.sensitiveInformation = sensitiveInformation;
    this.vehicleInterest = vehicleInterest;
  }

  public int getId() {
    return id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public int getIncome() {
    return income;
  }

  public Character getGender() {
    return gender;
  }

  public Address getAddress() {
    return address;
  }

  public ContactDetails getContactDetails() {
    return contactDetails;
  }

  public VehicleInterest getVehicleInterest() {
    return vehicleInterest;
  }

  protected SensitiveInformation getSensitiveInformation() {
    return sensitiveInformation;
  }

  @Override
  public String toString() {
    return "Person -> " +
      "id: " + id +
      "firstName: " + firstName +
      ", lastName: " + lastName +
      ", birthDate: " + birthDate +
      ", income: " + income +
      ", gender: " + gender +
      ", " + address +
      ", " + contactDetails;
  }
}
