package com.example.admin.management.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.management.R;
import com.example.admin.management.models.Ex_LaboutStrengthModel;
import com.example.admin.management.models.Ex_MaterialIssueModel;

import java.util.List;

/**
 * Created by Admin on 11/24/2017.
 */

public class Ex_LabourStrengthAdapter extends RecyclerView.Adapter<Ex_LabourStrengthAdapter.ViewHolder> {

    List<Ex_LaboutStrengthModel> dataList, filterList;
    Context context;
    View row;

    public Ex_LabourStrengthAdapter(List<Ex_LaboutStrengthModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        this.filterList = dataList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.ex_labourstrength_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Ex_LaboutStrengthModel model = filterList.get(position);
        holder.tv_labourType.setText(model.getLabourStrength());
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_labourType;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_labourType = (TextView) itemView.findViewById(R.id.tv_labourType);
        }
    }
}
