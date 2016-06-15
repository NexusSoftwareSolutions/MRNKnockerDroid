package com.mrncontracting.mrnknocker;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.mrncontracting.mrnknocker.dtos.DTO_Employee;
import com.mrncontracting.mrnknocker.dtos.DTO_KnockerResponse;
import com.mrncontracting.mrnknocker.dtos.DTO_LU_KnockResponseType;

import java.util.List;

public class SelectResponse extends AppCompatActivity {

    private Spinner knockResponseTypeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_response);

        // Get KnockResponseTypes
        Connection connTask = new Connection();
        try { connTask.execute(null, 8, "GetKnockResponseTypes", false).get(); }catch(Exception ex){ }

        List<DTO_LU_KnockResponseType> knockResponseTypes = (List<DTO_LU_KnockResponseType>)connTask.results;
        knockResponseTypes.add(0, new DTO_LU_KnockResponseType());

        //Create Data Adapter for Spinner
        ArrayAdapter<DTO_LU_KnockResponseType> dataAdapter = new ArrayAdapter<DTO_LU_KnockResponseType>(this,
                R.layout.support_simple_spinner_dropdown_item, knockResponseTypes );

        knockResponseTypeSpinner = (Spinner)findViewById(R.id.knock_response_spinner);
        knockResponseTypeSpinner.setAdapter(dataAdapter);
        knockResponseTypeSpinner.setSelection(0,false);

        knockResponseTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                processKnockerResponse();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do Nothing
            }
        });
    }

    private void processKnockerResponse(){
        DTO_LU_KnockResponseType responseType = (DTO_LU_KnockResponseType)knockResponseTypeSpinner.getSelectedItem();
        Members.setKnockResponseID(responseType.getKnockResponseTypeID());

        DTO_KnockerResponse token;
        Connection connTask;

        switch(responseType.getKnockResponseTypeID()){

            case 1: // No Answer
                token = new DTO_KnockerResponse(Members.getAddress(), Members.getKnockerID(),
                        Members.getKnockResponseID(), Members.getLatitude(), Members.getLongitude(), Members.getZip());
                connTask = new Connection();
                try { connTask.execute(token, 3, "AddKnockerResponse", true).get(); }catch(Exception ex){ }

                if(((DTO_KnockerResponse)connTask.result).getKnockerResponseID() > 0){
                    Toast.makeText(this, "Knock Response Recorded!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, Knock.class);
                    startActivity(i);
                    //moveon
                }
                else {
                    Toast.makeText(this, ((DTO_KnockerResponse)connTask.result).Message, Toast.LENGTH_LONG).show();
                }

                break;

            case 2: // Appointment Set
                token = new DTO_KnockerResponse(null, Members.getKnockerID(),
                        Members.getKnockResponseID(), Members.getLatitude(), Members.getLongitude(), null);
                connTask = new Connection();
                try { connTask.execute(token, 3, "AddKnockerResponse", true).get(); }catch(Exception ex){ }

                if(((DTO_KnockerResponse)connTask.result).getKnockerResponseID() > 0){
                    Toast.makeText(this, "Knock Response Recorded!", Toast.LENGTH_LONG).show();
                    Members.setKnockerResponseID(((DTO_KnockerResponse)connTask.result).getKnockerResponseID());
                    Intent i = new Intent(this, LeadProcessing.class);
                    startActivity(i);
                }
                else {
                    Toast.makeText(this, ((DTO_KnockerResponse)connTask.result).Message, Toast.LENGTH_LONG).show();
                }

                break;

            case 3: // Come Back Later
                token = new DTO_KnockerResponse(Members.getAddress(), Members.getKnockerID(),
                        Members.getKnockResponseID(), Members.getLatitude(), Members.getLongitude(), Members.getZip());
                connTask = new Connection();
                try { connTask.execute(token, 3, "AddKnockerResponse", true).get(); }catch(Exception ex){ }

                if(((DTO_KnockerResponse)connTask.result).getKnockerResponseID() > 0){
                    Toast.makeText(this, "Knock Response Recorded!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, Knock.class);
                    startActivity(i);

                }
                else {
                    Toast.makeText(this, ((DTO_KnockerResponse)connTask.result).Message, Toast.LENGTH_LONG).show();
                }
                break;

            case 4: // Not Interested
                token = new DTO_KnockerResponse(Members.getAddress(), Members.getKnockerID(),
                        Members.getKnockResponseID(), Members.getLatitude(), Members.getLongitude(), Members.getZip());
                connTask = new Connection();
                try { connTask.execute(token, 3, "AddKnockerResponse", true).get(); }catch(Exception ex){ }

                if(((DTO_KnockerResponse)connTask.result).getKnockerResponseID() > 0){
                    Toast.makeText(this, "Knock Response Recorded!", Toast.LENGTH_LONG).show();
                    Intent i = new Intent(this, Knock.class);
                    startActivity(i);
                    //moveon
                }
                else {
                    Toast.makeText(this, ((DTO_KnockerResponse)connTask.result).Message, Toast.LENGTH_LONG).show();
                }
                break;
        }
    }


}
