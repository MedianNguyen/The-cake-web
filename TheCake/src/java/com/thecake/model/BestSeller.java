/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.thecake.model;

/**
 *
 * @author Du
 */
public class BestSeller {
    int id_product;
    int total;

    public BestSeller(int id_product, int total) {
        this.id_product = id_product;
        this.total = total;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}
