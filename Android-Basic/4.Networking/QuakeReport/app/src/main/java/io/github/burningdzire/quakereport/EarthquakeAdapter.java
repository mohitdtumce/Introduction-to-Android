package io.github.burningdzire.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.earthquake_list_item, parent, false);
        }

        Earthquake currentQuake = getItem(position);
        TextView magnitude = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitude.setText("" + currentQuake.getmMagnitude());
        TextView location = (TextView) listItemView.findViewById(R.id.location);
        location.setText(currentQuake.getmLocation());
        TextView dateTime = (TextView) listItemView.findViewById(R.id.date_time);
        dateTime.setText("" + currentQuake.getmTimeInMilliseconds());
        return listItemView;
    }
}
