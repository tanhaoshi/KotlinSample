package com.qzy.kotlinsample.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.qzy.kotlinsample.R;
import com.socks.library.KLog;


/**
 * @author tanhaoshi
 * @time   7/8 2019
 */
public class RoundRectView extends View {

    private static final int DEFAULT_WIDTH  = 200;
    private static final int DEFAULT_HEIGHT = 100;

    /** The fixed number */
    private static final int DEFAULT_NUMBER = 11;

    private int width;
    private int height;

    private int number = 0;

    private final Paint innerPaint = new Paint();

    public RoundRectView(Context context) {
        super(context);
    }

    public RoundRectView(Context context, AttributeSet attrs) {
        super(context, attrs);

        innerPaint.setColor(getContext().getResources().getColor(R.color.colorAccent));
        innerPaint.setStyle(Paint.Style.STROKE);
        innerPaint.setStrokeWidth(5);
        innerPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = translateViewSize(DEFAULT_WIDTH,widthMeasureSpec);
        height = translateViewSize(DEFAULT_HEIGHT,heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    private int translateViewSize(int defaultSize,int measureSpec){
        int initializeSize = DEFAULT_WIDTH;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode){
            /**
             * The parent has not imposed any constraint
             * on the child. It can be whatever size it wants.
             * 如果没有指定大小 就设置为默认大小
             */
            case MeasureSpec.UNSPECIFIED:
                initializeSize = defaultSize;
                break;
            /**
             *  The child can be as large as it wants up
             *  to the specified size.
             *  如果测量模式是取最大值为size
             */
            case MeasureSpec.AT_MOST:
                initializeSize = size;
                break;
            /**
             * The parent has determined an exact size for the child.
             * The child is going to be given those bounds regardless of how
             * big it wants to be.
             * 如果是固定的大小 就不用去改变它的大小
             */
            case MeasureSpec.EXACTLY:
                initializeSize = size;
                break;
        }

        return initializeSize;
    }

    /**
     *    left     right          X
     *  -------------------------->
     *  ：top
     *  ： ---------—
     *  ： ：        ：
     *  ： ：------- ：
     *  ： ：        ：
     *  ： ：        ：
     *  ： ：        ：
     *  ： ：        ：
     *  ： - --------- bottom
     *  ：
     *  ：
     *  Y
     *
     */

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        curveOriginal(canvas);
    }

    private void curveOriginal(Canvas canvas){
        if(number == 0){
            drawingStroke(canvas,DEFAULT_NUMBER, Paint.Style.STROKE);
        }else {
            int drawFillNumber = DEFAULT_NUMBER - number;

            try{

                drawingStroke(canvas,drawFillNumber,Paint.Style.STROKE);

            }finally {

                drawingFill(canvas,number,Paint.Style.FILL);

            }
        }
    }

    private void drawingStroke(Canvas canvas,int number,Paint.Style style) {
        innerPaint.setStyle(style);

        int fixedHeight = 20;
        int rectHeight = 0;
        int specHeight = 50;

        for (int i = 0; i < number; i++) {
            RectF rectF = new RectF(fixedHeight, fixedHeight + rectHeight, width - 19, specHeight);
            canvas.drawRoundRect(rectF, 18, 18, innerPaint);

            specHeight += 50;
            rectHeight += 50;
        }
    }

    private void drawingFill(Canvas canvas,int number,Paint.Style style){
        innerPaint.setStyle(style);

        int fixedHeight = 20;
        int rectHeight = 50 * (DEFAULT_NUMBER - number) ;
        int specHeight = 50 * (DEFAULT_NUMBER - number + 1);

        for (int i = 0; i < number; i++) {
            RectF rectF = new RectF(fixedHeight, fixedHeight + rectHeight, width - 19, specHeight);
            canvas.drawRoundRect(rectF, 18, 18, innerPaint);

            specHeight += 50;
            rectHeight += 50;
        }
    }

    public void postInvalidate(int number){
        this.number = number;
        postInvalidate();
    }
}
