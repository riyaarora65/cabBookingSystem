package practice.cabBooking.models.rating;
import practice.cabBooking.models.Driver;

public class DriverRating extends Rating{

	private Driver driver;

	public DriverRating(Driver driver, Rating rating){
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