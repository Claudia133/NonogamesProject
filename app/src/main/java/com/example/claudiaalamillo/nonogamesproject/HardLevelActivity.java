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

public class HardLevelActivity extends AppCompatActivity {

    //VARIABLES
    private static final int COLUMNS = 15, ROWS = 15;
    private static final int DIMENSIONS = ROWS * COLUMNS;
    private int[] solution = new int[DIMENSIONS];
    private Button goBack;
    private Button levelSelection;
    private Button mainMenu;

    //current state of the board, initialize to 0
    private int[] currentState = new int[DIMENSIONS];

    //row hints & column hints to display
    TextView r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15;
    TextView c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15;

    //current state of the grid/board
    ImageView[] grid = new ImageView[DIMENSIONS];

    //string arrays to store hints
    String[] row_hints = new String[ROWS];
    String[] col_hints = new String[COLUMNS];

    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hard_level);

        goBack = findViewById(R.id.backButton);
        goBack.setOnClickListener (new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                goToHardLibrary();
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
        r11 = findViewById(R.id.r11_hints);
        r12 = findViewById(R.id.r12_hints);
        r13 = findViewById(R.id.r13_hints);
        r14 = findViewById(R.id.r14_hints);
        r15 = findViewById(R.id.r15_hints);

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
        r11.setText(row_hints[10]);
        r12.setText(row_hints[11]);
        r13.setText(row_hints[12]);
        r14.setText(row_hints[13]);
        r15.setText(row_hints[14]);

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
        c11 = findViewById(R.id.c11_hints);
        c12 = findViewById(R.id.c12_hints);
        c13 = findViewById(R.id.c13_hints);
        c14 = findViewById(R.id.c14_hints);
        c15 = findViewById(R.id.c15_hints);

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
        c11.setText(col_hints[10]);
        c12.setText(col_hints[11]);
        c13.setText(col_hints[12]);
        c14.setText(col_hints[13]);
        c15.setText(col_hints[14]);

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
        grid[10] = findViewById(R.id.r1c11);
        grid[11] = findViewById(R.id.r1c12);
        grid[12] = findViewById(R.id.r1c13);
        grid[13] = findViewById(R.id.r1c14);
        grid[14] = findViewById(R.id.r1c15);

        grid[15] = findViewById(R.id.r2c1);
        grid[16] = findViewById(R.id.r2c2);
        grid[17] = findViewById(R.id.r2c3);
        grid[18] = findViewById(R.id.r2c4);
        grid[19] = findViewById(R.id.r2c5);
        grid[20] = findViewById(R.id.r2c6);
        grid[21] = findViewById(R.id.r2c7);
        grid[22] = findViewById(R.id.r2c8);
        grid[23] = findViewById(R.id.r2c9);
        grid[24] = findViewById(R.id.r2c10);
        grid[25] = findViewById(R.id.r2c11);
        grid[26] = findViewById(R.id.r2c12);
        grid[27] = findViewById(R.id.r2c13);
        grid[28] = findViewById(R.id.r2c14);
        grid[29] = findViewById(R.id.r2c15);

        grid[30] = findViewById(R.id.r3c1);
        grid[31] = findViewById(R.id.r3c2);
        grid[32] = findViewById(R.id.r3c3);
        grid[33] = findViewById(R.id.r3c4);
        grid[34] = findViewById(R.id.r3c5);
        grid[35] = findViewById(R.id.r3c6);
        grid[36] = findViewById(R.id.r3c7);
        grid[37] = findViewById(R.id.r3c8);
        grid[38] = findViewById(R.id.r3c9);
        grid[39] = findViewById(R.id.r3c10);
        grid[40] = findViewById(R.id.r3c11);
        grid[41] = findViewById(R.id.r3c12);
        grid[42] = findViewById(R.id.r3c13);
        grid[43] = findViewById(R.id.r3c14);
        grid[44] = findViewById(R.id.r3c15);

        grid[45] = findViewById(R.id.r4c1);
        grid[46] = findViewById(R.id.r4c2);
        grid[47] = findViewById(R.id.r4c3);
        grid[48] = findViewById(R.id.r4c4);
        grid[49] = findViewById(R.id.r4c5);
        grid[50] = findViewById(R.id.r4c6);
        grid[51] = findViewById(R.id.r4c7);
        grid[52] = findViewById(R.id.r4c8);
        grid[53] = findViewById(R.id.r4c9);
        grid[54] = findViewById(R.id.r4c10);
        grid[55] = findViewById(R.id.r4c11);
        grid[56] = findViewById(R.id.r4c12);
        grid[57] = findViewById(R.id.r4c13);
        grid[58] = findViewById(R.id.r4c14);
        grid[59] = findViewById(R.id.r4c15);

        grid[60] = findViewById(R.id.r5c1);
        grid[61] = findViewById(R.id.r5c2);
        grid[62] = findViewById(R.id.r5c3);
        grid[63] = findViewById(R.id.r5c4);
        grid[64] = findViewById(R.id.r5c5);
        grid[65] = findViewById(R.id.r5c6);
        grid[66] = findViewById(R.id.r5c7);
        grid[67] = findViewById(R.id.r5c8);
        grid[68] = findViewById(R.id.r5c9);
        grid[69] = findViewById(R.id.r5c10);
        grid[70] = findViewById(R.id.r5c11);
        grid[71] = findViewById(R.id.r5c12);
        grid[72] = findViewById(R.id.r5c13);
        grid[73] = findViewById(R.id.r5c14);
        grid[74] = findViewById(R.id.r5c15);

        grid[75] = findViewById(R.id.r6c1);
        grid[76] = findViewById(R.id.r6c2);
        grid[77] = findViewById(R.id.r6c3);
        grid[78] = findViewById(R.id.r6c4);
        grid[79] = findViewById(R.id.r6c5);
        grid[80] = findViewById(R.id.r6c6);
        grid[81] = findViewById(R.id.r6c7);
        grid[82] = findViewById(R.id.r6c8);
        grid[83] = findViewById(R.id.r6c9);
        grid[84] = findViewById(R.id.r6c10);
        grid[85] =findViewById(R.id.r6c11);
        grid[86] = findViewById(R.id.r6c12);
        grid[87] = findViewById(R.id.r6c13);
        grid[88] = findViewById(R.id.r6c14);
        grid[89] = findViewById(R.id.r6c15);

        grid[90] = findViewById(R.id.r7c1);
        grid[91] = findViewById(R.id.r7c2);
        grid[92] = findViewById(R.id.r7c3);
        grid[93] = findViewById(R.id.r7c4);
        grid[94] = findViewById(R.id.r7c5);
        grid[95] = findViewById(R.id.r7c6);
        grid[96] = findViewById(R.id.r7c7);
        grid[97] = findViewById(R.id.r7c8);
        grid[98] = findViewById(R.id.r7c9);
        grid[99] = findViewById(R.id.r7c10);
        grid[100] = findViewById(R.id.r7c11);
        grid[101] = findViewById(R.id.r7c12);
        grid[102] = findViewById(R.id.r7c13);
        grid[103] = findViewById(R.id.r7c14);
        grid[104] = findViewById(R.id.r7c15);

        grid[105] = findViewById(R.id.r8c1);
        grid[106] = findViewById(R.id.r8c2);
        grid[107] = findViewById(R.id.r8c3);
        grid[108] = findViewById(R.id.r8c4);
        grid[109] = findViewById(R.id.r8c5);
        grid[110] = findViewById(R.id.r8c6);
        grid[111] = findViewById(R.id.r8c7);
        grid[112] = findViewById(R.id.r8c8);
        grid[113] = findViewById(R.id.r8c9);
        grid[114] = findViewById(R.id.r8c10);
        grid[115] = findViewById(R.id.r8c11);
        grid[116] = findViewById(R.id.r8c12);
        grid[117] = findViewById(R.id.r8c13);
        grid[118] = findViewById(R.id.r8c14);
        grid[119] = findViewById(R.id.r8c15);

        grid[120] = findViewById(R.id.r9c1);
        grid[121] = findViewById(R.id.r9c2);
        grid[122] = findViewById(R.id.r9c3);
        grid[123] = findViewById(R.id.r9c4);
        grid[124] = findViewById(R.id.r9c5);
        grid[125] = findViewById(R.id.r9c6);
        grid[126] = findViewById(R.id.r9c7);
        grid[127] = findViewById(R.id.r9c8);
        grid[128] = findViewById(R.id.r9c9);
        grid[129] = findViewById(R.id.r9c10);
        grid[130] = findViewById(R.id.r9c11);
        grid[131] = findViewById(R.id.r9c12);
        grid[132] = findViewById(R.id.r9c13);
        grid[133] = findViewById(R.id.r9c14);
        grid[134] = findViewById(R.id.r9c15);

        grid[135] = findViewById(R.id.r10c1);
        grid[136] = findViewById(R.id.r10c2);
        grid[137] = findViewById(R.id.r10c3);
        grid[138] = findViewById(R.id.r10c4);
        grid[139] = findViewById(R.id.r10c5);
        grid[140] = findViewById(R.id.r10c6);
        grid[141] = findViewById(R.id.r10c7);
        grid[142] = findViewById(R.id.r10c8);
        grid[143] = findViewById(R.id.r10c9);
        grid[144] = findViewById(R.id.r10c10);
        grid[145] = findViewById(R.id.r10c11);
        grid[146] = findViewById(R.id.r10c12);
        grid[147] = findViewById(R.id.r10c13);
        grid[148] = findViewById(R.id.r10c14);
        grid[149] = findViewById(R.id.r10c15);

        grid[150] = findViewById(R.id.r11c1);
        grid[151] = findViewById(R.id.r11c2);
        grid[152] = findViewById(R.id.r11c3);
        grid[153] = findViewById(R.id.r11c4);
        grid[154] = findViewById(R.id.r11c5);
        grid[155] = findViewById(R.id.r11c6);
        grid[156] = findViewById(R.id.r11c7);
        grid[157] = findViewById(R.id.r11c8);
        grid[158] = findViewById(R.id.r11c9);
        grid[159] = findViewById(R.id.r11c10);
        grid[160] = findViewById(R.id.r11c11);
        grid[161] = findViewById(R.id.r11c12);
        grid[162] = findViewById(R.id.r11c13);
        grid[163] = findViewById(R.id.r11c14);
        grid[164] = findViewById(R.id.r11c15);

        grid[165] = findViewById(R.id.r12c1);
        grid[166] = findViewById(R.id.r12c2);
        grid[167] = findViewById(R.id.r12c3);
        grid[168] = findViewById(R.id.r12c4);
        grid[169] = findViewById(R.id.r12c5);
        grid[170] = findViewById(R.id.r12c6);
        grid[171] = findViewById(R.id.r12c7);
        grid[172] = findViewById(R.id.r12c8);
        grid[173] = findViewById(R.id.r12c9);
        grid[174] = findViewById(R.id.r12c10);
        grid[175] = findViewById(R.id.r12c11);
        grid[176] = findViewById(R.id.r12c12);
        grid[177] = findViewById(R.id.r12c13);
        grid[178] = findViewById(R.id.r12c14);
        grid[179] = findViewById(R.id.r12c15);

        grid[180] = findViewById(R.id.r13c1);
        grid[181] = findViewById(R.id.r13c2);
        grid[182] = findViewById(R.id.r13c3);
        grid[183] = findViewById(R.id.r13c4);
        grid[184] = findViewById(R.id.r13c5);
        grid[185] = findViewById(R.id.r13c6);
        grid[186] = findViewById(R.id.r13c7);
        grid[187] = findViewById(R.id.r13c8);
        grid[188] = findViewById(R.id.r13c9);
        grid[189] = findViewById(R.id.r13c10);
        grid[190] = findViewById(R.id.r13c11);
        grid[191] = findViewById(R.id.r13c12);
        grid[192] = findViewById(R.id.r13c13);
        grid[193] = findViewById(R.id.r13c14);
        grid[194] = findViewById(R.id.r13c15);

        grid[195] = findViewById(R.id.r14c1);
        grid[196] = findViewById(R.id.r14c2);
        grid[197] = findViewById(R.id.r14c3);
        grid[198] = findViewById(R.id.r14c4);
        grid[199] = findViewById(R.id.r14c5);
        grid[200] = findViewById(R.id.r14c6);
        grid[201] = findViewById(R.id.r14c7);
        grid[202] = findViewById(R.id.r14c8);
        grid[203] = findViewById(R.id.r14c9);
        grid[204] = findViewById(R.id.r14c10);
        grid[205] = findViewById(R.id.r14c11);
        grid[206] = findViewById(R.id.r14c12);
        grid[207] = findViewById(R.id.r14c13);
        grid[208] = findViewById(R.id.r14c14);
        grid[209] = findViewById(R.id.r14c15);

        grid[210] = findViewById(R.id.r15c1);
        grid[211] = findViewById(R.id.r15c2);
        grid[212] = findViewById(R.id.r15c3);
        grid[213] = findViewById(R.id.r15c4);
        grid[214] = findViewById(R.id.r15c5);
        grid[215] = findViewById(R.id.r15c6);
        grid[216] = findViewById(R.id.r15c7);
        grid[217] = findViewById(R.id.r15c8);
        grid[218] = findViewById(R.id.r15c9);
        grid[219] = findViewById(R.id.r15c10);
        grid[220] = findViewById(R.id.r15c11);
        grid[221] = findViewById(R.id.r15c12);
        grid[222] = findViewById(R.id.r15c13);
        grid[223] = findViewById(R.id.r15c14);
        grid[224] = findViewById(R.id.r15c15);


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

    private void goToHardLibrary()
    {
        startActivity(new Intent(this, HardLibraryActivity.class));
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
                this.row_hints = res.getStringArray(R.array.hard_puzzle_1_row);
                this.col_hints = res.getStringArray(R.array.hard_puzzle_1_col);
                this.solution = res.getIntArray(R.array.hard_puzzle_1);
                break;
            case 2:
                this.row_hints = res.getStringArray(R.array.hard_puzzle_2_row);
                this.col_hints = res.getStringArray(R.array.hard_puzzle_2_col);
                this.solution = res.getIntArray(R.array.hard_puzzle_2);
                break;
            case 3:
                this.row_hints = res.getStringArray(R.array.hard_puzzle_3_row);
                this.col_hints = res.getStringArray(R.array.hard_puzzle_3_col);
                this.solution = res.getIntArray(R.array.hard_puzzle_3);
                break;
            case 4:
                this.row_hints = res.getStringArray(R.array.hard_puzzle_4_row);
                this.col_hints = res.getStringArray(R.array.hard_puzzle_4_col);
                this.solution = res.getIntArray(R.array.hard_puzzle_4);
                break;
        }
    }

    private void showPopupWindow()
    {
        ConstraintLayout hardLayout = (ConstraintLayout) findViewById(R.id.activity_hard_level);

        LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = li.inflate(R.layout.activity_solved_popup_window, null);

        // creating actual popup window
        int width = 1000;
        int height = 500;
//        boolean dismiss = true;
        final PopupWindow popupWindow = new PopupWindow(popupView, width, height, false);

        // display popup
        popupWindow.showAtLocation(hardLayout, Gravity.CENTER, 0, 0);

        levelSelection = popupView.findViewById(R.id.levelSelectionSPW);
        mainMenu = popupView.findViewById(R.id.mainMenuButtonSPW);

        levelSelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HardLevelActivity.this, LevelSelection.class);
                HardLevelActivity.this.startActivity(intent);
            }
        });
        mainMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(HardLevelActivity.this, MainMenuActivity.class);
                HardLevelActivity.this.startActivity(intent);
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

