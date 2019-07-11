package com.proxym.location.dto;

import com.proxym.location.entity.Image;


public class LocationDto {


    private Integer id;

    private String name;

    private String place;

    private String description;

    private String id_user;

    private Image image;

    public LocationDto() {
    }

    public LocationDto(Integer id, String name, String place, String description, String id_user, Image image) {
        this.id = id;
        this.name = name;
        this.place = place;
        this.description = description;
        this.id_user = id_user;
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public Image getImage_id() {
        return image;
    }

    public void setImage_id(Image image_id) {
        this.image = image_id;
    }
}
