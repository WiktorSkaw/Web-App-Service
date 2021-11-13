package com.wiktor.WebApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SecSecurityConfig extends WebSecurityConfigurerAdapter {

   // @Autowired
    //MyUserDetailsService userDetailsService;
    @Override
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
          auth.userDetailsService(userDetailsService());
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new MyUserDetailsService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //.csrf().ignoringAntMatchers("/Createuser", "/perform_login").and()
                .cors().and().csrf().disable()
                .authorizeRequests()
                //.antMatchers("/", "/home").permitAll()
                .antMatchers("/Createuser").anonymous()
                .antMatchers("/RegisterForm").anonymous()
                .antMatchers("/Checkuser").anonymous()
                .antMatchers("/images/logo.jpg").anonymous()
                .antMatchers("/AddOfferForm").authenticated()
                .antMatchers("/saveOfferDetails").authenticated()
                //.antMatchers("/LoginSuccess").authenticated()
                .anyRequest().authenticated()
                .and()
                .formLogin().passwordParameter("password")
                .loginPage("/LoginForm")
                .loginProcessingUrl("/perform_login")
                .defaultSuccessUrl("/LoginSuccess")
                .failureUrl("/LoginForm")
                .permitAll()
                .and()
                .logout().logoutSuccessUrl("/LoginForm").permitAll()
                .permitAll();
    }
}
