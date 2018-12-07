package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.ics115_project.cookbook.functions.login_function;

import java.util.concurrent.ExecutionException;

public class login_user_activity extends AppCompatActivity {
    EditText uname, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getSupportActionBar().hide();
        uname = findViewById(R.id.login_username);
        pass = findViewById(R.id.login_password);
    }

    public void signUp(View v){
        Intent i = new Intent(this, register_user_activity.class);
        startActivity(i);
    }

    public void login(View v) {
        Intent i = new Intent(this, home_page_activity.class);
        startActivity(i);
    }
}
