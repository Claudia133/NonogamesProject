package com.example.claudiaalamillo.nonogamesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class CreatePuzzle extends AppCompatActivity {
    //get the spinner from the xml.
    Spinner dropdown = (Spinner)findViewById(R.id.spinner1);
    //create a list of items for the spinner.
    String[] items = new String[]{"5x5", "10x10", "20x20"};
    //create an adapter to describe how the items are displayed, adapters are used in several places in android.
    //There are multiple variations of this, but this is the basic variant.
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
    //set the spinners adapter to the previously created one.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_puzzle);
    }
}

