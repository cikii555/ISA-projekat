package com.javaguide.ISAprojekat.config;

import com.javaguide.ISAprojekat.security.AuthEntryPoint;
import com.javaguide.ISAprojekat.security.TokenAuthFilter;
import com.javaguide.ISAprojekat.security.TokenUtils;
import com.javaguide.ISAprojekat.service.CustomUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@EnableWebSecurity
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private CustomUserDetailService customUserDetailService;

    @Autowired
    private AuthEntryPoint restAuthenticationEntryPoint;

    @Autowired
    private TokenUtils tokenUtils;


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//                .exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
//                .authorizeRequests().antMatchers("/auth/**").permitAll()
//                .anyRequest().authenticated().and()
//                .cors().and()
//                .addFilterBefore(
//                        new TokenAuthFilter(tokenUtils, customUserDetailService),
//                        BasicAuthenticationFilter.class
//                );
//
       http.cors().and().csrf().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers(HttpMethod.POST,
                "/auth/register/client");
        web.ignoring().antMatchers(HttpMethod.PUT,
                "/auth/clients/update");
//        web.ignoring().antMatchers(HttpMethod.GET, "");
    }
}
/*{
    "id": 1,
    "password": "$2a$10$34m5dosyTARXnOiqIEdM8uXyosZYQtDy75QBPPS7S91Iirn5ORQ8O",
    "email": "client@gmail.com",
    "firstName": "Marko",
    "lastName": "Markovic",
    "phoneNumber": "0601231231",
    "address": {
        "id": 1,
        "country": "Srbija",
        "city": "Novi Sad",
        "street": "Balzakova",
        "streetNumber": "58"
    },
    "jmbg": "439545",
    "gender": "MALE",
    "role": {
        "id": 1,
        "name": "ROLE_CLIENT",
        "authority": "ROLE_CLIENT"
    },
    "penalty": 0,
    "gradedCenter": false,
    "occupation": "student",
    "organizationInformation": "ftn",
    "enabled": false,
    "active": true,
    "accountNonLocked": false,
    "authorities": [
        {
            "id": 1,
            "name": "ROLE_CLIENT",
            "authority": "ROLE_CLIENT"
        }
    ],
    "username": null,
    "credentialsNonExpired": false,
    "accountNonExpired": false
}*/