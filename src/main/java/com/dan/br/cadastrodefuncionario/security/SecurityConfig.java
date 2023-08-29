package com.dan.br.cadastrodefuncionario.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       
        http.authorizeRequests()
        .antMatchers("/home", "/", "/image/**").permitAll()
        .anyRequest().authenticated()
        .and()
            .formLogin().loginPage("/login")
            .defaultSuccessUrl("/home", true)
            .failureUrl("/login").permitAll()
        .and()
            .logout()
            .logoutUrl("/logout")
            .logoutSuccessUrl("/home");

        http.csrf().disable();

    }

    
}