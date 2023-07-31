package com.example.controller;
/*
	import java.util.ArrayList;
	import java.util.List;

	import org.springframework.web.bind.annotation.DeleteMapping;
	import org.springframework.web.bind.annotation.PathVariable;
	import org.springframework.web.bind.annotation.PostMapping;
	import org.springframework.web.bind.annotation.PutMapping;
	import org.springframework.web.bind.annotation.RequestBody;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RestController;


		
	@RestController
	public class OrdersEnterpriseAPIController {
		//GET
			@RequestMapping("/api/enterprise/customers/{customerId}/orders")
			//@ResponseBody
			
			public ArrayList<Integer> getorderEnterpriseAPIList(){
				OrdersEnterpriseAPIController customerid=new OrdersEnterpriseAPIController();
				return customerid.getorderEnterpriseAPIList();
			}
		//GET
			@RequestMapping("/api/consumer/orders/{orderId}")
			//@ResponseBody
					
			public ArrayList<Integer> getOrderEnterpriseAPIList1(){
				OrdersEnterpriseAPIController orderid=new OrdersEnterpriseAPIController();
				return orderid.getOrderEnterpriseAPIList1();
			}
		
		//POST
			@PostMapping("/api/enterprise/customers/{customerId}/orders")
			String postOrdering(@RequestBody int cusid) {
				return "Customer Id" + cusid;
			}
			
					
		//PUT
			@PutMapping("/api/enterprise/customers/{customerId}/orders/{orderId}")
				String putCatalog(@PathVariable int customerId,int orderId) {
				return "Customer id " +customerId + "Order id" +orderId;
				}
			
			
				
				
			}
*/
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.EnterpriseOrder;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class EnterpriseOrderController {

    private List<EnterpriseOrder> orders = new ArrayList<>();

    @PostMapping("/api/enterprise/customers/{customerId}/orders")
    public ResponseEntity<EnterpriseOrder> createOrderForEnterpriseCustomer(@PathVariable Long customerId,
                                                                  @RequestBody EnterpriseOrder order) {
        order.setCustomerId(customerId);
        // Add additional logic to save the new order in the database or other storage
        orders.add(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/api/enterprise/customers/{customerId}/orders/{orderId}")
    public ResponseEntity<EnterpriseOrder> updateOrderForEnterpriseCustomer(@PathVariable Long customerId,
                                                                  @PathVariable Long orderId,
                                                                  @RequestBody EnterpriseOrder updatedOrder) {
        Optional<EnterpriseOrder> existingOrderOptional = orders.stream()
                .filter(order -> order.getorderId().equals(orderId) && order.getCustomerId().equals(customerId))
                .findFirst();

        if (existingOrderOptional.isPresent()) {
        	EnterpriseOrder existingOrder = existingOrderOptional.get();
            // Update the existing order properties with the new ones
            existingOrder.setOrderDetails(updatedOrder.getOrderDetails());
            existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            // Update other properties as needed

            return new ResponseEntity<>(existingOrder, HttpStatus.OK);
        } else {
            // If order with given ID not found for the specified customer, return 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/enterprise/customers/{customerId}/orders")
    public ResponseEntity<List<EnterpriseOrder>> getOrdersForEnterpriseCustomer(@PathVariable Long customerId) {
        List<EnterpriseOrder> ordersForCustomer = orders.stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .collect(Collectors.toList());

        return new ResponseEntity<>(ordersForCustomer, HttpStatus.OK);
    }

    @GetMapping("/api/enterprise/orders/{orderId}")
    public ResponseEntity<EnterpriseOrder> getOrderForEnterpriseCustomerById(
                                                                   @PathVariable Long orderId) {
        Optional<EnterpriseOrder> orderOptional = orders.stream()
                .filter(order -> order.getorderId().equals(orderId))
                .findFirst();

        if (orderOptional.isPresent()) {
        	EnterpriseOrder order = orderOptional.get();
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            // If order with given ID not found for the specified customer, return 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
