package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class register_user_activity extends AppCompatActivity {
    EditText r_uname, r_fname, r_lname, r_password, r_phone_number, r_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
//        getSupportActionBar().hide();
        r_uname = findViewById(R.id.reg_uname);
        r_fname = findViewById(R.id.reg_fname);
        r_lname = findViewById(R.id.reg_lname);
        r_password = findViewById(R.id.reg_password);
        r_phone_number = findViewById(R.id.reg_phone_number);
        r_email = findViewById(R.id.reg_email);
    }
}
