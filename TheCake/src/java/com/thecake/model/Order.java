/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thecake.model;

/**
 *
 * @author Link Larkin
 */
public class Order {
   private int id;
    private String name;
    private String address;
    private String phone;
    private String email;
    private float total_money;
    private String order_date;
    private String delivery_date;

    public Order() {
    }

    public Order(String name, String address, String phone, String email, float total_money, String order_date,String delivery_date) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.total_money = total_money;
        this.order_date = order_date;
        this.delivery_date=delivery_date;
    }
    
    public Order(int id, String name, String address, String phone, String email, float total_money, String order_date,String delivery_date) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.total_money = total_money;
        this.order_date = order_date;
        this.delivery_date=delivery_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getTotal_money() {
        return total_money;
    }

    public void setTotal_money(float total_money) {
        this.total_money = total_money;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public String getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(String delivery_date) {
        this.delivery_date = delivery_date;
    }

    
    
}
