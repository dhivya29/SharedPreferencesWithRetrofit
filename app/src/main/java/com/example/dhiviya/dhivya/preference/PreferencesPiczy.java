package com.example.dhiviya.dhivya.preference;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesPiczy implements PreferenceKeys {

    public static String getStringValue(Context context, String key) {
        String image_key= "";

        if (context != null && context.getSharedPreferences(KEY, Context.MODE_PRIVATE) != null) {
            SharedPreferences user_pref = context.getSharedPreferences(KEY, Context.MODE_PRIVATE);
            image_key = user_pref.getString(key, "");
        }
        return image_key;
    }

    public static void setStringValue(Context ctx, String key, String value) {
        if (ctx != null) {
            SharedPreferences.Editor edt = ctx.getSharedPreferences(KEY, Context.MODE_PRIVATE).edit();
            edt.putString(key, value);
            edt.commit();
        }
    }


}
