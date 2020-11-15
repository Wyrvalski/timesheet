package com.timesheet.auth.config;

import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CustomJwtTokenEnchancer extends JwtAccessTokenConverter {

  @Override
  public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
    authentication.getPrincipal();
    final Map<String, Object> additionalInfo = new HashMap<>();
    additionalInfo.put("name", authentication.getName());
    Set<String> permissions = new HashSet<>();
    Set<String> roles = new HashSet<>();

    authentication.getAuthorities().forEach(grantedAuthority -> {
      System.out.println(grantedAuthority.getAuthority());
      if (grantedAuthority.getAuthority().startsWith("ROLE_")) {
        roles.add(grantedAuthority.getAuthority());
      } else {
        permissions.add(grantedAuthority.getAuthority());
      }
    });

    additionalInfo.put("name", authentication.getName());
    additionalInfo.put("roles", roles);
    additionalInfo.put("permissions", permissions);

    ((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
    return accessToken;
  }
}
