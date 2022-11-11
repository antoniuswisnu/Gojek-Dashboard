package com.example.gojekdashboard.ui.orders;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gojekdashboard.MainActivity;
import com.example.gojekdashboard.R;
import com.example.gojekdashboard.databinding.FragmentOrdersBinding;

import java.util.ArrayList;

public class OrdersFragment extends Fragment {

    private FragmentOrdersBinding binding;
    private RecyclerView rvOrders;
    private ArrayList<Order> list = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        OrdersViewModel ordersViewModel =
                new ViewModelProvider(this).get(OrdersViewModel.class);

        binding = FragmentOrdersBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        rvOrders = root.findViewById(R.id.rvOrders);
//        rvOrders = rvOrders.findViewById(R.id.rvOrders);
        rvOrders.setHasFixedSize(true);
        list.addAll(OrderData.getListDataOrder());
        showRecyclerList();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void showRecyclerList(){
        rvOrders.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        ListAdapter listAdapter = new ListAdapter(list);
        rvOrders.setAdapter(listAdapter);
    }

}

