package com.neuromotion.service;

import com.neuromotion.model.User;

public interface ILoginService {

    User checkUsername(String username);
    void changePassword(String password, String username);

    User findPerfil(String username);
}
