package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WorkSansLight extends android.support.v7.widget.AppCompatTextView
{
    public WorkSansLight(Context context) {
        super(context);
        init();
    }

    public WorkSansLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSansLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Light.ttf");
        setTypeface(tf ,1);

    }
}
