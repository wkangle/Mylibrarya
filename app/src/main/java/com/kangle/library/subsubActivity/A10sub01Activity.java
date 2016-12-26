package com.kangle.library.subsubActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;

import com.kangle.RevealBackgroundView;
import com.kangle.library.R;
import com.kangle.library.subActivity.BaseActivity;

public class A10sub01Activity extends BaseActivity {


    public RevealBackgroundView mContentRevealBackgroundView;
    public int[] mLocation;
    public static final String LOCATION = "location";

    private ImageView yyiv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a10sub01);


        mContentRevealBackgroundView = (RevealBackgroundView) findViewById(R.id.rbv_content);
        yyiv = (ImageView) findViewById(R.id.yyiv);
        parseIntent();
        mContentRevealBackgroundView.setOnStateChangeListener(new RevealBackgroundView.OnStateChangeListener() {
            @Override
            public void onStateChange(int state) {
                if (RevealBackgroundView.STATE_FINISHED == state) {
                    yyiv.setVisibility(View.VISIBLE);
                    Log.d("kangle", "onStateChange");
                }
            }
        });

        Log.d("wangkangle",mLocation.length + "    "+mLocation[0]  +"    " + mLocation[1]);
//        mContentRevealBackgroundView.setCurrentRadius();
        if (mLocation == null || savedInstanceState != null) {
            mContentRevealBackgroundView.setToFinishedFrame();
        } else {
            final int[] startingLocation = getIntent().getIntArrayExtra(LOCATION);
            Log.d("wangkangle",startingLocation.length + "    "+startingLocation[0]  +"    " + startingLocation[1]);
            mContentRevealBackgroundView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver
                    .OnPreDrawListener() {
                @Override
                public boolean onPreDraw() {
                    mContentRevealBackgroundView.getViewTreeObserver().removeOnPreDrawListener(this);
                    mContentRevealBackgroundView.startFromLocation(startingLocation);
                    return true;
                }
            });
        }

    }


    /**
     * 启动本Activity
     *
     * @param activity
     * @param locationArr
     * @return
     */
    public static Intent newTopStoriesIntent(Activity activity, int[] locationArr) {
        Bundle bundle = new Bundle();
        bundle.putIntArray(LOCATION, locationArr);
        Intent intent = new Intent(activity, A10sub01Activity.class);
        intent.putExtras(bundle);
        return intent;
    }


    private void parseIntent() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        mLocation = bundle.getIntArray(LOCATION);
    }
}
