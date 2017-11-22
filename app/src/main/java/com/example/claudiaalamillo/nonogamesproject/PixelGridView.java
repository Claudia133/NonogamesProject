package com.example.claudiaalamillo.nonogamesproject;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.ScriptGroup;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Rect;
import android.util.Log;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by joaoaguilera on 11/7/17.
 */

public class PixelGridView extends View {
    private int numColumns, numRows;
    private int cellWidth, cellHeight;
    private Paint blackPaint = new Paint();
    private Paint bluePaint = new Paint();
    private boolean[][] cellChecked;
    private boolean[][] selectableGrid;
    private String [][] content = new String[numRows][numColumns];



    public PixelGridView(Context context) {
        this(context, null);
    }

    public PixelGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        blackPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        bluePaint.setStyle((Paint.Style.FILL_AND_STROKE));
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

        if (numColumns == 0 || numRows == 0) {
            return;
        }

        int width = getWidth();
        int height = getHeight();

        //draws black selection


        InputStream ls = this.getResources().openRawResource(R.raw.p1);
        String[] g = getGridData(ls);

        for (int i = 0; i < numColumns; i++) {

            Rect r = new Rect();


            for (int j = 0; j < numRows; j++) {
                // if (cellChecked[i][j]) {

                //String t = g[j];
                float left = i * cellWidth;
                float top = j * cellHeight;
                float right = (i + 1) * cellWidth;
                float bottom = (j + 1) * cellHeight;

                r = new Rect((int)left,(int) top, (int)right,(int) bottom);

                bluePaint.setColor((Color.BLUE));
                bluePaint.setTextSize((80));

                String x = g[j].charAt(i) + "";

                String t = g[j];

                /*canvas.drawRect(left, top,
                        right, bottom,
                        blackPaint);*/

                if (x.equals("-")) {

                    canvas.drawText("", r.centerX() - 20, r.centerY() + 25, bluePaint);
                } else {

                    canvas.drawText(x, r.centerX() - 20, r.centerY() + 25, bluePaint);
                }




            }





        }


        //draws vertical line

        for (int i = 1; i < numColumns; i++) {
            canvas.drawLine(i * cellWidth, 0, i * cellWidth, height, blackPaint);
        }

        //draws horizontal line

        for (int i = 1; i < numRows; i++) {
            canvas.drawLine(0, i * cellHeight, width, i * cellHeight, blackPaint);
        }

        //InputStream ls = this.getResources().openRawResource(R.raw.p1);

        //String[] g = getGridData(ls);
        //Log.d("Grid", Arrays.toString(g));
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

    private String readData(InputStream ls){

        String data = "";
        StringBuffer buffer = new StringBuffer();

        BufferedReader reader = new BufferedReader(new InputStreamReader(ls));

        if (ls != null){
            try {

                while ((data = reader.readLine())!= null){
                    buffer.append(data + "\n");
                }

                ls.close();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

        return buffer.toString();
    }

    private String[] getGridData(InputStream ls){

       // InputStream ls = this.getResources().openRawResource(R.raw.p1);
        String g = readData(ls);

        String lines[] = g.split("\\r?\\n");
        String[] l = new String [lines.length];
        for (int i = 0; i < lines.length; i++){

                String t = lines[i].replaceAll("\\s+","");
                l[i] = t;


        }

        return l;

    }




}