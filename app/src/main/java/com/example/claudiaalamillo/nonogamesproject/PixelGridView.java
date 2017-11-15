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
        int[] testEasy0 = getResources().getIntArray(R.array.row0);
        int[] testEasy1 = getResources().getIntArray(R.array.row1);
        int[] testEasy2 = getResources().getIntArray(R.array.row2);
        int[] testEasy3 = getResources().getIntArray(R.array.row3);
        int[] testEasy4 = getResources().getIntArray(R.array.row4);

        String easy0 = Arrays.toString(testEasy0);
        String easy1 = Arrays.toString(testEasy1);
        String easy2 = Arrays.toString(testEasy2);
        String easy3 = Arrays.toString(testEasy3);
        String easy4 = Arrays.toString(testEasy4);



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
                blackPaint.setTextSize(65);


                canvas.drawText(easy0, 10, 400, blackPaint);
                canvas.drawText(easy1, 10, 700, blackPaint);
                canvas.drawText(easy2, 10, 1000, blackPaint);
                canvas.drawText(easy3, 10, 1300, blackPaint);
                canvas.drawText(easy4, 10, 1600, blackPaint);
            }





        }

//        int[] testEasy1 = getResources().getIntArray();

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
}