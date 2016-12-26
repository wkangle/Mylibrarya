package com.kangle;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import identify.uniubi.com.customizeview.R;

/**
 * 仿朋友圈查看全文，文本自动展开闭合
 * Created by kangle 2016年12月12日14:48:57
 */
public class ExpandTextView extends LinearLayout {
    private TextView contentText;//显示的内容
    private TextView textPlus;//全文
    private int showLines = 3;//显示的最大行数,默认为3

    public ExpandTextView(Context context) {
        super(context);
        initView();
    }

    public ExpandTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public ExpandTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        setOrientation(LinearLayout.VERTICAL);
        LayoutInflater.from(getContext()).inflate(R.layout.expand_textview, this);
        contentText = (TextView) findViewById(R.id.contentText);

        textPlus = (TextView) findViewById(R.id.textPlus);
        textPlus.setText("全文");
        contentText.setMaxLines(showLines);
        textPlus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                String textStr = textPlus.getText().toString().trim();
                if ("全文".equals(textStr)) {
                    contentText.setMaxLines(Integer.MAX_VALUE);
                    textPlus.setText("收起");
                } else {
                    contentText.setMaxLines(showLines);
                    textPlus.setText("全文");
                }
            }
        });
    }


    /**
     * 设置文本
     * @param content
     */
    public void setText(CharSequence content) {
        contentText.setText(content);
        contentText.post(new Runnable() {
            @Override
            public void run() {
                int linCount = contentText.getLineCount();
                if (linCount > showLines) {
                    contentText.setMaxLines(showLines);
                    textPlus.setVisibility(View.VISIBLE);
                    textPlus.setText("全文");
                } else {
                    textPlus.setVisibility(View.GONE);
                }
            }
        });

    }


    /**
     * 获取显示的最大行数
     * @return
     */
    public int getShowLines() {
        return showLines;
    }


    /**
     * 设置显示的最大行数
     * @param showLines
     */
    public void setShowLines(int showLines) {
        this.showLines = showLines;
    }
}
