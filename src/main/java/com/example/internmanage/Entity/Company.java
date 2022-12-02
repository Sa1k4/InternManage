package com.example.internmanage.Entity;

public class Company {
    private int cpmy_id;
    private String company_name;
    private String company_legal;
    private String company_licence;
    private String username;
    private String password;
    private int del;

    public int getDel() {
        return del;
    }

    public void setDel(int del) {
        this.del = del;
    }

    public int getCpmy_id() {
        return cpmy_id;
    }

    public void setCpmy_id(int cpmy_id) {
        this.cpmy_id = cpmy_id;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompany_legal() {
        return company_legal;
    }

    public void setCompany_legal(String company_legal) {
        this.company_legal = company_legal;
    }

    public String getCompany_licence() {
        return company_licence;
    }

    public void setCompany_licence(String company_licence) {
        this.company_licence = company_licence;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
