package com.hetal.googleassistantsdkdemo;

import android.content.Context;

import com.google.auth.oauth2.UserCredentials;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mlghsava on 8/26/2017.
 */

public class Credentials_ {


    public static UserCredentials fromResource(Context context, int resourceId)
            throws IOException, JSONException {
        InputStream is = context.getResources().openRawResource(resourceId);
        byte[] bytes = new byte[is.available()];
        is.read(bytes);
        JSONObject json = new JSONObject(new String(bytes, "UTF-8"));
        return new UserCredentials(
                json.getString("client_id"),
                json.getString("client_secret"),
                json.getString("refresh_token")
        );
    }

}
