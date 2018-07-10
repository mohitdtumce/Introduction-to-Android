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
        words.add(new Word("weṭeṭṭi", "red"));
        words.add(new Word("chokokki", "green"));
        words.add(new Word("ṭakaakki", "brown"));
        words.add(new Word("ṭopoppi", "gray"));
        words.add(new Word("kululli", "black"));
        words.add(new Word("kelelli", "white"));
        words.add(new Word("ṭopiisә", "dusty yellow"));
        words.add(new Word("chiwiiṭә", "mustard yellow"));

        WordAdapter itemAdapter = new WordAdapter(this, words);
        ListView listview = (ListView) findViewById(R.id.color);
        listview.setAdapter(itemAdapter);
    }
}
