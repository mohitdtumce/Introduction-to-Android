package io.github.burningdzire.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<AndroidFlavor> androidFlavors = new ArrayList<AndroidFlavor>();
        androidFlavors.add(new AndroidFlavor("Donut", "1.6", R.drawable.donut));
        androidFlavors.add(new AndroidFlavor("Eclair", "2.0-2.1", R.drawable.eclair));
        androidFlavors.add(new AndroidFlavor("Froyo", "2.2-2.2.3", R.drawable.froyo));
        androidFlavors.add(new AndroidFlavor("GingerBread", "2.3-2.3.7", R.drawable.gingerbread));
        androidFlavors.add(new AndroidFlavor("Honeycomb", "3.0-3.2.6", R.drawable.honeycomb));
        androidFlavors.add(new AndroidFlavor("Ice Cream Sandwich", "4.0-4.0.4", R.drawable.icecream));
        androidFlavors.add(new AndroidFlavor("Jelly Bean", "4.1-4.3.1", R.drawable.jellybean));
        androidFlavors.add(new AndroidFlavor("KitKat", "4.4-4.4.4", R.drawable.kitkat));
        androidFlavors.add(new AndroidFlavor("Lollipop", "5.0-5.1.1", R.drawable.lollipop));
        androidFlavors.add(new AndroidFlavor("Marshmallow", "6.0-6.0.1", R.drawable.marshmallow));

        AndroidFlavorAdapter flavorAdapter = new AndroidFlavorAdapter(this, androidFlavors);
        ListView listview = (ListView) findViewById(R.id.listview_flavor);
        listview.setAdapter(flavorAdapter);
    }
}
