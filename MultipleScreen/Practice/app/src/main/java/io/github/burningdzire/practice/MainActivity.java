package io.github.burningdzire.practice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.view.View.OnClickListener;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView numberTextView = (TextView) findViewById(R.id.numberTextView);
        numberTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numberIntent = new Intent(MainActivity.this, Number.class);
                startActivity(numberIntent);
            }
        });


        TextView familyTextView = (TextView) findViewById(R.id.familyTextView);
        familyTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent familyIntent = new Intent(MainActivity.this, Family.class);
                startActivity(familyIntent);
            }
        });

        TextView colorTextView = (TextView) findViewById(R.id.colorTextView);
        colorTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent colorIntent = new Intent(MainActivity.this, Color.class);
                startActivity(colorIntent);
            }
        });


        TextView phrasesTextView = (TextView) findViewById(R.id.phrasesTextView);
        phrasesTextView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phrasesIntent = new Intent(MainActivity.this, Phrases.class);
                startActivity(phrasesIntent);
            }
        });
    }
}
