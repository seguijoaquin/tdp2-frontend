package com.example.android.linkup.network;

public class NetworkConfiguration {
    public static final String SERVER_REQUEST_ERROR = "ERROR AL CONECTARSE CON EL SERVER" ;
    public String serverAddr;
    public String accessToken;
    private static NetworkConfiguration instance;


    private NetworkConfiguration() {
    }

    public static NetworkConfiguration getInstance() {
        if ( instance == null ) {
            instance = new NetworkConfiguration();
        }
        return instance;
    }
}
