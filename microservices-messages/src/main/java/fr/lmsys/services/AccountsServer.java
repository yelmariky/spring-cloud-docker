package fr.lmsys.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//
public class AccountsServer {

	private static final Logger log = LoggerFactory.getLogger(AccountsServer.class);

		 public static void main(String[] args) {
		        SpringApplication.run(AccountsServer.class, args);

}
		 
}