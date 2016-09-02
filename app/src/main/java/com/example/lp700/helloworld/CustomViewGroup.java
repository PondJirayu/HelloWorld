package com.example.lp700.helloworld;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by lp700 on 2/9/2559.
 */
public class CustomViewGroup extends FrameLayout {
    public CustomViewGroup(Context context) {
        super(context);
        initInflate();
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initInflate();
    }

    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initInflate();
    }

    @TargetApi(21)
    public CustomViewGroup(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initInflate();
    }

    // Inflate Layout Here
    private void initInflate(){
        inflate(getContext(),R.layout.sample_layout, this);
    }
}
