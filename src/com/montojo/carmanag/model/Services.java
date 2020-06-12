package com.montojo.carmanag.model;

public class Services {

    private int id;
    private String name;
    private int carId;
    private String date;
    private String notes;
    private Float price;


    public Services(int id, String name, int carId, String date, String notes, Float price) {
        this.id = id;
        this.name = name;
        this.carId = carId;
        this.date = date;
        this.notes = notes;
        this.price = price;
    }

    public Services(String name, int carId, String date, String notes, Float price) {
        this.name = name;
        this.carId = carId;
        this.date = date;
        this.notes = notes;
        this.price = price;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Float getPrice() {
        return price;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Service id: " + id + " | car id: " + carId + " | date: " + date + " | price: "+ price + " | notes: " + notes;
    }
}
