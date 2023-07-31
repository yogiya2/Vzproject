package com.example.model;

/*import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class CatalogAPI {
	 private String name;
	 private int userId;
	public CatalogAPI(){}
	public int getUserId()
	{
		return this.userId;
	}
	public String getName() {
		return this.name;
	}
	CatalogAPI(String name){
			this.name=name;
		}
	public void test()
	{
		System.out.println("Catalogging API");
	}
	public ArrayList<String>getCatalogAPIList(){
		ArrayList<String>products=new ArrayList<String>();
		products.add("wires");
		products.add("fibres");
		products.add("cables");
		return products;
		
		
	}

}
*/



	public class CatalogAPI {
	    private Long id;
	    private String name;
	    private String description;
	    private double price;
	    // Add more properties as needed

	    // Constructors
	    public CatalogAPI() {
	    }

	    public CatalogAPI(Long id, String name, String description, double price) {
	        this.id = id;
	        this.name = name;
	        this.description = description;
	        this.price = price;
	    }

	    // Getters and Setters
	    public Long getId() {
	        return id;
	    }

	    public void setId(Long id) {
	        this.id = id;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public String getDescription() {
	        return description;
	    }

	    public void setDescription(String description) {
	        this.description = description;
	    }

	    public double getPrice() {
	        return price;
	    }

	    public void setPrice(double price) {
	        this.price = price;
	    }
	    public void test()
		{
			System.out.println("Catalogging API");
		}

	    // Other methods (optional)
	    @Override
	    public String toString() {
	        return "CatalogItem{" +
	                "id=" + id +
	                ", name='" + name + '\'' +
	                ", description='" + description + '\'' +
	                ", price=" + price +
	                // Add more properties to the toString method if needed
	                '}';
	    }
	}

	


