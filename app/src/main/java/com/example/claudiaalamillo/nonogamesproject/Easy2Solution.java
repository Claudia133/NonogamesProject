package com.example.claudiaalamillo.nonogamesproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by claudiaalamillo on 11/8/17.
 */

class Easy2Solution {
    List<List<Integer>> rowHints = new ArrayList<List<Integer>>();
    List<List<Integer>> columnHints = new ArrayList<List<Integer>>(5);
    int [][] solution = new int[5][5];

    private void setRowHints()
    {
        for( int i = 0; i < 5; i++){
            rowHints.add( new ArrayList<Integer>());
        }

        rowHints.get(0).add(5);

        rowHints.get(1).add(1);
        rowHints.get(1).add(1);
        rowHints.get(1).add(1);

        rowHints.get(2).add(5);

        rowHints.get(3).add(1);
        rowHints.get(3).add(1);

        rowHints.get(4).add(3);
    }

    private void setColumnHints()
    {
        for( int i = 0; i < 5; i++){
            columnHints.add( new ArrayList<Integer>());
        }

        columnHints.get(0).add(3);

        columnHints.get(1).add(1);
        columnHints.get(1).add(3);

        columnHints.get(2).add(3);
        columnHints.get(2).add(1);

        columnHints.get(3).add(1);
        columnHints.get(3).add(3);

        columnHints.get(4).add(3);
    }

    private void setSolution()
    {
        solution[0][0] = 1;
        solution[0][1] = 1;
        solution[0][2] = 1;
        solution[0][3] = 1;
        solution[0][4] = 1;

        solution[1][0] = 1;
        solution[1][2] = 1;
        solution[1][4] = 1;

        solution[2][0] = 1;
        solution[2][1] = 1;
        solution[2][2] = 1;
        solution[2][3] = 1;
        solution[2][4] = 1;

        solution[3][1] = 1;
        solution[3][3] = 1;

        solution[4][1] = 1;
        solution[4][2] = 1;
        solution[4][3] = 1;
    }
}
