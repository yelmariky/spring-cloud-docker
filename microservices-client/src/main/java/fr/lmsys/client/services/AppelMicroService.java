package fr.lmsys.client.services;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import fr.lmsys.client.compte.Customer;

@Service
public class AppelMicroService {
	
	private final RestTemplate restTemplate;

	private Log log = LogFactory.getLog(getClass());

	@Autowired
	AppelMicroService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
//	@Autowired
//	protected CompteFeignClient cptFeignClient;
//	@HystrixCommand(fallbackMethod = "reliable")
	public Customer callPremierService(String accountNumber){
		Customer customer=restTemplate.getForObject("http://DETAILS-SERVICE/customers/{id}", Customer.class,accountNumber);//cptFeignClient.find(accountNumber);
		String resp = restTemplate.getForObject("http://DEUXIEME-SERVICE/messages/{id}", String.class, "hello");
		if(customer!=null){
			customer.setFirstName(resp);
			return customer;
		}else{
			 throw new ResourceNotFoundException("resource not found");
		}
	}
	
	 public Customer reliable() {
		 Customer customer = new Customer();
		 customer.setFirstName("defaultNamne");
		 customer.setLastName("lasnameDefault");
		    return customer;
		  }
	 
}


