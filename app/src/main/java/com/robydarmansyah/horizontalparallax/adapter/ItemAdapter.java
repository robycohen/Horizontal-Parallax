package com.robydarmansyah.horizontalparallax.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.robydarmansyah.horizontalparallax.R;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list;
    private static final int VIEW_COVER = 1;
    private static final int VIEW_ITEM = 2;

    public ItemAdapter(List<String> l) {
        this.list = l;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == VIEW_COVER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cover, parent, false);
            return new EmptyViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
            return new ItemViewHolder(view);
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).deskTxt.setText(list.get(position));
        }

    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView deskTxt;

        public ItemViewHolder(View itemView) {
            super(itemView);
            deskTxt = (TextView) itemView.findViewById(R.id.deskTxt);
        }
    }

    public class EmptyViewHolder extends RecyclerView.ViewHolder {
        public EmptyViewHolder(View itemView) {
            super(itemView);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return position == 0 ? VIEW_COVER : VIEW_ITEM;
    }

}
