package com.example.durma.idjmvp.mvp.model.list;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.mvp.model.pojo.Emisije;
import com.example.durma.idjmvp.mvp.model.pojo.IDJClips;
import com.example.durma.idjmvp.mvp.model.pojo.Izdanja;
import com.example.durma.idjmvp.mvp.model.pojo.Izvodjaci;
import com.example.durma.idjmvp.mvp.model.pojo.Playlist;
import com.example.durma.idjmvp.mvp.model.pojo.Video;

import java.util.ArrayList;

public class Lists {

    public static ArrayList<Video> getAllVideos(){
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.nikolija, "Nikolija - Los momak (Official Video)", "20,392,564 Views", "1zqVnbzN9ps"));
        videos.add(new Video(R.drawable.cvija, "Cvija - Brzina", "8,545,243 Views", "DQVCLOK_f4w"));
        videos.add(new Video(R.drawable.krvavi_balkan, "THC feat Coby - Krvavi balkan (Official Video)", "11,305,549 Views", "eKTlSYR0z3E"));
        videos.add(new Video(R.drawable.marko_mandic, "Marko Mandic - Ramdagadam (Official Video)", "11,305,549 Views", "FLA1Su3sdIU"));
        videos.add(new Video(R.drawable.elena, "Elena - Zlato", "11,305,549 Views", "cMLWAa70Vws"));


        return videos;
    }

    public static ArrayList<Video> getAllVideos2() {
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.marko_mandic, "Marko Mandic - Ramdagadam (Official Video)", "11,305,549 Views", "FLA1Su3sdIU"));
        videos.add(new Video(R.drawable.nikolija, "Nikolija - Los momak (Official Video)", "20,392,564 Views", "1zqVnbzN9ps"));
        videos.add(new Video(R.drawable.elena, "Elena - Zlato", "11,305,549 Views", "cMLWAa70Vws"));
        videos.add(new Video(R.drawable.cvija, "Cvija - Brzina", "8,545,243 Views", "DQVCLOK_f4w"));
        videos.add(new Video(R.drawable.krvavi_balkan, "THC feat Coby - Krvavi balkan (Official Video)", "11,305,549 Views", "eKTlSYR0z3E"));



        return videos;
    }

    public static ArrayList<Video> getAllSpotovi() {
        ArrayList<Video> videos = new ArrayList<>();
        videos.add(new Video(R.drawable.acalukas, "Aca Lukas Mile Kitc Sasa Matic - Da me je ona volela", "55,875,564 Views", "sISE_oNaOIA"));
        videos.add(new Video(R.drawable.coronabela, "Corrona - Bella", "17,444,002 Views", "CHKu71S9Gpg"));
        videos.add(new Video(R.drawable.crnisin, "Cvija Relja Coby - Crni sine", "66,545,243 Views", "KF-9RpwhHco"));
        videos.add(new Video(R.drawable.dadootebi, "Dado Polumenta - O tebi (Official Video)", "8,305,549 Views", "5VXh84xWM5Q"));
        videos.add(new Video(R.drawable.mainshatcz, "Mc Stojan ft. Darko lazic - Mein Schatz (Official Video)", "20,305,549 Views", "tuWM6uG79RI"));


        return videos;
    }

    public static ArrayList<IDJClips> getAllClips() {
        ArrayList<IDJClips> clips = new ArrayList<>();

        clips.add(new IDJClips(R.drawable.gru, "Gru"));
        clips.add(new IDJClips(R.drawable.mcstojanmotor, "Mc Stojan otriva ko mu je dao motor"));
        clips.add(new IDJClips(R.drawable.sara_idj, "Sara jo u emisiji prica o"));
        clips.add(new IDJClips(R.drawable.lanausne, "Lana je dobila priliku da se konacno pokaze"));
        clips.add(new IDJClips(R.drawable.indira, "Indira"));

        return clips;
    }

    public static ArrayList<Emisije> getAllEmisije() {
        ArrayList<Emisije> emisije = new ArrayList<>();

        emisije.add(new Emisije(R.drawable.idjhot, "IDJHot"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "IDJToplista"));
        emisije.add(new Emisije(R.drawable.idjhot2, "IDJHot 2"));
        emisije.add(new Emisije(R.drawable.idjhot3, "Playlist"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "Emerging"));
        emisije.add(new Emisije(R.drawable.idjhot, "IDJHot"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "IDJToplista"));
        emisije.add(new Emisije(R.drawable.idjhot2, "IDJHot 2"));
        emisije.add(new Emisije(R.drawable.idjhot3, "Playlist"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "Emerging"));
        emisije.add(new Emisije(R.drawable.idjhot, "IDJHot"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "IDJToplista"));
        emisije.add(new Emisije(R.drawable.idjhot2, "IDJHot 2"));
        emisije.add(new Emisije(R.drawable.idjhot3, "Playlist"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "Emerging"));
        emisije.add(new Emisije(R.drawable.idjhot, "IDJHot"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "IDJToplista"));
        emisije.add(new Emisije(R.drawable.idjhot2, "IDJHot 2"));
        emisije.add(new Emisije(R.drawable.idjhot3, "Playlist"));
        emisije.add(new Emisije(R.drawable.idjtoplista, "Emerging"));

        return emisije;
    }

    public static ArrayList<Izdanja> getAllIzdanja() {
        ArrayList<Izdanja> izdanja = new ArrayList<>();

        izdanja.add(new Izdanja(R.drawable.nikolija, new Izvodjaci(R.drawable.nikolija, "Nikolija Jovanovic"),"Moj tempo"));
        izdanja.add(new Izdanja(R.drawable.relja, new Izvodjaci(R.drawable.relja, "Relja Popovic"),"Beograd jos zivo"));
        izdanja.add(new Izdanja(R.drawable.severina, new Izvodjaci(R.drawable.severina, "Severina"),"Uno momento"));
        izdanja.add(new Izdanja(R.drawable.indira, new Izvodjaci(R.drawable.indira, "Indira"),"Zmaj"));
        izdanja.add(new Izdanja(R.drawable.idjhot3, new Izvodjaci(R.drawable.acalukas, "Aca Lukas"),"Balkan"));

        return izdanja;
    }

    public static ArrayList<Playlist> getAllPlaylist() {
        ArrayList<Playlist> playlists = new ArrayList<>();

        playlists.add(new Playlist(R.drawable.hearthis,"Hear this"));
        playlists.add(new Playlist(R.drawable.summerhits,"Summer hits"));
        playlists.add(new Playlist(R.drawable.idjtoplista,"Top lista"));
        playlists.add(new Playlist(R.drawable.idjhot,"Hot list"));
        playlists.add(new Playlist(R.drawable.idjhot3,"Hot hotova"));


        return playlists;
    }

    public static ArrayList<Izvodjaci> getAllIzvodjaci() {
        ArrayList<Izvodjaci> izvodjaci = new ArrayList<>();

        izvodjaci.add(new Izvodjaci(R.drawable.nikolija,"Nikolija Jovanovic"));
        izvodjaci.add(new Izvodjaci(R.drawable.relja,"Relja Popovic"));
        izvodjaci.add(new Izvodjaci(R.drawable.severina, "Severina"));
        izvodjaci.add(new Izvodjaci(R.drawable.lanausne, "Lana Jurcevic"));
        izvodjaci.add( new Izvodjaci(R.drawable.harisskarep, "Haris Skarep"));

        return izvodjaci;
    }

}
