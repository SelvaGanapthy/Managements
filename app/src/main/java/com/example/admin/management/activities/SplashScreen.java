package com.example.admin.management.activities;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;
import com.example.admin.management.R;


public class SplashScreen extends AppCompatActivity {
    public static final int requestcode_permisson = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (checkPermisson())
            splash();
        else
            requestPermission();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public boolean checkPermisson() {
        int result = ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.INTERNET);
        return (result == PackageManager.PERMISSION_GRANTED);

    }

    public void requestPermission() {
        ActivityCompat.requestPermissions(SplashScreen.this, new String[]{Manifest.permission.INTERNET}, requestcode_permisson);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case requestcode_permisson:
                if (grantResults.length > 0) {
                    boolean InternetPermisson = grantResults[0] == PackageManager.PERMISSION_DENIED;
                    if (InternetPermisson) {
                        Toast.makeText(getApplicationContext(), "Permission denied", Toast.LENGTH_SHORT).show();
                        requestPermission();
                    } else
                        splash();
                }
                break;
        }
    }


    public void splash() {
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
