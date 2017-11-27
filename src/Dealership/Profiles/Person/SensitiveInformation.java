package Dealership.Profiles.Person;

/**
 * Soring sensitive information about person
 *
 * Created by manishgajare
 */
public class SensitiveInformation {

  private String SSN;
  private String passportId;
  private String citizenshipCountry;

  protected SensitiveInformation(String SSN, String passportId, String citizenshipCountry) {
    this.SSN = SSN;
    this.passportId = passportId;
    this.citizenshipCountry = citizenshipCountry;
  }

  protected String getSSN() {
    return SSN;
  }

  protected String getPassportId() {
    return passportId;
  }

  protected String getCitizenshipCountry() {
    return citizenshipCountry;
  }
}
