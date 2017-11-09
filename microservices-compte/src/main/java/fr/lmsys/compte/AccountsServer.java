package fr.lmsys.compte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import fr.lmsys.compte.model.Customer;
import fr.lmsys.compte.services.CustomerRepository;

@SpringBootApplication
//@ActiveProfiles("prod")
@EnableDiscoveryClient
//@EnableWebSecurity
//@ComponentScan(basePackageClasses = CustomerRest.class)
public class AccountsServer implements CommandLineRunner{

	private static final Logger log = LoggerFactory.getLogger(AccountsServer.class);
	@Autowired 
	private CustomerRepository customerRep ;
		 public static void main(String[] args) {
			 // Will configure using accounts-server.yml
		        //System.setProperty("spring.config.name", "accounts-server");

		        SpringApplication.run(AccountsServer.class, args);

}
		 
//		 @FeignClient("EurekaServer")
//			interface HelloClient {
//				@RequestMapping(value = "/", method = GET)
//				String hello();
//			}

		@Override
		public void run(String... arg0) throws Exception {
			customerRep.save(new Customer("EL MARIKY", "ADAM"));
			customerRep.save(new Customer("EL MARIKY", "ILIAS"));
			customerRep.save(new Customer("EL MARIKY", "LINA"));
			customerRep.save(new Customer("LAMNAOUER", "MOUNIA"));
			
			
		}
		
//		@Autowired
//	    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//	        auth
//	            .inMemoryAuthentication()
//	                .withUser("user").password("user").roles("USER");
//	    }
		
}