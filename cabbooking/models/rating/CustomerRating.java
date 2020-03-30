package cabbooking.models.rating;
import cabbooking.models.Customer;


public class CustomerRating extends Rating
{

	private Customer customer;

	public CustomerRating(Customer customer, Integer rating){
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