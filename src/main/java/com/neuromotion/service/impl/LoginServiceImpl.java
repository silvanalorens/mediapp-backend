package com.neuromotion.service.impl;

import com.neuromotion.model.User;
import com.neuromotion.repo.ILoginRepo;
import com.neuromotion.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements ILoginService{

    @Autowired
    private BCryptPasswordEncoder bcrypt;

    @Autowired
    private ILoginRepo repo;

    @Override
    public User checkUsername(String username) {
        return repo.checkUsername(username);
    }

    @Override
    public void changePassword(String password, String username) {
        repo.changePassword(bcrypt.encode(password), username);
    }

    @Override
    public User findPerfil(String username) {
        return null;
    }


}
