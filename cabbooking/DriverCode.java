package cabbooking;

import cabbooking.services.TripManager;
import cabbooking.models.Customer;
import cabbooking.models.Driver;
import java.util.Scanner;

public class DriverCode {
	public static void main(String args[]){
		TripManager tripManager = new TripManager();

		tripManager.addCustomer(new Customer("c1"));
		tripManager.addCustomer(new Customer("c2"));
		tripManager.addCustomer(new Customer("c3"));


		tripManager.addDriver(new Driver("d1"));
		tripManager.addDriver(new Driver("d2"));
		tripManager.addDriver(new Driver("d3"));

		try{
			tripManager.addTrip("c1", "d1", "5", "4");
			tripManager.addTrip("null", "d1", "4", "5");
			tripManager.addTrip("c3", "d1", "5", "1");
			tripManager.addTrip("c1", "d2", "1", "5");
			tripManager.addTrip("c2", "d2", "5", "5");
			tripManager.addTrip("c3", "d2", "5", "4");
			tripManager.addTrip("c1", "d3", "2", "3");
			tripManager.addTrip("c2", "d3", "5", "4");
			tripManager.addTrip("c3", "d3", "5", "3");
		}
		catch(NumberFormatException e){
			System.out.print("Please enter valid inputs "+ e.toString());
			return;
		}
		catch(IllegalArgumentException e3){
			System.out.print("Please enter valid inputs "+ e3.toString());
			return;
		}
		catch(NullPointerException e){
			System.out.println("Something went wrong "+ e.toString());
			return;
		}

		tripManager.calculateTotalRatings();

		Scanner sc = new Scanner(System.in);

		while(true){
			try{
				String customerName = sc.nextLine();

				if(customerName == null){
					throw new NullPointerException();
				}

				tripManager.showAverageRatingCustomer(customerName);

				tripManager.findElegibleDriver(customerName);
			}
			catch(NullPointerException e){
				System.out.println("Something went wrong "+ e.toString());
				return;
			}

			catch(ArithmeticException e){
				System.out.println("Please enter valid Inputs "+ e.toString());
				return;
			}
			catch(NumberFormatException e){
				System.out.print("Please enter valid inputs "+ e.toString());
				return;
			}
			catch(IllegalArgumentException e3){
				System.out.print("Please enter valid inputs "+ e3.toString());
				return;
			}
			catch(RuntimeException e4){
				System.out.println("Something went wrong "+e4.toString());
				return;
			}
		}
		}
}