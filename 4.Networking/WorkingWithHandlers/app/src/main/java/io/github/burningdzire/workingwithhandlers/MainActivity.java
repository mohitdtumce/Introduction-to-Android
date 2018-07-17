package io.github.burningdzire.workingwithhandlers;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        textView = (TextView) findViewById(R.id.text_view);
    }

    public void startProgress(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 10; i++) {
                    final int value = i;
                    doFakeWork();
                    progressBar.post(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText("Updating");
                            progressBar.setProgress(value);
                        }
                    });
                }
            }
        };
        new Thread(runnable).start();
    }

    private void doFakeWork() {
        SystemClock.sleep(1000);
    }
}
