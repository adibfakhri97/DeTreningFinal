package com.detrening.detrening;

import android.content.ContentValues;
import android.content.Context;
import android.location.LocationManager;
import android.util.JsonReader;

import com.detrening.detrening.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zulfikaranshari on 18/09/2018.
 */

public class RemoteFetch {
    private String temp;
    private static String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org/data/2.5/weather?lat=-6.9&lon=107&units=metric";

    public static JSONObject getJSON(Context context){
        try {
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API));
            HttpURLConnection connection =
                    (HttpURLConnection)url.openConnection();

            connection.addRequestProperty("x-api-key",
                    context.getString(R.string.open_weather_maps_app_id));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuffer json = new StringBuffer(1024);
            String tmp="";
            while((tmp=reader.readLine())!=null)
                json.append(tmp).append("\n");
            reader.close();

            JSONObject data = new JSONObject(json.toString());

            // This value will be 404 if the request was not
            // successful
            if(data.getInt("cod") != 200){
                return null;
            }

            return data;
        }catch(Exception e){
            return null;
        }
    }
    private void getTemp() throws JSONException {
//        JsonReader curTemp = JSONObject();
    }
}
