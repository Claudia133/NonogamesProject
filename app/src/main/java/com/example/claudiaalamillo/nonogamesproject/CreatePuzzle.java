package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class CreatePuzzle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_puzzle);

        Button backButton = (Button) findViewById(R.id.button7);

        backButton.setOnClickListener (new View.OnClickListener() {
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

