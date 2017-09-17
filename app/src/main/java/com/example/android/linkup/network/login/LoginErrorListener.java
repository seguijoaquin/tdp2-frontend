package com.example.android.linkup.network.login;


import android.util.Log;
import android.widget.Toast;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;

import java.io.UnsupportedEncodingException;

public class LoginErrorListener implements Response.ErrorListener {


    public LoginErrorListener() {
    }

    @Override
    public void onErrorResponse(VolleyError error) {


        if (error instanceof TimeoutError) {
            //Toast toast = Toast.makeText(context, "no hemos podido comunicarnos con el servidor", Toast.LENGTH_LONG);
            //toast.show();
        }

        NetworkResponse response = error.networkResponse;
        String body = "Nada por aqui";
        //get response body and parse with appropriate encoding
        if(response != null && response.data != null ) {
            try {
                body = new String(error.networkResponse.data,"UTF-8");
                Log.d("ServerResponse",body);

                int duration = Toast.LENGTH_LONG;
                //Toast toast = Toast.makeText(context, "Lo sentimos, su cuenta de facebook no cumple con los requisitos necesarios para acceder al sistema", duration);
                //toast.show();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }


}
