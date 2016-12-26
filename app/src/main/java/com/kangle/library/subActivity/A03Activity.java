package com.kangle.library.subActivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.kangle.library.R;
import com.kangle.library.subsubActivity.A03sub01Activity;
import com.kangle.library.subsubActivity.A03sub02Activity;
import com.kangle.library.subsubActivity.A03sub03Activity;

public class A03Activity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a03);
    }





    public void bt01(View view){
        Intent intent = new Intent(A03Activity.this, A03sub01Activity.class);
        startActivity(intent);
    }


    public void bt02(View view){
        Intent intent = new Intent(A03Activity.this, A03sub02Activity.class);
        startActivity(intent);
    }

    public void bt03(View view){
        Intent intent = new Intent(A03Activity.this, A03sub03Activity.class);
        startActivity(intent);
    }
}
