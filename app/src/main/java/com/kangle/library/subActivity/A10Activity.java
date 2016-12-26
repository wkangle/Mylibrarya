package com.kangle.library.subActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.kangle.library.R;
import com.kangle.library.subsubActivity.A10sub01Activity;

public class A10Activity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a10);

    }

    public void onClick(View view) {
        Intent intent = A10sub01Activity.newTopStoriesIntent(this, getClickLocation(view));
        startActivity(intent);

    }

    private int[] getClickLocation(View v) {
        int[] clickLocation = new int[2];
        v.getLocationOnScreen(clickLocation);
        clickLocation[0] += v.getWidth() / 2;
        return clickLocation;
    }
}
