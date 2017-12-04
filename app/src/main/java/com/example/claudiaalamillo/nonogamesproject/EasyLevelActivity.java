package com.example.claudiaalamillo.nonogamesproject;

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
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class EasyLevelActivity extends AppCompatActivity {

    //VARIABLES
    private static final int COLUMNS = 5, ROWS = 5;
    private static final int DIMENSIONS = ROWS * COLUMNS;
    private int[] solution = new int[DIMENSIONS];
    private PopupWindow pw;

    //current state of the board, initialize to 0
    private int[] currentState = new int[DIMENSIONS];

    //row hints & column hints to display
    TextView r1, r2, r3, r4, r5;
    TextView c1, c2, c3, c4, c5;

    //current state of the grid/board
    ImageView[] grid = new ImageView[DIMENSIONS];

    //string arrays to store hints
    String[] row_hints = new String[ROWS];
    String[] col_hints = new String[COLUMNS];

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_level);

        Button goBack = findViewById(R.id.backButton);

        goBack.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToEasyLibrary();
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

        //connect row hint variables with id's in xml
        r1 = (TextView) findViewById(R.id.r1_hints);
        r2 = (TextView) findViewById(R.id.r2_hints);
        r3 = (TextView) findViewById(R.id.r3_hints);
        r4 = (TextView) findViewById(R.id.r4_hints);
        r5 = (TextView) findViewById(R.id.r5_hints);

        r1.setText(row_hints[0]);
        r2.setText(row_hints[1]);
        r3.setText(row_hints[2]);
        r4.setText(row_hints[3]);
        r5.setText(row_hints[4]);

        //connect col hint variables with i's in xml
        c1 = (TextView) findViewById(R.id.c1_hints);
        c2 = (TextView) findViewById(R.id.c2_hints);
        c3 = (TextView) findViewById(R.id.c3_hints);
        c4 = (TextView) findViewById(R.id.c4_hints);
        c5 = (TextView) findViewById(R.id.c5_hints);

        c1.setText(col_hints[0]);
        c2.setText(col_hints[1]);
        c3.setText(col_hints[2]);
        c4.setText(col_hints[3]);
        c5.setText(col_hints[4]);

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
//                        Context context = getApplicationContext();
//                        CharSequence text = "SOLVED!";
//                        int duration = Toast.LENGTH_SHORT;
//
//                        Toast toast = Toast.makeText(context, text, duration);
//                        toast.show();
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
    }

    private void goToEasyLibrary()
    {
        Intent intent = new Intent(this, EasyLibraryActivity.class);
        startActivity(intent);
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
                this.row_hints = res.getStringArray(R.array.easy_puzzle_1_row);
                this.col_hints = res.getStringArray(R.array.easy_puzzle_1_col);
                this.solution = res.getIntArray(R.array.easy_puzzle_1);
                break;
            case 2:
                this.row_hints = res.getStringArray(R.array.easy_puzzle_2_row);
                this.col_hints = res.getStringArray(R.array.easy_puzzle_2_col);
                this.solution = res.getIntArray(R.array.easy_puzzle_2);
                break;
            case 3:
                this.row_hints = res.getStringArray(R.array.easy_puzzle_3_row);
                this.col_hints = res.getStringArray(R.array.easy_puzzle_3_col);
                this.solution = res.getIntArray(R.array.easy_puzzle_3);
                break;
            case 4:
                this.row_hints = res.getStringArray(R.array.easy_puzzle_4_row);
                this.col_hints = res.getStringArray(R.array.easy_puzzle_4_col);
                this.solution = res.getIntArray(R.array.easy_puzzle_4);
                break;
        }
    }

    private void showPopupWindow()
    {
        ConstraintLayout easyLayout = (ConstraintLayout) findViewById(R.id.activity_easy_level);

        LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = li.inflate(R.layout.activity_solved_popup_window, null);

        SolvedPopupWindow spw = new SolvedPopupWindow();

        Button levelSelection = findViewById(R.id.levelSelectionSPW);
        Button mainMenu = findViewById(R.id.mainMenuButtonSPW);

//        levelSelection.setOnClickListener(this);

        // creating actual popup window
        int width = 1000;
        int height = 500;
        boolean dismiss = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, dismiss);

        // display popup
        popupWindow.showAtLocation(easyLayout, Gravity.CENTER, 0, 0);

        levelSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                SolvedPopupWindow.class.
//                Intent intent = new Intent();
//                intent.setClass(this, LevelSelection.class);
//                startActivity(intent);
                startActivity(new Intent(EasyLevelActivity.this, LevelSelection.class));
            }
        });
        mainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

            }
        });

        // allow user to dismiss the window when touched
        popupView.setOnTouchListener(new View.OnTouchListener()
        {
            @Override
            public boolean onTouch(View v, MotionEvent me)
            {
                popupWindow.dismiss();
                return true;
            }
        });

    }
}
