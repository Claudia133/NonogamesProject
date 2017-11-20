package com.example.claudiaalamillo.nonogamesproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.*;

/**
 * Created by joaoaguilera on 11/7/17.
 */

public class PixelGridView extends View {
    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint blackPaint = new Paint();
    private Paint redPaint = new Paint();
    private boolean[][] cellChecked;

    public PixelGridView(Context context) {
        this(context, null);
    }

    public PixelGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    public void setNumColumns(int numColumns) {
        this.numColumns = numColumns;
        calculateDimensions();
    }

    public int getNumColumns() {
        return numColumns;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
        calculateDimensions();
    }

    public int getNumRows() {
        return numRows;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        calculateDimensions();
    }

    private void calculateDimensions() {
        if (numColumns < 1 || numRows < 1) {
            return;
        }

        cellWidth = getWidth() / numColumns;
        cellHeight = getHeight() / numRows;

        cellChecked = new boolean[numColumns][numRows];

        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.WHITE);
        int[] testRowEasy0 = getResources().getIntArray(R.array.row0);
        int[] testRowEasy1 = getResources().getIntArray(R.array.row1);
        int[] testRowEasy2 = getResources().getIntArray(R.array.row2);
        int[] testRowEasy3 = getResources().getIntArray(R.array.row3);
        int[] testRowEasy4 = getResources().getIntArray(R.array.row4);

        int[] colEasy0 = getResources().getIntArray(R.array.col0);
        int[] colEasy1 = getResources().getIntArray(R.array.col1);
        int[] colEasy2 = getResources().getIntArray(R.array.col2);
        int[] colEasy3 = getResources().getIntArray(R.array.col3);
        int[] colEasy4 = getResources().getIntArray(R.array.col4);


        String easyRow0 = Arrays.toString(testRowEasy0);
        String easyRow1 = Arrays.toString(testRowEasy1);
        String easyRow2 = Arrays.toString(testRowEasy2);
        String easyRow3 = Arrays.toString(testRowEasy3);
        String easyRow4 = Arrays.toString(testRowEasy4);

        String easyCol0 = Arrays.toString(colEasy0);
        String easyCol1 = Arrays.toString(colEasy1);
        String easyCol2 = Arrays.toString(colEasy2);
        String easyCol3 = Arrays.toString(colEasy3);
        String easyCol4 = Arrays.toString(colEasy4);

        redPaint.setColor(Color.RED);

        if (numColumns == 0 || numRows == 0) {
            return;
        }

        int width = getWidth();
        int height = getHeight();

        for (int i = 0; i < numColumns; i++) {
            for (int j = 0; j < numRows; j++) {
                if (cellChecked[i][j]) {


                    float left = i * cellWidth;
                    float top = j * cellHeight;
                    float right = (i + 1) * cellWidth;
                    float bottom = (j + 1) * cellHeight;

                    float x1 = (left + right)/ 2;
                    float y1 = (top + bottom) /2;

                    canvas.drawRect(left, top,
                            right, bottom,
                            blackPaint);
                }

                blackPaint.setColor(Color.BLACK);
                blackPaint.setTextSize(50);


                canvas.drawText(easyRow0, 15, 400, blackPaint);
                canvas.drawText(easyRow1, 15, 650, blackPaint);
                canvas.drawText(easyRow2, 15, 900, blackPaint);
                canvas.drawText(easyRow3, 15, 1150, blackPaint);
                canvas.drawText(easyRow4, 15, 1350, blackPaint);

                canvas.drawText(easyCol0, 250, 50, blackPaint);
                canvas.drawText(easyCol1, 400, 50, blackPaint);
                canvas.drawText(easyCol2, 580, 50, blackPaint);
                canvas.drawText(easyCol3, 800, 50, blackPaint);
                canvas.drawText(easyCol4, 1000, 50, blackPaint);

            }





        }


        for (int i = 1; i < numColumns; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, height, blackPaint);
        }

        for (int i = 1; i < numRows; i++) {
            canvas.drawLine(0, i * cellHeight, width, i * cellHeight, blackPaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            int column = (int)(event.getX() / cellWidth);
            int row = (int)(event.getY() / cellHeight);

            cellChecked[column][row] = !cellChecked[column][row];
            invalidate();
        }

        return true;
    }

    public boolean isSolution(MotionEvent event)
    {
        // check if each square is checked and compare to the hints using cellChecked boolean 2D array

        Easy1Solution easysol = new Easy1Solution();

        int [][] easySol = easysol.solution;
        for (int row = 0; row < numRows; row++)
        {
            for (int col = 0; col < numColumns; col++)
            {
                if ((easySol[row][col] != 1) && (cellChecked[row][col] == false))
                {
                    return false;
                }
            }
        }

        return true;
    }
}