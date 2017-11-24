package com.example.admin.management.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.management.adapters.Po_DetailsAdapter;
import com.example.admin.management.R;
import com.example.admin.management.models.Po_DetailsModel;
import com.example.admin.management.models.Po_SummaryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/23/2017.
 */

public class PurchaseOrderDetails extends Fragment {
    RecyclerView rv;
    View view;
    Po_DetailsAdapter adapter;
    List<Po_DetailsModel> data = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.purchaseor_detailstab, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        adapter = new Po_DetailsAdapter(push(), PurchaseOrderDetails.this);
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return view;
    }


    public List<Po_DetailsModel> push() {
        String[] name = {"selva", "sathish", "balajisir", "Gokul", "sai"};
        for (int i = 0; i < name.length; i++) {
            Po_DetailsModel po_detailsModel = new Po_DetailsModel();
            po_detailsModel.setVendorName(name[i]);
            data.add(po_detailsModel);
        }
        return data;
    }

    public void search2(SearchView searchView1) {
        searchView1.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return true;
            }
        });
    }

}
