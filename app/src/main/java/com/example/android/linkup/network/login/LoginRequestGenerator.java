package com.example.android.linkup.network.login;

import android.content.Context;

import com.android.volley.Request;
import com.example.android.linkup.network.Command;
import com.example.android.linkup.network.CustomJsonObjectRequest;
import com.example.android.linkup.network.NetworkConfiguration;

import org.json.JSONObject;


public class LoginRequestGenerator {
    private static final int GET_PROFILE_METHOD = Request.Method.GET;
    private static final String PROFILE_ENDPOINT = "/login";

    public static Request generate (Command onSuccessCommand, Command onErrorCommand, Context c) {
        String url = NetworkConfiguration.getInstance().serverAddr;
        url += PROFILE_ENDPOINT;
        JSONObject obj = new JSONObject();
        LoginErrorListener errorListener = new LoginErrorListener(onErrorCommand,c);
        LoginResponseListener responseListener = new LoginResponseListener(onSuccessCommand);
        CustomJsonObjectRequest request = new CustomJsonObjectRequest(GET_PROFILE_METHOD, url, obj, responseListener, errorListener);
        return request;
    }


}
