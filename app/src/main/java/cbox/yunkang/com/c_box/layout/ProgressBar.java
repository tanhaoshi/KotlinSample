package cbox.yunkang.com.c_box.layout;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import cbox.yunkang.com.c_box.R;
import cbox.yunkang.com.c_box.mvp.datamodel.ScaleProgress;

import java.util.List;

/**
 * @author tanhaoshi
 * @time   7/10 2019
 */
public class ProgressBar extends View{

    private static final int DEFAULT_WIDTH  = 300;
    private static final int DEFAULT_HEIGHT = 36;

    private int width;
    private int height;

    private int position = 0;

    private final Paint mPaint = new Paint();

    private List<ScaleProgress> mProgressList;

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
        try{
            curveOriginal(canvas);
        }finally {
            fillProgressBar(canvas,position);
        }
    }

    private void init(){
        mPaint.setAntiAlias(true);
        mPaint.setColor(getContext().getResources().getColor(R.color.grayColor));
        mPaint.setStrokeWidth(5);
    }

    public void postInvalidateAction(List<ScaleProgress> data){
        this.mProgressList = data;
        postInvalidate();
    }

    public void postDelayInvalidate(int position){
        this.position = position;
        postInvalidate();
    }

    private void curveOriginal(Canvas canvas){
        if(mProgressList == null) return;

        int size = mProgressList.size();

        mPaint.setColor(getContext().getResources().getColor(R.color.grayColor));

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

    private float right = 0;
    private float left  = 0;
    private float nextLeft = 0;

    private int   lastPosition = 0;

    public void fillProgressBar(Canvas canvas,int position){
        if(mProgressList == null) return;

        if(lastPosition != position){
            nextLeft += Float.valueOf((float) (width * mProgressList.get(lastPosition).getScaleWidth()));
            lastPosition = position;
        }

        float reLeft     = 0;
        float reRight    = 0;

        for(int i=0; i<position; i++){
            if(i == position) break;
            mPaint.setColor(mProgressList.get(i).getSignalColor());

            float top = Float.valueOf((float)(height-height * mProgressList.get(i).getScaleTop()));
            float tempRight = Float.valueOf((float) (width * mProgressList.get(i).getScaleWidth()));

            RectF f = new RectF(reLeft,top, tempRight+reRight , height);
            canvas.drawRect(f,mPaint);

            reLeft += (float) (width * mProgressList.get(i).getScaleWidth());
            reRight += tempRight;
        }

        mPaint.setColor(mProgressList.get(position).getSignalColor());
        mPaint.setStyle(Paint.Style.FILL);

        float tempRight = Float.valueOf((float) (width * mProgressList.get(position).getScaleWidth()))
                / (mProgressList.get(position).getSecond() / 2);
        float top  = Float.valueOf((float) (height-height * mProgressList.get(position).getScaleTop()));

        RectF rectF = new RectF(left+nextLeft,top,right+tempRight,height);
        canvas.drawRect(rectF,mPaint);

        right += tempRight;
    }

}
