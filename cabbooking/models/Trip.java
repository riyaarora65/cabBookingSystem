package cabbooking.models;

import  cabbooking.models.rating.*;

public class Trip{

	public Customer customer;
	public Driver driver;
	public CustomerRating customerRatings;
	public DriverRating driverRatings;

	public Trip(Customer customer, Driver driver, CustomerRating customerRatings, DriverRating driverRatings){
		
		this.customerRatings = customerRatings;
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
		this.driverRatings = driverRatings;
	}

	public CustomerRating getCustomerRating(){
		return customerRatings;
	}

	public void setCustomerRating(CustomerRating customerRatings){
		this.customerRatings = customerRatings;
	}


}