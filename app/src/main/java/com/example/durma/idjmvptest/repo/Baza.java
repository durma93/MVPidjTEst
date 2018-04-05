package com.example.durma.idjmvptest.repo;

import com.example.durma.idjmvptest.R;
import com.example.durma.idjmvptest.mvp.model.Video;

import java.util.ArrayList;

public class Baza {

    public static ArrayList<Video> getAllVideos(){
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.nikolija, "Nikolija - Los momak (Official Video)", "20,392,564 Views", "1zqVnbzN9ps"));
        videos.add(new Video(R.drawable.cvija, "Cvija - Brzina", "8,545,243 Views", "DQVCLOK_f4w"));
        videos.add(new Video(R.drawable.krvavi_balkan, "THC feat Coby - Krvavi balkan (Official Video)", "11,305,549 Views", "eKTlSYR0z3E"));
        videos.add(new Video(R.drawable.marko_mandic, "Marko Mandic - Ramdagadam (Official Video)", "11,305,549 Views", "FLA1Su3sdIU"));
        videos.add(new Video(R.drawable.elena, "Elena - Zlato", "11,305,549 Views", "cMLWAa70Vws"));


        return videos;
    }
    public static ArrayList getRows() {
        ArrayList rows = new ArrayList<>();
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new Video());
        rows.add(new Video());
        return rows;
    }

}
