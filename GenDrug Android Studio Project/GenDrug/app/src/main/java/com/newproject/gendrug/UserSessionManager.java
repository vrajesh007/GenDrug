package com.newproject.gendrug;

import android.content.Context;
import android.content.SharedPreferences;

import com.newproject.gendrug.ApiHelper.JsonField;

public class UserSessionManager {

    private static final String MY_PREF = "user_pref";
    private static final String IS_LOGIN = "is_login";

    Context mContext;
    SharedPreferences mSharedPreferences;


    private final SharedPreferences.Editor mEditor;

    public UserSessionManager(Context mContext) {
        this.mContext = mContext;
        mSharedPreferences = mContext.getSharedPreferences(MY_PREF,Context.MODE_PRIVATE);
        mEditor = mSharedPreferences.edit();

    }

    public void setLoginStatus() {
        mEditor.putBoolean(IS_LOGIN, true).commit();
    }

    public boolean getLoginStatus() {
        return mSharedPreferences.getBoolean(IS_LOGIN, false);
    }

    public void setUserDetails(String U_id, String U_name, String Gender, String DOB, String Phonenum, String Email, String Address, String Password) {
        mEditor.putString(JsonField.KEY_USER_ID, U_id);
        mEditor.putString(JsonField.KEY_USER_NAME, U_name);
        mEditor.putString(JsonField.KEY_USER_GENDER, Gender);
        mEditor.putString(JsonField.KEY_USER_EMAIL, Email);
        mEditor.putString(JsonField.KEY_USER_MOBILE_NUMBER, Phonenum);
        mEditor.putString(JsonField.KEY_USER_DOB, DOB);
        mEditor.putString(JsonField.KEY_USER_ADDRESS, Address);
        mEditor.putString(JsonField.KEY_USER_PASSWORD, Password);
        mEditor.commit();
    }




}
