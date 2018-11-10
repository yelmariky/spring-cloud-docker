package fr.lmsys.proxy.service;

import java.io.Serializable;

public class JwtAuthenticationResponse implements Serializable {

   /**
	 * 
	 */
	private static final long serialVersionUID = -1523213397327773422L;
private final String token;

    public  JwtAuthenticationResponse(String token) {
        this.token = token;
    }

    public  String getToken() {
        return this.token;
    }
}
