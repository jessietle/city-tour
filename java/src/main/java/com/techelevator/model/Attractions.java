package com.techelevator.model;

public class Attractions {

    private String name;
    private int id;
    private String address;
    private String image;
    private int rate;
    private String type;
    private String description;

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public Attractions(int id, String name, String description, String type) {
        this.name = name;
        this.id =id;
        this.description = description;
        this.type = type;


    }

    public Attractions (int id, String name, String address, String description, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.type = type;
    }

    public Attractions (String name, String address, String description, String type) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.type = type;

    }

    public Attractions (int id, String name, String address, String description, String image, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.image = image;
        this.type = type;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }




    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Attractions () {

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}
