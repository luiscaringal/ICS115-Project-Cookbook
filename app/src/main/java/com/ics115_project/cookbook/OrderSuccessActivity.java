package com.ics115_project.cookbook;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class OrderSuccessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_success_layout);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent i = new Intent(OrderSuccessActivity.this, HomeActivity.class);
                OrderSuccessActivity.this.startActivity(i);
                OrderSuccessActivity.this.finish();
            }
        }, 2500);
    }
}
