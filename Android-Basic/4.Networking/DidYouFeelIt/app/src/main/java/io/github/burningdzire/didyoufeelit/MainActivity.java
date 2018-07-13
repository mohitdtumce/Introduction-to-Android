package io.github.burningdzire.didyoufeelit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.TextView;

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

public class MainActivity extends AppCompatActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();
    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute();
    }

    private void updateUI(Event earthquake) {
        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(earthquake.title);

        TextView perceivedStrengthView = (TextView) findViewById(R.id.perceived_strength);
        perceivedStrengthView.setText(earthquake.perceivedStrength);

        TextView numberOfPeopleView = (TextView) findViewById(R.id.no_of_people);
        numberOfPeopleView.setText(earthquake.numberOfPeople);
    }

    private class EarthquakeAsyncTask extends AsyncTask<URL, Void, Event> {

        @Override
        protected Event doInBackground(URL... requestUrl) {
            URL url = createUrl(USGS_REQUEST_URL);
            String jsonResponse = makeHttpRequest(url);
            return extractFeaturesFromJson(jsonResponse);
        }

        protected void onPostExecute(Event earthquake) {
            if (earthquake == null)
                return;
            updateUI(earthquake);
        }

        private URL createUrl(String requestUrl) {
            URL url = null;
            try {
                url = new URL(requestUrl);
            } catch (MalformedURLException e) {
                Log.e(LOG_TAG, "Cannot create URL", e);
            }
            return url;
        }

        private String makeHttpRequest(URL url) {
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

        private String readFromStream(InputStream inputStream) {
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

        private Event extractFeaturesFromJson(String earthquakeJson) {
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
}
