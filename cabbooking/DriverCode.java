package cabbooking;

import cabbooking.services.TripManager;
import cabbooking.models.Customer;
import cabbooking.models.Driver;
import java.util.Scanner;

public class DriverCode{
	public static void main(String args[]){
		TripManager tripManager = new TripManager();

		tripManager.addCustomer(new Customer("c1"));
		tripManager.addCustomer(new Customer("c2"));
		tripManager.addCustomer(new Customer("c3"));


		tripManager.addDriver(new Driver("d1"));
		tripManager.addDriver(new Driver("d2"));
		tripManager.addDriver(new Driver("d3"));


		tripManager.addTrip("c1", "d1", "5", "4");
		tripManager.addTrip("c2", "d1", "4", "5");
		tripManager.addTrip("c3", "d1", "2", "1");
		tripManager.addTrip("c1", "d2", "1", "5");
		tripManager.addTrip("c2", "d2", "5", "5");
		tripManager.addTrip("c3", "d2", "5", "4");
		tripManager.addTrip("c1", "d3", "2", "3");
		tripManager.addTrip("c2", "d3", "5", "4");
		tripManager.addTrip("c3", "d3", "3", "3");

		Scanner sc = new Scanner(System.in);

		while(true){
				String customerName = sc.nextLine();

				tripManager.showAverageRatingCustomer(customerName);

				tripManager.findElegibleDriver(customerName);
		}
		}
}