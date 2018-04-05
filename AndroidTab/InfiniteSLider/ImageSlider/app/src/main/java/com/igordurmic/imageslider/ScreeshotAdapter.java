package com.igordurmic.imageslider;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class ScreeshotAdapter extends PagerAdapter{
    private int[] image_resources ={   // dodavanje slika iz layout foldera
            R.drawable.number1,
            R.drawable.number2,
            R.drawable.number3,
            R.drawable.number4,
            R.drawable.slika1,
            R.drawable.slika2,
            R.drawable.slika3,
            R.drawable.slika4,
            };

    private Context context;

    private LayoutInflater layoutInflater;  // ovaj objekat se pravi da bi se element ubacio u InfiniteViewPager u activity main layout-u

    public ScreeshotAdapter(Context context) {
        this.context = context;
    } // konstruktor

    @Override
    public int getCount() {
        return image_resources.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view ==(LinearLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View v = layoutInflater.inflate(R.layout.element, container, false);

        ImageView iv = (ImageView)v.findViewById(R.id.slider_image);

        iv.setImageResource(image_resources[position]);
        container.addView(v);

        return v;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }



}
