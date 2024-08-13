package com.example.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.HttpSecurityDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((val)->
                        val.requestMatchers("/user/logIn", "/user/sinUp", "/").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin((arg)-> arg.disable())//혼자 해보기
                .logout((val)->              //얘도 혼자 해보기
                        val.logoutUrl("/logout")
                                .logoutSuccessUrl("/")
                );
                //.oauth2Login()

        return http.build();

    }
}
