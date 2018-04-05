package com.example.durma.idjmvp.Utils.SeeMore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.Utils.Adapters.RecyclerViewAdapterEmisije;
import com.example.durma.idjmvp.Utils.Adapters.RecyclerViewAdapterIDJClips;
import com.example.durma.idjmvp.Utils.Adapters.RecyclerViewAdapterIzdanja;
import com.example.durma.idjmvp.Utils.Adapters.RecyclerViewAdapterIzvodjaci;
import com.example.durma.idjmvp.Utils.Adapters.RecyclerViewAdapterPlaylist;
import com.example.durma.idjmvp.Utils.Adapters.RecyclerViewAdapterSpotovi;
import com.example.durma.idjmvp.mvp.model.list.Lists;

public class SeeMoreActivity extends AppCompatActivity {

    RecyclerViewAdapterEmisije recyclerViewAdapterEmisije;
    RecyclerViewAdapterSpotovi recyclerViewAdapterSpotovi;
    RecyclerViewAdapterIDJClips recyclerViewAdapterIDJClips;
    RecyclerViewAdapterIzdanja recyclerViewAdapterIzdanja;
    RecyclerViewAdapterPlaylist recyclerViewAdapterPlaylist;
    RecyclerViewAdapterIzvodjaci recyclerViewAdapterIzvodjaci;
    RecyclerView recyclerView;

    TextView seeMoreTitle;

    LinearLayoutManager linearLayoutManager;

    ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerSeemore);
        recyclerView.setFocusable(false);
        seeMoreTitle = (TextView)findViewById(R.id.headTitleSeeMore);

        backButton = (ImageView)findViewById(R.id.backbutton);

        //Dugme za back u toolbaru
        backButton.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               onBackPressed();
           }
        });

        if (getIntent().getStringExtra("headTitle").equals("SPOTOVI")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterSpotovi = new RecyclerViewAdapterSpotovi(this, Lists.getAllSpotovi(),text);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterSpotovi);


        }
        else if (getIntent().getStringExtra("headTitle").equals("IDJKLIPS")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterIDJClips = new RecyclerViewAdapterIDJClips(this,Lists.getAllClips(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterIDJClips);


        }
        else if (getIntent().getStringExtra("headTitle").equals("EMISIJE")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterEmisije = new RecyclerViewAdapterEmisije(this,Lists.getAllEmisije(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterEmisije);


        }
        else if (getIntent().getStringExtra("headTitle").equals("IZDANJA")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterIzdanja = new RecyclerViewAdapterIzdanja(this,Lists.getAllIzdanja(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterIzdanja);


        }
        else if (getIntent().getStringExtra("headTitle").equals("PLAYLIST")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterPlaylist = new RecyclerViewAdapterPlaylist(this,Lists.getAllPlaylist(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterPlaylist);


        }
        else if (getIntent().getStringExtra("headTitle").equals("IZVODJACI")){

            String text = getIntent().getStringExtra("headTitle");

            seeMoreTitle.setText(text);

            recyclerViewAdapterIzvodjaci = new RecyclerViewAdapterIzvodjaci(this,Lists.getAllIzvodjaci(),null);
            linearLayoutManager = new GridLayoutManager(this, 2);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(recyclerViewAdapterIzvodjaci);


        }


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}
