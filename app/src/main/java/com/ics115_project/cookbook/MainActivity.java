package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_page);
        getSupportActionBar().hide();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent i = new Intent(MainActivity.this, login_user_activity.class);
                MainActivity.this.startActivity(i);
                MainActivity.this.finish();
            }
        }, 2500);

    }
}
