package com.ics115_project.cookbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class register_user_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_user_layout);
        getSupportActionBar().hide();
    }
}
