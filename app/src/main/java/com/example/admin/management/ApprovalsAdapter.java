package com.example.admin.management;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Admin on 11/22/2017.
 */

public class ApprovalsAdapter extends RecyclerView.Adapter<ApprovalsAdapter.ViewHolder> {
    String[] data;
    View row;

    public ApprovalsAdapter(String[] data) {
        this.data = data;
    }

    @Override
    public ApprovalsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.approvals_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(final ApprovalsAdapter.ViewHolder holder, final int position) {
        holder.checkBox.setTag(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.tab1_titletv.setVisibility(View.VISIBLE);
                holder.tab1_titletv.setText(data[position]);
            }
        });

        if (!holder.checkBox.isChecked())
        {
            holder.tab1_titletv.setVisibility(View.GONE);
            holder.tab1_titletv.setText(data[position]);
        }

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tab1_titletv;
        ImageView tab1_msgiv;
        CheckBox checkBox;

        public ViewHolder(View itemView) {
            super(itemView);
            tab1_titletv = (TextView) itemView.findViewById(R.id.tab1_titletv);
            tab1_msgiv = (ImageView) itemView.findViewById(R.id.tab1_mgs_iv);
            checkBox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}
