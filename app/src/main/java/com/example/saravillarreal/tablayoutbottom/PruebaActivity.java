package com.example.saravillarreal.tablayoutbottom;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by saravillarreal on 2/1/17.
 */
public class PruebaActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupViewPager(this, 4);
        //setContentView(R.layout.activity_main);
        //PageFragment.newInstance(4);

    }
}
