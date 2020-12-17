package com.example.fitnesstrackerapp.Parser;

import android.os.AsyncTask;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;


import java.io.IOException;
import java.util.HashMap;

public class GetDirection extends AsyncTask<Object, String, String> {

    GoogleMap googleMap;
    String url, googleDirection, length, time;
    LatLng latLng;

    @Override
    protected String doInBackground(Object... objects) {
        googleMap = (GoogleMap) objects[0];
        url = (String) objects[1];
        latLng = (LatLng) objects[2];

        DownloadUrl getUrl = new  DownloadUrl();
        try {
            googleDirection = getUrl.readUrl(url);
        } catch (IOException e) {
            e.getMessage();
        }

        return googleDirection;
    }

    @Override
    protected void onPostExecute(String s) {
        HashMap<String, String> directionList;
        DataPars parser = new DataPars();
        directionList = parser.parseDirections(s);
        time = directionList.get("duration");
        length = directionList.get("distance");
        googleMap.clear();


    }
}
