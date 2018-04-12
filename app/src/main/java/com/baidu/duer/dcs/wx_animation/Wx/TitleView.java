package com.baidu.duer.dcs.wx_animation.Wx;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.baidu.duer.dcs.wx_animation.R;

/**
 * Created by wx on 2016/9/15.
 */
public class TitleView extends FrameLayout {
    private Button leftButton;
    private TextView titleView;
    public TitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_layout, this);
        titleView = (TextView) findViewById(R.id.title_text);
        leftButton = (Button) findViewById(R.id.button_left);
        leftButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((Activity) getContext()).finish();
            }
        });
    }
    public void setTitleText(String text) {
        titleView.setText(text);
    }

    public void setLeftButtonText(String text){
        leftButton.setText(text);
    }

    public void setLeftButtonOnclickListener(OnClickListener listener){
        leftButton.setOnClickListener(listener);
    }
}
