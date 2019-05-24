package com.techonologies.developer.alves.icecreamtable.model;

public class Product {
    private String name;
    private String description;
    private String measure;
    private String urlImage;
    private double costValue;

    public Product() {
    }

    public Product(String name, String description, String measure, String urlImage, double costValue) {
        this.name = name;
        this.description = description;
        this.measure = measure;
        this.urlImage = urlImage;
        this.costValue = costValue;
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

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public double getCostValue() {
        return costValue;
    }

    public void setCostValue(double costValue) {
        this.costValue = costValue;
    }
}
