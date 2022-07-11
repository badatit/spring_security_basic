package com.example.spring_security_basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

/*
*  WebSecurityConfigurerAdapter is an abstract class implementing Interface WebSecurityConfigure.
*   WebSecurityConfigure define default configuration required for Spring security.
* */
@Configuration
public class ApplicationConfig extends WebSecurityConfigurerAdapter {

    /*
    *   HttpSecurity to configure for Authorization
    * */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll();
        http.authorizeRequests().antMatchers("/greeting/**").hasRole("ADMIN")
                .and().formLogin();
    }

    /*
    * AuthenticationManagerBuilder to configure for Authentication    *  : user and role
    * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("badat").password("210999").roles("ADMIN")
                .and()
                .withUser("thuyvy").password("311209").roles("CUSTOMER");
    }

    /*
    * WebSecurity to disable access from requests to resource of application
    * */
    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    @Bean
    public static NoOpPasswordEncoder passwordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
