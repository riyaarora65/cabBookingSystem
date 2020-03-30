package cabbooking.models.rating;
import cabbooking.models.Driver;

public class DriverRating extends Rating{

	private Driver driver;

	public DriverRating(Driver driver, Integer rating){
		super(rating);
		this.driver = driver;
	}

	public Driver getDriver(){
		return driver;
	}

	public void setDriver(Driver driver){
		this.driver = driver;
	}


}