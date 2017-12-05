package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MediumLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_library);

        ImageButton board1 = findViewById(R.id.imageButton1);
        ImageButton board2 = findViewById(R.id.imageButton2);
        ImageButton board3 = findViewById(R.id.imageButton3);
        ImageButton board4 = findViewById(R.id.imageButton4);

        board1.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMediumLevelActivity(1);
            }
        } );
        board2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMediumLevelActivity(2);
            }
        } );
        board3.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMediumLevelActivity(3);
            }
        } );
        board4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMediumLevelActivity(4);
            }
        } );

    }

    private void goToMediumLevelActivity(int puzzle_num){
        Intent intent = new Intent(this, MediumLevelActivity.class);

        //set the puzzle id so it knows what stored solution and hints to use
        Bundle b = new Bundle();
        b.putInt("id", puzzle_num);
        intent.putExtras(b);

        startActivity(intent);
    }
}

