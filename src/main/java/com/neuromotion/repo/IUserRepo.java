package com.neuromotion.repo;

import com.neuromotion.model.User;

public interface IUserRepo extends IGenericRepo<User, Integer>  {

    //from user where username = ?
    //Derived Query
    User findOneByUsername(String username);
}
