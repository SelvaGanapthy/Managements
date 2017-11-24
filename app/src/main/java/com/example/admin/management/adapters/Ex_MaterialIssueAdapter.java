package com.example.admin.management.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.management.R;
import com.example.admin.management.models.Ex_MaterialIssueModel;
import com.example.admin.management.models.Ex_WorkProgressModel;

import java.util.List;

/**
 * Created by Admin on 11/24/2017.
 */

public class Ex_MaterialIssueAdapter extends RecyclerView.Adapter<Ex_MaterialIssueAdapter.ViewHolder> {
    List<Ex_MaterialIssueModel> dataList, filterList;
    Context context;
    View row;

    public Ex_MaterialIssueAdapter(List<Ex_MaterialIssueModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        this.filterList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ex_materialissue_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ex_MaterialIssueModel model  = filterList.get(position);
        holder.tv_materialName.setText(model.getMaterialName());
    }

    @Override
    public int getItemCount() {
        return  filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_materialName;
        public ViewHolder(View itemView) {
            super(itemView);
            tv_materialName=(TextView)itemView.findViewById(R.id.tv_materialName);
        }
    }
}
