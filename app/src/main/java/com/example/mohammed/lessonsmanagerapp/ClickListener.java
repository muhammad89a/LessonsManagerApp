package com.example.mohammed.lessonsmanagerapp;
/**
 * Created by mohammed on 03/01/2017.
 */
import android.view.View;

public interface ClickListener {

    void onClick(View view, int position);

    void onLongClick(View view, int position);

}

