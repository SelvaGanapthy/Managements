package com.example.admin.management.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.admin.management.R;
import com.example.admin.management.adapters.Ex_LabourStrengthAdapter;
import com.example.admin.management.adapters.Ex_MaterialIssueAdapter;
import com.example.admin.management.adapters.Ex_WorkProgressAdapter;
import com.example.admin.management.models.Ex_LaboutStrengthModel;
import com.example.admin.management.models.Ex_MaterialIssueModel;
import com.example.admin.management.models.Ex_WorkProgressModel;

import java.util.ArrayList;
import java.util.List;

public class Execution extends AppCompatActivity implements View.OnClickListener {
    Button bt_workProgress, bt_materialIssues, bt_labourStrength;
    LinearLayout id_layoutWorkprogress, id_layoutMaterialissue, id_layoutLabourstrength;
    RelativeLayout id_executionMain;
    RecyclerView rv_labourStrength, rv_materialIssue, rv_workProgress;
    Ex_WorkProgressAdapter progressAdapter;
    Ex_LabourStrengthAdapter labourAdapter;
    Ex_MaterialIssueAdapter materialAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_execution);
        initialize();
    }

    private void initialize() {
        id_layoutWorkprogress = (LinearLayout) findViewById(R.id.id_layoutWorkprogress);
        id_layoutMaterialissue = (LinearLayout) findViewById(R.id.id_layoutMaterialissue);
        id_layoutLabourstrength = (LinearLayout) findViewById(R.id.id_layoutLabourstrength);
        id_executionMain = (RelativeLayout) findViewById(R.id.id_executionMain);
        bt_workProgress = (Button) findViewById(R.id.bt_workProgress);
        bt_materialIssues = (Button) findViewById(R.id.bt_materialIssues);
        bt_labourStrength = (Button) findViewById(R.id.bt_labourStrength);
        rv_labourStrength = (RecyclerView) findViewById(R.id.rv_labourStrength);
        rv_materialIssue = (RecyclerView) findViewById(R.id.rv_materialIssue);
        rv_workProgress = (RecyclerView) findViewById(R.id.rv_workProgress);
        bt_workProgress.setOnClickListener(this);
        bt_materialIssues.setOnClickListener(this);
        bt_labourStrength.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_workProgress:
                id_layoutWorkprogress.setVisibility(View.VISIBLE);
                id_layoutMaterialissue.setVisibility(View.GONE);
                id_layoutLabourstrength.setVisibility(View.GONE);
                id_executionMain.setVisibility(View.GONE);
                workProgress();

                break;
            case R.id.bt_materialIssues:
                id_layoutWorkprogress.setVisibility(View.GONE);
                id_layoutMaterialissue.setVisibility(View.VISIBLE);
                id_layoutLabourstrength.setVisibility(View.GONE);
                id_executionMain.setVisibility(View.GONE);
                materialIssue();
                break;
            case R.id.bt_labourStrength:
                id_layoutWorkprogress.setVisibility(View.GONE);
                id_layoutMaterialissue.setVisibility(View.GONE);
                id_layoutLabourstrength.setVisibility(View.VISIBLE);
                id_executionMain.setVisibility(View.GONE);
                labourStrength();
                break;
        }
    }

    public void workProgress() {
        List<Ex_WorkProgressModel> data = new ArrayList<>();
        String[] specification = {"item1", "item2", "item3", "item4", "item5"};
        for (int i = 0; i < specification.length; i++) {
            Ex_WorkProgressModel model = new Ex_WorkProgressModel();
            model.setSpecification(specification[i]);
            data.add(model);
        }
        progressAdapter = new Ex_WorkProgressAdapter(data, Execution.this);
        progressAdapter.notifyDataSetChanged();

    }

    public void materialIssue() {
        List<Ex_MaterialIssueModel> data = new ArrayList<>();
        String[] materialName = {"item1", "item2", "item3", "item4", "item5"};
        for (int i = 0; i < materialName.length; i++) {
            Ex_MaterialIssueModel model = new Ex_MaterialIssueModel();
            model.setMaterialName(materialName[i]);
            data.add(model);
        }
        materialAdapter = new Ex_MaterialIssueAdapter(data, Execution.this);
        materialAdapter.notifyDataSetChanged();
    }

    public void labourStrength() {
        List<Ex_LaboutStrengthModel> data = new ArrayList<>();
        String[] labourType = {"item1", "item2", "item3", "item4", "item5"};
        for (int i = 0; i < labourType.length; i++) {
            Ex_LaboutStrengthModel model = new Ex_LaboutStrengthModel();
            model.setLabourStrength(labourType[i]);
            data.add(model);
        }
        labourAdapter = new Ex_LabourStrengthAdapter(data, Execution.this);
        labourAdapter.notifyDataSetChanged();
    }
}
