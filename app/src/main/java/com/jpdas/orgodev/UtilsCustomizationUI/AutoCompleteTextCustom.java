package com.jpdas.orgodev.UtilsCustomizationUI;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class AutoCompleteTextCustom extends AutoCompleteTextView {
    public AutoCompleteTextCustom(Context context) {
        super(context);
        init();
    }

    public AutoCompleteTextCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AutoCompleteTextCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Bold.ttf");
            setTypeface(tf);
        }
    }
}
