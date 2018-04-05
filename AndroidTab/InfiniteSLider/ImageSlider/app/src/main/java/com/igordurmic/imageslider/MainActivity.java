package com.igordurmic.imageslider;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import com.antonyt.infiniteviewpager.InfinitePagerAdapter;

public class MainActivity extends AppCompatActivity{
    ViewPager viewPager;
    ScreeshotAdapter screeshotAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager)findViewById(R.id.viewPager);

        int margin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,100*2, getResources().getDisplayMetrics()); // postavljanje margina za razmak izmedju slika
        viewPager.setPageMargin(-margin);


        screeshotAdapter = new ScreeshotAdapter(this);


        PagerAdapter pagerAdapter = new InfinitePagerAdapter(screeshotAdapter);
        viewPager.setAdapter(pagerAdapter);

    }

    

}
