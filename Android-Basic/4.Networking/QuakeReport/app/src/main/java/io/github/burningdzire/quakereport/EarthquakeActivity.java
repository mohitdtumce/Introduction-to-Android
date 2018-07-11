package io.github.burningdzire.quakereport;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class EarthquakeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.earthquake_activity);

        ArrayList<Earthquake> earthquakes = new ArrayList<>();
        earthquakes.add(new Earthquake(7.2, "San Francisco", 1023));
        earthquakes.add(new Earthquake(7.2, "San Francisco", 1023));
        earthquakes.add(new Earthquake(7.2, "San Francisco", 1023));
        earthquakes.add(new Earthquake(7.2, "San Francisco", 1023));
        earthquakes.add(new Earthquake(7.2, "San Francisco", 1023));
        earthquakes.add(new Earthquake(7.2, "San Francisco", 1023));
        earthquakes.add(new Earthquake(7.2, "San Francisco", 1023));

        EarthquakeAdapter itemAdapter = new EarthquakeAdapter(this, earthquakes);
        ListView earthquakeListView  = (ListView) findViewById(R.id.list);
        earthquakeListView.setAdapter(itemAdapter);
    }
}
