package com.example.model;
/*
import java.util.ArrayList;

import javax.persistence.Entity;

@Entity
public class OrdersEnterpriseAPI {
	 private String name;
	 private int userId;
	public OrdersEnterpriseAPI(){}
	public int getUserId()
	{
		return this.userId;
	}
	public String getName() {
		return this.name;
	}
	public OrdersEnterpriseAPI(String name){
			this.name=name;
		}
	public void test()
	{
		System.out.println("Ordering Enterprise API");
	}
	ArrayList<Integer>getorderEnterpriseAPIList(){
		ArrayList<Integer>customerid=new ArrayList<Integer>();
		customerid.add(001);
		customerid.add(002);
		customerid.add(004);
		return customerid;
	}
	ArrayList<Integer>getorderEnterpriseAPIList1(){
			ArrayList<Integer>orderid=new ArrayList<Integer>();
			orderid.add(1);
			orderid.add(2);
			orderid.add(3);
		return orderid;
	}

}
*/

public class EnterpriseOrder {
    private Long orderId;
    private Long customerId;
    private String orderDetails;
    private double totalAmount;
    // Add more properties as needed

    // Constructors
    public EnterpriseOrder() {
    }

    public EnterpriseOrder(Long orderId, Long customerId, String orderDetails, double totalAmount) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDetails = orderDetails;
        this.totalAmount = totalAmount;
    }

    // Getters and Setters
    public Long getorderId() {
        return orderId;
    }

    public void setId(Long orderId) {
        this.orderId = orderId;
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
		System.out.println("Ordering Enterprise API");
	}

    // Other methods (optional)
    @Override
    public String toString() {
        return "EnterpriseOrder{" +
                "orderId=" + orderId +
                ", customerId=" + customerId +
                ", orderDetails='" + orderDetails + '\'' +
                ", totalAmount=" + totalAmount +
                // Add more properties to the toString method if needed
                '}';
    }
}
