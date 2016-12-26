package com.kangle.library.subsubActivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kangle.library.R;

import java.util.Timer;
import java.util.TimerTask;

import com.kangle.circleprogress.ArcProgress;

public class A03sub02Activity extends AppCompatActivity {

    ArcProgress arcStore;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a03sub02);

        arcStore = (ArcProgress) findViewById(R.id.arc_store);
        arcStore.setMax(100);
        arcStore.setBottomText("bottom text");
        arcStore.setProgress(0);
        arcStore.setUnfinishedStrokeColor(0xff0000ff);
        arcStore.setFinishedStrokeColor(0xffff0000);
//        arcStore.setArcAngle(360.0f);
        arcStore.setStrokeWidth(20.0f);
        arcStore.setSuffixText("SuffixText");

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (arcStore.getProgress() >= arcStore.getMax()) {
                            timer.cancel();
                        } else {
                            arcStore.setProgress(arcStore.getProgress() + 1);
                        }
                    }
                });
            }
        }, 100, 100);

    }


    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }
}
