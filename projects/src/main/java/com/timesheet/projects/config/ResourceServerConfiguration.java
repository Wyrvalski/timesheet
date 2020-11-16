package com.timesheet.projects.config;

import static com.timesheet.commons.domain.Authorities.ADMIN;
import static com.timesheet.commons.domain.Authorities.USER;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import static org.springframework.http.HttpMethod.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Generated
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends WebSecurityConfigurerAdapter implements ResourceServerConfigurer {

    @Value("${spring.security.oauth2.client.resource-ids}")
    private String resourceId;

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http.requestMatchers()
                .antMatchers("/**")
                .and()
                .authorizeRequests()
                .antMatchers(GET, "/v2/api-docs/**",
                        "/configuration/ui",
                        "/swagger-resources/**",
                        "/swagger-ui.html",
                        "/webjars/**").permitAll()
                .antMatchers(GET, "/user/all/**").hasAuthority(ADMIN.name())
                .antMatchers(GET, "/user/*").hasAuthority(USER.name())
                .antMatchers(POST, "/user/*").hasAuthority(USER.name())
                .antMatchers(PUT, "/user/*").hasAuthority(USER.name())
                .antMatchers(PUT, "/userproject/*").hasAuthority(USER.name())
                .anyRequest().hasAuthority(ADMIN.name());
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(resourceId);
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(accessTokenConverter());
    }

    @Bean
    public JwtAccessTokenConverter accessTokenConverter() {
        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
        converter.setSigningKey("zallpy6571");
        return converter;
    }

    @Bean
    @Primary
    public DefaultTokenServices tokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
}
