package com.vadelic.plants;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@Slf4j
public class WebSecurityConfig {


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return
                http
                        .authorizeRequests()
                        .anyRequest()
                        .permitAll()
//                        .antMatchers("/*/**").permitAll()
                        .and()
                        .oauth2Login()
                        .and().logout()
                        .and().securityContext()
                        .and().csrf().disable()
                        .build();
    }
}
