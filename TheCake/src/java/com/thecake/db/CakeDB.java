/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.db;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.thecake.connection.MyConnection;
import com.thecake.model.BestSeller;
import com.thecake.model.CartItem;
import com.thecake.model.Category;
import com.thecake.model.Order;
import com.thecake.model.OrderDetail;
import com.thecake.model.Product;
import com.thecake.model.Store;
import com.thecake.model.User;

/**
 *
 * @author Du
 */
public class CakeDB {

    Connection con;
    PreparedStatement st;
    ResultSet rs;

    public CakeDB() {
        con = MyConnection.getConnection();
    }

    public ArrayList<Category> getCategories() {
        ArrayList<Category> list = new ArrayList<>();
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getCategories()}");
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Category c = new Category(id, name);
                list.add(c);
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

    public ArrayList<Product> getProduct(int id_category, int current_page) {
        Connection connec = MyConnection.getConnection();
        ArrayList<Product> list = new ArrayList<>();
        try {
            int page_size = 20;
            CallableStatement call = connec.prepareCall("{call getProduct(?,?,?)}");
            call.setInt("id_category", id_category);
            call.setInt("PageSize", page_size);
            call.setInt("PageNum", current_page);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img_decription = resultSet.getString("img_description");
                String egg = resultSet.getString("egg");
                String description = resultSet.getString("DESCRIPTIONS");
                float price = resultSet.getFloat("PRICE");
                String date = resultSet.getString("TIMEADDED");
                Product product = new Product(id, name, id_category, img_decription, egg, description, price, date);
                list.add(product);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Product> getProductFromIdCategory(int id_category) {
        Connection connec = MyConnection.getConnection();
        ArrayList<Product> list = new ArrayList<>();
        try {

            CallableStatement call = connec.prepareCall("{call getProductFromIdCategory(?)}");
            call.setInt("id_category", id_category);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String img_decription = resultSet.getString("img_description");
                String egg = resultSet.getString("egg");
                String description = resultSet.getString("DESCRIPTIONS");
                float price = resultSet.getFloat("PRICE");
                String date = resultSet.getString("TIMEADDED");
                Product product = new Product(id, name, id_category, img_decription, egg, description, price, date);
                list.add(product);
            }
        } catch (SQLException e) {
        }
        return list;
    }

    public ArrayList<Store> getListStore() {
        ArrayList<Store> list = new ArrayList<>();
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getStore()}");
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String images = resultSet.getString("images");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone_number");
                Store store = new Store(id, name, images, address, phone);
                list.add(store);
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

    public ArrayList<Product> getFeatured() {
        ArrayList<Product> list = new ArrayList<>();
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getFeatured()}");
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

    /**
     *
     * @return
     */
    public ArrayList<Product> getProductNew() {
        ArrayList<Product> list = new ArrayList<>();
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getProductNew()}");
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

    public ArrayList<Product> getBestSellingHome() {
        ArrayList<Product> list = new ArrayList<>();
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getBestSellingTop()}");
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

    public ArrayList<BestSeller> getBestSelling() {
        ArrayList<BestSeller> list = new ArrayList<>();
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getBestSellingTop()}");
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("PRODUCT");
                int total = resultSet.getInt("TONG_BAN");
                BestSeller bestSeller = new BestSeller(id, total);
                list.add(bestSeller);
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

    public Category getTitle(int id) {
        Connection connec = MyConnection.getConnection();
        Category category = new Category();
        try {
            CallableStatement call = connec.prepareCall("{call getTitle(?)}");
            call.setInt("id_category", id);
            ResultSet resultSet = call.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                category = new Category(id, name);
            }
        } catch (SQLException e) {
        }
        return category;
    }

    public CartItem additem(int id) {
        Connection connec = MyConnection.getConnection();
        try {
            CallableStatement call = connec.prepareCall("{call getProductFromID(?)}");
            call.setInt("id", id);
            ResultSet resultSet = call.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String img_decription = resultSet.getString("img_description");
                String egg = resultSet.getString("egg");
                String description = resultSet.getString("DESCRIPTIONS");
                float price = resultSet.getFloat("PRICE");
                String date = resultSet.getString("TIMEADDED");
                Product product = new Product(id, name, img_decription, egg, description, price, date);
                CartItem c = new CartItem(product);
                return c;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public Product getProductFromID(int id) {
        Connection connec = MyConnection.getConnection();
        Product product = new Product();
        try {
            CallableStatement call = connec.prepareCall("{call getProductFromID(?)}");
            call.setInt("id", id);
            ResultSet resultSet = call.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String img_decription = resultSet.getString("img_description");
                String egg = resultSet.getString("egg");
                String description = resultSet.getString("DESCRIPTIONS");
                float price = resultSet.getFloat("PRICE");
                String date = resultSet.getString("TIMEADDED");
                product = new Product(id, name, img_decription, egg, description, price, date);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }

    public User isValidUser(String userName, String pass) {
        try {
            st = con.prepareStatement("Select * from [USER] where ACCOUNT=? and [PASSWORD]=?");
            st.setString(1, userName);
            st.setString(2, pass);
            rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("ID"), userName, rs.getString("PASSWORD"), rs.getString("NAME"), rs.getString("CONTACT_NUMBER"), rs.getString("ADDRESS"), rs.getString("SPECICAL_DATE"), rs.getInt("ROLE"));
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public User getUserByID(int ID) {
        try {
            st = con.prepareStatement("Select * from [USER] where ID=?");
            st.setInt(1, ID);
            rs = st.executeQuery();
            if (rs.next()) {
                return new User(rs.getInt("ID"), rs.getString("NAME"), rs.getString("PASSWORD"), rs.getString("NAME"), rs.getString("CONTACT_NUMBER"), rs.getString("ADDRESS"), rs.getString("SPECICAL_DATE"), rs.getInt("ROLE"));
            }
        } catch (SQLException ex) {

        }
        return null;
    }

    public boolean changePass(String newPass, int ID) {
        try {
            st = con.prepareStatement("update [USER] set [PASSWORD]=? WHERE ID=?");
            st.setString(1, newPass);
            st.setInt(2, ID);
            //boolean test = st.execute();
            st.execute();

            return true;

        } catch (SQLException e) {

        }
        return false;
    }
//    public ArrayList<Order> getUserOrder(int UserID) {
//        ArrayList<Order> list = new ArrayList<>();
//        try {
//            st = con.prepareStatement("Select * from [ORDER] where USER=?");
//            st.setInt(1, UserID);
//            rs = st.executeQuery();
//            while (rs.next()) {
//                list.add(new Order(rs.getInt("ID"), UserID, rs.getString("DELIVERY_ADD"), rs.getString("DELIVERY_NUM"), rs.getInt("PROMOTION"), rs.getString("SPECICAL_SALE"), rs.getString("ORDER_DATE"), rs.getInt("STATUS")));
//            }
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

//    public ArrayList<Order> getOrderUncheck() {
//        ArrayList<Order> list = new ArrayList<>();
//        try {
//            st = con.prepareStatement("Select * from [ORDER] where STATUS=1");
//            rs = st.executeQuery();
//            while (rs.next()) {
//                list.add(new Order(rs.getInt("ID"), rs.getInt("USER"), rs.getString("DELIVERY_ADD"), rs.getString("DELIVERY_NUM"), rs.getInt("PROMOTION"), rs.getString("SPECICAL_SALE"), rs.getString("ORDER_DATE"), rs.getInt("STATUS")));
//            }
//            return list;
//        } catch (SQLException ex) {
//            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
    public ArrayList<OrderDetail> getOrderDetail(int OrderID) {
        ArrayList<OrderDetail> list = new ArrayList<>();
        try {
            st = con.prepareStatement("Select * from [ORDER_DETAIL] where [ID_ORDER]=?");
            st.setInt(1, OrderID);
            rs = st.executeQuery();
            while (rs.next()) {
                list.add(new OrderDetail(rs.getInt("ID"), rs.getInt("PRODUCT"), rs.getInt("QUANTITY"), OrderID));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int insertOrder(Order order) {
        Connection connec = MyConnection.getConnection();
        ResultSet resultSet;
        int id = 0;
        try {
            CallableStatement call = connec.prepareCall("{call insertOrder(?,?,?,?,?,?,?,?)}");
            call.setString("name", order.getName());
            call.setString("address", order.getAddress());
            call.setString("mobile", order.getPhone());
            call.setString("email", order.getEmail());
            call.setFloat("total_money", order.getTotal_money());
            call.setString("order_date", order.getOrder_date());
            call.setString("delivery_date", order.getDelivery_date());
            call.registerOutParameter("id_out", java.sql.Types.INTEGER);
            int i = call.executeUpdate();

            if (i > 0) {
                id = call.getInt("id_out");
                System.out.println("ID=" + String.valueOf(id));

                return id;
            }
        } catch (SQLException e) {
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
            }
        }
        return id;
    }

    public boolean insertOrderDetails(OrderDetail orderDetail) {
        Connection connec = MyConnection.getConnection();
        int id = 0;
        try {
            CallableStatement call = connec.prepareCall("{call insertOrderDetails(?,?,?)}");
            call.setInt("id_product", orderDetail.getPRODUCT_ID());
            call.setInt("quantity", orderDetail.getQUANTITY());
            call.setInt("id_order", orderDetail.getORDER_ID());
            int i = call.executeUpdate();
            if (i > 0) {
                return true;
            }
        } catch (SQLException e) {
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
            }
        }
        return false;
    }

    public ArrayList<Order> getOrder(String query) {
        Connection connec = MyConnection.getConnection();
        Order order = new Order();
        ArrayList<Order> list = new ArrayList<>();
        try {
            CallableStatement call = connec.prepareCall(query);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                float money = resultSet.getFloat("TOTAL_MONEY");
                String order_date = resultSet.getString("ORDER_DATE");
                String delivery_date= resultSet.getString("Delivery_date");
                order = new Order(id, name, address, phone, email, money, order_date,delivery_date);
                list.add(order);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    
    public Order getOrderFromID(int id) {
        Connection connec = MyConnection.getConnection();
        Order order = null ;
        
        try {
            CallableStatement call = connec.prepareCall("{call getOrderFromID(?)}");
            call.setInt("id", id);
            ResultSet resultSet = call.executeQuery();
            if (resultSet.next()) {
                
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                float money = resultSet.getFloat("TOTAL_MONEY");
                String order_date = resultSet.getString("ORDER_DATE");
                String delivery_date= resultSet.getString("Delivery_date");
                order = new Order(id, name, address, phone, email, money, order_date,delivery_date);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return order;
    }
    public boolean UpdateOrder(int id,int status) {
        Connection connec = MyConnection.getConnection();        
        try {
            CallableStatement call = connec.prepareCall("{call updateOrder(?,?)}");
            call.setInt("id", id);
            call.setInt("status", status);
            ResultSet resultSet = call.executeQuery();
            if (resultSet.next()) {
                
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public boolean DeleteOrder(int id) {
        Connection connec = MyConnection.getConnection();        
        try {
            CallableStatement call = connec.prepareCall("{call DeleteOrder(?)}");
            call.setInt("id", id);
            int resultSet = call.executeUpdate();
            if (resultSet!=0) { 
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public boolean DeleteOrderDetails(int id_order) {
        Connection connec = MyConnection.getConnection();        
        try {
            CallableStatement call = connec.prepareCall("{call deleteOrderDetails(?)}");
            call.setInt("id_order", id_order);
            int resultSet=0;
            resultSet = call.executeUpdate();
            if (resultSet!=0) {
                return true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    public ArrayList<Order> searchOrder(String query) {
        Connection connec = MyConnection.getConnection();
        Order order = new Order();
        ArrayList<Order> list = new ArrayList<>();
        try {
            CallableStatement call = connec.prepareCall("{call searchOrder(?)}");
            call.setString("query", query);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                float money = resultSet.getFloat("TOTAL_MONEY");
                String order_date = resultSet.getString("ORDER_DATE");
                String delivery_date= resultSet.getString("Delivery_date");
                order = new Order(id, name, address, phone, email, money, order_date,delivery_date);
                list.add(order);
            }
        } catch (SQLException ex) {
             Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public ArrayList<Order> getOrderDay(String query) {
        Connection connec = MyConnection.getConnection();
        Order order = new Order();
        ArrayList<Order> list = new ArrayList<>();
        try {
            CallableStatement call = connec.prepareCall(query);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                float money = resultSet.getFloat("TOTAL_MONEY");
                String order_date = resultSet.getString("ORDER_DATE");
                String delivery_date= resultSet.getString("Delivery_date");
                order = new Order(id, name, address, phone, email, money, order_date,delivery_date);
                list.add(order);
            }
        } catch (SQLException ex) {
             Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public ArrayList<Order> getOrderMoney(float start ,float and) {
        Connection connec = MyConnection.getConnection();
        Order order = new Order();
        ArrayList<Order> list = new ArrayList<>();
        try {
            CallableStatement call = connec.prepareCall("{call getOrderMoney(?,?)}");
            call.setFloat(1, start);
            call.setFloat(2, and);
            ResultSet resultSet = call.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String phone = resultSet.getString("phone");
                String email = resultSet.getString("email");
                float money = resultSet.getFloat("TOTAL_MONEY");
                String order_date = resultSet.getString("ORDER_DATE");
                String delivery_date= resultSet.getString("Delivery_date");
                order = new Order(id, name, address, phone, email, money, order_date,delivery_date);
                list.add(order);
            }
        } catch (SQLException ex) {
             Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                connec.close();
            } catch (SQLException ex) {
                Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return list;
    }
    public ArrayList<Product> getAllProduct(){
        try {
            st = con.prepareStatement("select * from Product");
            rs= st.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while(rs.next()){
                list.add(new Product(rs.getInt("ID"), rs.getString("Name"), rs.getInt("CATEGORY_ID"), rs.getString("IMG_DESCRIPTION"), rs.getString("EGG"), rs.getString("DESCRIPTIONS"), rs.getFloat("PRICE"), rs.getString("TIMEADDED"), rs.getBoolean("FEATURED")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public ArrayList<Product> getAllProduct(String name,String id, String egg,String Price1,String price2){
        try {
            st = con.prepareStatement("select * from Product where NAME like '%"+name+"%' and ID like '%"+id+"%' and egg like '%"+egg+"%' and price >"+Price1+" and price<"+price2);
            rs= st.executeQuery();
            ArrayList<Product> list = new ArrayList<>();
            while(rs.next()){
                list.add(new Product(rs.getInt("ID"), rs.getString("Name"), rs.getInt("CATEGORY_ID"), rs.getString("IMG_DESCRIPTION"), rs.getString("EGG"), rs.getString("DESCRIPTIONS"), rs.getFloat("PRICE"), rs.getString("TIMEADDED"), rs.getBoolean("FEATURED")));
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    public boolean addProduct(Product p) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            st = con.prepareStatement("insert (Name,Egg,IMG_DESCRIPTION,PRICE)into Product values('"+p.getName()+"','"+p.getEgg()+"','"+p.getImg_description()+"',"+p.getPrice()+")");
            st.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateProduct(Product p) {
        try {
            st = con.prepareStatement("update Product set Name=?,Egg=?,IMG_DESCRIPTION=?,PRICE=? Where id=?");
            st.setString(1, p.getName());
            st.setString(2, p.getEgg());
            st.setString(3, p.getImg_description());
            st.setFloat(4, p.getPrice());
            st.setInt(5, p.getId());
            st.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(CakeDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}

