package com.example.gojekdashboard.ui.orders;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gojekdashboard.R;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {

    private final ArrayList<Order> listOrder;

    public ListAdapter(ArrayList<Order> listOrder) {
        this.listOrder = listOrder;
    }

    @NonNull
    @Override
    public ListAdapter.ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListAdapter.ListViewHolder holder, int position) {
        final Order news = listOrder.get(position);
        Glide.with(holder.itemView.getContext())
                .load(news.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvNamaMakanan.setText(news.getTitle());
        holder.tvHarga.setText(news.getPrice());

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), OrderDetail.class);
            Bundle bundle = new Bundle();

            bundle.putString("title", news.getTitle());
            bundle.putString("price", news.getPrice());
            bundle.putInt("picture", news.getImage());
            intent.putExtras(bundle);
            v.getContext().startActivity(intent);

            Toast.makeText(holder.itemView.getContext(), "" + listOrder.get(holder.getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return listOrder.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder{
        ImageView imgPhoto;
        TextView tvNamaMakanan, tvHarga;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.imgPhoto);
            tvNamaMakanan = itemView.findViewById(R.id.tvNamaMakanan);
            tvHarga = itemView.findViewById(R.id.tvHarga);
        }
    }
}

