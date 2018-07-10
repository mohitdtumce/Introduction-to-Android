package io.github.burningdzire.practice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Family extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("әpә", "father"));
        words.add(new Word("әṭa", "mother"));
        words.add(new Word("angsi", "son"));
        words.add(new Word("tune", "daughter"));
        words.add(new Word("taachi", "older brother"));
        words.add(new Word("chalitti", "younger brother"));
        words.add(new Word("teṭe", "older sister"));
        words.add(new Word("kolliti", "younger sister"));
        words.add(new Word("ama", "granadmother"));
        words.add(new Word("paapa", "grandfather"));

        WordAdapter itemAdapter = new WordAdapter(this, words);
        ListView listview = (ListView) findViewById(R.id.family);
        listview.setAdapter(itemAdapter);
    }
}
