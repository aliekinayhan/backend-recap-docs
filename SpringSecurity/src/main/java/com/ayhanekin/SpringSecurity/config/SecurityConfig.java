package com.ayhanekin.SpringSecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;



@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public AuthenticationProvider authProvider() {

        DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));

        return provider;
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) {
        security.csrf(customize ->
                        customize.disable())
                .authorizeHttpRequests(request ->
                        request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(management ->
                        management.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return security.build();
    }



}


//    @Bean
//    public UserDetailsService userDetailsService () {
//        UserDetails user = User
//                .withDefaultPasswordEncoder()
//                .username("ali")
//                .password("ali6262")
//                .roles("USER")
//                .build();
//
//        UserDetails admin = User
//                .withDefaultPasswordEncoder()
//                .username("ali ekin")
//                .password("ekin6262")
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user,admin);
//    }


//Customizer<CsrfConfigurer<HttpSecurity>> customCsrf =
//        new Customizer<CsrfConfigurer<HttpSecurity>>() {
//            @Override
//            public void customize(CsrfConfigurer<HttpSecurity> customCsrf) {
//                customCsrf.disable();
//            }
//        };
//        security.csrf(customCsrf);
//        security.csrf(customizer -> customizer.disable());
//
//
//Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.
//        AuthorizationManagerRequestMatcherRegistry> customHttpAuthorizer =
//        new Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>
//                .AuthorizationManagerRequestMatcherRegistry>() {
//            @Override
//            public void customize(AuthorizeHttpRequestsConfigurer<HttpSecurity>
//                                          .AuthorizationManagerRequestMatcherRegistry customHttpAuthorizer) {
//                customHttpAuthorizer.anyRequest().authenticated();
//            }
//        };
//        security.authorizeHttpRequests(customHttpAuthorizer);
//        security.authorizeHttpRequests(request ->
//        request.anyRequest().authenticated());
//
//        security.httpBasic(Customizer.withDefaults());
//
//    Customizer<SessionManagementConfigurer<HttpSecurity>> customSessionManagement = new Customizer<SessionManagementConfigurer<HttpSecurity>>() {
//    @Override
//    public void customize(SessionManagementConfigurer<HttpSecurity> customSessionManagement) {
//        customSessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//    }
//      };
//        security.sessionManagement(customSessionManagement);
//
//        security.sessionManagement(session ->
//        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//
//        return security.build();