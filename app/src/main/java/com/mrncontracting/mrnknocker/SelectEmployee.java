package com.mrncontracting.mrnknocker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.mrncontracting.mrnknocker.dtos.DTO_Employee;
import com.mrncontracting.mrnknocker.dtos.DTO_LU_EmployeeType;

import java.util.List;

public class SelectEmployee extends AppCompatActivity {

    private Spinner employeeSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_employee);

        DTO_LU_EmployeeType token = new DTO_LU_EmployeeType();
        token.setEmployeeTypeID(13);

        Connection connTask = new Connection();
        try { connTask.execute(token, 7, "GetEmployeesByEmployeeTypeID", true).get(); }catch(Exception ex){ }

        List<DTO_Employee> employees = (List<DTO_Employee>)connTask.results;
        employees.add(0, new DTO_Employee());

        ArrayAdapter<DTO_Employee> dataAdapter = new ArrayAdapter<DTO_Employee>(this,
                R.layout.support_simple_spinner_dropdown_item, employees );

        employeeSpinner = (Spinner)findViewById(R.id.employee_spinner);
        employeeSpinner.setAdapter(dataAdapter);
        employeeSpinner.setSelection(0,false);

        employeeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                DTO_Employee e = (DTO_Employee)employeeSpinner.getSelectedItem();
                Members.setSalespersonID(e.EmployeeID);
                continueToKnock();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });
    }

    private void continueToKnock(){
        Intent i = new Intent(this, Knock.class);
        startActivity(i);
    }
}
