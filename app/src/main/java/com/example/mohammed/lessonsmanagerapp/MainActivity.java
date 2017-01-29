package com.example.mohammed.lessonsmanagerapp;

import android.os.Bundle;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.mohammed.lessonsmanagerapp.Adapters.LessonAdapter;

import layout.FragList;
import layout.info;


public class MainActivity extends FragmentActivity {
    private FragList mFragment;
    private info infofrag;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFragment = new FragList();

        infofrag=new info();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.container, mFragment);
        ft.commit();
    }
}
