package com.one.duanone.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.one.duanone.R;

/**
 * Created by Masterr_Robot on 2016/7/23.
 */
public class TabBottomFragment extends BaseFragment implements View.OnClickListener {


    private OnChangPagerListener listener;
    private ImageView[] imageViewArray = new ImageView[4];
    private TextView[] textViewArray = new TextView[4];
    private int currentPager = 0;
    private View view;

    @Override
    public View getFragmentView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.my_bttom_view, null);

        imageViewArray[0] = $(R.id.home_image);
        imageViewArray[1] = $(R.id.find_image);
        imageViewArray[2] = $(R.id.audit_image);
        imageViewArray[3] = $(R.id.message_image);

        textViewArray[0] = $(R.id.home_textView);
        textViewArray[1] = $(R.id.find_textView);
        textViewArray[2] = $(R.id.audit_textView);
        textViewArray[3] = $(R.id.message_textView);

        $(R.id.audit_linear).setOnClickListener(this);
        $(R.id.home_linear).setOnClickListener(this);
        $(R.id.find_linear).setOnClickListener(this);
        $(R.id.message_linear).setOnClickListener(this);

        return view;
    }

    @Override
    public void initFragmentData() {

    }

    /**
     * 设置显示的页面
     * @param pager
     */
    public void setPager(int pager) {
        if (pager == currentPager)
            return;
        //先取消当前的状态
        imageViewArray[currentPager].setSelected(false);
        textViewArray[currentPager].setSelected(false);
        currentPager = pager;
        //选中当前的状态
        imageViewArray[currentPager].setSelected(true);
        textViewArray[currentPager].setSelected(true);

        changePager(currentPager);

    }
    private void changePager(int page){
        if (listener==null)
            return;
        listener.onChangPager(page);
    }

    public void setListener(OnChangPagerListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        int pager = -1;
        switch (v.getId()){
            case R.id.home_linear:
                pager = 0;
                break;
            case R.id.find_linear:
                pager = 1;
                break;
            case R.id.audit_linear:
                pager = 2;
                break;
            case R.id.message_linear:
                pager = 3;
                break;
        }
        setPager(pager);
    }

    public interface OnChangPagerListener {
        void onChangPager(int pager);
    }

    /**
     * findViewBy id
     *
     * @param resId
     * @param <T>
     * @return
     */
    public <T extends View> T $(int resId) {
        return (T) view.findViewById(resId);
    }
}
