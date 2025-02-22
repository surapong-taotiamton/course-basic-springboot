package blog.surapong.coursespringboot.controller;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;

@Slf4j
@RestController
public class JwtController {

    public static final String secretKey = "yhuZs0OfR6mzK9Zu7Y6mDHueqYFrLN45";

    @GetMapping("/jwt/create-token")
    public String createJwtToken() {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        Date currentDateTime = new Date();
        Date expireDateTime =new Date( currentDateTime.getTime() + ( 5 * 60 * 1000 )  );

        return Jwts.builder()
                .claim("my-claim-1", "AAAA")
                .claim("my-claim-2", "BBBB")
                .setIssuer("test")
                .setIssuedAt(currentDateTime)
                .setExpiration(expireDateTime)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    @GetMapping("/jwt/verify-token")
    public void verifyToken(@RequestParam("token") String token ) {
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            claims.forEach((s, object) -> {
                log.info("key : {}  value : {}", s, object);
            });
        }

        catch (io.jsonwebtoken.ExpiredJwtException e) {
            log.error("Token has expired!", e);
        } catch (io.jsonwebtoken.SignatureException e) {
            log.error("Invalid signature!", e);
        } catch (Exception e) {
            log.error("Invalid token!", e);
        }
    }





}
