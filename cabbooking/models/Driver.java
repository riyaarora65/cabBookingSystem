package cabbooking.models;

public class Driver{

	private static int count = 0;
	private String id;
	private String name;

	public Driver(String name){
		this.id = Integer.toString(count++);
		this.name = name;
	}

	public String getId(){
		return id;
	}

	public void setId(String id){
		this.id = id; 
	}

	public String getName(){
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
	
}