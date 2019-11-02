package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WorkSansBold extends android.support.v7.widget.AppCompatTextView
{
    public WorkSansBold(Context context) {
        super(context);
        init();
    }

    public WorkSansBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSansBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Bold.ttf");
        setTypeface(tf ,1);

    }
}
