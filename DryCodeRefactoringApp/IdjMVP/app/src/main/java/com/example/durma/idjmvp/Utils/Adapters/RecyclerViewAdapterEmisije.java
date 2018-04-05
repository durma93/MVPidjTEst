package com.example.durma.idjmvp.Utils.Adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.durma.idjmvp.R;
import com.example.durma.idjmvp.mvp.model.pojo.Emisije;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


/**
 * Created by durma on 2.3.18..
 */

public class RecyclerViewAdapterEmisije extends RecyclerView.Adapter<RecyclerViewAdapterEmisije.ViewHolder> {

    private Context context;
    private ArrayList<Emisije> emisijes;
    private String headTitle;



    public RecyclerViewAdapterEmisije(Context context, ArrayList<Emisije> emisijes, String headTitle) {
        this.context = context;
        this.emisijes = emisijes;
        this.headTitle = headTitle;
    }

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tab_item, parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Emisije emisije = emisijes.get(position);

        Picasso.with(context).
                load(emisije.getImage()).
                resize(200,100).
                centerCrop().
                into(holder.image);

        holder.name.setText(emisije.getTitle());
    }

    @Override
    public int getItemCount() {
        return emisijes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image;
        TextView name;
        LinearLayout linearLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.image);
            name = (TextView) itemView.findViewById(R.id.name);
            linearLayout = (LinearLayout)itemView.findViewById(R.id.tabLayoutmain);

            int i = itemView.getResources().getColor(R.color.colorPrimary);

            linearLayout.setBackgroundColor(i);

   /*         LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();

            params.setMargins(10,10,10,10);

            linearLayout.setLayoutParams(params);*/

        }
    }
}
