package com.mrncontracting.mrnknocker.dtos;

/**
 * Created by Alyssa on 5/4/2016.
 */
public class DTO_KnockerResponse extends DTO_Base{

    private int KnockerResponseID;
    private int KnockerID;
    private int KnockResponseTypeID;
    private String Address;
    private String Zip;
    private double Latitude;
    private double Longitude;

    public DTO_KnockerResponse(String address, int knockerID, int knockResponseTypeID, double latitude, double longitude, String zip) {
        Address = address;
        KnockerID = knockerID;
        KnockResponseTypeID = knockResponseTypeID;
        Latitude = latitude;
        Longitude = longitude;
        Zip = zip;
    }

    public int getKnockerResponseID() {
        return KnockerResponseID;
    }

    public void setKnockerResponseID(int knockerResponseID) {
        KnockerResponseID = knockerResponseID;
    }

    public int getKnockerID() {
        return KnockerID;
    }

    public void setKnockerID(int knockerID) {
        KnockerID = knockerID;
    }

    public int getKnockResponseTypeID() {
        return KnockResponseTypeID;
    }

    public void setKnockResponseTypeID(int knockResponseTypeID) {
        KnockResponseTypeID = knockResponseTypeID;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getZip() {
        return Zip;
    }

    public void setZip(String zip) {
        Zip = zip;
    }

    public double getLatitude() {
        return Latitude;
    }

    public void setLatitude(double latitude) {
        Latitude = latitude;
    }

    public double getLongitude() {
        return Longitude;
    }

    public void setLongitude(double longitude) {
        Longitude = longitude;
    }
}
