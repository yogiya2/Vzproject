package com.example.controller;


/*import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


	
@RestController
public class Ordering_API_Controller {
	@GetMapping(value="/order",produces=MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String getData() {
		return "<html>\n"+"<header><title>Welcome</title><?header>\n"+"<body>\n"+"<h1>Hello</h1>world\n"+
				"</body>\n"+"</html>";
		
	}
	/*@GetMapping("/orders/{id}")
	String getData(@PathVariable int id)
	{
		return id+"";
	}*/
	/*//GET
		@RequestMapping("/api/consumer/customers/{customerId}/orders")
		//@ResponseBody
		
		public ArrayList<Integer> getOrdering_APIList(){
			Ordering_API_Controller customerid=new Ordering_API_Controller();
			return customerid.getOrdering_APIList();
		}
	//GET
		@RequestMapping("/api/consumer/orders/{orderId}")
		//@ResponseBody
				
		public ArrayList<Integer> getOrdering_APIList1(){
			Ordering_API_Controller orderid=new Ordering_API_Controller();
			return orderid.getOrdering_APIList1();
		}
	//GET
		@RequestMapping("/api/consumer/orders/status/{orderId}")
		//@ResponseBody
		
		public ArrayList<Integer> getOrdering_APIList2(){
			Ordering_API_Controller sorderid=new Ordering_API_Controller();
			return sorderid.getOrdering_APIList2();
		}*/
		//POST
		/*@PostMapping("/api/consumer/customers/{customerId}/orders")
		List<Ordering_API> postOrder(@PathVariable int customerid,@RequestBody List<Ordering_API>data){
			data.get(0).setOrderId(customerid);
			data.get(1).setOrderId(customerid);
			return data;
			
		}
		
		
				
/*	//PUT
 * String postOrdering(@RequestBody int cusid) {
			return "Customer Id" + cusid;
		} 
		@PutMapping("/api/consumer/customers/{customerId}/orders/{orderId}")
			String putCatalog(@PathVariable int cusid,int orderid) {
			return "Customer id " +cusid + "Order id" +orderid;
			}
		
		
	*/		
			
		




import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping
public class OrderController {

    private List<Order> orders = new ArrayList<>();

    @PostMapping("/api/consumer/customers/{customerId}/orders")
    public ResponseEntity<Order> createOrderForConsumerCustomer(@PathVariable Long customerId,
                                                               @RequestBody Order order) {
        order.setCustomerId(customerId);
        // Add additional logic to calculate the totalAmount or process the order
        orders.add(order);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @PutMapping("/api/consumer/customers/{customerId}/orders/{orderId}")
    public ResponseEntity<Order> updateOrderForConsumerCustomer(@PathVariable Long customerId,
                                                               @PathVariable Long orderId,
                                                               @RequestBody Order updatedOrder) {
        Optional<Order> existingOrderOptional = orders.stream()
                .filter(order -> order.getorderId().equals(orderId) && order.getCustomerId().equals(customerId))
                .findFirst();

        if (existingOrderOptional.isPresent()) {
            Order existingOrder = existingOrderOptional.get();
            // Update the existing order details with the new ones
            existingOrder.setOrderDetails(updatedOrder.getOrderDetails());
            existingOrder.setTotalAmount(updatedOrder.getTotalAmount());
            // Add additional logic for updating other properties as needed

            return new ResponseEntity<>(existingOrder, HttpStatus.OK);
        } else {
            // If order with given ID not found for the specified customer, return 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/consumer/customers/{customerId}/orders")
    public ResponseEntity<List<Order>> getAllOrdersForConsumerCustomer(@PathVariable Long customerId) {
        List<Order> customerOrders = orders.stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .collect(Collectors.toList());
        return new ResponseEntity<>(customerOrders, HttpStatus.OK);
    }

    @GetMapping("/api/consumer/orders/{orderId}")
    public ResponseEntity<Order> getorderId( @PathVariable Long orderId) {
        Optional<Order> orderOptional = orders.stream()
                .filter(order -> order.getorderId().equals(orderId) )
                .findFirst();

        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            return new ResponseEntity<>(order, HttpStatus.OK);
        } else {
            // If order with given ID not found for the specified customer, return 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/consumer/orders/status/{orderId}")
    public ResponseEntity<String> getOrderStatus(@PathVariable Long customerId, @PathVariable Long orderId) {
        Optional<Order> orderOptional = orders.stream()
                .filter(order -> order.getorderId().equals(orderId) && order.getCustomerId().equals(customerId))
                .findFirst();

        if (orderOptional.isPresent()) {
            // Simulate getting the order status (e.g., from a database or external service)
            String orderStatus = "In Progress";
            return new ResponseEntity<>(orderStatus, HttpStatus.OK);
        } else {
            // If order with given ID not found for the specified customer, return 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}



