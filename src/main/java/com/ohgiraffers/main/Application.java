package com.ohgiraffers.main;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.service.MenuService;

public class Application {

    public static void main(String[] args) {


        int menuCode = 0;
        String menuName = null;
        int menuPrice = 0;

        MenuService menuService = new MenuService();

        int result = menuService.modifyMenu(new MenuDTO(menuCode, menuName, menuPrice));
        System.out.println("result = " + result);

    }

}
