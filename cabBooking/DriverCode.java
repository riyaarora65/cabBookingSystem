package practice.cabBooking;

import practice.cabBooking.services;
import practice.cabBooking.models.*;

public class Driver{
	public static void main(String args[]){
		TripManager tripManager = new TripManager();

		tripManager.addCustomer(new Customer("c1", "Customer1"));
		tripManager.addCustomer(new Customer("c2", "Customer2"));
		tripManager.addCustomer(new Customer("c3", "Customer3"));


		tripManager.addDriver(new Driver("d1", "Driver1"));
		tripManager.addDriver(new Driver("d2", "Driver2"));
		tripManager.addDriver(new Driver("d3", "Driver3"));


		tripManager.addTrip(new Trip("c1", "d1", "5", "4"));
		tripManager.addTrip(new Trip("c2", "d1", "4", "5"));
		tripManager.addTrip(new Trip("c3", "d1", "2", "1"));
		tripManager.addTrip(new Trip("c1", "d2", "1", "5"));
		tripManager.addTrip(new Trip("c2", "d2", "5", "5"));
		tripManager.addTrip(new Trip("c3", "d2", "5", "4"));
		tripManager.addTrip(new Trip("c1", "d3", "2", "3"));
		tripManager.addTrip(new Trip("c2", "d3", "5", "4"));
		tripManager.addTrip(new Trip("c3", "d3", "3", "3"));

		Scanner sc = new Scanner(System.in);

		while(true){
				String customerName = sc.nextLine();

				tripManager.showAverageRatingCustomer(customerName);

				tripManager.findElegibleDriver(customerName);
		}
	}
}