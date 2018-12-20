package com.ics115_project.cookbook;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EditProfileActivity extends AppCompatActivity {
    Button saveProfile;
    ImageView addSpecialty;
    Dialog specialtyDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        specialtyDialog = new Dialog(this);
        addSpecialty = (ImageView) findViewById(R.id.add_specialty);
        saveProfile = (Button) findViewById(R.id.saveProfile);

        addSpecialty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopUp(v);
            }
        });

        saveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(EditProfileActivity.this,HomeActivity.class));
            }
        });
    }

    public void showPopUp(View v){
        TextView close;
        Button save;

        specialtyDialog.setContentView(R.layout.add_specialty_layout);
        close = (TextView) specialtyDialog.findViewById(R.id.closeSpecialty);
        save = (Button) specialtyDialog.findViewById(R.id.add_specific_specialty);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specialtyDialog.dismiss();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                specialtyDialog.dismiss();
            }
        });

        specialtyDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        specialtyDialog.show();
    }
}
