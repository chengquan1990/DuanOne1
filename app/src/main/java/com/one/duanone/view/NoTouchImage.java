package com.one.duanone.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * 本文档由：成全 于：2016/7/23 创建
 */
public class NoTouchImage extends ImageView {
    public NoTouchImage(Context context) {
        super(context);
    }

    public NoTouchImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }
}
