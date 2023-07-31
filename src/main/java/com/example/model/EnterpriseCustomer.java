package com.example.model;
/*import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class EnterpriseAPI {
	 private String name;
	 private int userId;
	public EnterpriseAPI(){}
	public int getUserId()
	{
		return this.userId;
	}
	public String getName() {
		return this.name;
	}
	EnterpriseAPI(String name){
			this.name=name;
		}
	public void test()
	{
		System.out.println("Enterprising API");
	}
}*/


public class EnterpriseCustomer {
    private Long customerId;
    private String name;
    private String address;
    // Add more properties as needed
    // Also, consider adding lists for associated orders and discounts

    // Constructors
    public EnterpriseCustomer() {
    }

    public EnterpriseCustomer(Long customerId, String name, String address) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
    }

    // Getters and Setters
    public Long getcustomerId() {
        return customerId;
    }

    public void setcustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void test()
	{
		System.out.println("Enterprising API");
	}

    // Other methods (optional)
    @Override
    public String toString() {
        return "EnterpriseCustomer{" +
                "customerId=" + customerId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                // Add more properties to the toString method if needed
                '}';
    }
}
