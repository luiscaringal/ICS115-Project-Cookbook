package com.ics115_project.cookbook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class OrderFragment extends Fragment {
    ListView listViewUserOrder;
    List<UserOrder> userOrderList;
    private DatabaseReference databaseOrderList;
    FirebaseUser loggedInUser;
    ArrayAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order,container,false);
        listViewUserOrder = (ListView) view.findViewById(R.id.listViewUserOrder);

        loggedInUser = FirebaseAuth.getInstance().getCurrentUser();
        databaseOrderList = FirebaseDatabase.getInstance().getReference("orders");

        userOrderList = new ArrayList<>();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        databaseOrderList.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                userOrderList.clear();

                for(DataSnapshot userOrderSnapshot: dataSnapshot.getChildren()){
                    UserOrder userOrder = userOrderSnapshot.getValue(UserOrder.class);
                    if(userOrder.getCustomerEmail().equals(loggedInUser.getEmail())) {
                        userOrderList.add(userOrder);
                    }
                }

                if(OrderFragment.this.getActivity()!=null) {
                    adapter = new UserOrderList(OrderFragment.this.getActivity(), userOrderList);
                    listViewUserOrder.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
