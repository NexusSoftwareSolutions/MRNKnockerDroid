package com.mrncontracting.mrnknocker.dtos;

import java.util.Date;

/**
 * Created by Alyssa on 5/2/2016.
 */
public class DTO_CalendarData extends DTO_Base {

    private int EntryID;
    private int EmployeeID;
    private int AppointmentTypeID;
    private int LeadID;
    private Date StartTime;
    private Date EndTime;
    private int ClaimID;
    private String Note;

    public int getEntryID() {
        return EntryID;
    }

    public void setEntryID(int entryID) {
        EntryID = entryID;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        EmployeeID = employeeID;
    }

    public int getAppointmentTypeID() {
        return AppointmentTypeID;
    }

    public void setAppointmentTypeID(int appointmentTypeID) {
        AppointmentTypeID = appointmentTypeID;
    }

    public int getLeadID() {
        return LeadID;
    }

    public void setLeadID(int leadID) {
        LeadID = leadID;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public int getClaimID() {
        return ClaimID;
    }

    public void setClaimID(int claimID) {
        ClaimID = claimID;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }
}
