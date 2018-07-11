package io.github.burningdzire.quakereport;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import android.graphics.drawable.GradientDrawable;

public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {

    private static final String LOCATION_SEPARATOR = " of ";

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

        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        magnitudeView.setText(formatMagnitude(currentQuake.getmMagnitude()));

        String originalLocation = currentQuake.getmLocation();
        String primaryLocation, locationOffset;
        if (originalLocation.contains(LOCATION_SEPARATOR)) {

            String[] parts = originalLocation.split(LOCATION_SEPARATOR);
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            primaryLocation = parts[1];
        } else {

            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = originalLocation;
        }

        GradientDrawable magnitudeCircle = (GradientDrawable) magnitudeView.getBackground();
        int magnitudeColor = getMagnitudeColor(currentQuake.getmMagnitude());
        magnitudeCircle.setColor(magnitudeColor);

        TextView primaryLocationView = (TextView) listItemView.findViewById(R.id.primary_location);
        primaryLocationView.setText(primaryLocation);

        TextView locationOffsetView = (TextView) listItemView.findViewById(R.id.location_offset);
        locationOffsetView.setText(locationOffset);

        Date dateObject = new Date(currentQuake.getmTimeInMilliseconds());

        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        dateView.setText(formatDate(dateObject));

        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        timeView.setText(formatTime(dateObject));

        return listItemView;
    }

    private int getMagnitudeColor(double magnitude)
    {
        int magnitudeColorResourceID;
        int magnitudeFloor = (int) Math.floor(magnitude);
        switch (magnitudeFloor)
        {
            case 0:
            case 1: magnitudeColorResourceID = R.color.magnitude1;
                break;
            case 2: magnitudeColorResourceID = R.color.magnitude2;
                break;
            case 3: magnitudeColorResourceID = R.color.magnitude3;
            break;
            case 4: magnitudeColorResourceID = R.color.magnitude4;
                break;
            case 5: magnitudeColorResourceID = R.color.magnitude5;
                break;
            case 6: magnitudeColorResourceID = R.color.magnitude6;
                break;
            case 7: magnitudeColorResourceID = R.color.magnitude7;
                break;
            case 8: magnitudeColorResourceID = R.color.magnitude8;
                break;
            case 9: magnitudeColorResourceID = R.color.magnitude9;
                break;
            default: magnitudeColorResourceID = R.color.magnitude10plus;
                break;
        }
        return ContextCompat.getColor(getContext(), magnitudeColorResourceID);
    }

    private String formatMagnitude(double magnitude)
    {
        DecimalFormat formatter = new DecimalFormat("0.00");
        return formatter.format(magnitude);
    }

    private String formatDate (Date dateObject)
    {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM DD, yyyy");
        return dateFormatter.format(dateObject);
    }

    private String formatTime (Date dateObject)
    {
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a");
        return timeFormatter.format(dateObject);
    }
}
