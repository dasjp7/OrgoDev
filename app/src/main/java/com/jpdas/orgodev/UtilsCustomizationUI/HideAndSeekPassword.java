package com.jpdas.orgodev.UtilsCustomizationUI;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.ColorInt;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.view.MotionEvent;

import com.jpdas.orgodev.R;
import com.scottyab.showhidepasswordedittext.ShowHidePasswordEditText;

public class HideAndSeekPassword extends ShowHidePasswordEditText {
    private static final String TAG = ShowHidePasswordEditText.class.getSimpleName();
    private boolean isShowingPassword = false;
    private Drawable drawableEnd;
    private boolean leftToRight = true;
    private int tintColor = 0;
    private final int DEFAULT_ADDITIONAL_TOUCH_TARGET_SIZE = 40;
    @DrawableRes
    private int visibilityIndicatorShow;
    @DrawableRes
    private int visibilityIndicatorHide;
    private int additionalTouchTargetSize = 40;
    private static final String IS_SHOWING_PASSWORD_STATE_KEY = "IS_SHOWING_PASSWORD_STATE_KEY";
    private static final String SUPER_STATE_KEY = "SUPER_STATE_KEY";
    public HideAndSeekPassword(Context context) {
        super(context);
        init(null);
    }

    public HideAndSeekPassword(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    public HideAndSeekPassword(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }
    private void init(AttributeSet attrs) {
        if (attrs != null || !isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/WorkSans-Bold.ttf");
            setTypeface(tf);
            TypedArray attrsArray = this.getContext().obtainStyledAttributes(attrs, R.styleable.ShowHidePasswordEditText);
            this.visibilityIndicatorShow = attrsArray.getResourceId(R.styleable.ShowHidePasswordEditText_drawable_show, R.drawable.show);
            this.visibilityIndicatorHide = attrsArray.getResourceId(R.styleable.ShowHidePasswordEditText_drawable_hide, R.drawable.hide1);
            this.tintColor = attrsArray.getColor(R.styleable.ShowHidePasswordEditText_tint_color, 0);
            this.additionalTouchTargetSize = attrsArray.getDimensionPixelSize(R.styleable.ShowHidePasswordEditText_additionalTouchTargetSize, 40);
            attrsArray.recycle();
        } else {
            this.visibilityIndicatorShow = R.drawable.ic_visibility_grey_900_24dp;
            this.visibilityIndicatorHide = R.drawable.ic_visibility_off_grey_900_24dp;
        }

        this.leftToRight = this.isLeftToRight();
        this.setMaxLines(1);
        this.setSingleLine(true);
        this.isShowingPassword = false;
        this.maskPassword();
        this.setSaveEnabled(true);
        if (!TextUtils.isEmpty(this.getText())) {
            this.showPasswordVisibilityIndicator(true);
        }

        this.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    HideAndSeekPassword.this.showPasswordVisibilityIndicator(true);
                } else {
                    HideAndSeekPassword.this.showPasswordVisibilityIndicator(false);
                }

            }

            public void afterTextChanged(Editable s) {
            }
        });
    }

    private boolean isLeftToRight() {
        if (Build.VERSION.SDK_INT < 17) {
            return true;
        } else {
            Configuration config = this.getResources().getConfiguration();
            return config.getLayoutDirection() != 1;
        }
    }

    public void setCompoundDrawables(Drawable left, Drawable top, Drawable right, Drawable bottom) {
        if (this.leftToRight && right != null) {
            this.drawableEnd = right;
        } else if (!this.leftToRight && left != null) {
            this.drawableEnd = left;
        }

        super.setCompoundDrawables(left, top, right, bottom);
    }

    public void setTintColor(@ColorInt int tintColor) {
        this.tintColor = tintColor;
    }

    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == 1 && this.drawableEnd != null) {
            Rect bounds = this.drawableEnd.getBounds();
            int x = (int)event.getX();
            int drawableWidthWithPadding = bounds.width() + (this.leftToRight ? this.getPaddingRight() : this.getPaddingLeft()) + this.additionalTouchTargetSize;
            if (this.leftToRight && x >= this.getRight() - drawableWidthWithPadding || !this.leftToRight && x <= this.getLeft() + drawableWidthWithPadding) {
                this.togglePasswordVisibility();
                event.setAction(3);
            }
        }

        return super.onTouchEvent(event);
    }

    private void showPasswordVisibilityIndicator(boolean show) {
        Drawable[] existingDrawables = this.getCompoundDrawables();
        Drawable left = existingDrawables[0];
        Drawable top = existingDrawables[1];
        Drawable right = existingDrawables[2];
        Drawable bottom = existingDrawables[3];
        if (show) {
            Drawable original = this.isShowingPassword ? ContextCompat.getDrawable(this.getContext(), this.visibilityIndicatorHide) : ContextCompat.getDrawable(this.getContext(), this.visibilityIndicatorShow);
            original.mutate();
            if (this.tintColor == 0) {
                this.setCompoundDrawablesWithIntrinsicBounds(this.leftToRight ? left : original, top, this.leftToRight ? original : right, bottom);
            } else {
                Drawable wrapper = DrawableCompat.wrap(original);
                DrawableCompat.setTint(wrapper, this.tintColor);
                this.setCompoundDrawablesWithIntrinsicBounds(this.leftToRight ? left : wrapper, top, this.leftToRight ? wrapper : right, bottom);
            }
        } else {
            this.setCompoundDrawablesWithIntrinsicBounds(this.leftToRight ? left : null, top, this.leftToRight ? null : right, bottom);
        }

    }

    private void unmaskPassword() {
        this.setTransformationMethod((TransformationMethod)null);
    }

    private void maskPassword() {
        this.setTransformationMethod(PasswordTransformationMethod.getInstance());
    }

    public void togglePasswordVisibility() {
        int selectionStart = this.getSelectionStart();
        int selectionEnd = this.getSelectionEnd();
        if (this.isShowingPassword) {
            this.maskPassword();
        } else {
            this.unmaskPassword();
        }

        this.setSelection(selectionStart, selectionEnd);
        this.isShowingPassword = !this.isShowingPassword;
        this.showPasswordVisibilityIndicator(true);
    }

    protected void finalize() throws Throwable {
        this.drawableEnd = null;
        super.finalize();
    }

    @DrawableRes
    public int getVisibilityIndicatorShow() {
        return this.visibilityIndicatorShow;
    }

    public void setVisibilityIndicatorShow(@DrawableRes int visibilityIndicatorShow) {
        this.visibilityIndicatorShow = visibilityIndicatorShow;
    }

    @DrawableRes
    public int getVisibilityIndicatorHide() {
        return this.visibilityIndicatorHide;
    }

    public void setVisibilityIndicatorHide(@DrawableRes int visibilityIndicatorHide) {
        this.visibilityIndicatorHide = visibilityIndicatorHide;
    }

    public boolean isShowingPassword() {
        return this.isShowingPassword;
    }

    public int getAdditionalTouchTargetSizePixels() {
        return this.additionalTouchTargetSize;
    }

    public void setAdditionalTouchTargetSizePixels(int additionalTouchTargetSize) {
        this.additionalTouchTargetSize = additionalTouchTargetSize;
    }

    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("SUPER_STATE_KEY", super.onSaveInstanceState());
        bundle.putBoolean("IS_SHOWING_PASSWORD_STATE_KEY", this.isShowingPassword);
        return bundle;
    }

    public void onRestoreInstanceState(Parcelable state) {
        if (state instanceof Bundle) {
            Bundle bundle = (Bundle)state;
            this.isShowingPassword = bundle.getBoolean("IS_SHOWING_PASSWORD_STATE_KEY", false);
            if (this.isShowingPassword) {
                this.unmaskPassword();
            }

            state = bundle.getParcelable("SUPER_STATE_KEY");
        }

        super.onRestoreInstanceState(state);
    }
}
