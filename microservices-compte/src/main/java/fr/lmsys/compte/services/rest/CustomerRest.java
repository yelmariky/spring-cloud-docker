package fr.lmsys.compte.services.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lmsys.compte.model.Customer;
import fr.lmsys.compte.services.CustomerRepository;

@Profile("prod")
@RestController
@RequestMapping("/customers")
public class CustomerRest {
	@Autowired
	private CustomerRepository customDAO;
	@RequestMapping("/{id}")
    public Customer find(@PathVariable String id) {
		 return  customDAO.findOne(Long.parseLong(id)) ;
    }
}
