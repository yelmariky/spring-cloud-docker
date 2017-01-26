package fr.lmsys.client.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lmsys.client.compte.Customer;


@RestController
@RequestMapping("/premier")
public class AppelMicroServicesRest {
	private static final Log LOG = LogFactory.getLog(AppelMicroServicesRest.class);
	@Autowired
	AppelMicroService service;

	@RequestMapping("/{id}")
	public Customer getCustomer(@PathVariable String id){
		LOG.info("find Customer");
		return  service.callPremierService(id);
	}
	
}
