package com.montojo.carmanag.model;

import java.util.ArrayList;

public class Car {

    private int id;
    private int owner_id;
    private String brand;
    private String model;
    private ArrayList<Services> services;

    public Car(int id, int owner_id, String brand, String model) {
        this.id = id;
        this.owner_id = owner_id;
        this.brand = brand;
        this.model = model;
        this.services = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public ArrayList<Services> getServices() {
        return services;
    }

    public void setServices(ArrayList<Services> services) {
        this.services = services;
    }

    public int getOwner() {
        return owner_id;
    }

    public void setOwner(int owner_id) {
        this.owner_id = owner_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void newService(String name,String date, String note, Long price){
        int newindex = this.services.size();
        services.add(new Services(newindex,name,this.id,date,note,price));
        System.out.println("New service added");
    }

    @Override
    public String toString() {
        return "Car id: " + id + " | owner id: " + owner_id + " | brand: " + brand + " | model: " + model;
    }
}
