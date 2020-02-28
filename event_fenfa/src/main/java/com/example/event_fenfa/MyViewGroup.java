package com.example.event_fenfa;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.RelativeLayout;

public class MyViewGroup extends RelativeLayout {
    private static final String TAG = "MyViewGroup";
    private float mDownX;
    private float mDonwY;
    private float x;


    public MyViewGroup(Context context) {
        super(context);
    }

    public MyViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.d(TAG, "dispatchTouchEvent: "+ev.getAction());
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()){
            case MotionEvent.ACTION_DOWN:
                mDownX = ev.getX();
                mDonwY = ev.getY();
                break;
                case MotionEvent.ACTION_MOVE:
                    float mMoveX = ev.getX();
                    float mMoveY = ev.getY();
                    float x = mMoveX - mDownX;
                    float v = mMoveY - mDonwY;
                    if (Math.abs(x)>=Math.abs(v)){
                        return false;
                    }else{
                        return true;
                    }
        }
        Log.d(TAG, "onInterceptTouchEvent: "+ev.getAction());
        //true 拦截事件就给到自己的onTonchEvent
        //false 和super一样 事件分发
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: "+event.getAction());
        return true;
    }
}
