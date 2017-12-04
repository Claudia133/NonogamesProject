package com.example.claudiaalamillo.nonogamesproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


public class EasyLibraryActivity extends AppCompatActivity {

//    private PopupWindow pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_library);

        //buttons for thumbnails of puzzles
        ImageButton board1 = (ImageButton)findViewById(R.id.imageButton1);
        ImageButton board2 = (ImageButton)findViewById(R.id.imageButton2);
        ImageButton board3 = (ImageButton)findViewById(R.id.imageButton3);
        ImageButton board4 = (ImageButton)findViewById(R.id.imageButton4);

        Button goBack = findViewById(R.id.easyButton);



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

        goBack.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToLevelSelection();
            }
        } );
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
