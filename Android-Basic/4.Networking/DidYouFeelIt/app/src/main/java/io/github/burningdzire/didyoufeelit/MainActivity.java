package io.github.burningdzire.didyoufeelit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String USGS_REQUEST_URL = "https://earthquake.usgs.gov/fdsnws/event/1/query?format=geojson&starttime=2016-01-01&endtime=2016-05-02&minfelt=50&minmagnitude=5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Event earthquake = Utils.fetchEarthquakeData(USGS_REQUEST_URL);
        updateUI(earthquake);
    }

    private void updateUI(Event earthquake) {
        TextView titleView = (TextView) findViewById(R.id.title);
        titleView.setText(earthquake.title);
        TextView perceivedStrengthView = (TextView) findViewById(R.id.perceived_strength);
        perceivedStrengthView.setText(earthquake.perceivedStrength);
        TextView numberOfPeopleView = (TextView) findViewById(R.id.no_of_people);
        numberOfPeopleView.setText(earthquake.numberOfPeople);
    }
}
