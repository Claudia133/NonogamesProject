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
        Button backToMainMenuButton = (Button) findViewById(R.id.button13);

        backToMainMenuButton.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainMenuActivity();
            }
        } );
    }

    private void goToMainMenuActivity()
    {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
