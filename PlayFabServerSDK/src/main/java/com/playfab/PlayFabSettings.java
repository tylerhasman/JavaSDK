package com.playfab;

import java.lang.StringBuilder;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.playfab.PlayFabErrors.ErrorCallback;

public class PlayFabSettings {
    public static String SdkVersion = "0.75.180906";
    public static String BuildIdentifier = "jbuild_javasdk__sdk-slave2016-3_0";
    public static String SdkVersionString = "JavaSDK-0.75.180906";

    public static Map<String, String> RequestGetParams;
    static {
        Map<String, String> getParams = new HashMap<String, String>();
        getParams.put("sdk", SdkVersionString);
        RequestGetParams = Collections.unmodifiableMap(getParams);
    }

    public static String TitleId = null; // You must set this value for PlayFabSdk to work properly (Found in the Game Manager for your title, at the PlayFab Website)
    public static ErrorCallback GlobalErrorHandler;
    public static String EntityToken = null; // Set by GetEntityToken
    public static String DeveloperSecretKey = null; // You must set this value for PlayFabSdk to work properly (Found in the Game Manager for your title, at the PlayFab Website)
    public static String ClientSessionTicket = null; // Set by any Client Login Call

    public static String GetURL(String apiCall) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://").append(TitleId).append(".playfabapi.com").append(apiCall);

        boolean firstParam = true;
        for (Map.Entry paramPair : RequestGetParams.entrySet()) {
            if (firstParam) {
                sb.append("?");
                firstParam = false;
            } else {
                sb.append("&");
            }
            sb.append(paramPair.getKey()).append("=").append(paramPair.getValue());
        }

        return sb.toString();
    }
}
