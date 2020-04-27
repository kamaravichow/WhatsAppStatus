package com.aravi.statusmaster.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aravi.statusmaster.R;
import com.aravi.statusmaster.model.Status;
import com.balysv.materialripple.MaterialRippleLayout;
import com.bumptech.glide.Glide;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ProductViewHolder> {

    private final Context mCtx;
    private final List<Status> offerList;


    public ListAdapter(Context mCtx, List<Status> offerList) {
        this.mCtx = mCtx;
        this.offerList = offerList;
    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.item_status,
                parent, false);
        return new ProductViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        final Status status = offerList.get(position);
        Glide.with(mCtx).load(status.getName()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return offerList.size();
    }

    class ProductViewHolder extends RecyclerView.ViewHolder {

        final ImageView image;
        final TextView time;
        MaterialRippleLayout parent;

        private ProductViewHolder(View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.image_item);
            time = itemView.findViewById(R.id.name_item);
            parent = itemView.findViewById(R.id.parent_item);

        }
    }

}
