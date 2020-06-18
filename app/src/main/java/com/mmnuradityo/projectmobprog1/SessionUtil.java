package com.mmnuradityo.projectmobprog1;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionUtil {
    Context context;
    SharedPreferences sharedPreferences;

    public SessionUtil(Context context) {
        this.context = context;

        String name = this.context.getPackageName();

        sharedPreferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
    }

    public static SessionUtil init(Context context){
        return new SessionUtil(context);
    }

    public SessionUtil set(String key, boolean value){
        sharedPreferences.edit().clear().apply();
        sharedPreferences.edit().putBoolean(key, value).apply();
        return this;
    }

    public Boolean getBoolean(String key){
        return sharedPreferences.getBoolean(key, false);
    }

    public SessionUtil set(String key, String value){
        sharedPreferences.edit().clear().apply();
        sharedPreferences.edit().putString(key, value).apply();
        return this;
    }

    public String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    public SessionUtil set(String key, int value){
        sharedPreferences.edit().clear().apply();
        sharedPreferences.edit().putInt(key, value).apply();
        return this;
    }

    public Integer getInt(String key){
        return sharedPreferences.getInt(key, 0);
    }

    public void registerPreference(SharedPreferences.OnSharedPreferenceChangeListener listener){
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener);
    }

    public void unregisterPreference(SharedPreferences.OnSharedPreferenceChangeListener listener){
        sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener);
    }
}
