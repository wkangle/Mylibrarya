package com.kangle.library.subActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.kangle.library.R;
import com.kangle.library.fragment.FirstFragment;
import com.kangle.library.fragment.SecondFragment;
import com.kangle.library.subsubActivity.A07sub01Activity;


/**
 *
 */
public class A07Activity extends BaseActivity {


    private Toolbar mTitleToolbar;//
    private NavigationView mContentNavigationView;
    private DrawerLayout mMainDrawerLayout;

    private int mLastItemId;

    private FirstFragment mContentZhihu;
    private SecondFragment mContentGank;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_a07);
        mTitleToolbar = (Toolbar) findViewById(R.id.tb_title);
//        mTitleTabLayout = (TabLayout) findViewById(R.id.tl_title);
        mContentNavigationView = (NavigationView) findViewById(R.id.nv_content);
        mMainDrawerLayout = (DrawerLayout) findViewById(R.id.dl_main);


        View view = mContentNavigationView.getHeaderView(0);
        ImageView header = (ImageView) view.findViewById(R.id.nav_head);
        header.setImageResource(R.drawable.asd);

        setSupportActionBar(mTitleToolbar);
        final ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_menu);
        ab.setDisplayHomeAsUpEnabled(true);


        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mMainDrawerLayout,
                mTitleToolbar, R.string.meizhi, R.string.meizhi);
        mMainDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();


        setupDrawerContent();
        mContentNavigationView.setCheckedItem(0);
    }


    /**
     * 初始化抽屉
     */
    private void setupDrawerContent() {
        mLastItemId = mContentNavigationView.getMenu().getItem(0).getItemId();
        changeFragments(mLastItemId);
        mContentNavigationView.setNavigationItemSelectedListener(new NavigationView
                .OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mMainDrawerLayout.closeDrawers();
                if (item.getItemId() == R.id.menu_introduce) {
                    startActivity(new Intent(A07Activity.this, A07sub01Activity.class));
                    item.setChecked(false);
                } else {
                    if (item.getItemId() != mLastItemId) {
                        item.setChecked(true);
                        changeFragments(item.getItemId());
                        mLastItemId = item.getItemId();
                    }
                }
                return true;
            }
        });
    }


    /**
     * 切换Fragment
     *
     * @param itemId
     */
    public void changeFragments(int itemId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hideAll(transaction);
        switch (itemId) {
            case R.id.nav_knowledge:
//                      知乎界面
                if (mContentZhihu != null) {
                    transaction.show(mContentZhihu);
                } else {
                    mContentZhihu = new FirstFragment();
                    transaction.add(R.id.fl_content, mContentZhihu);
                }
                initToolbar("知乎");
                break;
            case R.id.nav_beauty:
//                      妹纸界面
                if (mContentGank != null) {
                    transaction.show(mContentGank);
                } else {
                    mContentGank = new SecondFragment();
                    transaction.add(R.id.fl_content, mContentGank);
                }
                initToolbar("妹纸");
                break;
            default:
                break;
        }
        transaction.commit();
    }


    /**
     * 隐藏掉所有的Fragment
     *
     * @param transaction
     */
    private void hideAll(FragmentTransaction transaction) {
        if (mContentZhihu != null) {
            transaction.hide(mContentZhihu);
        }
        if (mContentGank != null) {
            transaction.hide(mContentGank);
        }
    }


    /**
     * 初始化Toolbar
     *
     * @param args
     */
    public void initToolbar(String args) {
        if (args.equals("妹纸")) {
            setToolbarTitle("妹纸");
        } else {
//            hideTabLayout(false);
            setToolbarTitle("知乎");
        }
    }


    public void setToolbarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }


}
