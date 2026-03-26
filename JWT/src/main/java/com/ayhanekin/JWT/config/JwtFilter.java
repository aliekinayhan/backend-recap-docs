package com.ayhanekin.JWT.config;

import com.ayhanekin.JWT.service.JWTService;
import com.ayhanekin.JWT.service.UserDetailsServiceImpl;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter { // Work once per request

    /*
        we have to manipulate jwt token that's why we have it
        extractUsername(),
        */
    private final JWTService jwtService;
    /*
    we need it to search whether username that we took from token is there in database or not
    we have to validate user in database
    */
    private final UserDetailsServiceImpl userDetailsService;

    public JwtFilter(JWTService jwtService, UserDetailsServiceImpl userDetailsService) {
        this.jwtService = jwtService;
        this.userDetailsService = userDetailsService;
    }

    /*
    every request should go through this method it is like bouncer :D
    */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        /*
        we took Authorization title from request object because user sends it via http request
        if there is no Authorization title it'll return null and authHeader will be null
        */
        String authHeader = request.getHeader("Authorization");

        String token = null;
        String username = null;

        /*
        There is two condition we are looking for
        is authHeader has some value and is it starts with "Bearer "
        "Bearer " is the beginning of the token if the token is not starts with
        "Bearer " then it means it's not the token so pass it
        Bearer comes from OAuth2 standard, it means "whoever carries this token has access"
        It also tells the server this is JWT authentication, not Basic Auth or another scheme
        */
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            /*
            pass the "Bearer " and go with only token
            */
            token = authHeader.substring(7);
            /*
            Decode the payload to take the username
            */
            username = jwtService.extractUsername(token);
        }

        /*
                                    2 condition
        is there any username and if there is username does spring security knows it
        if the user is not in spring security just go on
        if the user in spring security don't take it to the spring security again
        */
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            /*
            we are going to the database with the username we took from token to check if
            this user is existed or not
            */
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            /*
                                        2 condition
            is token expired and is the username at the db and token is same if it is let
            the user in
            */
            if (jwtService.validateToken(token, userDetails)) {
                /*
                we do create object to tell the spring security this user is validated
                */
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        // user details
                        userDetails,
                        // password is null because token already proves the identity,
                        // no need for password check
                        null,
                        // roles the user have
                        userDetails.getAuthorities()
                );

                /*
                We are adding the ip address of the request and session info to the token
                we might use it for logging or security controls its optional but best practice is
                adding this
                */
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                /*
                Most critical line: we are telling to the spring security that this user has been
                logged in trust him and @preauthorize, rol control
                and authentication.getName(); would work on it
                */
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        /*
        it means the logic is done keep going to do if we wouldn't put this line request
        would stick in here
        */
        filterChain.doFilter(request, response);
    }
}