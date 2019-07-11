package com.proxym.location.entity;


import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {


    //    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "CONFIGURATION")
    private String configuration;
    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private Location location;

    public Image() {
    }

    public Image(String name, String size, String configuration, Location location) {
        this.name = name;
        this.size = size;
        this.configuration = configuration;
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
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

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }
}
