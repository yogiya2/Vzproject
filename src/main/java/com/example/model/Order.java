package com.example.model;
/*
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class Order {
	 private String name;
	 private int orderId;
	
	
	public int getOrderId() {
		
		return this.orderId;
	}
	public String getName() {
		return this.name;
	}
	public void setOrderId(int num) {
		this.orderId=num;
	}
	public void setName(String n) {
		this.name=n;
	}
	/*Ordering_API(String name){
			this.name=name;
	}
	public void test()
	{
		System.out.println("Ordering API");
	}
	/*
	ArrayList<Integer>getOrdering_APIList(){
		ArrayList<Integer>customerid=new ArrayList<Integer>();
		customerid.add(001);
		customerid.add(002);
		customerid.add(004);
		return customerid;
	}
	ArrayList<Integer>getOrdering_APIList1(){
			ArrayList<Integer>orderid=new ArrayList<Integer>();
			orderid.add(1);
			orderid.add(2);
			orderid.add(3);
		return orderid;
	}
	ArrayList<Integer>getOrdering_APIList2(){
		ArrayList<Integer>sorderid=new ArrayList<Integer>();	
		sorderid.add(1);
		sorderid.add(2);
		sorderid.add(3);
	return sorderid;
}
	

}*/

public class Order {
    private Long orderId;
    private Long customerId;
    private String orderDetails;
    private double totalAmount;
  
    // Add more properties as needed

    // Constructors
    public Order() {
    }

    public Order( Long orderId,Long customerId, String orderDetails, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDetails = orderDetails;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public Long getorderId() {
        return orderId;
    }

    public void setorderId(Long id) {
        this.orderId = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(String orderDetails) {
        this.orderDetails = orderDetails;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public void test()
	{
		System.out.println("Ordering API");
	}

    // Other methods (optional)
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDetails='" + orderDetails + '\'' +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

