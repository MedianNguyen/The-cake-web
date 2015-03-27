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
public class OrderDetail {

    private int ID;
    private int PRODUCT_ID;
    private int QUANTITY;
    private int ORDER_ID;
    public OrderDetail() {
    }

    public OrderDetail(int PRODUCT_ID, int QUANTITY, int ORDER_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
        this.QUANTITY = QUANTITY;
        this.ORDER_ID = ORDER_ID;
    }

    public OrderDetail(int ID, int PRODUCT_ID, int QUANTITY, int ORDER_ID) {
        this.ID = ID;
        this.PRODUCT_ID = PRODUCT_ID;
        this.QUANTITY = QUANTITY;
        this.ORDER_ID = ORDER_ID;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getPRODUCT_ID() {
        return PRODUCT_ID;
    }

    public void setPRODUCT_ID(int PRODUCT_ID) {
        this.PRODUCT_ID = PRODUCT_ID;
    }

    public int getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(int QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public int getORDER_ID() {
        return ORDER_ID;
    }

    public void setORDER_ID(int ORDER_ID) {
        this.ORDER_ID = ORDER_ID;
    }

}
