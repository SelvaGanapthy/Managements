package com.example.admin.management.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.example.admin.management.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    RelativeLayout layout_login, layout_getclient, layout_verifypending;
    Button btn_Login, btn_getClient, btn_pending;
    EditText edtUsername, edtPassword, edtUsernameCL, edtClientname, edtMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialize();
    }

    private void initialize() {
        layout_getclient = (RelativeLayout) findViewById(R.id.layout_getclient);
        layout_login = (RelativeLayout) findViewById(R.id.layout_login);
        layout_verifypending = (RelativeLayout) findViewById(R.id.layout_verifypending);
        edtUsername = (EditText) findViewById(R.id.edtUsername);
        edtPassword = (EditText) findViewById(R.id.edtPassword);
        edtUsernameCL = (EditText) findViewById(R.id.edtUsernameCL);
        edtClientname = (EditText) findViewById(R.id.edtClientname);
        edtMobile = (EditText) findViewById(R.id.edtMobile);
        btn_Login = (Button) findViewById(R.id.btn_login);
        btn_getClient = (Button) findViewById(R.id.btn_getClient);
        btn_pending = (Button) findViewById(R.id.btn_pending);
        btn_getClient.setOnClickListener(this);
        btn_pending.setOnClickListener(this);
        btn_Login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_getClient:
                layout_getclient.setVisibility(View.GONE);
                layout_verifypending.setVisibility(View.VISIBLE);
                layout_login.setVisibility(View.GONE);
                break;
            case R.id.btn_pending:
                layout_getclient.setVisibility(View.GONE);
                layout_verifypending.setVisibility(View.GONE);
                layout_login.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_login:
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
