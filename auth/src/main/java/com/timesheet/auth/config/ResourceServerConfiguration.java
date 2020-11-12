package com.timesheet.auth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.http.HttpMethod.POST;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

  @Value("${spring.security.oauth2.client.resource-ids}")
  private String resourceId;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) {
    resources.resourceId(resourceId);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
    http.requestMatchers()
        .antMatchers("/**")
        .and()
        .authorizeRequests()
        .antMatchers(GET, "/v1/api-docs",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
        .antMatchers(POST, "/**").hasAuthority("USER")
        .antMatchers(GET, "/v1/user").hasAuthority("USER")
        .anyRequest().hasAuthority("ADMIN")
        .anyRequest()
        .authenticated()
        .and()
        .csrf()
        .disable()
        .sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }
}
