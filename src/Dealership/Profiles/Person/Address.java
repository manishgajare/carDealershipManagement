package Dealership.Profiles.Person;

/**
 * Address of person
 *
 * Created by manishgajare
 */
public class Address {

  private String streetName;
  private String blockNumber;
  private String city;
  private String state;
  private String country;
  private int zipcode;

  protected Address(String streetName, String blockNumber, String city, String state, String country, int zipcode) {
    this.streetName = streetName;
    this.blockNumber = blockNumber;
    this.city = city;
    this.state = state;
    this.country = country;
    this.zipcode = zipcode;
  }

  public String getStreetName() {
    return streetName;
  }

  public String getBlockNumber() {
    return blockNumber;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getCountry() {
    return country;
  }

  public int getZipcode() {
    return zipcode;
  }

  @Override
  public String toString() {
    return "Address: " + streetName +
      ", " + blockNumber +
      ", " + city +
      ", " + state +
      ", " + country +
      " - " + zipcode;
  }
}
