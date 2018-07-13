package io.github.burningdzire.didyoufeelit;

import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class Utils {
    public static final String LOG_TAG = Utils.class.getSimpleName();

    public static Event fetchEarthquakeData(String requestUrl) {
        URL url = createUrl(requestUrl);
        String jsonResponse = makeHttpRequest(url);
        return extractFeaturesFromJson(jsonResponse);
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
        String jsonResponse = "";
        if (url == null) {
            return null;
        }

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        try {
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setReadTimeout(10000/*In milliseconds*/);
            urlConnection.setConnectTimeout(15000/*In milliseconds*/);
            urlConnection.connect();

            if (urlConnection.getResponseCode() == 200) {
                inputStream = urlConnection.getInputStream();
                jsonResponse = readFromStream(inputStream);
            } else {
                Log.e(LOG_TAG, "Error response code: " + urlConnection.getResponseCode());
            }
        } catch (IOException e) {
            Log.e(LOG_TAG, "Problem retrieving JSON results", e);
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                Log.e(LOG_TAG, "Cannot close input stream");
            }
        }
        return jsonResponse;
    }

    private static String readFromStream(InputStream inputStream) {
        StringBuilder output = new StringBuilder();
        if (inputStream != null) {
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, Charset.forName("UTF-8"));
            BufferedReader reader = new BufferedReader(inputStreamReader);
            try {
                String line = reader.readLine();
                while (line != null) {
                    output.append(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                Log.e(LOG_TAG, "Cannot read lines", e);
            }
        }
        return output.toString();
    }

    private static Event extractFeaturesFromJson(String earthquakeJson) {
        if (TextUtils.isEmpty(earthquakeJson))
            return null;

        try {
            JSONObject root = new JSONObject(earthquakeJson);
            JSONArray featureArray = root.getJSONArray("features");
            if (featureArray.length() > 0) {
                JSONObject firstFeature = featureArray.getJSONObject(0);
                JSONObject properties = firstFeature.getJSONObject("properties");
                String title = properties.getString("title");
                String numberOfPeople = properties.getString("felt");
                String perveivedStrength = properties.getString("cdi");
                return new Event(title, perveivedStrength, numberOfPeople);
            }
        } catch (JSONException e) {
            Log.e(LOG_TAG, "Cannot extract features", e);
        }
        return null;
    }
}
