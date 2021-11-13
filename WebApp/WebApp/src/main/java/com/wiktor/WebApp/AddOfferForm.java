package com.wiktor.WebApp;

import org.springframework.web.multipart.MultipartFile;

public class AddOfferForm {
    String Name;
    String Description;
    MultipartFile image;

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

    public MultipartFile getImage() { return image; }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
