package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int scoreTeamA ;
    int scoreTeamB ;
    int foulsTeamA ;
    int foulsTeamB ;
    int cornersTeamA ;
    int cornersTeamB ;
    TextView scoreViewA;
    TextView scoreViewB;
    TextView foulsViewA;
    TextView foulsViewB;
    TextView cornersViewA;
    TextView cornersViewB;
    static final String STATE_SCORE_A = "team_score_A";
    static final String STATE_SCORE_B = "team_score_B";
    static final String STATE_FOULS_A = "fouls_team_A";
    static final String STATE_FOULS_B = "fouls_team_B";
    static final String STATE_CORNERS_A = "corners_team_A";
    static final String STATE_CORNERS_B = "corners_team_B";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore value of members from saved state
            scoreTeamA = savedInstanceState.getInt(STATE_SCORE_A);
            scoreTeamB = savedInstanceState.getInt(STATE_SCORE_B);
            foulsTeamA = savedInstanceState.getInt(STATE_FOULS_A);
            foulsTeamB = savedInstanceState.getInt(STATE_FOULS_B);
            cornersTeamA = savedInstanceState.getInt(STATE_CORNERS_A);
            cornersTeamB = savedInstanceState.getInt(STATE_CORNERS_B);
        }
        setContentView(R.layout.activity_main);
        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewA.setText(String.valueOf(scoreTeamA));
        scoreViewB = findViewById(R.id.team_b_score);
        //scoreViewB.setText(String.valueOf(scoreTeamB));
        displayForTeamB(scoreTeamB);
        foulsViewA = findViewById(R.id.fouls_team_A);
        foulsViewA.setText(String.valueOf(foulsTeamA));
        foulsViewB = findViewById(R.id.fouls_team_B);
        foulsViewB.setText(String.valueOf(foulsTeamB));
        cornersViewA = findViewById(R.id.corners_team_A);
        cornersViewA.setText(String.valueOf(cornersTeamA));
        cornersViewB = findViewById(R.id.corners_team_B);
        cornersViewB.setText(String.valueOf(cornersTeamB));
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(STATE_SCORE_A, scoreTeamA);
        savedInstanceState.putInt(STATE_SCORE_B, scoreTeamB);
        savedInstanceState.putInt(STATE_FOULS_A, foulsTeamA);
        savedInstanceState.putInt(STATE_FOULS_B, foulsTeamB);
        savedInstanceState.putInt(STATE_CORNERS_A, cornersTeamA);
        savedInstanceState.putInt(STATE_CORNERS_B, cornersTeamB);
        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }
    /**
     * Methods for each button
     * */
    public void goalA(View view) {
        scoreTeamA = scoreTeamA +1;
        scoreViewA.setText(String.valueOf(scoreTeamA));
    }
    public void foulsTeamA(View view) {
        foulsTeamA = foulsTeamA +1;
        foulsViewA.setText(String.valueOf(foulsTeamA));
    }
    public void cornerTeamA(View view) {
        cornersTeamA = cornersTeamA +1;
        cornersViewA.setText(String.valueOf(cornersTeamA));
    }
    public void goalB(View view) {
        scoreTeamB = scoreTeamB +1;
        //scoreViewB.setText(String.valueOf(scoreTeamB));
        displayForTeamB(scoreTeamB);
    }
    public void foulsTeamB(View view) {
        foulsTeamB = foulsTeamB + 1;
        foulsViewB.setText(String.valueOf(foulsTeamB));
    }
    public void cornerTeamB(View view) {
        cornersTeamB = cornersTeamB +1;
        cornersViewB.setText(String.valueOf(cornersTeamB));
    }
    /**
     * Reset button resets all textviews to 0
     * */
    public void reset(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        foulsTeamA = 0;
        foulsTeamB = 0;
        cornersTeamA = 0;
        cornersTeamB = 0;
        scoreViewA.setText(String.valueOf(scoreTeamA));
        foulsViewA.setText(String.valueOf(foulsTeamA));
        cornersViewA.setText(String.valueOf(cornersTeamA));
        //scoreViewB.setText(String.valueOf(scoreTeamB));
        displayForTeamB(scoreTeamB);
        foulsViewB.setText(String.valueOf(foulsTeamB));
        cornersViewB.setText(String.valueOf(cornersTeamB));
    }
    public void displayForTeamB(int score) {
        //TextView scoreView = findViewById(R.id.team_b_score);
        //scoreView.setText(String.valueOf(score));
        scoreViewB.setText(String.valueOf(score));
    }
}
