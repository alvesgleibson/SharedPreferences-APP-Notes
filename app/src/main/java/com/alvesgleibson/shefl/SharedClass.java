package com.alvesgleibson.shefl;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedClass {

    private Context context;
    private SharedPreferences.Editor editor;
    private SharedPreferences preferences;
    private final String KEY_SP = "values";
    private final String NAME_SP = "app_teste";

    public SharedClass(Context context){
        this.context = context;
        preferences = context.getSharedPreferences(NAME_SP,0);
        editor = preferences.edit();
    }

    public void SaveSP(String saveNotes){
        editor.putString(KEY_SP, saveNotes);
        editor.commit();
    }

    public String recoverSP(){
        String s = preferences.getString(KEY_SP,"");
        return s;
    }




}
