package com.mrncontracting.mrnknocker.dtos;

/**
 * Created by snota on 5/4/2016.
 */
public class DTO_Customer extends DTO_Base {

    private int CustomerID;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Suffix;
    private String PrimaryNumber;
    private String SecondaryNumber;
    private String Email;
    private boolean MailPromos;

    public DTO_Customer(String firstName, String middleName, String lastName, String suffix, String primaryNumber, String secondaryNumber, String email, boolean mailPromos) {
        setFirstName(firstName);
        setMiddleName(middleName);
        setLastName(lastName);
        setSuffix(suffix);
        setPrimaryNumber(primaryNumber);
        setSecondaryNumber(secondaryNumber);
        setEmail(email);
        setMailPromos(mailPromos);
    }


    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getSuffix() {
        return Suffix;
    }

    public void setSuffix(String suffix) {
        Suffix = suffix;
    }

    public String getPrimaryNumber() {
        return PrimaryNumber;
    }

    public void setPrimaryNumber(String primaryNumber) {
        PrimaryNumber = primaryNumber;
    }

    public String getSecondaryNumber() {
        return SecondaryNumber;
    }

    public void setSecondaryNumber(String secondaryNumber) {
        SecondaryNumber = secondaryNumber;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public boolean isMailPromos() {
        return MailPromos;
    }

    public void setMailPromos(boolean mailPromos) {
        MailPromos = mailPromos;
    }
}
