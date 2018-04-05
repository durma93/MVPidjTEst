package com.example.durma.idjmvp.Utils.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.mvp.model.pojo.Izvodjaci;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by durma on 2.3.18..
 */

public class RecyclerViewAdapterIzvodjaci extends RecyclerView.Adapter<RecyclerViewAdapterIzvodjaci.ViewHolder> {

    private Context context;
    private ArrayList<Izvodjaci> izvodjacis;
    private String headTitle;



    public RecyclerViewAdapterIzvodjaci(Context context, ArrayList<Izvodjaci> izvodjacis, String headTitle) {
        this.context = context;
        this.izvodjacis = izvodjacis;
        this.headTitle = headTitle;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item_last_3, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Izvodjaci izvodjaci = izvodjacis.get(position);

        Picasso.with(context).
                load(izvodjaci.getImage()).
                resize(300,300).
                into(holder.image);

        holder.name.setText(izvodjaci.getFullName());
    }

    @Override
    public int getItemCount() {
        return izvodjacis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name, info;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image2);
            name = (TextView) itemView.findViewById(R.id.name2);
            info = (TextView) itemView.findViewById(R.id.info);


        }
    }
}
