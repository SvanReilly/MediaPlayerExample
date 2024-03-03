package com.ssreilly.mediaplayerexample;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String correo,pass;
    private Button buttonContinuar;
    private Switch recordarUsuario;
    private ImageView spotifyLogoGif;
    private TextView hiddenText;
    private TextView correoIns;
    private TextView passIns;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spotifyLogoGif= findViewById(R.id.spotiLogoView);

        Glide.with(this).asGif().load(R.drawable.spotifylogogif).into(spotifyLogoGif);
        buttonContinuar = findViewById(R.id.buttonContinuar);
        hiddenText = findViewById(R.id.resultText);
        correoIns=findViewById(R.id.cajaTextoCorreo);
        passIns=findViewById(R.id.cajaTextoPass);
        recordarUsuario=findViewById(R.id.switchRecordar);

        buttonContinuar.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        correo = correoIns.getText().toString();
        pass = passIns.getText().toString();
        Intent goToSecondActivity = new Intent(this, SecondActivity.class);
        if (view.getId() == R.id.buttonContinuar) {
            if (correo.equals("admin@rickrolled.com") && pass.equals("12345")) {
                hiddenText.setVisibility(View.VISIBLE);
                hiddenText.setTextColor(getColor(R.color.green));
                hiddenText.setText("Usuario y contraseña correctos.");
                startActivity(goToSecondActivity);
                if (correo.equals("admin@rickrolled.com") && pass.equals("12345") && recordarUsuario.isChecked()) {
                    hiddenText.setText(hiddenText.getText() +
                            "\n" + "Se almacenó la información para próximos accesos.");
                    startActivity(goToSecondActivity);
                }
            } else {
                hiddenText.setVisibility(View.VISIBLE);
                hiddenText.setTextColor(getColor(R.color.red));
                hiddenText.setText("Usuario y/o contraseña incorrectos.");
            }

        }
    }
}
