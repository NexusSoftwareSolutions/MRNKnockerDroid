package com.mrncontracting.mrnknocker.dtos;

import java.io.Serializable;

/**
 * Created by Alyssa on 4/30/2016.
 */
public class DTO_User extends DTO_Base implements Serializable{

    public int UserID;
    private int EmployeeID;
    private String Username;
    private String Pass;
    private int PermissionID;
    private boolean Active;

    public int getUserID() {
        return UserID;
    }

    public void setUserID(int userID) {
        UserID = userID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String pass) {
        Pass = pass;
    }

    public int getPermissionID() {
        return PermissionID;
    }

    public void setPermissionID(int permissionID) {
        PermissionID = permissionID;
    }

    public boolean isActive() {
        return Active;
    }

    public void setActive(boolean active) {
        Active = active;
    }
}
