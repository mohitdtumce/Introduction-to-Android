package io.github.burningdzire.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int scoreTeamA = 0;

    //    int scoreTeamB = 0;


    public void displayScoreTeamA() {
        TextView t = (TextView) findViewById(R.id.team_a_score);
        t.setText(scoreTeamA);
    }
//    public void displayScoreTeamB()
//    {
//        TextView t = (TextView) findViewById(R.id.score_teamB);
//        t.setText(scoreTeamB);
//    }
}
