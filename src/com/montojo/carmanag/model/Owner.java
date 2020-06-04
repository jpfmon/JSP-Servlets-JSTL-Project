package com.montojo.carmanag.model;

public class Owner {

    private int id;
    private String fullName;
    private int idCardNumber;
    private int phone;
    private String email;


    public Owner(String fullName, int idCardNumber, int phone, String email) {
        this.id = 0;
        this.fullName = fullName;
        this.idCardNumber = idCardNumber;
        this.phone = phone;
        this.email = email;
    }

    public Owner(int id, String fullName, int idCardNumber, int phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.idCardNumber = idCardNumber;
        this.phone = phone;
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        //logic to get id from mysql
        this.id = id;
    }

    public int getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(int idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", idCardNumber=" + idCardNumber +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                '}';
    }
}
