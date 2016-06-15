package com.mrncontracting.mrnknocker.dtos;

/**
 * Created by Alyssa on 5/2/2016.
 */
public class DTO_LU_EmployeeType extends DTO_Base {

    private int EmployeeTypeID;
    private String EmployeeType;

    public int getEmployeeTypeID() {
        return EmployeeTypeID;
    }

    public void setEmployeeTypeID(int employeeTypeID) {
        EmployeeTypeID = employeeTypeID;
    }

    public String getEmployeeType() {
        return EmployeeType;
    }

    public void setEmployeeType(String employeeType) {
        EmployeeType = employeeType;
    }
}
