package com.example.admin.management;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by Admin on 11/23/2017.
 */

public class PurchaseOrderSummary extends Fragment {
    RecyclerView rv;
    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.purchaseor_summarytab, container, false);
        rv = (RecyclerView) view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(new Po_SummaryAdapter(new String[]{"ss1","ss1","ss1","ss1","ss1"},PurchaseOrderSummary.this));
        return view;
    }


}
