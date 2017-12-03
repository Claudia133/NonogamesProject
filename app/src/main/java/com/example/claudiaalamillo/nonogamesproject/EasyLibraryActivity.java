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
            public void onClick(View v) {
                goToEasyLevelActivity();
            }
        } );


    }

    private void goToEasyLevelActivity()
    {
        Intent intent = new Intent(this, EasyLevelActivity.class);
        startActivity(intent);
    }
}
