package com.mrncontracting.mrnknocker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mrncontracting.mrnknocker.dtos.DTO_Employee;
import com.mrncontracting.mrnknocker.dtos.DTO_User;

public class MainActivity extends AppCompatActivity {

    EditText usernameTF;
    EditText passwordTF;
    TextView usernameTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void login(View view){
        usernameTF = (EditText)findViewById(R.id.username_tf);
        passwordTF = (EditText)findViewById(R.id.password_tf);
        String username = usernameTF.getText().toString();
        String password = passwordTF.getText().toString();

        DTO_User token = new DTO_User();
        //token.setUsername(usernameTF.getText().toString());
        //token.setPass(password);
        token.setPass("Harvey1214");
        token.setUsername("aharvey@gmail.com");

        Connection connTask = new Connection();
        try { connTask.execute(token, 1, "Login", true).get(); }catch(Exception ex){ }

        if(((DTO_Employee)connTask.result).EmployeeID > 0) {
            Members.setKnockerID(((DTO_Employee)connTask.result).EmployeeID);
            Intent i = new Intent(this, SelectEmployee.class);
            startActivity(i);
        } else {
            Toast.makeText(this, ((DTO_Employee)connTask.result).Message, Toast.LENGTH_LONG).show();
        }



    }
}
