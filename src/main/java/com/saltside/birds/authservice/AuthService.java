package com.saltside.birds.authservice;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * Created by mukesh.kumar on 11/25/16.
 */
@Service
public class AuthService {
    private static final String AUTH_SERVICE_URL_KEY = "authServiceUrl";
    public static final String ROLE_ADMIN = "ADMIN";

    public Object getLoggedInUser() {
        Object user = SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        return user;
    }

}
