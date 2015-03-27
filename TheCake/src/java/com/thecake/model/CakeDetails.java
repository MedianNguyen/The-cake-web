/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.model;

import com.thecake.connection.MyConnection;
import com.thecake.db.CakeDB;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Die4Top
 */
public class CakeDetails {

    public Product getCakeDetails(int id) {
        Product product = null;
        Connection connec = MyConnection.getConnection();
      
        try {
            CallableStatement call = connec.prepareCall("{call getCakeDetails(?)}");
            call.setInt("id", id);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String img_decription = resultSet.getString("img_description");
                String egg = resultSet.getString("egg");
                String description = resultSet.getString("DESCRIPTIONS");
                float price = resultSet.getFloat("PRICE");
                String date = resultSet.getString("TIMEADDED");
                int id_category = resultSet.getInt("CATEGORY_ID");
                product = new Product(id, name, id_category, img_decription, egg, description, price, date);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }
    
    public String getCategoryName(int cateID){
        String cateName="The cake";        
        Connection connec = MyConnection.getConnection();
      
        try {
            CallableStatement call = connec.prepareCall("{call getCategoryName(?)}");
            call.setInt("id", cateID);           
            ResultSet resultSet = call.executeQuery();  
             while (resultSet.next()) {
                         cateName= resultSet.getString("name");   }         
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cateName;
    }
    
    public ArrayList<Product> getProductsRelatived(int cateID,int cakeID) {
        ArrayList<Product> list = new ArrayList<>();
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getProductFromSameCategory(?, ?)}");
            call.setInt("idcate", cateID);    
            call.setInt("id", cakeID); 
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img_decription = resultSet.getString("img_description");
                String egg = resultSet.getString("egg");
                String description = resultSet.getString("DESCRIPTIONS");
                float price = resultSet.getFloat("PRICE");
                String date = resultSet.getString("TIMEADDED");
                Product product = new Product(id, name, img_decription, egg, description, price, date);
                list.add(product);
            }
        } catch (SQLException e) {
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.ALL, null, ex);
            }
        }
        return list;
    }
}
