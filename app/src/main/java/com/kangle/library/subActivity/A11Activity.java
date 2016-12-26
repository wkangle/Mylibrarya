package com.kangle.library.subActivity;


import android.os.Bundle;

import com.kangle.library.R;
import com.kangle.textcounter.CounterView;
import com.kangle.textcounter.formatters.DecimalFormatter;

public class A11Activity extends BaseActivity {

    private CounterView counterView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a11);

        counterView = (CounterView) findViewById(R.id.counterView);
        counterView.setAutoFormat(false);//设置自动格式
        counterView.setFormatter(new DecimalFormatter());
        counterView.setAutoStart(false);//自动开始
        counterView.setIncrement(0.1f); // 步进长度
        counterView.setTimeInterval(2); //步进时间  ms
        counterView.setStartValue(0f);//起始值
        counterView.setEndValue(88.9f);//结束值
        counterView.setPrefix("前面文字");
        counterView.setSuffix("后面文字");
        counterView.start();//开始


    }
}
