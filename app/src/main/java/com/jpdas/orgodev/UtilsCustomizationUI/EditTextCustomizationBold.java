package com.jpdas.orgodev.UtilsCustomizationUI;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

public class EditTextCustomizationBold extends EditText
{
    public EditTextCustomizationBold(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditTextCustomizationBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditTextCustomizationBold(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Bold.ttf");
            setTypeface(tf);
        }
    }
}
