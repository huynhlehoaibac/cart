package com.cross.solutions.cart.core;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author huynhlehoaibac
 * @since 0.0.1-SNAPSHOT
 */
@EnableWebSecurity
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain cartSecurityFilterChain(HttpSecurity http) throws Exception {
    http.authorizeRequests(
            authorize ->
                authorize
                    .antMatchers("/cart/**")
                    .hasAnyAuthority("ROLE_user", "ROLE_admin")
                    .anyRequest()
                    .authenticated())
        .oauth2ResourceServer(oauth2 -> oauth2.jwt());
    return http.build();
  }

  @Bean
  public JwtAuthenticationConverter jwtAuthenticationConverter() {
    JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter =
        new JwtGrantedAuthoritiesConverter();

    JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
    jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
    return jwtAuthenticationConverter;
  }
}
