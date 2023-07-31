package com.example.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.CatalogAPI;

@RestController
/*public class CatalogController {
	@RequestMapping("/api/catalog")
	//@ResponseBody
	
	public ArrayList<String> getCatalogAPIList(){
		CatalogAPI c=new CatalogAPI();
		return c.getCatalogAPIList();
	}
	@PostMapping("/api/catalog")
	String postCatalog(@RequestBody String data) {
		return "Data posted"+data;
	}
	@PostMapping("/api/catalog2")
	String postCatalog2(@RequestBody CatalogAPI data) {
		return ("Data posted"+data.getUserId()+" "+data.getName());
	}
	@PostMapping("/api/catalog3")
	String postCatalog3(@RequestBody List<CatalogAPI>data) {
		return("Data posted "+data.get(0).getUserId()+" "+data.get(1).getUserId());
			
	}
	@PutMapping("/api/catalog/{id}")
		String putCatalog(@PathVariable int id) {
		return "Data updated " +id;
		}
	@DeleteMapping("/api/catalog/{id}")
	    boolean deleteCatalog(@PathVariable int id) {
		return true;
	}
		
		
	}
*/
@RequestMapping("/api/catalog")
public class CatalogController {

    private List<CatalogAPI> catalogItems = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<CatalogAPI>> getAllCatalogItems() {
        return new ResponseEntity<>(catalogItems, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<CatalogAPI> addCatalogItem(@RequestBody CatalogAPI catalogItem) {
        // Assuming no validation for simplicity.
        // You should add proper validation, error handling, and database integration in a real-world scenario.
        catalogItems.add(catalogItem);
        return new ResponseEntity<>(catalogItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CatalogAPI> updateCatalogItem(@PathVariable Long id, @RequestBody CatalogAPI updatedItem) {
    	Optional<CatalogAPI> existingItemOptional = catalogItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (existingItemOptional.isPresent()) {
            CatalogAPI existingItem = existingItemOptional.get();
           
			// Update the existing item properties with the new ones
            existingItem.setId(updatedItem.getId());
            existingItem.setName(updatedItem.getName());
            existingItem.setDescription(updatedItem.getDescription());
            existingItem.setPrice(updatedItem.getPrice());
            // Update other properties as needed

            return new ResponseEntity<>(existingItem, HttpStatus.OK);
        } else {
            // If item with given ID not found, return 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCatalogItem(@PathVariable Long id) {
    	Optional<CatalogAPI> itemOptional = catalogItems.stream()
                .filter(item -> item.getId().equals(id))
                .findFirst();

        if (itemOptional.isPresent()) {
            CatalogAPI itemToRemove = itemOptional.get();
            // Remove the item from the catalog list
            catalogItems.remove(itemToRemove);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // If item with given ID not found, return 404 Not Found status
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    }





