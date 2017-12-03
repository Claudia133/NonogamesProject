package com.example.claudiaalamillo.nonogamesproject;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class EasyLevelActivity extends AppCompatActivity {

    //VARIABLES
    private static final int COLUMNS = 5, ROWS = 5;
    private static final int DIMENSIONS = ROWS * COLUMNS;
    private int[] solution = {1, 1, 0, 1, 1,
            1, 0, 1, 0, 1,
            1, 0, 0, 0, 1,
            0, 1, 0, 1, 0,
            0, 0, 1, 0, 0};
    //current state of the board, initialize to 0
    private int[] currentState = new int[DIMENSIONS];
    //row hints
    TextView r1, r2, r3, r4, r5;
    //column hints
    TextView c1, c2, c3, c4, c5;
    //current state of the
    ImageView[] grid = new ImageView[DIMENSIONS];

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);

        //connect row hint variables with id's in xml
        r1 = (TextView) findViewById(R.id.r1_hints);
        r2 = (TextView) findViewById(R.id.r2_hints);
        r3 = (TextView) findViewById(R.id.r3_hints);
        r4 = (TextView) findViewById(R.id.r4_hints);
        r5 = (TextView) findViewById(R.id.r5_hints);

        r1.setText("2 2");
        r2.setText("1 1 1");
        r3.setText("1 1");
        r4.setText("1 1");
        r5.setText("1");

        //connect col hint variables with i's in xml
        c1 = (TextView) findViewById(R.id.c1_hints);
        c2 = (TextView) findViewById(R.id.c2_hints);
        c3 = (TextView) findViewById(R.id.c3_hints);
        c4 = (TextView) findViewById(R.id.c4_hints);
        c5 = (TextView) findViewById(R.id.c5_hints);

        c1.setText("3");
        c2.setText("1\n1");
        c3.setText("1\n1");
        c4.setText("1\n1");
        c5.setText("3");

        //connect image view variables
        grid[0] = (ImageView) findViewById(R.id.r1c1);
        grid[1] = (ImageView) findViewById(R.id.r1c2);
        grid[2] = (ImageView) findViewById(R.id.r1c3);
        grid[3] = (ImageView) findViewById(R.id.r1c4);
        grid[4] = (ImageView) findViewById(R.id.r1c5);

        grid[5] = (ImageView) findViewById(R.id.r2c1);
        grid[6] = (ImageView) findViewById(R.id.r2c2);
        grid[7] = (ImageView) findViewById(R.id.r2c3);
        grid[8] = (ImageView) findViewById(R.id.r2c4);
        grid[9] = (ImageView) findViewById(R.id.r2c5);

        grid[10] = (ImageView) findViewById(R.id.r3c1);
        grid[11] = (ImageView) findViewById(R.id.r3c2);
        grid[12] = (ImageView) findViewById(R.id.r3c3);
        grid[13] = (ImageView) findViewById(R.id.r3c4);
        grid[14] = (ImageView) findViewById(R.id.r3c5);

        grid[15] = (ImageView) findViewById(R.id.r4c1);
        grid[16] = (ImageView) findViewById(R.id.r4c2);
        grid[17] = (ImageView) findViewById(R.id.r4c3);
        grid[18] = (ImageView) findViewById(R.id.r4c4);
        grid[19] = (ImageView) findViewById(R.id.r4c5);

        grid[20] = (ImageView) findViewById(R.id.r5c1);
        grid[21] = (ImageView) findViewById(R.id.r5c2);
        grid[22] = (ImageView) findViewById(R.id.r5c3);
        grid[23] = (ImageView) findViewById(R.id.r5c4);
        grid[24] = (ImageView) findViewById(R.id.r5c5);

        //start all at 0 (white)
        for(int i = 0; i < DIMENSIONS; i++){
            final int finalI = i;
            grid[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    flip(finalI);
                    if( isSolved()){
                        Context context = getApplicationContext();
                        CharSequence text = "SOLVED!";
                        int duration = Toast.LENGTH_SHORT;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }
                }
            });
        }
    }


    private void flip(int index){
        if(currentState[index] == 0){
            grid[index].setImageResource(R.drawable.black);
            currentState[index] = 1;
        }
        else{ //if it's 1
            grid[index].setImageResource(R.drawable.white);
            currentState[index] = 0;
        }
    }


    //check if the board is solved by comparing the pixelList array with solution array
    private boolean isSolved(){
        boolean solved = false;
        for(int i = 0; i < currentState.length; i++){
            if(currentState[i] == solution[i]){
                solved = true;
            }
            else{
                solved = false;
                break;
            }
        }
        return solved;
    }
}
