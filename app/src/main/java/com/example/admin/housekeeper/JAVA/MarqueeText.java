package com.example.admin.housekeeper.JAVA;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by admin on 2016/7/16.
 */
public class MarqueeText extends TextView {
    public MarqueeText(Context context) {
        super(context);
    }

    public MarqueeText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MarqueeText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean isFocused() {
        return true;
    }
}
