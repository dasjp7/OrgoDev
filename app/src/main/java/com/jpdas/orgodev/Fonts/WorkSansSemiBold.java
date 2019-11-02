package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WorkSansSemiBold  extends android.support.v7.widget.AppCompatTextView
{
    public WorkSansSemiBold(Context context) {
        super(context);
        init();
    }

    public WorkSansSemiBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSansSemiBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-SemiBold.ttf");
        setTypeface(tf ,1);

    }
}
