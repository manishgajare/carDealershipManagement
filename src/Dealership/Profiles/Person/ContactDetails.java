package Dealership.Profiles.Person;

/**
 * Contact details of person
 *
 * Created by manishgajare
 */
public class ContactDetails {

  private String phoneNumber;
  private String email;

  protected ContactDetails(String phoneNumber, String email) {
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    return "ContactDetails: " +
      "phoneNumber: " + phoneNumber +
      ", email: " + email;
  }
}
