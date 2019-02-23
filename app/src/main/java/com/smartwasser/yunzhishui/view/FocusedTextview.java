package com.smartwasser.yunzhishui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

public class FocusedTextview extends TextView {

	public FocusedTextview(Context context) {
		super(context);
	}

	public FocusedTextview(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	public FocusedTextview(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}
	@Override
	public boolean isFocused() {
		return true;
	}
}
