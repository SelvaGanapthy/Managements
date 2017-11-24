package com.example.admin.management.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.TextView;

import com.example.admin.management.R;
import com.example.admin.management.fragments.PurchaseOrderDetails;
import com.example.admin.management.models.Po_DetailsModel;
import com.example.admin.management.models.Po_SummaryModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/24/2017.
 */

public class Po_DetailsAdapter extends RecyclerView.Adapter<Po_DetailsAdapter.ViewHolder> {
    List<Po_DetailsModel> dataList, filterList;
    PurchaseOrderDetails context;

    public Po_DetailsAdapter(List<Po_DetailsModel> dataList, PurchaseOrderDetails context) {
        this.dataList = dataList;
        this.filterList = dataList;
        this.context = context;
    }

    View row;

    @Override
    public Po_DetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.podetails_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(Po_DetailsAdapter.ViewHolder holder, int position) {

        Po_DetailsModel model = filterList.get(position);
        holder.tv_VendorName.setText(model.getVendorName());

    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_VendorName, tv_costCentre, tv_status;

        public ViewHolder(View itemView) {
            super(itemView);
            tv_VendorName = (TextView) itemView.findViewById(R.id.tv_VendorName);
            tv_costCentre = (TextView) itemView.findViewById(R.id.tv_costCentre);
            tv_status = (TextView) itemView.findViewById(R.id.tv_status);

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

                    ArrayList<Po_DetailsModel> filteredList1 = new ArrayList<>();

                    for (Po_DetailsModel dataModel : dataList) {

                        if (dataModel.getVendorName().toLowerCase().contains(charString)) {

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
                filterList = (ArrayList<Po_DetailsModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
