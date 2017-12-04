package com.example.claudiaalamillo.nonogamesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class LevelSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        Button goBackButton = (Button) findViewById(R.id.button13);
        Button easyButton = (Button) findViewById(R.id.easyButton);
        Button mediumButton = (Button) findViewById(R.id.mediumButton);
        Button hardButton = (Button) findViewById(R.id.hardButton);
        Button timedButton = (Button) findViewById(R.id.timedButton);
        Button customButton = (Button) findViewById(R.id.customButton);

        goBackButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToMainMenuActivity();
            }
        } );
        easyButton.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToEasyLibraryActivity();
            }
        } );
        mediumButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMediumActivity();
            }
        } );
        hardButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToHardActivity();
            }
        } );
    }

    private void goToMainMenuActivity()
    {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }

    private void goToEasyLibraryActivity()
    {
        Intent intent = new Intent(this, EasyLibraryActivity.class);
        startActivity(intent);
    }

    private void goToMediumActivity()
    {
        Intent intent = new Intent(this, MediumLibraryActivity.class);
        startActivity(intent);
    }

    private void goToHardActivity()
    {
        Intent intent = new Intent(this, HardLibraryActivity.class);
        startActivity(intent);
    }

    private void goToTimedActivity()
    {

    }

    private void goToCustomActivity()
    {

    }
}
