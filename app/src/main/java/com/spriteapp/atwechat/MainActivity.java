package com.spriteapp.atwechat;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.spriteapp.atwechat.fragment.HomeFragment;
import com.spriteapp.atwechat.fragment.ViewsFragment;
import com.spriteapp.atwechat.fragment.ActiveFragment;
import com.spriteapp.atwechat.fragment.TaskFragment;
import com.spriteapp.atwechat.fragment.CenterFragment;
import com.spriteapp.atwechat.wediget.BottomLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private HomeFragment mHomeFragment;
    private ViewsFragment mViewsFragment;
    private ActiveFragment mActiveFragment;
    private TaskFragment mTaskFragment;
    private CenterFragment mCenterFragment;
    private List<Fragment> mFragmentList;
    private ViewPager mViewPager;
    private ViewPagerAdapter mAdapter;
    private BottomLayout mHomeLayout;
    private BottomLayout mViewsLayout;
    private BottomLayout mActiveLayout;
    private BottomLayout mTaskLayout;
    private BottomLayout mCenterLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initId();
        initFragment();
        initList();
        setPagerAdapter();
        mHomeLayout.setSelectState();
        setViewPagerListener();
    }

    private void setViewPagerListener() {
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                setBottomState(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setPagerAdapter() {
        mAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
    }

    private void initId() {
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mHomeLayout = (BottomLayout) findViewById(R.id.home_layout);
        mViewsLayout = (BottomLayout) findViewById(R.id.views_layout);
        mActiveLayout = (BottomLayout) findViewById(R.id.active_layout);
        mTaskLayout = (BottomLayout) findViewById(R.id.task_layout);
        mCenterLayout = (BottomLayout) findViewById(R.id.center_layout);

        mHomeLayout.setOnClickListener(this);
        mViewsLayout.setOnClickListener(this);
        mActiveLayout.setOnClickListener(this);
        mTaskLayout.setOnClickListener(this);
        mCenterLayout.setOnClickListener(this);
    }

    private void initList() {
        mFragmentList = new ArrayList<>();
        mFragmentList.add(mHomeFragment);
        mFragmentList.add(mViewsFragment);
        mFragmentList.add(mActiveFragment);
        mFragmentList.add(mTaskFragment);
        mFragmentList.add(mCenterFragment);
    }

    private void initFragment() {
        mHomeFragment = new HomeFragment();
        mViewsFragment = new ViewsFragment();
        mActiveFragment = new ActiveFragment();
        mTaskFragment = new TaskFragment();
        mCenterFragment = new CenterFragment();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_layout:
                setBottomState(0);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.views_layout:
                setBottomState(1);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.active_layout:
                setBottomState(2);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.task_layout:
                setBottomState(3);
                mViewPager.setCurrentItem(3);
                break;
            case R.id.center_layout:
                setBottomState(4);
                mViewPager.setCurrentItem(4);
                break;
            default:
                break;
        }
    }

    private void setBottomState(int position) {
        switch (position) {
            case 0:
                mHomeLayout.setSelectState();
                mViewsLayout.setUnSelectState();
                mActiveLayout.setUnSelectState();
                mTaskLayout.setUnSelectState();
                mCenterLayout.setUnSelectState();
                break;
            case 1:
                mHomeLayout.setUnSelectState();
                mViewsLayout.setSelectState();
                mActiveLayout.setUnSelectState();
                mTaskLayout.setUnSelectState();
                mCenterLayout.setUnSelectState();
                break;
            case 2:
                mHomeLayout.setUnSelectState();
                mViewsLayout.setUnSelectState();
                mActiveLayout.setSelectState();
                mTaskLayout.setUnSelectState();
                mCenterLayout.setUnSelectState();
                break;
            case 3:
                mHomeLayout.setUnSelectState();
                mViewsLayout.setUnSelectState();
                mActiveLayout.setUnSelectState();
                mTaskLayout.setSelectState();
                mCenterLayout.setUnSelectState();
                break;
            case 4:
                mHomeLayout.setUnSelectState();
                mViewsLayout.setUnSelectState();
                mActiveLayout.setUnSelectState();
                mTaskLayout.setUnSelectState();
                mCenterLayout.setSelectState();
                break;
            default:
                break;
        }
    }

    private class ViewPagerAdapter extends FragmentPagerAdapter {

        private ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
