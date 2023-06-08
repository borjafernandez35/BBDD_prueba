package edu.upc.eetac.dsa.model;

import java.util.Objects;

public class Aim {
    int id;
    String name;
    String description;
    double price;
    String imagePhoto;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aim aim = (Aim) o;
        return Double.compare(aim.price, price) == 0 && Objects.equals(name, aim.name) && Objects.equals(description, aim.description) && Objects.equals(imagePhoto, aim.imagePhoto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, price, imagePhoto);
    }

    @Override
    public String toString() {
        return "Aim{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imagePhoto='" + imagePhoto + '\'' +
                '}';
    }

    public Aim(int id, String name, String description, double price, String imagePhoto) {
        this.id=id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePhoto = imagePhoto;
    }
    public Aim( String name, String description, double price, String imagePhoto) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imagePhoto = imagePhoto;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImagePhoto() {
        return imagePhoto;
    }

    public void setImagePhoto(String imagePhoto) {
        this.imagePhoto = imagePhoto;
    }
}
