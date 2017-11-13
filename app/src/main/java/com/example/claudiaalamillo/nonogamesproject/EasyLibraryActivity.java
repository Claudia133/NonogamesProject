package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class EasyLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_library);

      //  ImageButton board1 = (ImageButton)findViewById(R.id.imageButton);

        /*board1.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPuzzleBoard1();
            }
        } );*/


        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setNumColumns(5);
        pixelGrid.setNumRows(5);

        setContentView(pixelGrid);

    }

    private void goToPuzzleBoard1()
    {
        Intent intent = new Intent(this, PuzzleBoard1.class);
        startActivity(intent);
    }
}
