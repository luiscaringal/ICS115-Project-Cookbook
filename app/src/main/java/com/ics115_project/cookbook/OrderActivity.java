package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class OrderActivity extends AppCompatActivity {
    TextView foodName;
    private String food;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_food_profile_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle bundle = getIntent().getExtras();
        food = bundle.getString("foodName");

        foodName = (TextView) findViewById(R.id.food_title);
        foodName.setText(food);
    }
}
