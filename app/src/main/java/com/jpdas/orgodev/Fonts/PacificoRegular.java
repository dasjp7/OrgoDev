package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class PacificoRegular extends android.support.v7.widget.AppCompatTextView
{
    public PacificoRegular(Context context) {
        super(context);
        init();
    }

    public PacificoRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PacificoRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/Pacifico-Regular.ttf");
        setTypeface(tf ,1);

    }
}
