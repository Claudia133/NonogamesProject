package com.example.claudiaalamillo.nonogamesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class LevelSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_selection);
        Button goBackButton = (Button) findViewById(R.id.button13);
        Button easyButton = (Button) findViewById(R.id.button);
//        Button mediumButton = (Button) findViewById(R.id.button12);
//        Button hardButton = (Button) findViewById(R.id.button11);
//        Button timedButton = (Button) findViewById(R.id.button10);
//        Button customButton = (Button) findViewById(R.id.button9);

        goBackButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainMenuActivity();
            }
        } );
        easyButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToEasyLibraryActivity();
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
}
