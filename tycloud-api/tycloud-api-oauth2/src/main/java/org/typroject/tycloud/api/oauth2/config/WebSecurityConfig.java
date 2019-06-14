package org.typroject.tycloud.api.oauth2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Order(10)
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailsService userDetailsFitService;
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/oauth/**").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/actuator/**").permitAll()
                .antMatchers("/swagger-ui.html**").permitAll()
                .antMatchers("/webjars/**").permitAll()
                .antMatchers("/css/**").permitAll()
                .antMatchers("/swagger-resources").permitAll()
                .antMatchers("/configuration/**").permitAll()
                .antMatchers("/images/favicon-16x16.png").permitAll()
                .antMatchers("/images/favicon-32x32.png").permitAll()
                .antMatchers("favicon.ico").permitAll()
                .antMatchers("/v2/api-docs/**").permitAll()
                //.antMatchers("/**").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").failureUrl("/login?error")
                .permitAll();
        http.logout().permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsFitService).passwordEncoder(passwordEncoder());
        auth.parentAuthenticationManager(authenticationManagerBean());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

}