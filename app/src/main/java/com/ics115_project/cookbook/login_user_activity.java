package com.ics115_project.cookbook;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class login_user_activity extends AppCompatActivity implements View.OnClickListener {
    private EditText loginEmail, loginPassword;
    private Button login, signup;
    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        loginEmail = (EditText) findViewById(R.id.login_email);
        loginPassword = (EditText) findViewById(R.id.login_password);
        login = (Button) findViewById(R.id.button_login);
        signup = (Button) findViewById(R.id.button_signup);

        progressDialog = new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();

        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(this, home_page_activity.class));
            finish();
        }

        login.setOnClickListener(this);
        signup.setOnClickListener(this);
    }

    private void userLogin() {
        String email = loginEmail.getText().toString().trim();
        String password = loginPassword.getText().toString().trim();

        if (email.length() == 0 && password.length() == 0) {
            Toast.makeText(login_user_activity.this, "Please enter email and password", Toast.LENGTH_LONG).show();
        } else if (email.length() == 0) {
            Toast.makeText(login_user_activity.this, "Please enter email", Toast.LENGTH_LONG).show();
        } else if (password.length() == 0) {
            Toast.makeText(login_user_activity.this, "Please enter password", Toast.LENGTH_LONG).show();
        } else {
            progressDialog.setMessage("Logging in");
            progressDialog.show();

            firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<com.google.firebase.auth.AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<com.google.firebase.auth.AuthResult> task) {
                            progressDialog.dismiss();
                            if (task.isSuccessful()) {
                                Toast.makeText(login_user_activity.this, "Login Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(login_user_activity.this, home_page_activity.class));
                                finish();
                            } else {
                                Toast.makeText(login_user_activity.this, "Login Failed", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
        }
    }

    @Override
    public void onClick(View v) {
        if (v == login) {
            userLogin();
        }
        if (v == signup) {
            startActivity(new Intent(this, RegisterUserActivity.class));
            finish();
        }
    }
}
