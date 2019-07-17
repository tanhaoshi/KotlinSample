package com.qzy.spinning.layout;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.qzy.spinning.R;


public class GripProgressView extends View {

    private int mPower = 100;
    private int orientation;
    private int width;
    private int height;
    private int mColor;

    private final Paint paint = new Paint();

    public GripProgressView(Context context) {
        super(context);
    }

    public GripProgressView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.Battery);
        mColor = typedArray.getColor(R.styleable.Battery_batteryColor, 0xFFFFFFFF);
        orientation = typedArray.getInt(R.styleable.Battery_batteryOrientation, 0);
        mPower = typedArray.getInt(R.styleable.Battery_batteryPower, 100);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        /**
         * recycle() :官方的解释是：回收TypedArray，以便后面重用。在调用这个函数后，你就不能再使用这个TypedArray。
         * 在TypedArray后调用recycle主要是为了缓存。当recycle被调用后，这就说明这个对象从现在可以被重用了。
         *TypedArray 内部持有部分数组，它们缓存在Resources类中的静态字段中，这样就不用每次使用前都需要分配内存。
         */
        typedArray.recycle();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (orientation == 0) {
            drawHorizontalBattery(canvas);
        } else {
            drawVerticalBattery(canvas);
        }
    }

    private void drawHorizontalBattery(Canvas canvas) {
        paint.setColor(mColor);
        paint.setAntiAlias(true);
        paint.setShader(null);

        float strokeWidth = width / 20.f;
        float strokeWidth_2 = strokeWidth / 2;

        RectF r1 = new RectF(strokeWidth_2, strokeWidth_2, width - strokeWidth - strokeWidth_2, height - strokeWidth_2);
        canvas.drawRoundRect(r1,12,12, paint);

        float offset = (width - strokeWidth * 2) * mPower / 100.f;

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(getContext().getColor(R.color.grip_start));
        LinearGradient linearGradient = new LinearGradient(strokeWidth_2, strokeWidth_2, offset, height - strokeWidth_2,
                getContext().getColor(R.color.grip_start),
                getContext().getColor(R.color.grip_end), Shader.TileMode.MIRROR);

        paint.setShader(linearGradient);

        RectF r2 = new RectF(strokeWidth_2, strokeWidth_2, offset, height - strokeWidth_2);
        canvas.drawRoundRect(r2,12,12, paint);
    }


    private void drawVerticalBattery(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(mColor);
        paint.setStyle(Paint.Style.STROKE);

        float strokeWidth = height / 20.0f;
        float strokeWidth2 = strokeWidth / 2;

        paint.setStrokeWidth(strokeWidth);

        int headHeight = (int) (strokeWidth + 0.5f);

        RectF rect = new RectF(strokeWidth2, headHeight + strokeWidth2, width - strokeWidth2, height - strokeWidth2);
        canvas.drawRect(rect, paint);
        paint.setStrokeWidth(0);

        float topOffset = (height - headHeight - strokeWidth) * (100 - mPower) / 100.0f;

        RectF rect2 = new RectF(strokeWidth, headHeight + strokeWidth + topOffset, width - strokeWidth, height - strokeWidth);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(rect2, paint);

        RectF headRect = new RectF(width / 4.0f, 0, width * 0.75f, headHeight);
        canvas.drawRect(headRect, paint);
    }

    public void setPower(int power) {
        this.mPower = power;
        if (mPower < 0) {
            mPower = 100;
        }
        invalidate();
    }

    public void setColor(int color) {
        this.mColor = color;
        invalidate();
    }

    public int getPower() {
        return mPower;
    }
}


