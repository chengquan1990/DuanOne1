package com.one.duanone.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 本文档由：成全 于：2016/7/23 创建
 */
public class ConentFragment extends BaseFragment {

    private ViewPager viewPager;



    private   TabBottomFragment.OnChangPagerListener onChangPagerListener = new TabBottomFragment.OnChangPagerListener() {
        @Override
        public void onChangPager(int pager) {
//            viewPager.setCurrentItem(pager);
        }
    };

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return null;
    }

    @Override
    public void initFragmentData() {
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((PagerChange)getActivity()).onPageChange(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    public TabBottomFragment.OnChangPagerListener getOnChangPagerListener() {
        return onChangPagerListener;
    }
}
