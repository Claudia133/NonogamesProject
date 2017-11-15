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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_library);

        ImageButton board1 = (ImageButton)findViewById(R.id.imageButton2);

        board1.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
//                PixelGridView pixelGrid = new PixelGridView(Context);
//                pixelGrid.setNumColumns(5);
//                pixelGrid.setNumRows(5);
//
//                setContentView(pixelGrid);
            }
        });


        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setNumColumns(6);
        pixelGrid.setNumRows(6);

        setContentView(pixelGrid);

//        InputStream is = new FileInputStream(xmlFile);


//        int[] testEasy1 = getResources().getIntArray(R.array.easy1_solution);
//        String[] array = getResources().get
    }

    private void goToPuzzleBoard1()
    {
        Intent intent = new Intent(this, PuzzleBoard1.class);
        startActivity(intent);
    }
}
