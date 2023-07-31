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
	public class EnterpriseAPIController {
		//GET
			@RequestMapping("/api/enterprise/customers/{customerId}")
			//@ResponseBody
			
			public ArrayList<Integer> getEnterpriseAPIList(){
				EnterpriseAPIController customerId=new EnterpriseAPIController();
				return customerId.getEnterpriseAPIList();
			}
		//GET
			@RequestMapping("/api/enterprise/customers")
			//@ResponseBody
					
			public ArrayList<String> getEnterpriseAPIList1(){
				EnterpriseAPIController c=new EnterpriseAPIController();
				return c.getEnterpriseAPIList1();
			}

		//POST
			@PostMapping("/api/enterprise/customers")
			String postEnterprise(@RequestBody String data) {
				return "Data posted"+data;
			}
			
					
		//PUT
			@PutMapping("/api/enterprise/customers/{customerId}")
				String putEnterprise(@PathVariable int customerId) {
				return "Customer id " +customerId;
				}
			
			
				
				
			}

*/
	
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.model.EnterpriseCustomer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

	@RestController
	@RequestMapping("/api/enterprise/customers")
	public class EnterpriseCustomerController {

	    private List<EnterpriseCustomer> enterpriseCustomers = new ArrayList<>();

	    @PostMapping
	    public ResponseEntity<EnterpriseCustomer> createEnterpriseCustomer(@RequestBody EnterpriseCustomer customer) {
	        // Add additional logic to save the new customer in the database or other storage
	        enterpriseCustomers.add(customer);
	        return new ResponseEntity<>(customer, HttpStatus.CREATED);
	    }

	    @PutMapping("/{customerId}")
	    public ResponseEntity<EnterpriseCustomer> updateEnterpriseCustomer(@PathVariable Long customerId,
	                                                                        @RequestBody EnterpriseCustomer updatedCustomer) {
	        Optional<EnterpriseCustomer> existingCustomerOptional = enterpriseCustomers.stream()
	                .filter(customer -> customer.getcustomerId().equals(customerId))
	                .findFirst();

	        if (existingCustomerOptional.isPresent()) {
	            EnterpriseCustomer existingCustomer = existingCustomerOptional.get();
	            // Update the existing customer properties with the new ones
	            existingCustomer.setcustomerId(updatedCustomer.getcustomerId());
	            existingCustomer.setName(updatedCustomer.getName());
	            existingCustomer.setAddress(updatedCustomer.getAddress());
	            // Update other properties as needed

	            return new ResponseEntity<>(existingCustomer, HttpStatus.OK);
	        } else {
	            // If customer with given ID not found, return 404 Not Found status
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

	    @GetMapping
	    public ResponseEntity<List<EnterpriseCustomer>> getAllEnterpriseCustomers() {
	        return new ResponseEntity<>(enterpriseCustomers, HttpStatus.OK);
	    }

	    @GetMapping("/{customerId}")
	    public ResponseEntity<EnterpriseCustomer> getEnterpriseCustomerById(@PathVariable Long customerId) {
	        Optional<EnterpriseCustomer> customerOptional = enterpriseCustomers.stream()
	                .filter(customer -> customer.getcustomerId().equals(customerId))
	                .findFirst();

	        if (customerOptional.isPresent()) {
	            EnterpriseCustomer customer = customerOptional.get();
	            return new ResponseEntity<>(customer, HttpStatus.OK);
	        } else {
	            // If customer with given ID not found, return 404 Not Found status
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	}



