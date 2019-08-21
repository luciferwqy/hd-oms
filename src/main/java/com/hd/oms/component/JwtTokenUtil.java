package com.hd.oms.component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import cn.hutool.core.date.DateUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

/**
 * 
 * ClassName: JWTUtil <br/>
 * Function: JWT工具包. <br/>
 * date: Aug 21, 2017 6:43:48 PM <br/>
 * 
 * @author
 * @version
 * @since JDK 1.7
 */
@Component
public class JwtTokenUtil {

	private final static String SECRET = "hdnbyy";

	public final static String BANGE = "bange";

	@Value("${jwt.expiration}")
	private Integer expiration;

	public Claims getClaimsFromToken(String token) {
		Claims claims;
		try {
			claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
		} catch (Exception e) {
			claims = null;
		}
		return claims;
	}

	public String getBangeFromToken(String authToken) {
		Claims claims = getClaimsFromToken(authToken);
		if (claims == null) {
			return null;
		}
		return (String) claims.get(BANGE);
	}

	public String generateLimitTimeToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(BANGE, userDetails.getUsername());
		return Jwts.builder().setClaims(claims).setExpiration(DateUtil.offsetSecond(new Date(), expiration))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}
	
	public String generateLimitTimeToken(Claims cls) {
		Map<String, Object> claims = new HashMap<String, Object>();
		claims.put(BANGE, cls.get(BANGE));
		return Jwts.builder().setClaims(claims).setExpiration(DateUtil.offsetSecond(new Date(), expiration))
				.signWith(SignatureAlgorithm.HS512, SECRET).compact();
	}

	public boolean validateToken(String authToken, UserDetails userDetails) {
		String bange = getBangeFromToken(authToken);
		if (bange == null) {
			return false;
		}
		return bange.equals(userDetails.getUsername());
	}
	
	/**
     * 刷新token
     */
    public String refreshToken(String token) {
        Claims claims = getClaimsFromToken(token);
        if(claims == null) {
        	return null;
        }
        return generateLimitTimeToken(claims);
    }
}