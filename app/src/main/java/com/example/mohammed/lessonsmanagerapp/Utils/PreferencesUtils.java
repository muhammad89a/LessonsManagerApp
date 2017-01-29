package com.example.mohammed.lessonsmanagerapp.Utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mohammed on 27/01/2017.
 */

public class PreferencesUtils {

    private static final String SHARED_PREFERENCES_FILE_NAME = "SharedPreferences";
    private static final String SETTINGS_BACKGROUND_DARK = "settings_background_dard";

    public static void setDarkBackground(Context context, boolean dark) {
        SharedPreferences preferences =  context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME,
                Context.MODE_PRIVATE);
        preferences.edit().putBoolean(SETTINGS_BACKGROUND_DARK, dark).apply();
    }

    public static boolean isDark(Context context) {
        SharedPreferences  preferences =  context.getSharedPreferences(SHARED_PREFERENCES_FILE_NAME,
                Context.MODE_PRIVATE);
        return preferences.getBoolean(SETTINGS_BACKGROUND_DARK,true);
    }

}