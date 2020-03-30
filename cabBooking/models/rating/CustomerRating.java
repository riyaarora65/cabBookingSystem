package practice.cabBooking.models.rating;
import practice.cabBooking.models.Customer;

public class CustomerRating extends Rating
{

	private Customer customer;

	public CustomerRating(Customer customer, Rating rating){
		super(rating);
		this.customer = customer;
	}

	public Customer getCustomer(){
		return customer;
	}

	public void setCustomer(Customer customer){
		this.customer = customer;
	}
}