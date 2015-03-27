/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.model;

/**
 *
 * @author duhv_b01349
 */
public class CartItem {

    Product p;
    private int quantity;
    float total;

    public CartItem(Product p) {
        this.p = p;
        quantity = 1;
    }

    public Product getP() {
        return p;
    }

    public float getTotal() {
        return quantity * p.price;
    }

    public void setP(Product p) {
        this.p = p;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int incrementQuantity() {
        return quantity++;

    }

}
