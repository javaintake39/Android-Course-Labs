/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jets.chatproject.server.module.dal.entities;

import com.jets.chatproject.module.rmi.dto.Gender;
import com.jets.chatproject.module.rmi.dto.UserStatus;
import java.sql.Date;

/**
 *
 * @author ibrahim
 */
public class User {

    private final int id;
    private final String phoneNumber;
    private String displyName;
    private String email;
    private String password;
    private Gender gender;
    private String country;
    private Date dateOfBirth;
    private String bio;
    private UserStatus state;
    private int pictureId;

    public User(Builder builder) {
        this.id = builder.id;
        this.phoneNumber = builder.phoneNumber;
        this.displyName = builder.displyName;
        this.email = builder.email;
        this.password = builder.password;
        this.gender = builder.gender;
        this.country = builder.country;
        this.dateOfBirth = builder.dateOfBirth;
        this.bio = builder.bio;
        this.state = builder.state;
        this.pictureId = builder.pictureId;
    }

    public int getId() {
        return id;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDisplyName() {
        return displyName;
    }

    public void setDisplyName(String displyName) {
        this.displyName = displyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public UserStatus getState() {
        return state;
    }

    public void setState(UserStatus status) {
        this.state = status;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }

    public static class Builder {

        private int id;
        private final String phoneNumber;
        private final String displyName;
        private String email;
        private String password;
        private Gender gender;
        private String country;
        private Date dateOfBirth;
        private String bio;
        private UserStatus state;
        private int pictureId;

        public Builder(String phoneNumber, String displyName) {
            this.phoneNumber = phoneNumber;
            this.displyName = displyName;
        }

        public int getId() {
            return id;
        }

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String getDisplyName() {
            return displyName;
        }

        public String getEmail() {
            return email;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public String getPassword() {
            return password;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Gender getGender() {
            return gender;
        }

        public Builder setGender(Gender gender) {
            this.gender = gender;
            return this;
        }

        public String getCountry() {
            return country;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Date getDateOfBirth() {
            return dateOfBirth;
        }

        public Builder setDateOfBirth(Date dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public String getBio() {
            return bio;
        }

        public Builder setBio(String bio) {
            this.bio = bio;
            return this;
        }

        public UserStatus getState() {
            return state;
        }

        public Builder setState(UserStatus state) {
            this.state = state;
            return this;
        }

        public int getPictureId() {
            return pictureId;
        }

        public Builder setPictureId(int pictureId) {
            this.pictureId = pictureId;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

}
