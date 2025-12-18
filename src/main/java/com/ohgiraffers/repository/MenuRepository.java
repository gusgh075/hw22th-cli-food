package com.ohgiraffers.repository;

import com.ohgiraffers.dto.MenuDTO;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

/* Repository(저장소) 계층
 * DBMS를 통해 수행할 CRUD 작업 단위의 메서드를 정의하는 계층
 * */
public class MenuRepository {
    Properties prop;
    Connection con;

    public MenuRepository(Connection con) {
        prop = new Properties();
        this.con = con;
        try {
            prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<MenuDTO> selectAllMenu() {
        Statement stmt = null;
        ResultSet rs = null;
        List<MenuDTO> menuDTOS = new ArrayList<>();
        try {
            String sql = prop.getProperty("selectMenu");
            stmt = con.createStatement();
            stmt.execute(sql);
            rs = stmt.getResultSet();
            while (rs.next()) {
                MenuDTO menu = new MenuDTO(rs.getInt("MENU_CODE"), rs.getString("MENU_NAME"), rs.getInt("MENU_PRICE"));
                menuDTOS.add(menu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(stmt);
            close(rs);
        }
        return menuDTOS;
    }

    public int updateMenu(MenuDTO modifyMenu) {
        int result = 0; // 업데이트 결과 1 또는 0 저장할 변수

        PreparedStatement pstmt = null;
        try {
            String sql = prop.getProperty("updateMenu");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, modifyMenu.getMenuName());
            pstmt.setInt(2, modifyMenu.getMenuPrice());
            pstmt.setInt(3, modifyMenu.getMenuCode());

            result = pstmt.executeUpdate(); // UPDATE 수행

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int deleteMenu(int menuId) {
        int result = 0;
        PreparedStatement pstmt = null;
        try {
            String sql = prop.getProperty("deleteMenu");

            pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, menuId);

            result = pstmt.executeUpdate(); // UPDATE 수행

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int insertMenu(MenuDTO newMenu) {
        int result = 0; // 업데이트 결과 1 또는 0 저장할 변수

        PreparedStatement pstmt = null;
        try {
            String sql = prop.getProperty("insertMenu");

            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, newMenu.getMenuName());
            pstmt.setInt(2, newMenu.getMenuPrice());
            pstmt.setInt(3, newMenu.getMenuCode());

            result = pstmt.executeUpdate(); // UPDATE 수행

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }
}
