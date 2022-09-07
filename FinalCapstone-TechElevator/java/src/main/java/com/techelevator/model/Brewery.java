package com.techelevator.model;

public class Brewery {
    private int breweryID;
    private String breweryName;
    private String streetName;
    private String zipCode;
    private String phoneNumber;
    private String websiteUrl;
    private String breweryDescription;

    public Brewery(int breweryID, String breweryName, String streetName, String zipCode,String phoneNumber, String websiteUrl,String breweryDescription) {
        this.breweryID = breweryID;
        this.breweryName = breweryName;
        this.streetName = streetName;
        this.zipCode= zipCode;
        this.phoneNumber = phoneNumber;
        this.websiteUrl = websiteUrl;
        this.breweryDescription = breweryDescription;
    }

    public Brewery() {
    }

    public int getBreweryID() {
        return breweryID;
    }

    public void setBreweryID(int breweryID) {
        this.breweryID = breweryID;
    }

    public String getBreweryName() {
        return breweryName;
    }

    public void setBreweryName(String breweryName) {
        this.breweryName = breweryName;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public String getBreweryDescription() {
        return breweryDescription;
    }

    public void setBreweryDescription(String breweryDescription) {
        this.breweryDescription = breweryDescription;
    }
}
