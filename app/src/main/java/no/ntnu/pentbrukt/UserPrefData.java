package no.ntnu.pentbrukt;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

import no.ntnu.pentbrukt.Client.RestClient;
import no.ntnu.pentbrukt.Interface.RestInterface;

public class UserPrefData {

    private static final String USER_PREF_DATA = "USER_PREF_DATA";
    private SharedPreferences userPrefData;
    private SharedPreferences.Editor userPrefDataEditor;

    public UserPrefData(Context context){
        this.userPrefData = context.getSharedPreferences(USER_PREF_DATA, Activity.MODE_PRIVATE);
        this.userPrefDataEditor = userPrefData.edit();
    }

    public String getToken()
    {
        return userPrefData.getString("token", "");
    }

    public void setToken(String token)
    {
        userPrefDataEditor.putString("token", token).commit();
    }

}
