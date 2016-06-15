package com.mrncontracting.mrnknocker.dtos;

import java.util.Date;

/**
 * Created by Alyssa on 5/4/2016.
 */
public class DTO_Lead extends DTO_Base {

    private int LeadID;
    private int LeadTypeID;
    private int KnockerResponseID;
    private int SalesPersonID;
    private int AddressID;
    private Date LeadDate;
    private int CustomerID;
    private boolean Success;
    private int CreditToID;

    public DTO_Lead(int leadTypeID, int knockerResponseID, int salesPersonID, int addressID, Date leadDate, int customerID, boolean success, int creditToID) {
        LeadTypeID = leadTypeID;
        KnockerResponseID = knockerResponseID;
        SalesPersonID = salesPersonID;
        AddressID = addressID;
        LeadDate = leadDate;
        CustomerID = customerID;
        Success = success;
        CreditToID = creditToID;
    }


    public int getLeadID() {
        return LeadID;
    }

    public void setLeadID(int leadID) {
        LeadID = leadID;
    }

    public int getLeadTypeID() {
        return LeadTypeID;
    }

    public void setLeadTypeID(int leadTypeID) {
        LeadTypeID = leadTypeID;
    }

    public int getKnockerResponseID() {
        return KnockerResponseID;
    }

    public void setKnockerResponseID(int knockerResponseID) {
        KnockerResponseID = knockerResponseID;
    }

    public int getSalesPersonID() {
        return SalesPersonID;
    }

    public void setSalesPersonID(int salesPersonID) {
        SalesPersonID = salesPersonID;
    }

    public int getAddressID() {
        return AddressID;
    }

    public void setAddressID(int addressID) {
        AddressID = addressID;
    }

    public Date getLeadDate() {
        return LeadDate;
    }

    public void setLeadDate(Date leadDate) {
        LeadDate = leadDate;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public boolean isSuccess() {
        return Success;
    }

    public void setSuccess(boolean success) {
        Success = success;
    }

    public int getCreditToID() {
        return CreditToID;
    }

    public void setCreditToID(int creditToID) {
        CreditToID = creditToID;
    }
}
