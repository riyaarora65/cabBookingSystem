import  practice.cabBooking.models.customer;
import  practice.cabBooking.models.driver;
import  practice.cabBooking.models.rating.*;

package practice.cabBooking.models;

public class Trip{

	public Customer customer;
	public Driver driver;
	public CustomerRating customerRatings;
	public DriverRating driverRatings;

	public Trip(Customer customer, Driver driver, CustomerRating customerRatings, DriverRating driverRatings){
		
		this.coustomerRatings = customerRatings;
		this.customer = customer;
		this.driverRatings = driverRatings;
		this.driver = driver;
	}


	public Customer getCustomer(){
		return customer;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}

	public Driver getDriver(){
		return driver;
	}

	public void setDriver(Driver driver){
		this.driver = driver;
	}

	public DriverRating getDriverRating(){
		return driverRatings;
	}

	public void setDriverRating(DriverRating driverRatings){
		this.driverRating = driverRatings;
	}

	public CustomerRating getCustomerRatings(){
		return customerRatings;
	}

	public void setCustomerRating(CustomerRating customerRatings){
		this.customerRatings = customerRatings;
	}


}