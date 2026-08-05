package com.assettracking.config;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("auditorProvider")
public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {

        //Authentication authentication=SecurityContextHolder.getContext().getAuthentication();

       // if(authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonyymousAuthenticationToken){
            return Optional.of("SYSTEM");
       // }
       // return Optional.of(authentication.getName());
    }
}
