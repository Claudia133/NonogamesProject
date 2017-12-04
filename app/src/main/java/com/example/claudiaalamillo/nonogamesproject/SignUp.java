package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        Button backButton = (Button) findViewById(R.id.backButton);
        Button doneButton = (Button) findViewById(R.id.doneButton);

        backButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLogin();
            }
        } );
        doneButton.setOnClickListener (new View.OnClickListener() {
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
