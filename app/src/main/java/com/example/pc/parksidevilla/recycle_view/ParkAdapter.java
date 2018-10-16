package com.example.pc.parksidevilla.recycle_view;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pc.parksidevilla.R;

import java.util.ArrayList;
import java.util.List;

public class ParkAdapter extends RecyclerView.Adapter<ParkAdapter.ParkViewHolder> {
    final private ListItemClickListener listItemClickListener;

    public interface ListItemClickListener{
        void onListItemClickListener(int clickIndex);
    }

    private Context context;
    private ArrayList<Product> products;

    public ParkAdapter(Context context, ArrayList<Product> products, ListItemClickListener listItemClickListener) {
        this.context = context;
        this.products = products;
        this.listItemClickListener = listItemClickListener;
    }

    @NonNull
    @Override
    public ParkViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        Context context = viewGroup.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.item_holder, viewGroup, false);
        ParkViewHolder parkViewHolder = new ParkViewHolder(view);

        return parkViewHolder;
    }

    @Override
    public void onBindViewHolder(ParkViewHolder holder, final int position) {
        holder.imageView.setImageResource(products.get(position).getImageView());
        holder.title.setText(products.get(position).getTitle());
        holder.cost.setText("" + products.get(position).getCost());
        holder.availability.setText(products.get(position).getAvailability());


    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ParkViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView title;
        TextView cost;
        TextView availability;
        Product product;
        public ParkViewHolder(View view){
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageid);
            title = (TextView) view.findViewById(R.id.title);
            cost = (TextView) view.findViewById(R.id.cost);
            availability = (TextView) view.findViewById(R.id.availability);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int clickPosition = getAdapterPosition();
            listItemClickListener.onListItemClickListener(clickPosition);
        }
    }
}
