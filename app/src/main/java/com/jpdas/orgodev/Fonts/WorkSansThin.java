package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WorkSansThin extends android.support.v7.widget.AppCompatTextView
{
    public WorkSansThin(Context context) {
        super(context);
        init();
    }

    public WorkSansThin(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSansThin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Thin.ttf");
        setTypeface(tf ,1);

    }
}
