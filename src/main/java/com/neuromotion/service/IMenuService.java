package com.neuromotion.service;

import com.neuromotion.model.Menu;

import java.util.List;

public interface IMenuService extends ICRUD<Menu, Integer>{

    List<Menu> getMenusByUsername(String username);

}
