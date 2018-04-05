package com.example.durma.idjmvp.Utils.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.Utils.PlayVideo.PlayVideoActivity;
import com.example.durma.idjmvp.mvp.model.pojo.Video;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by durma on 26.2.18..
 */
public class SliderAdapter extends PagerAdapter {

        private Context context;
        private LayoutInflater inflater;
        private ArrayList<Video> videos;

        public SliderAdapter(Context context, ArrayList<Video> videos) {
            this.context = context;
            this.videos = videos;
        }

        @Override
        public int getCount() {
            return videos.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.element_carosel_layout, null);
            ImageView slika = (ImageView)view.findViewById(R.id.sliderImage);
            TextView naziv = (TextView) view.findViewById(R.id.naziv);
            TextView brojPregleda = (TextView) view.findViewById(R.id.brojPregleda);

            //slika.setImageResource(videos.get(position).getSlika());
            naziv.setText(videos.get(position).getNaziv());
            brojPregleda.setText(videos.get(position).getBroj_pregleda());

            Picasso.with(context).
                    load(videos.get(position).getSlika()).resize(800,600)
                    .into(slika);


            final ViewPager viewPager = (ViewPager) container;
            viewPager.addView(view, 0);

            slika.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = viewPager.getCurrentItem();
                    if (pos != RecyclerView.NO_POSITION){

                        Video getVideo = videos.get(pos);

                        Intent i = new Intent(context, PlayVideoActivity.class);
                        i.putExtra("videos", getVideo);
                        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(i);
                        Toast.makeText(view.getContext(), "Kliknuli smo: " +getVideo.getNaziv(), Toast.LENGTH_SHORT).show();
                    }

                }
            });

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            ViewPager viewPager = (ViewPager) container;
            View view = (View) object;
            viewPager.removeView(view);
        }
}



