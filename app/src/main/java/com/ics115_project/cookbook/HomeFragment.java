package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    private DatabaseReference databaseUser;
    ArrayAdapter adapter;

    ListView listViewUser;
    List<User> userList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        databaseUser = FirebaseDatabase.getInstance().getReference("users");

        listViewUser = (ListView) view.findViewById(R.id.listViewUser);
        userList = new ArrayList<>();

        listViewUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textViewUserNname = (TextView) view.findViewById(R.id.textViewUserName);
                TextView textViewName = (TextView) view.findViewById(R.id.textViewName);
                String username = textViewUserNname.getText().toString();
                String name = textViewName.getText().toString();

                Intent i = new Intent(HomeFragment.this.getActivity(),MenuActivity.class);
                i.putExtra("userName",username);
                i.putExtra("Name",name);
                startActivity(i);
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                userList.clear();

                for(DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                    User user = userSnapshot.getValue(User.class);
                    if(user.getAccountType().equals("CHEF")) {
                        userList.add(user);
                    }
                }

                if(HomeFragment.this.getActivity()!=null) {
                    adapter = new UserList(HomeFragment.this.getActivity(), userList);
                    listViewUser.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
