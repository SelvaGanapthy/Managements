package com.example.admin.management;

/**
 * Created by Admin on 11/22/2017.
 */

public class ApprovalsModel {
    String poId, callCentername, vendorName, approvalName;
    double amount;

    public String getPoId() {
        return poId;
    }

    public void setPoId(String poId) {
        this.poId = poId;
    }

    public String getCallCentername() {
        return callCentername;
    }

    public void setCallCentername(String callCentername) {
        this.callCentername = callCentername;
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
