package com.dan.br.cadastrodefuncionario.security;

import org.springframework.http.HttpMethod;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * SecurityConfig
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests(requests -> requests
                .antMatchers("/home", "/image/**").permitAll()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .anyRequest().authenticated())
                .formLogin(login -> login.loginPage("/login")
                        .defaultSuccessUrl("/home", true)
                        .successHandler((request, response, authentication) -> {
                            response.sendRedirect("/home");

                        })
                        .failureUrl("/login-error").permitAll())
                .logout(logout -> logout.logoutUrl("/logout").logoutSuccessUrl("/home"));

        http.csrf().disable();

    }

}