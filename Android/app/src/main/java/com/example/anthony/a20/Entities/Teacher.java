package com.example.anthony.a20.Entities;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    public static final List<Teacher> ITEMS = new ArrayList<Teacher>();
    private static final int NO_IMAGE_PROVIDED = -1;
    private String name;
    private String lastname;
    private String password;
    private String email;
    private String accountNumber;
    private String banco;
    private long dni;
    private long phone;
    private Float minPrice;
    private Float maxPrice;
    private int expYears;
    private Float rating;
    private int mProfileImage= NO_IMAGE_PROVIDED;

    public Teacher(String Mname, Float Mrating, int MmProfileImage){
        setName(Mname);
        rating=Mrating;
        mProfileImage=MmProfileImage;

    }

    public static int getNoImageProvided() {
        return NO_IMAGE_PROVIDED;
    }

    public String getName() {
        return name;
    }

    public boolean hasImage(){
        return mProfileImage!=NO_IMAGE_PROVIDED;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getmProfileImage() {
        return mProfileImage;
    }

    public void setmProfileImage(int mProfileImage) {
        this.mProfileImage = mProfileImage;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public Float getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Float minPrice) {
        this.minPrice = minPrice;
    }

    public Float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Float maxPrice) {
        this.maxPrice = maxPrice;
    }
}
