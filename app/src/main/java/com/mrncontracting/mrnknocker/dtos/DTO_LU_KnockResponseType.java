package com.mrncontracting.mrnknocker.dtos;

/**
 * Created by Alyssa on 5/4/2016.
 */
public class DTO_LU_KnockResponseType extends DTO_Base {

    private int KnockResponseTypeID;
    private String KnockResponseType;

    public int getKnockResponseTypeID() {
        return KnockResponseTypeID;
    }

    public void setKnockResponseTypeID(int knockResponseTypeID) {
        KnockResponseTypeID = knockResponseTypeID;
    }

    public String getKnockResponseType() {
        return KnockResponseType;
    }

    public void setKnockResponseType(String knockResponseType) {
        KnockResponseType = knockResponseType;
    }

    @Override
    public String toString(){
        return this.KnockResponseType;
    }
}
