package com.ohgiraffers.update;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.service.MenuService;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("변경할 메뉴 번호 : ");
        int menuCode = sc.nextInt();

        System.out.print("변경할 메뉴 이름 : ");
        sc.nextLine();
        String menuName = sc.nextLine();

        System.out.print("변경할 메뉴 가격 : ");
        int menuPrice = sc.nextInt();

        MenuDTO modifyMenu = new MenuDTO(menuCode, menuName, menuPrice);
        MenuService menuService = new MenuService();
        int result = menuService.modifyMenu(modifyMenu);

        if (result > 0) {
            System.out.println(menuCode + "번 메뉴가 수정되었습니다.");
        }else {
            System.out.println("메뉴코드가 잘 못 입 력 되 었 습 니 다");
        }
    }

}
