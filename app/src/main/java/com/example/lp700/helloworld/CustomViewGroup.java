package com.example.lp700.helloworld;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.FrameLayout;

/**
 * Created by lp700 on 1/9/2559.
 */
public class CustomViewGroup extends FrameLayout {

    private Button btnHello;

    public CustomViewGroup(Context context) {
        super(context);
        initInflate();
        initInstances();
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
        initInstances();
        initWithAttrs(attrs, 0, 0);
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, 0);
    }

    @TargetApi(21)
    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
        initInstances();
        initWithAttrs(attrs, defStyleAttr, defStyleRes);
    }

    private void initInflate(){
        // Inflate Layout Here
        inflate(getContext(), R.layout.sample_layout, this);
    }

    private void initInstances(){
        // findViewById Here
        btnHello = (Button) findViewById(R.id.btnCustomViewGroupHello);
    }

    public void setButtonText(String text){
        btnHello.setText(text);
    }

    private void initWithAttrs(AttributeSet attrs, int defStyleAttr, int defStyleRes){
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs,
                R.styleable.CustomView,
                defStyleAttr, defStyleRes);

        try {
            setButtonText(a.getString(R.styleable.CustomView_text));
        }finally {
            a.recycle();
        }
    }
}
