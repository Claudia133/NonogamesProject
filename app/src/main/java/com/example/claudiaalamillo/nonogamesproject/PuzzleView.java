package com.example.claudiaalamillo.nonogamesproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by joaoaguilera on 11/8/17.
 */

public class PuzzleView extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puzzle_view);

        PixelGridView pixelGrid = new PixelGridView(this);
        pixelGrid.setNumColumns(9);
        pixelGrid.setNumRows(9);

        setContentView(pixelGrid);
    }
}
