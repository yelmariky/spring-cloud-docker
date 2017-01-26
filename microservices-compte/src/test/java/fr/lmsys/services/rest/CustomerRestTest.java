package fr.lmsys.services.rest;

import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lmsys.compte.model.Customer;

@RestController
@Profile("test")
@RequestMapping("/customers")
public class CustomerRestTest {
//	@RequestMapping("/{id}")
//    public ResponseEntity<Customer> find(@PathVariable("id") String id){
//		if(Integer.parseInt(id)!=1){
//			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
//		}
//		return new ResponseEntity<Customer>(new Customer("MockFirstName", "MockLastName"),HttpStatus.OK);
//	}
	
	@RequestMapping("/{id}")
    public Customer find(@PathVariable("id") String id){
		
		return new Customer("MockFirstName", "MockLastName");
	}
}
