package com.ohgiraffers.main;

import com.ohgiraffers.io.menuIO;
import com.ohgiraffers.service.MenuService;

import java.util.Scanner;

public class Application {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int input = -1;
    MenuService menuService = new MenuService();
    do {
      System.out.println("1.전체 메뉴 출력");
      System.out.println("2.메뉴 수정");
      System.out.println("3.메뉴 삭제");
      System.out.println("4.메뉴 삽입");
      System.out.println("0.종료");
      System.out.print("메뉴 번호를 입력하세요 : ");
      input = sc.nextInt();
      sc.nextLine();
      switch (input) {
        case 1:
          menuIO.select();break;
        case 2:
          menuIO.update();break;
        case 3:
          menuIO.delete();break;
        case 4:
          menuIO.insert();break;
        case 0:break;
        default:
          System.out.println("올바른 메뉴번호를 입력하세요.");
      }
    }
    while (input != 0);
    System.out.println("안녕히 가세요!");
  }

}
