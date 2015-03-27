/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.thecake.model;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author Du
 */
public class Product {

    int id;
    String name;
    int id_category;
    String img_description;
    String egg;
    String description;
    float price;
    ArrayList<Images> listImages;
    String date;
    int oder_count;
    boolean i;

    public Product() {
    }

    public Product(int id, String name, int idCategory, String img_description, String egg, String description, float price, String date) {
        this.id = id;
        this.name = name;
        this.id_category = idCategory;
        this.img_description = img_description;
        this.egg = egg;
        this.description = description;
        this.price = price;
        this.date = date;
    }
    public Product(int id, String name, int idCategory, String img_description, String egg, String description, float price, String date, boolean i) {
        this.id = id;
        this.name = name;
        this.id_category = idCategory;
        this.img_description = img_description;
        this.egg = egg;
        this.description = description;
        this.price = price;
        this.date = date;
        this.i = i;
    }

    public Product(int id, String name, String img_description, String egg, String description, float price, String date) {
        this.id = id;
        this.name = name;
        this.img_description = img_description;
        this.egg = egg;
        this.description = description;
        this.price = price;
        this.date = date;
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

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public String getImg_description() {
        return img_description;
    }

    public void setImg_description(String img_description) {
        this.img_description = img_description;
    }

    public String getEgg() {
        return egg;
    }

    public void setEgg(String egg) {
        this.egg = egg;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return  price;
    }

    public void setPrice(float price) {

        this.price = price;
    }

    public ArrayList<Images> getListImages() {
        return listImages;
    }

    public void setListImages(ArrayList<Images> listImages) {
        this.listImages = listImages;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getOder_count() {
        return oder_count;
    }

    public void setOder_count(int oder_count) {
        this.oder_count = oder_count;
    }

    public boolean isI() {
        return i;
    }

    public void setI(boolean i) {
        this.i = i;
    }

}
