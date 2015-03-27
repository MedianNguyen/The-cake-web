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
public class Images {
    int id_product;
    String url;

    public Images() {
    }

    public Images(int id_product, String url) {
        this.id_product = id_product;
        this.url = url;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
}
