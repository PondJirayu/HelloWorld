package com.example.lp700.helloworld;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lp700 on 1/9/2559.
 */
public class TextView2 extends View {

    private String text;
    private float textSize;

    public TextView2(Context context) {
        super(context);
        init();
    }

    public TextView2(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        initWithAttrs(attrs,0,0);
    }

    public TextView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
        initWithAttrs(attrs,defStyleAttr,0);
    }

    @TargetApi(21)
    public TextView2(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void init() {

    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomView,
                defStyleAttr, defStyleRes);
        try {
            text = a.getString(R.styleable.CustomView_text);
            textSize = a.getFloat(R.styleable.CustomView_textSize, 0);
        }finally {
            a.recycle();
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint p = new Paint();
        p.setColor(Color.BLACK);
        p.setTextSize(textSize);

        canvas.drawText(text, 0, 50, p);
    }
}
