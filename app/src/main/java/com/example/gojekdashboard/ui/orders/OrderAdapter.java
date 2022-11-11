package com.example.gojekdashboard.ui.orders;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gojekdashboard.R;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ListViewHolder> {

    private final ArrayList<Order> listOrder;

    public OrderAdapter (ArrayList<Order> list) {
        this.listOrder = list;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_order, viewGroup, false);
        return new ListViewHolder(view);
    }

//    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final Order news = listOrder.get(position);
        Glide.with(holder.itemView.getContext())
                .load(news.getImage())
                .apply(new RequestOptions().override(55, 55))
                .into(holder.imgPhoto);
        holder.tvNamaMakanan.setText(news.getTitle());
//        holder.tvDetail.setText(news.getDesc());

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

    public static class ListViewHolder extends RecyclerView.ViewHolder {
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
