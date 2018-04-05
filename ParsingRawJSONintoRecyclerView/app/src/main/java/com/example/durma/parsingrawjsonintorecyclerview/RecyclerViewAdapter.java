package com.example.durma.parsingrawjsonintorecyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by durma on 27.12.17..
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    //A menu item view type
    private static final int MENU_ITEM_VIEW_TYPE=0;

    //The native Express ad view type
    private static final int NATIVE_EXPRESS_AD_VIEW_TYPE = 1;

    private final Context context;

    private final List<Object> recyclerViewItems;

    public RecyclerViewAdapter(Context context, List<Object> recyclerViewItems) {
        this.context = context;
        this.recyclerViewItems = recyclerViewItems;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType){
            case MENU_ITEM_VIEW_TYPE:









                default:
                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_container, parent, false);
                    return new MenuItemViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int viewType = getItemViewType(position);
        switch (viewType){
            case MENU_ITEM_VIEW_TYPE:
                default:
                    MenuItemViewHolder menuItemViewHolder = (MenuItemViewHolder) holder;
                    Pojo menuItem = (Pojo) recyclerViewItems.get(position);

                    //Get the menu item image resource ID
                    String imageName = menuItem.getImageName();
                    int imageResID = context.getResources().getIdentifier(imageName, "drawable",context.getPackageName());

                    //Add the menu item details to the menu item view
                    menuItemViewHolder.menuItemImage.setImageResource(imageResID);
                    menuItemViewHolder.menuItemPrice.setText(menuItem.getPrice());
                    menuItemViewHolder.menuItemName.setText(menuItem.getName());
                    menuItemViewHolder.menuItemDesc.setText(menuItem.getDescription());
                    menuItemViewHolder.menuItemCat.setText(menuItem.getCategory());
        }
    }

    @Override
    public int getItemCount() {
        return recyclerViewItems.size();
    }

    public class MenuItemViewHolder extends RecyclerView.ViewHolder{

        private TextView menuItemName;
        private TextView menuItemDesc;
        private TextView menuItemCat;
        private TextView menuItemPrice;
        private ImageView menuItemImage;

        public MenuItemViewHolder(View itemView) {
            super(itemView);

            menuItemCat = (TextView)itemView.findViewById(R.id.menuItemCategory);
            menuItemDesc = (TextView)itemView.findViewById(R.id.menuItemDesc);
            menuItemName = (TextView)itemView.findViewById(R.id.menuItemName);
            menuItemPrice = (TextView)itemView.findViewById(R.id.menuItemPrice);
            menuItemImage = (ImageView) itemView.findViewById(R.id.menuItemImage);
        }
    }
}
