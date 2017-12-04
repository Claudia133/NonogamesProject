package com.example.claudiaalamillo.nonogamesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Button playButton         = (Button) findViewById(R.id.button1);
        Button createPuzzleButton = (Button) findViewById(R.id.createButton);
        Button changeThemeButton  = (Button) findViewById(R.id.themeButton);
        Button loginButton        = (Button) findViewById(R.id.button4);

        playButton.setOnClickListener  (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLevelSelectionActivity();
            }
        } );
        loginButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToLoginActivity();
            }
        } );
        createPuzzleButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {goToCreatePuzzleActivity();
            }
        } );
    }

    private void goToLevelSelectionActivity()
    {
        Intent intent = new Intent(this, LevelSelection.class);
        startActivity(intent);
    }

    private void goToLoginActivity()
    {
        Intent intent = new Intent(this, Login.class);
        startActivity(intent);
    }

    private void goToCreatePuzzleActivity()
    {
        Intent intent = new Intent(this, CreatePuzzle.class);
        startActivity(intent);
    }
}
