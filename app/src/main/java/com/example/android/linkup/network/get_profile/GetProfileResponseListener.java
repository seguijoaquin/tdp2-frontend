package com.example.android.linkup.network.get_profile;

import android.util.Log;

import com.android.volley.Response;
import com.example.android.linkup.models.Profile;
import com.example.android.linkup.network.NetworkErrorMessages;
import com.example.android.linkup.network.WebServiceManager;
import com.example.android.linkup.utils.JSONParser;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;


public class GetProfileResponseListener implements Response.Listener<JSONObject> {

    @Override
    public void onResponse(JSONObject response) {
        Profile profile = JSONParser.getProfile(response);
        if (profile != null) {
            EventBus.getDefault().post(new GetProfileSuccessEvent(profile));
        } else {
            Log.e(NetworkErrorMessages.GET_PROFILE_TAG, NetworkErrorMessages.NO_PROFILE_ERROR);
            EventBus.getDefault().post(new WebServiceManager.ErrorMessageEvent(NetworkErrorMessages.ERROR_COMMUNICATING_WITH_THE_SERVER));
        }
    }

    public static class GetProfileSuccessEvent {
        public Profile profile;
        public GetProfileSuccessEvent( Profile profile ) {
            this.profile = profile;
        }
    }
}
