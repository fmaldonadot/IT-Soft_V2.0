package bus;

import java.io.Serializable;

public class Address implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String street_number;
	private String street_name;
	private String house_number;
	private String city;
	private String state;
	private String country;
	private String zipcode;
	
	public String getStreet_number() {
		return street_number;
	}
	public void setStreet_number(String street_number) throws ExceptionHandler 
	{
		Controler.verifyData( street_number , Controler.patternStreetno , new ExceptionHandler("Invalid Street Number.  Must be between 2 and 4 digits number\n") );
		this.street_number = street_number;
	}
	public String getStreet_name() {
		return street_name;
	}
	public void setStreet_name(String street_name) {
		this.street_name = street_name;
	}
	public String getHouse_number() {
		return house_number;
	}
	public void setHouse_number(String house_number) throws ExceptionHandler 
	{
		Controler.verifyData( house_number , Controler.patternApt , new ExceptionHandler("Invalid Apt/House Number.  Must be digits number\n") );
		this.house_number = house_number;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) throws ExceptionHandler 
	{
		Controler.verifyData( zipcode , Controler.patternZipcode , new ExceptionHandler("Invalid Zip Code.  Must be X9X-9X9\n") );
		this.zipcode = zipcode;
	}
	
	public Address(){}
	
	public Address(String street_number, String street_name, String house_number, String city, String state,
				   String country, String zipcode) {
		super();
		this.street_number = street_number;
		this.street_name = street_name;
		this.house_number = house_number;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
	}
	
	@Override
	public String toString() {
		return street_number + "|, " + street_name + "|, " + house_number + "|, " + city + 
			   "|, " + state + "|, " + country + "|, " + zipcode;
	}	
	
}
