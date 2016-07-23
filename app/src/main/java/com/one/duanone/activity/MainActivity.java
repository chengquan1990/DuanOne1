package com.one.duanone.activity;

import android.os.Bundle;

import com.one.duanone.R;
import com.one.duanone.fragment.ConentFragment;
import com.one.duanone.fragment.PagerChange;
import com.one.duanone.fragment.TabBottomFragment;

public class MainActivity extends BaseActivity implements PagerChange{
    private static final String TAG = MainActivity.class.getSimpleName();

    private TabBottomFragment tabFragment = new TabBottomFragment();
    private ConentFragment conentFragment = new ConentFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFragment();
    }

    private void initFragment() {
        tabFragment.setListener(conentFragment.getOnChangPagerListener());
        getSupportFragmentManager().beginTransaction().replace(R.id.main_bottom_tab,tabFragment).commit();
    }


    @Override
    public void onPageChange(int pager) {
        tabFragment.setPager(pager);
    }
}
