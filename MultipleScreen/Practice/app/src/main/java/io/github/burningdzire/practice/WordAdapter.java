package io.github.burningdzire.practice;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    public WordAdapter(Context context, ArrayList<Word> words) {
        super(context, 0, words);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item_view, parent, false);
        }
        Word currentWord = getItem(position);
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwokTranslation);
        miwokTextView.setText(currentWord.getmMiwokTranslation());
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.defaultTranslation);
        defaultTextView.setText(currentWord.getmDefaultTranslation());
        return listItemView;
    }

}
