package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.content.*;

import org.xml.sax.XMLReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class EasyLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeManager.updateTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_library);

        //buttons for thumbnails of puzzles
        ImageButton board1 = findViewById(R.id.imageButton1);
        ImageButton board2 = findViewById(R.id.imageButton2);
        ImageButton board3 = findViewById(R.id.imageButton3);
        ImageButton board4 = findViewById(R.id.imageButton4);

        Button backButton = findViewById(R.id.backButton);

        board1.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToEasyLevelActivity(1);
            }
        } );
        board2.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToEasyLevelActivity(2);
            }
        } );
        board3.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToEasyLevelActivity(3);
            }
        } );
        board4.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToEasyLevelActivity(4);
            }
        } );

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goToLevelSelection();
            }
        });
    }

    private void goToEasyLevelActivity(int puzzle_num)
    {
        Intent intent = new Intent(this, EasyLevelActivity.class);

        //set the puzzle id so it knows what stored solution and hints to use
        Bundle b = new Bundle();
        b.putInt("id", puzzle_num);
        intent.putExtras(b);

        startActivity(intent);
    }

    private void goToLevelSelection()
    {
        Intent intent = new Intent(this, LevelSelection.class);
        startActivity(intent);
    }
}
