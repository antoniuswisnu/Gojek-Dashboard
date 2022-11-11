package com.example.gojekdashboard.ui.orders;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.gojekdashboard.R;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class OrderDetail extends AppCompatActivity {

    TextView title, price;
    String txtTitle, txtPrice;
    int img_photo;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        Bundle bundle = getIntent().getExtras();
        txtTitle = bundle.getString("title");
        txtPrice= bundle.getString("price");
        img_photo = bundle.getInt("picture");

        title = findViewById(R.id.title);
        price = findViewById(R.id.price);
        img = findViewById(R.id.image);

        title.setText(txtTitle);
        price.setText(txtPrice);

        Glide.with(OrderDetail.this)
                .load(img_photo)
                .apply(new RequestOptions().override(370,370))
                .into(img);
    }
}