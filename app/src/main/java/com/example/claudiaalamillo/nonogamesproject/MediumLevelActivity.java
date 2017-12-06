package com.example.claudiaalamillo.nonogamesproject;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

public class MediumLevelActivity extends AppCompatActivity {

    //VARIABLES
    private static final int COLUMNS = 10, ROWS = 10;
    private static final int DIMENSIONS = ROWS * COLUMNS;
    private int[] solution = new int[DIMENSIONS];
    private Button levelSelection;
    private Button mainMenu;
    private Button goBack;

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

    //optimal number of moves
    private int optimal_moves = 0;
    private int user_total_moves = 0;

    //optimal moves and user moves to display
    TextView opt_moves, user_moves;

    public void onCreate (Bundle savedInstanceState) {
        ThemeManager.updateTheme(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium_level);

        goBack = findViewById(R.id.backButton);
        goBack.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToMediumLibrary();
            }
        } );

        //get puzzle id
        Bundle b = getIntent().getExtras();
        int puzzle_num = -1;
        if(b != null){
            puzzle_num = b.getInt("id");
        }

        //see method
        setHintsAndSolution(puzzle_num);

        //can set this now that we have the solution
        setOptimal_moves();

        //connect optimal and user textviews
        opt_moves = findViewById(R.id.optimal);
        user_moves = findViewById(R.id.user);

        //set optimal
        opt_moves.setText("Optimal:\n" + this.optimal_moves);
        user_moves.setText("Current:\n" + this.user_total_moves);

        //connect row hint variables with id's in xml
        r1 = findViewById(R.id.r1_hints);
        r2 = findViewById(R.id.r2_hints);
        r3 = findViewById(R.id.r3_hints);
        r4 = findViewById(R.id.r4_hints);
        r5 = findViewById(R.id.r5_hints);
        r6 = findViewById(R.id.r6_hints);
        r7 = findViewById(R.id.r7_hints);
        r8 = findViewById(R.id.r8_hints);
        r9 = findViewById(R.id.r9_hints);
        r10 = findViewById(R.id.r10_hints);

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
        c1 = findViewById(R.id.c1_hints);
        c2 = findViewById(R.id.c2_hints);
        c3 = findViewById(R.id.c3_hints);
        c4 = findViewById(R.id.c4_hints);
        c5 = findViewById(R.id.c5_hints);
        c6 = findViewById(R.id.c6_hints);
        c7 = findViewById(R.id.c7_hints);
        c8 = findViewById(R.id.c8_hints);
        c9 = findViewById(R.id.c9_hints);
        c10 = findViewById(R.id.c10_hints);

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
        grid[0] = findViewById(R.id.r1c1);
        grid[1] = findViewById(R.id.r1c2);
        grid[2] = findViewById(R.id.r1c3);
        grid[3] = findViewById(R.id.r1c4);
        grid[4] = findViewById(R.id.r1c5);
        grid[5] = findViewById(R.id.r1c6);
        grid[6] = findViewById(R.id.r1c7);
        grid[7] = findViewById(R.id.r1c8);
        grid[8] = findViewById(R.id.r1c9);
        grid[9] = findViewById(R.id.r1c10);

        grid[10] = findViewById(R.id.r2c1);
        grid[11] = findViewById(R.id.r2c2);
        grid[12] = findViewById(R.id.r2c3);
        grid[13] = findViewById(R.id.r2c4);
        grid[14] = findViewById(R.id.r2c5);
        grid[15] = findViewById(R.id.r2c6);
        grid[16] = findViewById(R.id.r2c7);
        grid[17] = findViewById(R.id.r2c8);
        grid[18] = findViewById(R.id.r2c9);
        grid[19] = findViewById(R.id.r2c10);

        grid[20] = findViewById(R.id.r3c1);
        grid[21] = findViewById(R.id.r3c2);
        grid[22] = findViewById(R.id.r3c3);
        grid[23] = findViewById(R.id.r3c4);
        grid[24] = findViewById(R.id.r3c5);
        grid[25] = findViewById(R.id.r3c6);
        grid[26] = findViewById(R.id.r3c7);
        grid[27] = findViewById(R.id.r3c8);
        grid[28] = findViewById(R.id.r3c9);
        grid[29] = findViewById(R.id.r3c10);

        grid[30] = findViewById(R.id.r4c1);
        grid[31] = findViewById(R.id.r4c2);
        grid[32] = findViewById(R.id.r4c3);
        grid[33] = findViewById(R.id.r4c4);
        grid[34] = findViewById(R.id.r4c5);
        grid[35] = findViewById(R.id.r4c6);
        grid[36] = findViewById(R.id.r4c7);
        grid[37] = findViewById(R.id.r4c8);
        grid[38] = findViewById(R.id.r4c9);
        grid[39] = findViewById(R.id.r4c10);

        grid[40] = findViewById(R.id.r5c1);
        grid[41] = findViewById(R.id.r5c2);
        grid[42] = findViewById(R.id.r5c3);
        grid[43] = findViewById(R.id.r5c4);
        grid[44] = findViewById(R.id.r5c5);
        grid[45] = findViewById(R.id.r5c6);
        grid[46] = findViewById(R.id.r5c7);
        grid[47] = findViewById(R.id.r5c8);
        grid[48] = findViewById(R.id.r5c9);
        grid[49] = findViewById(R.id.r5c10);

        grid[50] = findViewById(R.id.r6c1);
        grid[51] = findViewById(R.id.r6c2);
        grid[52] = findViewById(R.id.r6c3);
        grid[53] = findViewById(R.id.r6c4);
        grid[54] = findViewById(R.id.r6c5);
        grid[55] = findViewById(R.id.r6c6);
        grid[56] = findViewById(R.id.r6c7);
        grid[57] = findViewById(R.id.r6c8);
        grid[58] = findViewById(R.id.r6c9);
        grid[59] = findViewById(R.id.r6c10);

        grid[60] = findViewById(R.id.r7c1);
        grid[61] = findViewById(R.id.r7c2);
        grid[62] = findViewById(R.id.r7c3);
        grid[63] = findViewById(R.id.r7c4);
        grid[64] = findViewById(R.id.r7c5);
        grid[65] = findViewById(R.id.r7c6);
        grid[66] = findViewById(R.id.r7c7);
        grid[67] = findViewById(R.id.r7c8);
        grid[68] = findViewById(R.id.r7c9);
        grid[69] = findViewById(R.id.r7c10);

        grid[70] = findViewById(R.id.r8c1);
        grid[71] = findViewById(R.id.r8c2);
        grid[72] = findViewById(R.id.r8c3);
        grid[73] = findViewById(R.id.r8c4);
        grid[74] = findViewById(R.id.r8c5);
        grid[75] = findViewById(R.id.r8c6);
        grid[76] = findViewById(R.id.r8c7);
        grid[77] = findViewById(R.id.r8c8);
        grid[78] = findViewById(R.id.r8c9);
        grid[79] = findViewById(R.id.r8c10);

        grid[80] = findViewById(R.id.r9c1);
        grid[81] = findViewById(R.id.r9c2);
        grid[82] = findViewById(R.id.r9c3);
        grid[83] = findViewById(R.id.r9c4);
        grid[84] = findViewById(R.id.r9c5);
        grid[85] = findViewById(R.id.r9c6);
        grid[86] = findViewById(R.id.r9c7);
        grid[87] = findViewById(R.id.r9c8);
        grid[88] = findViewById(R.id.r9c9);
        grid[89] = findViewById(R.id.r9c10);

        grid[90] = findViewById(R.id.r10c1);
        grid[91] = findViewById(R.id.r10c2);
        grid[92] = findViewById(R.id.r10c3);
        grid[93] = findViewById(R.id.r10c4);
        grid[94] = findViewById(R.id.r10c5);
        grid[95] = findViewById(R.id.r10c6);
        grid[96] = findViewById(R.id.r10c7);
        grid[97] = findViewById(R.id.r10c8);
        grid[98] = findViewById(R.id.r10c9);
        grid[99] = findViewById(R.id.r10c10);

        //start all at 0 (white)
        for(int i = 0; i < DIMENSIONS; i++){
            final int finalI = i;
            grid[i].setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    flip(finalI);
                    user_moves.setText("Current:\n" + user_total_moves);
                    if( isSolved()){
                        showPopupWindow();
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
        user_total_moves++;
    }

    private void setOptimal_moves(){
        for(int i = 0; i < DIMENSIONS; i++){
            if(this.solution[i] == 1){
                this.optimal_moves++;
            }
        }
    }

    public void goToMediumLibrary()
    {
        startActivity(new Intent(this, MediumLibraryActivity.class));
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

    private void showPopupWindow()
    {
        ConstraintLayout mediumLayout = (ConstraintLayout) findViewById(R.id.activity_medium_level);

        LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = li.inflate(R.layout.activity_solved_popup_window, null);

        // creating actual popup window
        int width = 1000;
        int height = 500;
        boolean dismiss = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, true);

        // display popup
        popupWindow.showAtLocation(mediumLayout, Gravity.CENTER, 0, -250);

        levelSelection = popupView.findViewById(R.id.levelSelectionSPW);
        mainMenu = popupView.findViewById(R.id.mainMenuButtonSPW);

        levelSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediumLevelActivity.this, LevelSelection.class);
                MediumLevelActivity.this.startActivity(intent);
            }
        });
        mainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(MediumLevelActivity.this, MainMenuActivity.class);
                MediumLevelActivity.this.startActivity(intent);
            }
        });

        // allow user to dismiss the window when touched
//        popupView.setOnTouchListener(new View.OnTouchListener()
//        {
//            @Override
//            public boolean onTouch(View v, MotionEvent me)
//            {
//                popupWindow.dismiss();
//                return true;
//            }
//        });
    }
}
