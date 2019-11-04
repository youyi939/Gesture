package com.example.gesture;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "BaseTestActivity";
    private GestureDetectorCompat mGestureDetector;
    private TextView mBaseTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBaseTv = (TextView)findViewById(R.id.base_tv);
        mGestureDetector = new GestureDetectorCompat(this,mOnGestureListener);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private GestureDetector.OnGestureListener mOnGestureListener = new GestureDetector.OnGestureListener() {
        @Override
        public boolean onDown(MotionEvent mCurrentDownEvent) {
            logger("onDown: ");
            Log.i(TAG, "onDown: ");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent mCurrentDownEvent) {
            logger("onShowPress: ");
            Log.i(TAG, "onShowPress: ");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent mCurrentDownEvent) {
            logger("onSingleTapUp: ");
            Log.i(TAG, "onSingleTapUp: ");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent mCurrentDownEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
            logger("onScroll: "+velocityX+"     ，     "+velocityY);
            Log.i(TAG, "onScroll: "+velocityX+"     ，     "+velocityY);
            return false;
        }

        @Override
        public void onLongPress(MotionEvent mCurrentDownEvent) {
            logger("onLongPress: ");
            Log.i(TAG, "onLongPress: ");
        }

        @Override
        public boolean onFling(MotionEvent mCurrentDownEvent, MotionEvent motionEvent1, float velocityX, float velocityY) {
            Log.i(TAG, "onFling: "+velocityX+"----"+velocityY);
            logger("onFling: "+velocityX+"     ,     "+velocityY);
            //右滑关闭acitivity
            if(velocityX > 10 && velocityX > Math.abs(velocityY)) {
                finish();
            }
            return true;
        }
    };

    private void logger(String msg){
        String log = mBaseTv.getText()+"\n"+msg;
        if(log.split(":").length>30){
            log = msg;
        }
        mBaseTv.setText(log);
    }

    public void test1(View view) {
        Intent intent = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(intent);
    }
}
