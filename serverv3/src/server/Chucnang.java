/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.G;

/**
 *
 * @author minhduc
 */
public class Chucnang {
    public static boolean CheckNguoiDung(String ten){
        try {
            Statement statement = G.connection.createStatement();
            String sql = "select username from users where username="+"'"+ten+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(resultSet.next()) return true;
            return false;
        } catch (SQLException ex) {
            System.out.println("loi nguoi dung");
            Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public static boolean GroupnotExists(String tennhom){
        try {
            Statement statement = G.connection.createStatement();
            String sql = "select tennhom from nhom where tennhom="+"'"+tennhom+"'";
            ResultSet resultSet = statement.executeQuery(sql);
            if(!resultSet.next()) return true;
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Chucnang.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
