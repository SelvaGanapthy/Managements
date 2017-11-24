package com.example.admin.management.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.management.R;
import com.example.admin.management.models.ApprovalsModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/22/2017.
 */

public class ApprovalsAdapter extends RecyclerView.Adapter<ApprovalsAdapter.ViewHolder> {
    Context context;
    List<ApprovalsModel> dataList;
    List<ApprovalsModel> filterList;
    View row;
    static AlertDialog alertDialog;


    public ApprovalsAdapter(List<ApprovalsModel> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
        this.filterList = dataList;
    }

    @Override
    public ApprovalsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        row = LayoutInflater.from(parent.getContext()).inflate(R.layout.approvals_adapter, parent, false);
        return new ViewHolder(row);
    }

    @Override
    public void onBindViewHolder(final ApprovalsAdapter.ViewHolder holder, final int position) {
        final AlertDialog.Builder alert = new AlertDialog.Builder(context);
        final ApprovalsModel approvalsmodel = filterList.get(position);
        holder.tv_approvalName.setText(approvalsmodel.getApprovalName());
//        holder.tv_amt.setText((int) approvalsmodel.getAmount());
        holder.tv_costCentreName.setText(approvalsmodel.getcostCentername());
        holder.tv_vendorName.setText(approvalsmodel.getVendorName());
        holder.id_switch.setTag(position);
        holder.id_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    alert.setPositiveButton("Allow", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(context, "Approved Sucessed", Toast.LENGTH_SHORT).show();
                            holder.id_switch.setChecked(true);
                        }
                    });
                    alert.setNegativeButton("Deny", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            holder.id_switch.setChecked(false);
                        }
                    });
                    alert.setTitle("\t\t\t\tGive Approvals");
                    alert.setMessage("Are you sure want to give approval for  " + approvalsmodel.getApprovalName());
                    alertDialog = alert.create();
                    alert.setCancelable(false);
                    alert.show();

                } else
                    Toast.makeText(context, "Approval Failure", Toast.LENGTH_SHORT).show();

            }
        });


    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_approvalName, tv_costCentreName, tv_poId, tv_date, tv_amt, tv_vendorName;
        SwitchCompat id_switch;


        public ViewHolder(View itemView) {
            super(itemView);
            tv_approvalName = (TextView) itemView.findViewById(R.id.tv_approvalName);
            tv_costCentreName = (TextView) itemView.findViewById(R.id.tv_costCentre);
            tv_poId = (TextView) itemView.findViewById(R.id.tv_poId);
            tv_date = (TextView) itemView.findViewById(R.id.tv_date);
            tv_amt = (TextView) itemView.findViewById(R.id.tv_amt);
            tv_vendorName = (TextView) itemView.findViewById(R.id.tv_vendorName);
            id_switch = (SwitchCompat) itemView.findViewById(R.id.id_switch);
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

                    ArrayList<ApprovalsModel> filteredList1 = new ArrayList<>();

                    for (ApprovalsModel dataModel : dataList) {

                        if (dataModel.getApprovalName().toLowerCase().contains(charString) || dataModel.getVendorName().toLowerCase().contains(charString)) {

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
                filterList = (ArrayList<ApprovalsModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }
}
