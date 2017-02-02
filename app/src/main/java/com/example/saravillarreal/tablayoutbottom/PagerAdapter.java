package com.example.saravillarreal.tablayoutbottom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by saravillarreal on 2/1/17.
 */
public class PagerAdapter extends FragmentPagerAdapter {

    private String[] mTabsTitle;

    private int[] mTabsIcons = {
            R.drawable.icon_tab_heart,
            R.drawable.icon_tab_lab,
            R.drawable.icon_tab_survey,
            R.drawable.icon_tab_request,
            R.drawable.icon_tab_settings

    };

    Context mContext;
    int position = 0;


    public final int PAGE_COUNT = 5;


    public  PagerAdapter (Activity context, FragmentManager fm, int position, String[] mTabsTitle){
        super(fm);
        mContext = context;
        this.position = position;
        this.mTabsTitle = mTabsTitle;
    }

    public PagerAdapter(FragmentManager fm) {
        super(fm);
    }




    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View view = LayoutInflater.from(mContext).inflate(R.layout.custom_tab, null);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(mTabsTitle[position]);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        icon.setImageResource(mTabsIcons[position]);
        return view;
    }

    @Override
    public Fragment getItem(int pos) {
        switch (pos) {

            case 0:
                return PageFragment.newInstance(1);
            case 1:
                return PageFragment.newInstance(2);
            case 2:
                return PageFragment.newInstance(3);
            case 3:
                return PageFragment.newInstance(4);
            case 4:
                return PageFragment.newInstance(5);

        }
        return null;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabsTitle[position];
    }
}
