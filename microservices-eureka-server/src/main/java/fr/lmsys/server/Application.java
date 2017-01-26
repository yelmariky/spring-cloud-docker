package fr.lmsys.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Application {
//	@Autowired
//	org.springframework.cloud.client.discovery.DiscoveryClient client;
	public static void main(String[] args) {
//		 System.setProperty("spring.config.name", "registration-server");
		    SpringApplication.run(Application.class, args);
	}

}
