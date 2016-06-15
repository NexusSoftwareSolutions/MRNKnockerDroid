package com.mrncontracting.mrnknocker;

import java.util.Date;

/**
 * Created by Alyssa on 5/4/2016.
 */
public class Members {

    private static int knockerID = 0;
    private static int knockResponseID = 0;
    private static int salespersonID = 0;
    private static String address = "";
    private static String city = "";
    private static String state = "";
    private static String zip = "";
    private static double latitude = 0.0;
    private static double longitude = 0.0;

    private static int leadTypeID = 0;
    private static int knockerResponseID = 0;
    private static int customeID = 0;
    private static int addressID = 0;
    private static Date leadDate = null;
    private static int leadID = 0;


    public static int getKnockerID() {
        return knockerID;
    }

    public static void setKnockerID(int knockerID) {
        Members.knockerID = knockerID;
    }

    public static int getKnockResponseID() {
        return knockResponseID;
    }

    public static void setKnockResponseID(int knockResponseID) {
        Members.knockResponseID = knockResponseID;
    }

    public static int getSalespersonID() {
        return salespersonID;
    }

    public static void setSalespersonID(int salespersonID) {
        Members.salespersonID = salespersonID;
    }

    public static String getAddress() {
        return address;
    }

    public static void setAddress(String address) {
        Members.address = address;
    }

    public static String getCity() {
        return city;
    }

    public static void setCity(String city) {
        Members.city = city;
    }

    public static String getState() {
        return state;
    }

    public static void setState(String state) {
        Members.state = state;
    }

    public static String getZip() {
        return zip;
    }

    public static void setZip(String zip) {
        Members.zip = zip;
    }

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) {
        Members.latitude = latitude;
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        Members.longitude = longitude;
    }

    public static int getLeadTypeID() {
        return leadTypeID;
    }

    public static void setLeadTypeID(int leadTypeID) {
        Members.leadTypeID = leadTypeID;
    }

    public static int getKnockerResponseID() {
        return knockerResponseID;
    }

    public static void setKnockerResponseID(int knockerResponseID) {
        Members.knockerResponseID = knockerResponseID;
    }

    public static int getCustomeID() {
        return customeID;
    }

    public static void setCustomeID(int customeID) {
        Members.customeID = customeID;
    }

    public static int getAddressID() {
        return addressID;
    }

    public static void setAddressID(int addressID) {
        Members.addressID = addressID;
    }

    public static Date getLeadDate() {
        return leadDate;
    }

    public static void setLeadDate(Date leadDate) {
        Members.leadDate = leadDate;
    }

    public static void resetMembers(){
        knockerResponseID = 0;
        address = "";
        city = "";
        state = "";
        zip = "";
        latitude = 0.0;
        longitude = 0.0;

        leadTypeID = 0;
        knockerResponseID = 0;
        customeID = 0;
        addressID = 0;
        leadDate = null;
        leadID = 0;

    }

    public static int getLeadID() {
        return leadID;
    }

    public static void setLeadID(int leadID) {
        Members.leadID = leadID;
    }
}
