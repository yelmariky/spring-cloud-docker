package fr.lmsys.proxy.util;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6495989201917673727L;
	static final String CLAIM_KEY_USERNAME = "sub";
    static final String CLAIM_KEY_AUDIENCE = "audience";
    static final String CLAIM_KEY_CREATED = "created";

    private static final String AUDIENCE_UNKNOWN = "unknown";
    private static final String AUDIENCE_WEB = "web";
    private static final String AUDIENCE_MOBILE = "mobile";
    private static final String AUDIENCE_TABLET = "tablet";

	@Value("${jwt.security.key}")
	private String jwtKey;
	@Value("${jwt.access.token.validity.second}")
	private int nbSeconds;
	
	public  String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
       // claims.put(CLAIM_KEY_AUDIENCE, generateAudience(device));
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
/*	
	private  String generateAudience(Device device) {
        String audience = AUDIENCE_UNKNOWN;
        if (device.isNormal()) {
            audience = AUDIENCE_WEB;
        } else if (device.isTablet()) {
            audience = AUDIENCE_TABLET;
        } else if (device.isMobile()) {
            audience = AUDIENCE_MOBILE;
        }
        return audience;
    }
    */

	private String doGenerateToken(String subject) {
		Claims claims = Jwts.claims().setSubject(subject);
		return Jwts.builder().setClaims(claims).setIssuer("http://jwtdemo.com")
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(generateExpirationDate())
				.signWith(SignatureAlgorithm.HS256, jwtKey).compact();
	}
	
	 String generateToken(Map<String, Object> claims) {
	        return Jwts.builder()
	                .setClaims(claims)
	                .setExpiration(generateExpirationDate())
	                .signWith(SignatureAlgorithm.HS512, jwtKey)
	                .compact();
	    }

	public String getUsernameFromToken(String token) {
		String username;
		try {
			final Claims claims = getClaimsFromToken(token);
			username = claims.getSubject();
		} catch (Exception e) {
			username = null;
		}
		return username;
	}

	private Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(jwtKey).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	private Date generateExpirationDate() {
		return new Date(System.currentTimeMillis() + nbSeconds * 1000);
	}

	public Date getExpirationDateFromToken(String token) {
		Date expiration;
		try {
			final Claims claims = getClaimsFromToken(token);
			expiration = claims.getExpiration();
		} catch (Exception e) {
			expiration = null;
		}
		return expiration;
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		// JwtUser user = (JwtUser) userDetails;
		final String username = getUsernameFromToken(token);
		// final Date created = getCreatedDateFromToken(token);
		// final Date expiration = getExpirationDateFromToken(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}
	
	 public  String refreshToken(String token) {
	        String refreshedToken;
	        try {
	            final Claims claims = getClaimsFromToken(token);
	            claims.put(CLAIM_KEY_CREATED, new Date());
	            refreshedToken = generateToken(claims);
	        } catch (Exception e) {
	            refreshedToken = null;
	        }
	        return refreshedToken;
	    }
}