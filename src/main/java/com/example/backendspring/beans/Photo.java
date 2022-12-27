package com.example.backendspring.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class Photo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_photo;

    private String url;

    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "id", nullable = false)
    private Restaurant restaurant;

    public int getId() {
        return id_photo;
    }

    public void setId(int id_photo) {
        this.id_photo = id_photo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
