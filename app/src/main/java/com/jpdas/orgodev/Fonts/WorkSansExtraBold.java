package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WorkSansExtraBold extends android.support.v7.widget.AppCompatTextView
{
    public WorkSansExtraBold(Context context) {
        super(context);
        init();
    }

    public WorkSansExtraBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSansExtraBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-ExtraBold.ttf");
        setTypeface(tf ,1);

    }
}
