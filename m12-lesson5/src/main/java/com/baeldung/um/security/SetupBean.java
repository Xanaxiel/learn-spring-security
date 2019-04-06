package com.baeldung.um.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.baeldung.um.service.IUserService;
import com.baeldung.um.validation.EmailExistsException;
import com.baeldung.um.web.model.User;

@Component
public class SetupBean {

    @Autowired
    private IUserService userService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    //

    @PostConstruct
    public void setupUser() throws EmailExistsException {
        final User user = new User("admin@fake.com", passwordEncoder.encode("adminpass"));
        userService.registerNewUser(user);
    }

}
