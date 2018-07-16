package io.github.burningdzire.lifecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private String LOG_TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "onCreate() invoked");
    }

    public void startService(View view) {
        startService(new Intent(getBaseContext(), TestService.class));
    }

    public void stopService(View view) {
        stopService(new Intent(getBaseContext(), TestService.class));
    }
}
