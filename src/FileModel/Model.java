/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileModel;

import FileEntity.Entity;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Le Thanh Tung
 */
public class Model {

    public boolean SaveDB(Entity en) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fliefrom", "root", "");
            String sql = "insert into manageruser(name,img,price) values (?,?,?)";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            prepareStatement.setString(1, en.getName());
            prepareStatement.setString(2, en.getImg());
            prepareStatement.setString(3, en.getPrice());
            prepareStatement.execute();
            return true;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    public ArrayList<Entity> Query() {
        ArrayList<Entity> list = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fliefrom", "root", "");
            String sql = "select * from manageruser";
            PreparedStatement prepareStatement = con.prepareStatement(sql);
            ResultSet rs = prepareStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String img = rs.getString("img");
                String price = rs.getString("price");
                Entity en = new Entity(name, img, price);
                list.add(en);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return list;

    }
    public static void main(String[] args) {
        Model model =new Model();
        model.Query();
    }
}
