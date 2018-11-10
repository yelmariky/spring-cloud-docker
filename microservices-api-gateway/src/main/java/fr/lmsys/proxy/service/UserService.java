package fr.lmsys.proxy.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserService implements UserDetailsService {

   
   @Autowired
   private BCryptPasswordEncoder passwordEncoder;      
 
  
   public UserDetails loadUserByUsername(String userId) throws
               UsernameNotFoundException {
//         User user = userDao.findByUsername(userId);
//         if(user == null){
//            throw new UsernameNotFoundException("Invalid username or password.");
//         }
	   List<String> roles = new ArrayList<String>();
		roles.add("ROLE_USER");

		//if(myUser.isAdmin()) {
			//LOGGER.info(() -> String.format("\tUser is admin - email='%s'", email));
			roles.add("ROLE_ADMIN");
		//}
			
			List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
			for(String role : roles) {
				authorities.add(new SimpleGrantedAuthority(role));
			}
			
	    
	   if("younes".equals(userId)){
         return new org.springframework.security.core.userdetails.User(
            "younes", passwordEncoder.encode("younes"), authorities);
         }else{
        	 throw new UsernameNotFoundException("Invalid username or password.");
         }
}

}