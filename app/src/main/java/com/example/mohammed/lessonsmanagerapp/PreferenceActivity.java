package com.example.mohammed.lessonsmanagerapp;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import com.example.mohammed.lessonsmanagerapp.Utils.PreferencesUtils;

public class PreferenceActivity extends AppCompatActivity {
    private Switch aSwitch;
    private RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preference);
        aSwitch = (Switch) findViewById(R.id.switch1);
        layout = (RelativeLayout) findViewById(R.id.activity_preference);
        layout.setBackgroundColor(Color.GREEN);
        boolean dark = PreferencesUtils.isDark(getApplication());

        if(dark) {
            layout.setBackgroundColor(Color.GREEN);
        }

        else {
            layout.setBackgroundColor(Color.BLUE);
        }


        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
              PreferencesUtils.setDarkBackground(getApplication(),PreferencesUtils.isDark(getApplication()));

            }
        });






    }

}
