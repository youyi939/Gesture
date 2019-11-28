package com.example.gesture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;

public class Main2Activity extends AppCompatActivity {



    private View mView;
    private ScaleGestureDetector mScaleGestureDetector;
    private static final String TAG = "ScaleGestureActivity";
    private float mScaleFactor = 1.0f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mView = findViewById(R.id.scale_view);
        mScaleGestureDetector = new ScaleGestureDetector(this,mScaleGestureListener);



    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mScaleGestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private ScaleGestureDetector.OnScaleGestureListener mScaleGestureListener = new ScaleGestureDetector.OnScaleGestureListener() {
        @Override
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            mScaleFactor  *= scaleGestureDetector.getScaleFactor();
            mView.setScaleX(mScaleFactor);
            mView.setScaleY(mScaleFactor);
            Log.i(TAG, "onScale: "+ scaleGestureDetector.getScaleFactor()+"----"+mScaleFactor);
            return true;
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return true;
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {

        }
    };


}
