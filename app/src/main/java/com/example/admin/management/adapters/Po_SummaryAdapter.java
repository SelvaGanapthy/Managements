package com.example.admin.management.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.example.admin.management.R;
import com.example.admin.management.fragments.PurchaseOrderSummary;
import com.example.admin.management.models.ApprovalsModel;
import com.example.admin.management.models.Po_SummaryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/23/2017.
 */

public class Po_SummaryAdapter extends RecyclerView.Adapter<Po_SummaryAdapter.ViewHolder> {
    List<Po_SummaryModel> dataList, filterList;
    PurchaseOrderSummary context;
    View row;

    public Po_SummaryAdapter(List<Po_SummaryModel> data, PurchaseOrderSummary context) {
        this.dataList = data;
        this.context = context;
        this.filterList = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.posummary_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Po_SummaryModel model = filterList.get(position);
        holder.tv_materialName.setText(model.getMaterialName());
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_materialName;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_materialName = (TextView) itemView.findViewById(R.id.tv_materialName);
        }
    }


    public Filter getFilter() {

        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();

                if (charString.isEmpty()) {

                    filterList = dataList;
                } else {

                    ArrayList<Po_SummaryModel> filteredList1 = new ArrayList<>();

                    for (Po_SummaryModel dataModel : dataList) {

                        if (dataModel.getMaterialName().toLowerCase().contains(charString)) {

                            filteredList1.add(dataModel);
                        }
                    }

                    filterList = filteredList1;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList = (ArrayList<Po_SummaryModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
