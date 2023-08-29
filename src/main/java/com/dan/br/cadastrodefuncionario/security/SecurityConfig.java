package com.dan.br.cadastrodefuncionario.security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
// import org.springframework.http.HttpMethod;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

//import com.dan.br.cadastrodefuncionario.web.redirects.MappedApi;

/**
 * SecurityConfig
 */
//@EnableWebSecurity
public class SecurityConfig {//extends WebSecurityConfigurerAdapter {

    //@Override
   // protected void configure(HttpSecurity http) throws Exception {

        // http.authorizeRequests()
        //         .antMatchers("/home", "/image/**").permitAll()
        //         .antMatchers(HttpMethod.DELETE, "/api/**").authenticated()
        //         .antMatchers(HttpMethod.PUT, "/api/**").authenticated()
        //         .antMatchers(HttpMethod.GET, "/**").permitAll()
        //         .anyRequest().authenticated()
        //         .and()
        //         .formLogin().loginPage("/login")

        //         .defaultSuccessUrl("/home", true)
                // .successHandler((request, response, authentication) -> {

                //     if (request.getMethod().equalsIgnoreCase(HttpMethod.DELETE.toString()) &&
                //             request.getRequestURI().contains(MappedApi.FUNCIONARIOS.getUri())) {

                //         response.sendRedirect(MappedApi.FUNCIONARIOS.getUri());
                //     }else{
                //          // response.sendRedirect("/home");

                //     }


                // })
                //.failureUrl("/login-error").permitAll().and().logout().logoutUrl("/logout").logoutSuccessUrl("/home");

        //http.csrf().disable();

    //}

}