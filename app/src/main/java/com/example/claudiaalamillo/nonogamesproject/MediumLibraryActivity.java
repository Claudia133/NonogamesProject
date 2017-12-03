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

        ImageButton board1 = (ImageButton)findViewById(R.id.imageButton);

        board1.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMediumLevelActivity(1);
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

