package com.example.admin.management;

/**
 * Created by Admin on 11/22/2017.
 */

public class ApprovalsModel {
    String poId, costCentername, vendorName, approvalName;
    double amount;

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public String getcostCentername() {
        return costCentername;
    }

    public void setcostCentername(String costCentername) {
        this.costCentername = costCentername;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
