package com.mrncontracting.mrnknocker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.mrncontracting.mrnknocker.dtos.DTO_Address;
import com.mrncontracting.mrnknocker.dtos.DTO_CalendarData;
import com.mrncontracting.mrnknocker.dtos.DTO_Customer;
import com.mrncontracting.mrnknocker.dtos.DTO_KnockerResponse;
import com.mrncontracting.mrnknocker.dtos.DTO_Lead;

import java.util.Date;

public class LeadProcessing extends AppCompatActivity {

    static DTO_KnockerResponse knockerResponse;
    static DTO_Lead lead;
    static DTO_CalendarData calendarData;

    private EditText address;
    private EditText zip;
    private EditText firstname;
    private EditText middlename;
    private EditText lastname;
    private EditText primarynumber;
    private EditText secondarynumber;
    private EditText email;
    private CheckBox mailpromos;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_processing);

        address = (EditText)findViewById(R.id.address_tf);
        address.setText(Members.getAddress());
        zip = (EditText)findViewById(R.id.zipcode_tf);
        zip.setText(Members.getZip());
        firstname = (EditText)findViewById(R.id.firstname_tf);
        middlename = (EditText)findViewById(R.id.middlename_tf);
        lastname = (EditText)findViewById(R.id.lastname_tf);
        primarynumber = (EditText)findViewById(R.id.primarynumber_tf);
        secondarynumber = (EditText)findViewById(R.id.secondaynumber_tf);
        email = (EditText)findViewById(R.id.email_tf);
        mailpromos = (CheckBox) findViewById(R.id.mailpromo_chkbx);
    }





    public void processLead(View view) {


        if (generateCustomer())
            if (generateAddress())
                if (generateLead())
                    System.out.print("");
                else{}
            else{}
        else{}
    }

/*    private static void generateKnockerResponse(){
        knockerResponse = new DTO_KnockerResponse(Members.getAddress(), Members.getKnockerID(),
                Members.getKnockResponseID(), Members.getLatitude(), Members.getLongitude(), Members.getZip());
        Connection connTask = new Connection();
        try { connTask.execute(knockerResponse, 3, "AddKnockerResponse", true).get(); }catch(Exception ex){ }
    }*/

    private boolean generateCustomer(){
        DTO_Customer token = new DTO_Customer(firstname.getText().toString(), middlename.getText().toString(),
                lastname.getText().toString(), null, primarynumber.getText().toString(), secondarynumber.getText().toString(),
                email.getText().toString(), mailpromos.isChecked());

        Connection connTask = new Connection();
        try { connTask.execute(token, 4, "AddCustomer", true).get(); }catch(Exception ex){ }

        if(((DTO_Customer)connTask.result).getCustomerID() > 0){
            Toast.makeText(this, "Customer Record Created!", Toast.LENGTH_LONG).show();
            Members.setCustomeID(((DTO_Customer)connTask.result).getCustomerID());
            return true;
        }
        else {
            Toast.makeText(this, ((DTO_Customer)connTask.result).Message, Toast.LENGTH_LONG).show();
            return false;
        }

    }

    private boolean generateAddress(){
        DTO_Address token = new DTO_Address(Members.getCustomeID(), address.getText().toString(), zip.getText().toString());

        Connection connTask = new Connection();
        try { connTask.execute(token, 5, "AddAddress", true).get(); }catch(Exception ex){ }

        if(((DTO_Address)connTask.result).getAddressID() > 0){
            Toast.makeText(this, "Address Record Created!", Toast.LENGTH_LONG).show();
            Members.setAddressID(((DTO_Address)connTask.result).getAddressID());
            return true;
        }
        else {
            Toast.makeText(this, ((DTO_Address)connTask.result).Message, Toast.LENGTH_LONG).show();
            return false;
        }
    }

    private boolean generateLead(){
        DTO_Lead token = new DTO_Lead(1, Members.getKnockerResponseID(), Members.getSalespersonID(),
                Members.getAddressID(), new Date(), Members.getCustomeID(), false, Members.getKnockerID());

        Connection connTask = new Connection();
        try { connTask.execute(token, 6, "AddLead", true).get(); }catch(Exception ex){ }

        if(((DTO_Lead)connTask.result).getLeadID() > 0){
            Toast.makeText(this, "Lead Record Created!", Toast.LENGTH_LONG).show();
            Members.setLeadID(((DTO_Lead)connTask.result).getLeadID());
            return true;
        }
        else {
            Toast.makeText(this, ((DTO_Lead)connTask.result).Message, Toast.LENGTH_LONG).show();
            return false;
        }

    }

}
