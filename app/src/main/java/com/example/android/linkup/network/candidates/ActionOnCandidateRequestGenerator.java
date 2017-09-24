package com.example.android.linkup.network.candidates;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.android.linkup.network.CustomJsonObjectRequest;
import com.example.android.linkup.network.NetworkConfiguration;
import com.example.android.linkup.network.NetworkErrorMessages;
import com.example.android.linkup.network.WebServiceManager;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

public class ActionOnCandidateRequestGenerator {

    private static final int REJECT_CANDIDATE_METHODS = Request.Method.PUT;

    public static Request generate(String id, String action) {
        String url = NetworkConfiguration.getInstance().serverAddr;
        url += "/user/" + id + "/link" ;
        JSONObject obj = new JSONObject();
        try {
            obj.put("action",action);
        } catch (Exception e) {
            Log.e(NetworkErrorMessages.CANDIDATES_TAG, e.getMessage());
        }
        Response.Listener responseListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
            }
        };
        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(NetworkErrorMessages.CANDIDATES_TAG, error.getMessage());
                EventBus.getDefault().post(new WebServiceManager.ErrorMessageEvent(NetworkErrorMessages.ERROR_COMMUNICATING_WITH_THE_SERVER));
            }
        };
        CustomJsonObjectRequest request = new CustomJsonObjectRequest(REJECT_CANDIDATE_METHODS, url, obj, responseListener, errorListener);
        return request;
    }
}
