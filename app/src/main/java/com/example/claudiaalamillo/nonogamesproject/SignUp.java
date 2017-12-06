package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.updateTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button backButton = (Button) findViewById(R.id.button14);
        Button toMainMenuButton = (Button) findViewById(R.id.button15);

        backButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        } );
        toMainMenuButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainMenu();
            }
        } );
    }

    private void goToMainMenu()
    {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    private void goToLogin()
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }
}
