package com.mrncontracting.mrnknocker.dtos;

import java.io.Serializable;

/**
 * Created by Alyssa on 4/30/2016.
 */
public class DTO_Employee extends DTO_Base implements Serializable{

    public int EmployeeID;
    public int EmployeeTypeID;
    public String FirstName = "";
    public String LastName = "";
    public String Suffix;
    public String Email;
    public String CellPhone;
    public boolean Active;

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getEmployeeTypeID() {
        return EmployeeTypeID;
    }

    public void setEmployeeTypeID(int employeeTypeID) {
        EmployeeTypeID = employeeTypeID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(String cellPhone) {
        CellPhone = cellPhone;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }

    @Override
    public String toString(){
        return this.FirstName + " " + this.LastName;
    }
}
