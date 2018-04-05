package com.example.durma.idjmvp.Utils.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.mvp.model.pojo.Izdanja;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by durma on 2.3.18..
 */

public class RecyclerViewAdapterIzdanja extends RecyclerView.Adapter<RecyclerViewAdapterIzdanja.ViewHolder> {

    private Context context;
    private ArrayList<Izdanja> izdanjas;
    private String headTitle;



    public RecyclerViewAdapterIzdanja(Context context, ArrayList<Izdanja> izdanjas, String headTitle) {
        this.context = context;
        this.izdanjas = izdanjas;
        this.headTitle = headTitle;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item_last_3, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Izdanja izdanja = izdanjas.get(position);

        Picasso.with(context).
                load(izdanja.getImage()).
                resize(300,300).
                into(holder.image);

        holder.name.setText(izdanja.getIzvodjaci().getFullName());
        holder.info.setText(izdanja.getTitle());
    }

    @Override
    public int getItemCount() {
        return izdanjas.size();
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
