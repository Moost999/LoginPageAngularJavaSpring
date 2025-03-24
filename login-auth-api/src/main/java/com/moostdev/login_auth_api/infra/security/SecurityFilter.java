package com.moostdev.login_auth_api.infra.security;

import com.moostdev.login_auth_api.domain.user.User;
import com.moostdev.login_auth_api.repositories.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.Optional;
import java.util.logging.Logger;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private static final Logger LOGGER = Logger.getLogger(SecurityFilter.class.getName());

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            var token = recoverToken(request);
            if (token == null) {
                LOGGER.warning("Token not found in request.");
                filterChain.doFilter(request, response);
                return;
            }

            var login = tokenService.validateToken(token);
            if (login == null) {
                LOGGER.warning("Invalid token.");
                filterChain.doFilter(request, response);
                return;
            }

            LOGGER.info("User email extracted from token: " + login);

            Optional<User> userOptional = userRepository.findByEmail(login);
            if (userOptional.isEmpty()) {
                LOGGER.warning("User not found in database: " + login);
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "User not found");
                return;
            }

            User user = userOptional.get();
            var authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
            var authentication = new UsernamePasswordAuthenticationToken(user, null, authorities);
            SecurityContextHolder.getContext().setAuthentication(authentication);

            LOGGER.info("User authenticated successfully: " + user.getEmail());

        } catch (Exception e) {
            LOGGER.severe("Error in SecurityFilter: " + e.getMessage());
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Internal Authentication Error");
            return;
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return null;
        }
        return authHeader.replace("Bearer ", "").trim();
    }
}
