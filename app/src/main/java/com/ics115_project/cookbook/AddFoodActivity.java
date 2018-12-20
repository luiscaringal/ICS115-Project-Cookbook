package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AddFoodActivity extends AppCompatActivity {
    ImageView addFoodButtonInner, addFoodButtonOuter, viewFoodButtonInner, viewFoodButtonOuter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_food_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addFoodButtonInner = (ImageView) findViewById(R.id.addFoodButtonInner);
        addFoodButtonOuter = (ImageView) findViewById(R.id.addFoodButtonOuter);

        viewFoodButtonInner = (ImageView) findViewById(R.id.imageView5);
        viewFoodButtonOuter = (ImageView) findViewById(R.id.imageView10);

        addFoodButtonInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFoodActivity.this,AddFoodProfileActivity.class));
            }
        });

        addFoodButtonOuter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFoodActivity.this,AddFoodProfileActivity.class));
            }
        });

        viewFoodButtonInner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFoodActivity.this,EditFoodProfileActivity.class));
            }
        });

        viewFoodButtonOuter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AddFoodActivity.this,EditFoodProfileActivity.class));
            }
        });
    }
}
