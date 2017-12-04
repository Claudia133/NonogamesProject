package com.example.claudiaalamillo.nonogamesproject;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MediumLevelActivity extends AppCompatActivity {

    //VARIABLES
    private static final int COLUMNS = 10, ROWS = 10;
    private static final int DIMENSIONS = ROWS * COLUMNS;
    private int[] solution = new int[DIMENSIONS];

    //current state of the board, initialize to 0
    private int[] currentState = new int[DIMENSIONS];

    //row hints & column hints to display
    TextView r1, r2, r3, r4, r5, r6, r7, r8, r9, r10;
    TextView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10;

    //current state of the grid/board
    ImageView[] grid = new ImageView[DIMENSIONS];

    //string arrays to store hints
    String[] row_hints = new String[ROWS];
    String[] col_hints = new String[COLUMNS];

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level);

        //get puzzle id
        Bundle b = getIntent().getExtras();
        int puzzle_num = -1;
        if(b != null){
            puzzle_num = b.getInt("id");
        }

        //see method
        setHintsAndSolution(puzzle_num);

        //connect row hint variables with id's in xml
        r1 = (TextView) findViewById(R.id.r1_hints);
        r2 = (TextView) findViewById(R.id.r2_hints);
        r3 = (TextView) findViewById(R.id.r3_hints);
        r4 = (TextView) findViewById(R.id.r4_hints);
        r5 = (TextView) findViewById(R.id.r5_hints);
        r6 = (TextView) findViewById(R.id.r6_hints);
        r7 = (TextView) findViewById(R.id.r7_hints);
        r8 = (TextView) findViewById(R.id.r8_hints);
        r9 = (TextView) findViewById(R.id.r9_hints);
        r10 = (TextView) findViewById(R.id.r10_hints);

        r1.setText(row_hints[0]);
        r2.setText(row_hints[1]);
        r3.setText(row_hints[2]);
        r4.setText(row_hints[3]);
        r5.setText(row_hints[4]);
        r6.setText(row_hints[5]);
        r7.setText(row_hints[6]);
        r8.setText(row_hints[7]);
        r9.setText(row_hints[8]);
        r10.setText(row_hints[9]);

        //connect col hint variables with i's in xml
        c1 = (TextView) findViewById(R.id.c1_hints);
        c2 = (TextView) findViewById(R.id.c2_hints);
        c3 = (TextView) findViewById(R.id.c3_hints);
        c4 = (TextView) findViewById(R.id.c4_hints);
        c5 = (TextView) findViewById(R.id.c5_hints);
        c6 = (TextView) findViewById(R.id.c6_hints);
        c7 = (TextView) findViewById(R.id.c7_hints);
        c8 = (TextView) findViewById(R.id.c8_hints);
        c9 = (TextView) findViewById(R.id.c9_hints);
        c10 = (TextView) findViewById(R.id.c10_hints);

        c1.setText(col_hints[0]);
        c2.setText(col_hints[1]);
        c3.setText(col_hints[2]);
        c4.setText(col_hints[3]);
        c5.setText(col_hints[4]);
        c6.setText(col_hints[5]);
        c7.setText(col_hints[6]);
        c8.setText(col_hints[7]);
        c9.setText(col_hints[8]);
        c10.setText(col_hints[9]);

        //connect image view variables
        grid[0] = (ImageView) findViewById(R.id.r1c1);
        grid[1] = (ImageView) findViewById(R.id.r1c2);
        grid[2] = (ImageView) findViewById(R.id.r1c3);
        grid[3] = (ImageView) findViewById(R.id.r1c4);
        grid[4] = (ImageView) findViewById(R.id.r1c5);
        grid[5] = (ImageView) findViewById(R.id.r1c6);
        grid[6] = (ImageView) findViewById(R.id.r1c7);
        grid[7] = (ImageView) findViewById(R.id.r1c8);
        grid[8] = (ImageView) findViewById(R.id.r1c9);
        grid[9] = (ImageView) findViewById(R.id.r1c10);

        grid[10] = (ImageView) findViewById(R.id.r2c1);
        grid[11] = (ImageView) findViewById(R.id.r2c2);
        grid[12] = (ImageView) findViewById(R.id.r2c3);
        grid[13] = (ImageView) findViewById(R.id.r2c4);
        grid[14] = (ImageView) findViewById(R.id.r2c5);
        grid[15] = (ImageView) findViewById(R.id.r2c6);
        grid[16] = (ImageView) findViewById(R.id.r2c7);
        grid[17] = (ImageView) findViewById(R.id.r2c8);
        grid[18] = (ImageView) findViewById(R.id.r2c9);
        grid[19] = (ImageView) findViewById(R.id.r2c10);

        grid[20] = (ImageView) findViewById(R.id.r3c1);
        grid[21] = (ImageView) findViewById(R.id.r3c2);
        grid[22] = (ImageView) findViewById(R.id.r3c3);
        grid[23] = (ImageView) findViewById(R.id.r3c4);
        grid[24] = (ImageView) findViewById(R.id.r3c5);
        grid[25] = (ImageView) findViewById(R.id.r3c6);
        grid[26] = (ImageView) findViewById(R.id.r3c7);
        grid[27] = (ImageView) findViewById(R.id.r3c8);
        grid[28] = (ImageView) findViewById(R.id.r3c9);
        grid[29] = (ImageView) findViewById(R.id.r3c10);

        grid[30] = (ImageView) findViewById(R.id.r4c1);
        grid[31] = (ImageView) findViewById(R.id.r4c2);
        grid[32] = (ImageView) findViewById(R.id.r4c3);
        grid[33] = (ImageView) findViewById(R.id.r4c4);
        grid[34] = (ImageView) findViewById(R.id.r4c5);
        grid[35] = (ImageView) findViewById(R.id.r4c6);
        grid[36] = (ImageView) findViewById(R.id.r4c7);
        grid[37] = (ImageView) findViewById(R.id.r4c8);
        grid[38] = (ImageView) findViewById(R.id.r4c9);
        grid[39] = (ImageView) findViewById(R.id.r4c10);

        grid[40] = (ImageView) findViewById(R.id.r5c1);
        grid[41] = (ImageView) findViewById(R.id.r5c2);
        grid[42] = (ImageView) findViewById(R.id.r5c3);
        grid[43] = (ImageView) findViewById(R.id.r5c4);
        grid[44] = (ImageView) findViewById(R.id.r5c5);
        grid[45] = (ImageView) findViewById(R.id.r5c6);
        grid[46] = (ImageView) findViewById(R.id.r5c7);
        grid[47] = (ImageView) findViewById(R.id.r5c8);
        grid[48] = (ImageView) findViewById(R.id.r5c9);
        grid[49] = (ImageView) findViewById(R.id.r5c10);

        grid[50] = (ImageView) findViewById(R.id.r6c1);
        grid[51] = (ImageView) findViewById(R.id.r6c2);
        grid[52] = (ImageView) findViewById(R.id.r6c3);
        grid[53] = (ImageView) findViewById(R.id.r6c4);
        grid[54] = (ImageView) findViewById(R.id.r6c5);
        grid[55] = (ImageView) findViewById(R.id.r6c6);
        grid[56] = (ImageView) findViewById(R.id.r6c7);
        grid[57] = (ImageView) findViewById(R.id.r6c8);
        grid[58] = (ImageView) findViewById(R.id.r6c9);
        grid[59] = (ImageView) findViewById(R.id.r6c10);

        grid[60] = (ImageView) findViewById(R.id.r7c1);
        grid[61] = (ImageView) findViewById(R.id.r7c2);
        grid[62] = (ImageView) findViewById(R.id.r7c3);
        grid[63] = (ImageView) findViewById(R.id.r7c4);
        grid[64] = (ImageView) findViewById(R.id.r7c5);
        grid[65] = (ImageView) findViewById(R.id.r7c6);
        grid[66] = (ImageView) findViewById(R.id.r7c7);
        grid[67] = (ImageView) findViewById(R.id.r7c8);
        grid[68] = (ImageView) findViewById(R.id.r7c9);
        grid[69] = (ImageView) findViewById(R.id.r7c10);

        grid[70] = (ImageView) findViewById(R.id.r8c1);
        grid[71] = (ImageView) findViewById(R.id.r8c2);
        grid[72] = (ImageView) findViewById(R.id.r8c3);
        grid[73] = (ImageView) findViewById(R.id.r8c4);
        grid[74] = (ImageView) findViewById(R.id.r8c5);
        grid[75] = (ImageView) findViewById(R.id.r8c6);
        grid[76] = (ImageView) findViewById(R.id.r8c7);
        grid[77] = (ImageView) findViewById(R.id.r8c8);
        grid[78] = (ImageView) findViewById(R.id.r8c9);
        grid[79] = (ImageView) findViewById(R.id.r8c10);

        grid[80] = (ImageView) findViewById(R.id.r9c1);
        grid[81] = (ImageView) findViewById(R.id.r9c2);
        grid[82] = (ImageView) findViewById(R.id.r9c3);
        grid[83] = (ImageView) findViewById(R.id.r9c4);
        grid[84] = (ImageView) findViewById(R.id.r9c5);
        grid[85] = (ImageView) findViewById(R.id.r9c6);
        grid[86] = (ImageView) findViewById(R.id.r9c7);
        grid[87] = (ImageView) findViewById(R.id.r9c8);
        grid[88] = (ImageView) findViewById(R.id.r9c9);
        grid[89] = (ImageView) findViewById(R.id.r9c10);

        grid[90] = (ImageView) findViewById(R.id.r10c1);
        grid[91] = (ImageView) findViewById(R.id.r10c2);
        grid[92] = (ImageView) findViewById(R.id.r10c3);
        grid[93] = (ImageView) findViewById(R.id.r10c4);
        grid[94] = (ImageView) findViewById(R.id.r10c5);
        grid[95] = (ImageView) findViewById(R.id.r10c6);
        grid[96] = (ImageView) findViewById(R.id.r10c7);
        grid[97] = (ImageView) findViewById(R.id.r10c8);
        grid[98] = (ImageView) findViewById(R.id.r10c9);
        grid[99] = (ImageView) findViewById(R.id.r10c10);

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

    //change square to black or white depending on what it currently is
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

    //get the int arrays and string arrays from the resource files and set to global variables
    private void setHintsAndSolution(int puzzle_num){
        Resources res = getResources();
        switch(puzzle_num){
            case 1:
                this.row_hints = res.getStringArray(R.array.medium_puzzle_1_row);
                this.col_hints = res.getStringArray(R.array.medium_puzzle_1_col);
                this.solution = res.getIntArray(R.array.medium_puzzle_1);
                break;
            case 2:
                this.row_hints = res.getStringArray(R.array.medium_puzzle_2_row);
                this.col_hints = res.getStringArray(R.array.medium_puzzle_2_col);
                this.solution = res.getIntArray(R.array.medium_puzzle_2);
                break;
            case 3:
                this.row_hints = res.getStringArray(R.array.medium_puzzle_3_row);
                this.col_hints = res.getStringArray(R.array.medium_puzzle_3_col);
                this.solution = res.getIntArray(R.array.medium_puzzle_3);
                break;
            case 4:
                this.row_hints = res.getStringArray(R.array.medium_puzzle_4_row);
                this.col_hints = res.getStringArray(R.array.medium_puzzle_4_col);
                this.solution = res.getIntArray(R.array.medium_puzzle_4);
                break;
        }
    }
}
