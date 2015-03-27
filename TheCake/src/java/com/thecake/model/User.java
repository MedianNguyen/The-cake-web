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
public class User {

    private int ID;
    private String ACCOUNT;
    protected String PASSWORD;
    private String NAME;
    private String CONTACT_NUMBER;
    private String ADDRESS;
    private String SPECICAL_DATE;
    int ROLE;

    public User() {
    }

    public User(int ID, String ACCOUNT, String PASSWORD, String NAME, String CONTACT_NUMBER, String ADDRESS, String SPECICAL_DATE, int ROLE) {
        this.ID = ID;
        this.ACCOUNT = ACCOUNT;
        this.PASSWORD = PASSWORD;
        this.NAME = NAME;
        this.CONTACT_NUMBER = CONTACT_NUMBER;
        this.ADDRESS = ADDRESS;
        this.SPECICAL_DATE = SPECICAL_DATE;
        this.ROLE = ROLE;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getACCOUNT() {
        return ACCOUNT;
    }

    public void setACCOUNT(String ACCOUNT) {
        this.ACCOUNT = ACCOUNT;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCONTACT_NUMBER() {
        return CONTACT_NUMBER;
    }

    public void setCONTACT_NUMBER(String CONTACT_NUMBER) {
        this.CONTACT_NUMBER = CONTACT_NUMBER;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getSPECICAL_DATE() {
        return SPECICAL_DATE;
    }

    public void setSPECICAL_DATE(String SPECICAL_DATE) {
        this.SPECICAL_DATE = SPECICAL_DATE;
    }

    public int getROLE() {
        return ROLE;
    }

    public void setROLE(int ROLE) {
        this.ROLE = ROLE;
    }

}
