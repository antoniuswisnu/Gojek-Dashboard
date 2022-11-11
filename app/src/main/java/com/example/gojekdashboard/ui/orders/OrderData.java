package com.example.gojekdashboard.ui.orders;

import com.example.gojekdashboard.R;

import java.util.ArrayList;

public class OrderData {


    private static String[] titleOrder= {
            "PaNas 2 Ayam Kimchi",
            "Triple Cheeseburger",
            "Spicy McNuggets",
            "Iced Coffee Italian Dolce",
            "Dark Choco McFlurry® with Crunch",
            "Paket Hantaran McD",
            "Happy Meal® Chicken Burger",
            "Family Time Bertiga Happy Meal Beef Burger",
            "Sundae Strawberry",
            "Apple Pie",
    };

    private static String[] priceOrder= {
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",
            "Rp153.500",

    };

    private static int[] imageOrder = {
            R.drawable.img,
            R.drawable.img_2,
            R.drawable.img_3,
            R.drawable.img_4,
            R.drawable.img_5,
            R.drawable.img_6,
            R.drawable.img_7,
            R.drawable.img_8,
            R.drawable.img_9,
            R.drawable.img_10,


    };

    static ArrayList<Order> getListDataOrder() {
        ArrayList<Order> list = new ArrayList<>();
        for (int position = 0; position < titleOrder.length; position++) {
            Order order = new Order();
            order.setTitle(titleOrder[position]);
            order.setPrice(priceOrder[position]);
            order.setImage(imageOrder[position]);
            list.add(order);
        }
        return list;
    }

}
