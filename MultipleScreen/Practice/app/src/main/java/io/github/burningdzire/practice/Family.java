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
        words.add(new Word("әpә", "father", R.drawable.family_father));
        words.add(new Word("әṭa", "mother", R.drawable.family_mother));
        words.add(new Word("angsi", "son", R.drawable.family_son));
        words.add(new Word("tune", "daughter", R.drawable.family_daughter));
        words.add(new Word("taachi", "older brother", R.drawable.family_older_brother));
        words.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother));
        words.add(new Word("teṭe", "older sister", R.drawable.family_older_sister));
        words.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister));
        words.add(new Word("ama", "granadmother", R.drawable.family_grandfather));
        words.add(new Word("paapa", "grandfather", R.drawable.family_grandmother));

        WordAdapter itemAdapter = new WordAdapter(this, words);
        ListView listview = (ListView) findViewById(R.id.family);
        listview.setAdapter(itemAdapter);
    }
}
