package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderFormActivity extends AppCompatActivity {
    EditText customerName, orderFood, orderQuantity, pickUpDate, orderExtraComment;
    Button submitOrder;
    RadioGroup radioButtonChooser;
    RadioButton radioButton;

    private String food;
    private String chefUserName;
    String currentUser;
    String currentUserEmail;

    DatabaseReference databaseUser;
    DatabaseReference databaseOrder;
    FirebaseUser loggedInUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_form_layout);

        databaseUser = FirebaseDatabase.getInstance().getReference("users");
        databaseOrder = FirebaseDatabase.getInstance().getReference("orders");
        loggedInUser = FirebaseAuth.getInstance().getCurrentUser();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Initialize Elements
        orderQuantity = (EditText) findViewById(R.id.orderQuantity);
        pickUpDate = (EditText) findViewById(R.id.pickUpDate);
        orderExtraComment = (EditText) findViewById(R.id.orderExtraComment);
        radioButtonChooser = findViewById(R.id.radioButtonChooser);

        //Bundle from previous activity
        Bundle bundle = getIntent().getExtras();
        food = bundle.getString("orderFood");
        chefUserName  = bundle.getString("chefUserName");

        orderFood = (EditText) findViewById(R.id.orderFood);
        orderFood.setEnabled(false);
        orderFood.setText(food);

        //Submit Order Listener
        submitOrder = (Button) findViewById(R.id.button_order);
        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitOrder();
                Intent i = new Intent(OrderFormActivity.this, OrderSuccessActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseUser.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot userSnapshot: dataSnapshot.getChildren()){
                    User user = userSnapshot.getValue(User.class);
                    if(user.getEmail().equals(loggedInUser.getEmail())){
                        currentUser = user.getName();
                        currentUserEmail = user.getEmail();
                        break;
                    }
                }
                customerName = (EditText) findViewById(R.id.orderName);
                customerName.setEnabled(false);
                customerName.setText(currentUser);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void submitOrder(){
        String customer = customerName.getText().toString();
        String food = orderFood.getText().toString();
        String quantity = orderQuantity.getText().toString().trim();
        String dateOfPickUp = pickUpDate.getText().toString();
        String extraComment = orderExtraComment.getText().toString();

        int modeOfPaymentId = radioButtonChooser.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(modeOfPaymentId);
        String modeOfPayment = radioButton.getText().toString();

        UserOrder userOrder = new UserOrder(currentUserEmail,customer, food, quantity, dateOfPickUp, modeOfPayment, extraComment, chefUserName);

        databaseOrder.push().setValue(userOrder);
    }
}
