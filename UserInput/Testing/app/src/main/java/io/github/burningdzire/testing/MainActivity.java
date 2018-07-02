package io.github.burningdzire.testing;

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
}
