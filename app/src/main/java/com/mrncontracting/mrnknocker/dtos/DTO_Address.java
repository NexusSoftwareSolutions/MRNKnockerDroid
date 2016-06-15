package com.mrncontracting.mrnknocker.dtos;

/**
 * Created by Alyssa on 5/2/2016.
 */
public class DTO_Address extends DTO_Base {

    private int AddressID;
    private int CustomerID;
    private String Address;
    private String Zip;

    public DTO_Address(int customerID, String address, String zip) {
        CustomerID = customerID;
        Address = address;
        Zip = zip;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
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
}
