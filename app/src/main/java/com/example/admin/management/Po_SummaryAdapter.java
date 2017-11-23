package com.example.admin.management;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Admin on 11/23/2017.
 */

public class Po_SummaryAdapter extends RecyclerView.Adapter<Po_SummaryAdapter.ViewHolder> {
    String[] data;
    PurchaseOrderSummary context;
    View row;

    public Po_SummaryAdapter(String[] data, PurchaseOrderSummary context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.approvals_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv_approvalName.setText(data[position]);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_approvalName;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_approvalName = (TextView) itemView.findViewById(R.id.tv_approvalName);
        }
    }
}
