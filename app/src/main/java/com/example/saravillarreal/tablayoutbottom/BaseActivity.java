package com.example.saravillarreal.tablayoutbottom;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by saravillarreal on 2/1/17.
 */
public class BaseActivity extends AppCompatActivity {
    private TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void setupViewPager(Activity activity, int position){
        String[] mTabsTitle = {activity.getString(R.string.label_tab_medical_history),
                activity.getString(R.string.label_tab_laboratory),
                activity.getString(R.string.label_tab_survey),
                activity.getString(R.string.label_tab_doctors),
                activity.getString(R.string.label_tab_settings)};
        // Setup the viewPager
        ViewPager viewPager = (ViewPager) findViewById(R.id.view_pager);
        PagerAdapter pagerAdapter = new PagerAdapter(activity, getSupportFragmentManager(), position, mTabsTitle);
        if (viewPager != null)
            viewPager.setAdapter(pagerAdapter);

        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        if (mTabLayout != null) {
            mTabLayout.setupWithViewPager(viewPager);

            for (int i = 0; i < mTabLayout.getTabCount(); i++) {
                TabLayout.Tab tab = mTabLayout.getTabAt(i);
                if (tab != null)
                    tab.setCustomView(pagerAdapter.getTabView(i));
            }

            mTabLayout.getTabAt(0).getCustomView().setSelected(true);
        }
    }


}
