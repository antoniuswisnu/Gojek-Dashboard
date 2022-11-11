package com.example.gojekdashboard.ui.home;
import com.example.gojekdashboard.R;

import java.util.ArrayList;

public class HomeData {

    private static String[] title = {
            "Go Ride",
            "Go Ride",
            "Go Ride",
            "Go Ride",
            "Go Ride",
            "Go Ride",
            "Go Ride",
            "Go Ride",
    };

    private static int[] image = {
            R.drawable.ride,
            R.drawable.ride,
            R.drawable.ride,
            R.drawable.ride,
            R.drawable.ride,
            R.drawable.ride,
            R.drawable.ride,
            R.drawable.ride,

    };


    static ArrayList<Home> getListDataSports() {
        ArrayList<Home> list = new ArrayList<>();
        for (int position = 0; position < title.length; position++) {
            Home news = new Home();
            news.setTitle(title[position]);
            news.setImage(image[position]);
            list.add(news);
        }
        return list;
    }



}
