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

    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2018-01-01&endtime=2018-05-02&minfelt=50&minmagnitude=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EarthquakeAsyncTask task = new EarthquakeAsyncTask();
        task.execute(USGS_REQUEST_URL);
    }

    private void updateUI(Event earthquake) {
        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(earthquake.title);

        TextView perceivedStrengthView = (TextView) findViewById(R.id.perceived_strength);
        perceivedStrengthView.setText(earthquake.perceivedStrength);

        TextView numberOfPeopleView = (TextView) findViewById(R.id.no_of_people);
        numberOfPeopleView.setText(earthquake.numberOfPeople);
    }

    private class EarthquakeAsyncTask extends AsyncTask<String, Void, Event> {

        @Override
        protected Event doInBackground(String... urls) {

            if (urls.length < 1 || urls[0] == null)
                return null;

            return Utils.fetchEarthquakeData(urls[0]);
        }

        protected void onPostExecute(Event earthquake) {
            if (earthquake == null)
                return;
            updateUI(earthquake);
        }


    }
}
