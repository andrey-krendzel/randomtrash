package com.example.BookStore;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.BookStore.controller.UserDetailServiceImpl;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;


@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	 @Autowired
	    private UserDetailServiceImpl userDetailsService;	


    @Autowired
    private Http403ForbiddenEntryPoint forbiddenEntryPoint;

    @Bean
    public Http403ForbiddenEntryPoint forbiddenEntryPoint() {
        return new Http403ForbiddenEntryPoint();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
             // .antMatchers("/", "/files/**", "/upload-dir/**", "/files", "/upload-dir").permitAll()
            .antMatchers("/delete/**").hasRole("ADMIN")
                .anyRequest().authenticated()
               
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .httpBasic()
                .authenticationEntryPoint(forbiddenEntryPoint)
                .and()
                .csrf().disable()
            .logout()
                .permitAll();
    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}