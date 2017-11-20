package com.example.claudiaalamillo.nonogamesproject;

import java.util.*;
import java.lang.Integer;

/**
 * Created by claudiaalamillo on 11/6/17.
 */

class Easy1Solution {
    List<List<Integer>> rowHints = new ArrayList<List<Integer>>();
    List<List<Integer>> columnHints = new ArrayList<List<Integer>>(5);
    int [][] solution = new int[5][5];



    private void setRowHints()
    {
        for( int i = 0; i < 5; i++){
            rowHints.add( new ArrayList<Integer>());
        }

        rowHints.get(0).add(2);
        rowHints.get(0).add(2);

        rowHints.get(1).add(1);
        rowHints.get(1).add(1);
        rowHints.get(1).add(1);

        rowHints.get(2).add(1);
        rowHints.get(2).add(1);

        rowHints.get(3).add(1);
        rowHints.get(3).add(1);

        rowHints.get(4).add(1);
    }

    private void setColumnHints()
    {
        for( int i = 0; i < 5; i++){
            columnHints.add( new ArrayList<Integer>());
        }

        columnHints.get(0).add(3);

        columnHints.get(1).add(1);
        columnHints.get(1).add(1);

        columnHints.get(2).add(1);
        columnHints.get(2).add(1);

        columnHints.get(3).add(1);
        columnHints.get(3).add(1);

        columnHints.get(4).add(3);
    }

    private void setSolution()
    {
        solution[0][0] = 1;
        solution[0][1] = 1;
        solution[0][3] = 1;
        solution[0][4] = 1;

        solution[1][0] = 1;
        solution[1][2] = 1;
        solution[1][4] = 1;

        solution[2][0] = 1;
        solution[2][4] = 1;

        solution[3][1] = 1;
        solution[3][3] = 1;

        solution[4][2] = 1;
    }

    private int[][] getSolution()
    {
        return solution;
    }
}

