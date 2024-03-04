package com.chulbul.hotelbooking.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.context.SecurityContextRepository;

public class UsernamepwdAuthenticationProvider {

    @Autowired
    UserDetailsServiceImpl userDetailService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    SecurityContextRepository securityContextRepository;

    public boolean login(String userName, String password, HttpServletRequest request, HttpServletResponse response){
        UserDetails userDetails = userDetailService.loadUserByUsername(userName);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
         authenticationManager.authenticate(token);
         boolean result = token.isAuthenticated();

         if(result){
             SecurityContext context = SecurityContextHolder.getContext();
             context.setAuthentication(token);
             securityContextRepository.saveContext(context, request, response);
         }
         return result;
    }
}
