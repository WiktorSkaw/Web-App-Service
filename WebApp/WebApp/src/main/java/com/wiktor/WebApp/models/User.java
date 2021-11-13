package com.wiktor.WebApp.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    String userName;
    String userPassword;
    String userMail;

    @OneToMany
    List<OfferModel> offerModel;

  //  public List<OfferModel> getOfferModel() {
   //     return offerModel;
  //  }

  //  public void setOfferModel(List<OfferModel> offerModel) {
  //      this.offerModel = offerModel;
  //  }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserMail() {
        return userMail;
    }

    public void setUserMail(String userMail) {
        this.userMail = userMail;
    }

}
