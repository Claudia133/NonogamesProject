package com.example.claudiaalamillo.nonogamesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button goBackButton = (Button) findViewById(R.id.nextButton);
        Button loginButton = (Button) findViewById(R.id.loginButton);
        Button signupButton = findViewById(R.id.signupButton);

        goBackButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainMenu();
            }
        } );

        loginButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainMenu();
            }
        } );

        signupButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                goToSignUp();
            }
        }
        );
    }

    private void goToMainMenu()
    {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    private void goToSignUp()
    {
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
