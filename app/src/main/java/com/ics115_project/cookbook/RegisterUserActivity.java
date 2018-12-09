package com.ics115_project.cookbook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterUserActivity extends AppCompatActivity implements View.OnClickListener {
    EditText r_uname, r_fname, r_lname, r_password, r_phone_number, r_email;
    RadioGroup radioButtonChooser;
    RadioButton radioButton;
    Button registerUser;

    DatabaseReference databaseUser;
    FirebaseAuth firebaseAuth;

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);

        databaseUser = FirebaseDatabase.getInstance().getReference("users");
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        r_uname = findViewById(R.id.reg_uname);
        r_fname = findViewById(R.id.reg_fname);
        r_lname = findViewById(R.id.reg_lname);
        r_password = findViewById(R.id.reg_password);
        r_phone_number = findViewById(R.id.reg_name);
        r_email = findViewById(R.id.reg_email);
        radioButtonChooser = findViewById(R.id.radioButtonChooser);
        registerUser = findViewById(R.id.button3);

        registerUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        addUser();
    }

    private void addUser() {
        String uname = r_uname.getText().toString().trim();
        String fname = r_fname.getText().toString().trim();
        String lname = r_lname.getText().toString().trim();
        String password = r_password.getText().toString().trim();
        String phone_number = r_phone_number.getText().toString().trim();
        String email = r_email.getText().toString().trim();

        int account_type_id = radioButtonChooser.getCheckedRadioButtonId();
        radioButton = (RadioButton) findViewById(account_type_id);
        String account_type = radioButton.getText().toString();

        progressDialog.setMessage("Registering Account");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if (task.isSuccessful()) {
                    Toast.makeText(RegisterUserActivity.this, "Register Account Success", Toast.LENGTH_LONG).show();
                    firebaseAuth.signOut();
                    startActivity(new Intent(RegisterUserActivity.this, login_user_activity.class));
                    finish();
                } else {
                    Toast.makeText(RegisterUserActivity.this, "Register Account Failed", Toast.LENGTH_LONG).show();
                }
            }
        });

        User user = new User(uname, email, fname + " " + lname, account_type, phone_number);

        databaseUser.child(uname).setValue(user);
    }
}
