package com.example.claudiaalamillo.nonogamesproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class HardLibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_library);

        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setNumColumns(20);
        pixelGrid.setNumRows(20);

        setContentView(pixelGrid);
    }
}
