package com.kangle.library.subsubActivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.kangle.library.R;

import fr.castorflex.android.circularprogressbar.CircularProgressBar;


public class A03sub03Activity extends AppCompatActivity {


    CircularProgressBar  CircularProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a03sub03);
           CircularProgressBar = (fr.castorflex.android.circularprogressbar.CircularProgressBar) findViewById(R.id.CircularProgressBar);
    }
}
