package com.qzy.kotlinsample.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.qzy.kotlinsample.R;
import com.qzy.kotlinsample.mvp.datamodel.ScaleProgress;
import com.socks.library.KLog;

import java.util.List;

/**
 * @author tanhaoshi
 * @time   7/10 2019
 */
public class ProgressBar extends View{

    private static final int DEFAULT_WIDTH  = 300;
    private static final int DEFAULT_HEIGHT = 18;

    private int width;
    private int height;

    public ProgressBar(Context context) {
        super(context);
    }

    public ProgressBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = translateViewSize(DEFAULT_WIDTH,widthMeasureSpec);
        height = translateViewSize(DEFAULT_HEIGHT,heightMeasureSpec);
        setMeasuredDimension(width,height);
    }

    private int translateViewSize(int defaultSize , int measureSpec){
        int initializeWidth  = DEFAULT_WIDTH;

        int mode = MeasureSpec.getMode(measureSpec);
        int size = MeasureSpec.getSize(measureSpec);

        switch (mode){
            case MeasureSpec.UNSPECIFIED:
                initializeWidth = defaultSize;
                break;
            case MeasureSpec.AT_MOST:
                initializeWidth = size;
                break;
            case MeasureSpec.EXACTLY:
                initializeWidth = size;
                break;
        }

        return initializeWidth;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        curveOriginal(canvas);
    }

    private final Paint mPaint = new Paint();
    private List<ScaleProgress> mProgressList;

    private void init(){
        mPaint.setAntiAlias(true);
        mPaint.setColor(getContext().getResources().getColor(R.color.grayColor));
        mPaint.setStrokeWidth(5);
    }

    public void postInvalidateAction(List<ScaleProgress> data){
        this.mProgressList = data;
        postInvalidate();
    }

    private void curveOriginal(Canvas canvas){
        if(mProgressList == null) return;

        int size = mProgressList.size();

        float left = 0;
        float right = 0;

        for(int i=0; i<size; i++){

            float top = Float.valueOf((float) (height-height * mProgressList.get(i).getScaleTop()));

            float tempRight = Float.valueOf((float) (width * mProgressList.get(i).getScaleWidth()));

            RectF f = new RectF(left,top, right + tempRight , height);

            canvas.drawRect(f,mPaint);

            left  += (float) (width * mProgressList.get(i).getScaleWidth());

            right += tempRight;
        }
    }

}
