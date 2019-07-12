package com.proxym.location.entity;

/**
 * @author Anis OURAJINI
 */
import javax.persistence.*;


@Entity
@Table(name = "locations")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "PLACE")
    private String place;
    @Column(name = "DESCRIPTION")
    private String description;
    @Column(name = "ID_USER")
    private Integer id_user;
    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    public Location() {
    }

    public Location(String name, String place, String description, Integer id_user, Image image) {
        this.name = name;
        this.place = place;
        this.description = description;
        this.id_user = id_user;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
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

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }
}
