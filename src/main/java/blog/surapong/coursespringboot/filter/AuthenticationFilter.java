package blog.surapong.coursespringboot.filter;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestParam;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

@Accessors(chain = true)
@Slf4j
@RequiredArgsConstructor
public class AuthenticationFilter implements Filter {

    private final String secretKey;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;


        String authHeader = httpServletRequest.getHeader("Authorization");

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // Extract the token

            // You can now decode/validate the token as needed
            log.info("Extracted Token: " + token);

            if (verifyToken(token)) {
                log.info("In authentication filter verify JWT");
                filterChain.doFilter(servletRequest, servletResponse);
            } else {
                httpServletResponse.setStatus(401);
                httpServletResponse.getWriter().write("Authentication fail");
            }
        } else {
            httpServletResponse.setStatus(401);
            httpServletResponse.getWriter().write("Authentication fail");
        }
    }



    public boolean verifyToken( String token ) {
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
            return true;
        }

        catch (io.jsonwebtoken.ExpiredJwtException e) {
            log.error("Token has expired!", e);
            return false;
        } catch (io.jsonwebtoken.SignatureException e) {
            log.error("Invalid signature!", e);
            return false;
        } catch (Exception e) {
            log.error("Invalid token!", e);
            return false;
        }
    }


}
