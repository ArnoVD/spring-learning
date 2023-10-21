package com.arnovandijck.springboot.mytodoapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

        public boolean isUserValid(String user, String password) {
            return user.equalsIgnoreCase("arno") && password.equals("dummy");
        }
}
