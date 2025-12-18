package com.ohgiraffers.io;

import com.ohgiraffers.dto.MenuDTO;
import com.ohgiraffers.service.MenuService;

import java.util.List;
import java.util.Scanner;

public class menuIO {
  static Scanner sc = new Scanner(System.in);
  static MenuService menuService = new MenuService();

  public static void select(){
    List<MenuDTO> menuDTOS = menuService.selectAllMenu();
    System.out.println("====== menu 목록 =====");
    for (MenuDTO menuDTO : menuDTOS) {
      System.out.println(menuDTO);
    }
  }
  public static void update() {


    System.out.print("변경할 메뉴 번호 : ");
    int menuCode = sc.nextInt();

    System.out.print("변경할 메뉴 이름 : ");
    sc.nextLine();
    String menuName = sc.nextLine();

    System.out.print("변경할 메뉴 가격 : ");
    int menuPrice = sc.nextInt();

    MenuDTO modifyMenu = new MenuDTO(menuCode, menuName, menuPrice);
    int result = menuService.modifyMenu(modifyMenu);

    if (result > 0) {
      System.out.println(menuCode + "번 메뉴가 수정되었습니다.");
    } else {
      System.out.println("메뉴코드가 잘 못 입 력 되 었 습 니 다");
    }
  }
  public static void delete(){
    System.out.println("삭제할 메뉴 번호 : ");
    int menuId = sc.nextInt();
    int result = menuService.deleteMenu(menuId);

    if (result > 0) {
      System.out.println(menuId + "번 메뉴가 수정되었습니다.");
    } else {
      System.out.println("메뉴코드가 잘 못 입 력 되 었 습 니 다");
    }
  }

  public static void insert() {
    System.out.print("추가할 메뉴 이름 : ");
    String menuName = sc.nextLine();

    System.out.print("추가할 메뉴 가격 : ");
    int menuPrice = sc.nextInt();

    List<MenuDTO> menuDTOS = menuService.selectAllMenu();
    MenuDTO newMenu = new MenuDTO(menuDTOS.get(menuDTOS.size()-1).getMenuCode()+1, menuName, menuPrice);
    int result = menuService.insertMenu(newMenu);

    if (result > 0) {
      System.out.println(newMenu.getMenuCode() + "번 메뉴가 추가되었습니다.");
    } else {
      System.out.println("메뉴코드가 잘 못 입 력 되 었 습 니 다");
    }
  }
}
