package com.springboot.EmployeeCRM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer->
                configurer
                        .requestMatchers(HttpMethod.GET,"/api/v1/employees").hasRole("EMPLOYEE")
                .requestMatchers(HttpMethod.GET,"/api/v1/employees/**").hasRole("EMPLOYEE")
                        .requestMatchers(HttpMethod.POST,"/api/v1/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT,"/api/v1/employees").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE,"/api/v1/employees/**").hasRole("ADMIN")
        );
        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf->csrf.disable());
        return http.build();
    }





    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager(){
        UserDetails siva= User.builder()
                .username("siva")
                .password("{noop}siva@2003")
                .roles("EMPLOYEE")
                .build();
        UserDetails nivas= User.builder()
                .username("nivas")
                .password("{noop}nivas@2002")
                .roles("EMPLOYEE","MANAGER")
                .build();
        UserDetails aswin= User.builder()
                .username("aswin")
                .password("{noop}aswin@2001")
                .roles("EMPLOYEE","MANAGER","ADMIN")
                .build();

        return new InMemoryUserDetailsManager(siva,nivas,aswin);
    }*/
}
