package com.ssreilly.mediaplayerexample;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ThirdActivity extends AppCompatActivity implements View.OnClickListener{


    private ImageButton backButtonMain ,logOutButtonMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backButtonMain = findViewById(R.id.backButtonView);
        Glide.with(this).asGif().load(R.drawable.backplayerbutton).into(backButtonMain);

        logOutButtonMain = findViewById(R.id.logOutButtonView);
        Glide.with(this).asGif().load(R.drawable.logoutbutton).into(logOutButtonMain);

        backButtonMain.setOnClickListener(this);
        logOutButtonMain.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        Intent goToMainActivity = new Intent(this, MainActivity.class);
//      Intent goToSecondActivity = new Intent(this, SecondActivity.class);

        goToMainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        if (view.getId() == R.id.backButtonView) {
            finish();
//                startActivity(goToSecondActivity);
        } else if (view.getId() == R.id.logOutButtonView){

            finish();
            startActivity (goToMainActivity);
        }
    }
}
