package com.ohgiraffers.main;

import com.ohgiraffers.io.menuIO;
import com.ohgiraffers.service.MenuService;

public class Application {

  public static void main(String[] args) {


    int menuCode = 0;
    String menuName = null;
    int menuPrice = 0;

    MenuService menuService = new MenuService();

    menuIO.select();

  }

}
