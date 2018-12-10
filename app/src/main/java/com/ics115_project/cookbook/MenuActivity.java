package com.ics115_project.cookbook;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MenuActivity extends AppCompatActivity {
    private DatabaseReference databaseFood;
    private String username;

    ListView listViewFood;
    List<Food> foodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_page);

        databaseFood = FirebaseDatabase.getInstance().getReference("foods");

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewFood = (ListView) findViewById(R.id.listViewFood);
        foodList = new ArrayList<>();

        Bundle bundle = getIntent().getExtras();
        username = bundle.getString("userName");

        listViewFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textview = (TextView) view.findViewById(R.id.foodName);
                String text = textview.getText().toString();

                Intent i = new Intent(MenuActivity.this, OrderActivity.class);
                i.putExtra("foodName", text);
                i.putExtra("chefUserName", username);
                startActivity(i);
            }
        });

        TextView user = (TextView) findViewById(R.id.ChefName);
        user.setText(username);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseFood.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                foodList.clear();

                for (DataSnapshot foodSnapshot : dataSnapshot.getChildren()) {
                    Food food = foodSnapshot.getValue(Food.class);
                    if (food.getChefUserName().equals(username)) {
                        foodList.add(food);
                    }
                }

                ArrayAdapter adapter = new FoodList(MenuActivity.this, foodList);
                listViewFood.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
