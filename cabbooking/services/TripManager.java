package cabbooking.services;

import cabbooking.models.Customer;
import cabbooking.models.Driver;
import cabbooking.models.Trip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TripManager{

	List<Trip> trips;
	Map<String, Integer> customerCount;
	Map<String, Integer> driverCount;	
	Map<String, Customer> customerMap;
	Map<String, Driver> driverMap;
	Map<String, Integer> customersTotalRating;
	Map<String, Integer> driversTotalRating;
	Map<String, Double> customersAverageRating;
	Map<String, Double> driversAverageRating;

	public TripManager()
	{
		trips = new ArrayList<Trip>();
		customerMap = new HashMap<String, Customer>();
		customerCount = new HashMap<String, Integer>();
		driverCount = new HashMap<String, Integer>();
		driverMap = new HashMap<String, Driver>();
		customersAverageRating = new HashMap<String, Double>();
		driversAverageRating = new HashMap<String, Double>();
		customersTotalRating = new HashMap<String, Integer>();
		driversTotalRating = new HashMap<String, Integer>();
	}


	public void addCustomer(Customer customer){
		customerMap.put(customer.getId(), customer);
	}

	public void addDriver(Driver driver){
		driverMap.put(driver.getId(), driver);
	}

	public void addTrip(String customerName, String driverName, String customerRated, String driverRated){
		Trip newtrip = TripService.createTrip(customerName, driverName, customerRated, driverRated);
		trips.add(newtrip);

		for(Trip trip: trips){
			
			String customer = trip.getCustomer().getId();

			String driver = trip.getDriver().getId();

			Integer customerRating = trip.getCustomerRating().getRating();

			Integer driverRating = trip.getDriverRating().getRating();

			//here key is customerid and value is total of customer rating
			 if( !(customersTotalRating.containsKey(customer)) && ! (customerCount.containsKey(customer)) )
			 {
			 	customersTotalRating.put(customer, customerRating);
			 	customerCount.put(customer, 1);
			 }
			 else
			 {
			 	customerCount.put(customer, customerCount.get(customer) + 1);
			 	customersTotalRating.put(customer, customersTotalRating.get(customer) + customerRating);
			 }

			 //for count key is driverid and value is count of drivers
			 if( !(driversTotalRating.containsKey(driver)) && !(driverCount.containsKey(driver))) 
			 {
			 	driversTotalRating.put(driver, driverRating);
			 	driverCount.put(driver, 1);
			 }

			 else
			 {
			 	driverCount.put(driver, driverCount.get(driver) +1);
			 	driversTotalRating.put(driver, driversTotalRating.get(driver) + driverRating);
			}
		}

		calculateCustomersAverageRating();
		calculateDriversAverageRating();
	}

	public void calculateCustomersAverageRating()
	{
		//here id is customerid and value is avgrating
		for(Map.Entry<String, Integer> totalRatings: customersTotalRating.entrySet())
		{
				double averageRating = ( (totalRatings.getValue()) / (customerCount.get(totalRatings.getKey())) );
				customersAverageRating.put(totalRatings.getKey(), averageRating);
		}
	}

	public void calculateDriversAverageRating()
	{
		for(Map.Entry<String, Integer> totalRatings: driversTotalRating.entrySet())
		{
				double averageRating =  ((totalRatings.getValue()) / (driverCount.get(totalRatings.getKey())) );
				driversAverageRating.put(totalRatings.getKey(), averageRating);
		}
				
	}

	public double getCustomerAvgRating(String customerID) {
		double avgRating = 0.0;

		for(Map.Entry<String, Double> currentCustomerAvgRating: customersAverageRating.entrySet()){
			if(currentCustomerAvgRating.getKey() == customerID){
				avgRating = currentCustomerAvgRating.getValue();
				break;
			}	
		}
		return avgRating;
	}

	public double getDriverAvgRating(String driverID){
		double avgRating = 0.0;

		for(Map.Entry<String, Double> currentDriverAvgRating: driversAverageRating.entrySet()){
			if(currentDriverAvgRating.getKey() == driverID){
				avgRating = currentDriverAvgRating.getValue();
				break;
			}	
		}
		return avgRating;
	}

	public void showAverageRatingCustomer(String customerName)
	{
		String customerId = "";
		for(Trip trip: trips){
			if(customerName == trip.getCustomer().getName()){
				customerId = trip.getCustomer().getId();
				break;
			}
		}
		double avgRating = getCustomerAvgRating(customerId);
		printCustomerAverageRating(avgRating);
	}

	public void findElegibleDriver(String customerName)
	{
		boolean driverMatch = false;
		String customerId = "";

		for(Trip trip: trips){
			if(customerName == trip.getCustomer().getName()){
				customerId = trip.getCustomer().getId();
				break;
			}
		}

		for(Map.Entry<String, Double> driverAvgRating: driversAverageRating.entrySet())
		{

			double driverAverageRating = driverAvgRating.getValue();
			double customerAvgRating = getCustomerAvgRating(customerId);

			if(driverAverageRating >= customerAvgRating) {
				driverMatch = true;
				printElegibleDriver(driverAvgRating.getKey());
			}
		}

		if (!driverMatch) {
			for (Trip trip : trips) {
				if (trip.getCustomer().getId() == customerId) {
					String driver = trip.getDriver().getId();
					Integer driverRating = trip.getDriverRating().getRating();
					Integer customerRating = trip.getCustomerRating().getRating();
					if (driverRating > 1 && customerRating > 1) {
						driverMatch = true;
						printElegibleDriver(driver);
						}
					}
				}
			}
		else if(!driverMatch)
		{
			System.out.print("No Drivers found");
		}
	}

	public void printElegibleDriver(String driver)
	{
		System.out.println("Elegible Drivers are ");
		String driverName = driverMap.get(driver).getName();
		Double driverAvgRating = getDriverAvgRating(driver);
		System.out.println(driverName + " "+ driverAvgRating);
	}

	public void printCustomerAverageRating(Double customerRating)
	{
		System.out.printf("Average Rating of customer is", customerRating);
	}

	
}