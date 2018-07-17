package io.github.burningdzire.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Color extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("weṭeṭṭi", "red", R.drawable.color_red));
        words.add(new Word("chokokki", "green", R.drawable.color_green));
        words.add(new Word("ṭakaakki", "brown", R.drawable.color_brown));
        words.add(new Word("ṭopoppi", "gray", R.drawable.color_gray));
        words.add(new Word("kululli", "black", R.drawable.color_black));
        words.add(new Word("kelelli", "white", R.drawable.color_white));
        words.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow));
        words.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow));

        WordAdapter itemAdapter = new WordAdapter(this, words);
        ListView listview = (ListView) findViewById(R.id.color);
        listview.setAdapter(itemAdapter);
    }
}
