package io.github.burningdzire.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayScoreTeamA() {
        TextView t = (TextView) findViewById(R.id.score_team_a);
        t.setText(String.valueOf(scoreTeamA));
    }

    public void addThreePointsA(View view) {
        scoreTeamA += 3;
        displayScoreTeamA();
    }

    public void addTwoPointsA(View view) {
        scoreTeamA += 2;
        displayScoreTeamA();
    }

    public void addOnePointsA(View view) {
        scoreTeamA += 1;
        displayScoreTeamA();
    }

    public void displayScoreTeamB() {
        TextView t = (TextView) findViewById(R.id.score_team_b);
        t.setText(String.valueOf(scoreTeamB));
    }

    public void addThreePointsB(View view) {
        scoreTeamB += 3;
        displayScoreTeamB();
    }

    public void addTwoPointsB(View view) {
        scoreTeamB += 2;
        displayScoreTeamB();
    }

    public void addOnePointsB(View view) {
        scoreTeamB += 1;
        displayScoreTeamB();
    }

    public void resetScore(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreTeamA();
        displayScoreTeamB();
    }
}
