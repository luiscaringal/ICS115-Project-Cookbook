package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ics115_project.cookbook.functions.register_function;


public class register_user_activity extends AppCompatActivity {
    EditText r_uname, r_fname, r_lname, r_password, r_phone_number, r_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user_layout);
        getSupportActionBar().hide();
        r_uname = findViewById(R.id.reg_uname);
        r_fname = findViewById(R.id.reg_fname);
        r_lname = findViewById(R.id.reg_lname);
        r_password = findViewById(R.id.reg_password);
        r_phone_number = findViewById(R.id.reg_phone_number);
        r_email = findViewById(R.id.reg_email);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void registerUser(View v){
        String username = r_uname.getText().toString();
        String firstname = r_fname.getText().toString();
        String lastname = r_lname.getText().toString();
        String password = r_password.getText().toString();
        String phonenumber = r_phone_number.getText().toString();
        String email = r_email.getText().toString();

        register_function reg = new register_function(this);
        reg.execute(username, firstname,lastname,password,phonenumber,email);
        Toast.makeText(this,"Registration Success",Toast.LENGTH_LONG).show();
        Intent i = new Intent(this,login_user_activity.class);
        startActivity(i);
    }
}
