package com.qzy.spinning.layout.tablelayout;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


/**
 * @author qzy009
 * create on 7/18/2019
 */
public class TableView extends View{

    private static final int DEFAULT_WIDTH  = 400;
    private static final int DEFAULT_HEIGHT = 300;

    private int width;
    private int height;

    public TableView(Context context) {
        super(context);
        init();
    }

    public TableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width  = translateViewSize(DEFAULT_WIDTH,widthMeasureSpec);
        height = translateViewSize(DEFAULT_HEIGHT,heightMeasureSpec);

        setMeasuredDimension(width,height);
    }

    private int translateViewSize(int defaultSize,int measureSpec){
        int initializeSize = defaultSize;
        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode){
            case MeasureSpec.UNSPECIFIED:
                initializeSize = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                initializeSize = size;
                break;
            case MeasureSpec.EXACTLY:
                initializeSize = size;
                break;
        }
        return initializeSize;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }


}
