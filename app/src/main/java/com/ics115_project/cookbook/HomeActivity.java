package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity{
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseUser;

    ListView listViewUser;
    List<User> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        firebaseAuth = FirebaseAuth.getInstance();
        databaseUser = FirebaseDatabase.getInstance().getReference("users");

        if (firebaseAuth.getCurrentUser() == null) {
            startActivity(new Intent(this, login_user_activity.class));
        }

        listViewUser = (ListView) findViewById(R.id.listViewUser);
        userList = new ArrayList<>();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listViewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textview = (TextView) view.findViewById(R.id.textViewName);
                String text = textview.getText().toString();
                Toast.makeText(HomeActivity.this,text,Toast.LENGTH_LONG).show();
            }
        });

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();

                for(DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                    User user = userSnapshot.getValue(User.class);
                    userList.add(user);
                }

                ArrayAdapter adapter = new UserList(HomeActivity.this, userList);
                listViewUser.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()) {
                        case R.id.home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.profile:
                            selectedFragment = new ProfileFragment();
                            break;
                        case R.id.order:
                            selectedFragment = new OrderFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.logout) {
            firebaseAuth.signOut();
            finish();
            startActivity(new Intent(this, login_user_activity.class));
        }
        return true;
    }
}
