package com.example.mohammed.lessonsmanagerapp;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import layout.Imagefragmet;

public class DownloadImage extends AppCompatActivity {
    private Imagefragmet imagefragmet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_image);

        imagefragmet = new Imagefragmet();


        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.content, imagefragmet);
        ft.commit();




    }
}
