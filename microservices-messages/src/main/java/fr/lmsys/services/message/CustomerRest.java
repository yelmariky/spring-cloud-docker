package fr.lmsys.services.message;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class CustomerRest {
	@RequestMapping("/{id}")
    public String find(@PathVariable String id) {
		 return "deuxieme-service Greetings from Spring Boot! hello "+ id ;
    }
}
