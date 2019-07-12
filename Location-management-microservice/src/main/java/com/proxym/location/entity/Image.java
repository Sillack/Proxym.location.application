package com.proxym.location.entity;

/**
 * @author Anis OURAJINI
 */

import javax.persistence.*;

@Entity
@Table(name = "images")
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SIZE")
    private String size;
    @Column(name = "CONTENT")
    private String content;
    @OneToOne(mappedBy = "image", cascade = CascadeType.ALL)
    private Location location;

    public Image() {
    }

    public Image(String name, String size, String configuration, Location location) {
        this.name = name;
        this.size = size;
        this.content = configuration;
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
        return content;
    }

    public void setConfiguration(String configuration) {
        this.content = configuration;
    }
}
