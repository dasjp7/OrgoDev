package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WorkSansExtraLight extends android.support.v7.widget.AppCompatTextView
{
    public WorkSansExtraLight(Context context) {
        super(context);
        init();
    }

    public WorkSansExtraLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSansExtraLight(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-ExtraLight.ttf");
        setTypeface(tf ,1);

    }
}
