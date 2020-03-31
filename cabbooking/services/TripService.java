package cabbooking.services;

import cabbooking.models.Customer;
import cabbooking.models.Driver;
import cabbooking.models.Trip;
import cabbooking.models.rating.*;

public class TripService{

    
    public static Trip createTrip(Customer customer, Driver driver, String customerRating, String driverRating)
    {    
        Integer customerRated = Integer.parseInt(customerRating);
        CustomerRating currentCustomerRating = new CustomerRating(customer, customerRated);
        Integer driverRated = Integer.parseInt(driverRating);
        DriverRating currentDriverRating = new DriverRating(driver, driverRated);

        return new Trip(customer, driver, currentCustomerRating, currentDriverRating);
    }
}