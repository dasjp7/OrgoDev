package com.jpdas.orgodev.Fonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

public class WorkSansBlack extends android.support.v7.widget.AppCompatTextView
{
    public WorkSansBlack(Context context) {
        super(context);
        init();
    }

    public WorkSansBlack(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WorkSansBlack(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    public void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Black.ttf");
        setTypeface(tf ,1);

    }
}
