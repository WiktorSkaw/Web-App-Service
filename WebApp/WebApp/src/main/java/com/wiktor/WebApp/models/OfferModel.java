package com.wiktor.WebApp.models;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
public class OfferModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    String Name;
    String Description;
    @ManyToOne(cascade = {CascadeType.ALL})
    User user;
    @Lob
    byte[] image;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

   public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
   }




}
