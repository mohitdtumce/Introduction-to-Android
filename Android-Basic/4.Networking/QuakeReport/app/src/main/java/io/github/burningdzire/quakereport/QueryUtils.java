package io.github.burningdzire.quakereport;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public final class QueryUtils {

    public static final String LOG_TAG = QueryUtils.class.getSimpleName();

    public static ArrayList<Earthquake> fetchEarthquakes(String requestUrl) {

        URL url = createUrl(requestUrl);
        String jsonResponse = makeHttpRequest(url);

        ArrayList<Earthquake> earthquakes = new ArrayList<>();

        try {

            JSONObject rootJSON = new JSONObject(SAMPLE_JSON_RESPONSE);
            JSONArray earthquakeArray = rootJSON.getJSONArray("features");
            double magnitude;
            String location, url;
            long time;
            for (int i = 0; i < earthquakeArray.length(); i++) {
                JSONObject currentEarthquake = earthquakeArray.getJSONObject(i);
                JSONObject properties = currentEarthquake.getJSONObject("properties");
                magnitude = properties.getDouble("mag");
                location = properties.getString("place");
                time = properties.getLong("time");
                url = properties.getString("url");
                earthquakes.add(new Earthquake(magnitude, location, time, url));
            }

        } catch (JSONException e) {
            Log.e("QueryUtils", "Problem parsing the earthquake JSON results", e);
        }

        return earthquakes;
    }

    private static URL createUrl(String requestUrl) {
        URL url = null;
        try {
            url = new URL(requestUrl);
        } catch (MalformedURLException e) {
            Log.e(LOG_TAG, "Cannot create URL", e);
        }
        return url;
    }

    private static String makeHttpRequest(URL url) {
        HttpURLConnection urlConnection = null;
        String jsonResponse = null;
        try
        {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.
            urlConnection.setConnectTimeout(15000);

        }
        catch (IOException e)
        {

        }
    }
}
