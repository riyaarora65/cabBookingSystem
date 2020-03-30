package practice.cabBooking.services;

import practice.cabBooking.models.Customer;
import practice.cabBooking.models.Driver;
import practice.cabBooking.models.Trip;
import practice.cabBooking.models.rating.*;

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
		customerCount = new HasMap<String, Integer>();
		driverCount = new HashMap<String, Integer>();
		driverMap = new HashMap<String, Driver>();
		customersAverageRating = new HasMap<String, Double>();
		driversAverageRating = new HashMap<String, Double>();
		customersTotalRating = new HashMap<String, Integer>();
		driversTotalRating = new HasMap<String, Integer>();
	}


	public void addCustomer(Customer customer){
		customerMap.put(customer.getId(), customer>);
	}

	public void addDriver(Driver driver){
		driverMap.put(driver.getId(), driver>);
	}

	public void addTrip(Trip trip){
		trips.add(trip);

		for(Trip trip: trips){
			
			String customer = trip.getCustomer().getId();

			String driver = trip.getDriver().getId();

			String customerRating = trip.getCustomerRating().getRating();

			String driverRating = trip.getDriverRating().getRating();

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
		for(Map.Entry<String, Integer> totalRatings: customersTotalRating.entrySet())
		{
				double averageRating = Double.parseDouble ((totalRatings.getValue()) / (customerCount.get(totalRatings.getKey())) );
				customersAverageRating.put(totalRatings.getKey(), averageRating);
		}
	}

	public void calculateDriversAverageRating()
	{
		for(Map.Entry<String, Integer> totalRatings: driversTotalRating.entrySet())
		{
				double averageRating = Double.parseDouble( (totalRatings.getValue()) / (driverCount.get(totalRatings.getKey())));
				driversAverageRating.put(totalRatings.getKey(), averageRating);
		}
				
	}

	public void showAverageRatingCustomer(Customer customer)
	{

		String customerID = trip.getCustomer().getId();

		printCustomerAverageRating(customersAverageRating.getValue(customerID));
	}

	public void findElegibleDriver(String customer)
	{
		boolean driverMatch = false;
		String customerID = trip.getCustomer().getId();

		for(Map.Entry<String, Double> driverAvgRating: driversAverageRating.entrySet())
		{

			double averageRating = driverAvgRating.getValue();

			if(averageRating > = customersAverageRating.getValue(customerID))
			{
					driverMatch = true;
					printEligibleDriver(driverAvgRating.getKey());
			}
		}
			if(!driverMatch)
			{
				for(Trips trip: trips)
				{
					if(trip.getCustomer().getId() == customerID)
					{
						String driver = trip.getDriver().getId();
						String driverRating = trip.getDriverRating().getRating();
						String customerRating = trip.getCustomerRating().getRating();
						if(driverRating > 1 && customerRating > 1)
						{
							driverMatch = true;
							printEligibleDriver(driver);
						}
					}
				}
			}
		else if(!driverMatch)
		{
			System.out.print("No Drivers found");
		}
	}

	public void printCustomerAverageRating(String customerRating)
	{
		System.out.print("Customer Average Rating is ", customerRating);
	}

	public void printElegibleDriver(String driver)
	{
		System.out.println("Elegible Drivers are ");
		String driverName = driverMap.get(driver).getName();
		Double driverAvgRating = Double.parseDouble(driversAverageRating.getValue(driver));
		System.out.println(driverName + " "+ driverAvgRating);
	}
}