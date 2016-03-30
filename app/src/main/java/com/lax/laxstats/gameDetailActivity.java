package com.lax.laxstats;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class gameDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        FragmentManager fragmentManager = getFragmentManager();
        gameDetailFragment fragment = (gameDetailFragment) fragmentManager.findFragmentById(R.id.fragment_game_detail);
        if (fragment != null) {
            int position = 0;
            position = getIntent().getIntExtra("POSITION",0);
            fragment.loadPosition(position);
        }
    }

    int minutesPlayed = 0;
    int turnovers = 0;
    int causedTurnovers = 0;
    int fouls = 0;
    int assists = 0;
    int drawControls = 0;
    int groundBalls = 0;
    int shots = 0;
    int goals = 0;

    public void increaseTurnovers(View view) {
        turnovers++;
        display(turnovers,"turnovers");

    }
    public void decreaseTurnovers(View view) {
        if(turnovers  == 0)
            return;
        turnovers--;
        display(turnovers,"turnovers");
    }
    public void increaseMinutesPlayed(View view) {
        minutesPlayed++;
        display(minutesPlayed,"minutesPlayed");

    }
    public void decreaseMinutesPlayed(View view) {
        if(minutesPlayed  == 0)
            return;
        minutesPlayed--;
        display(minutesPlayed,"minutesPlayed");
    }
    public void increaseCausedTurnovers(View view) {
        causedTurnovers++;
        display(causedTurnovers,"causedTurnovers");

    }
    public void decreaseCausedTurnovers(View view) {
        if(causedTurnovers  == 0)
            return;
        causedTurnovers--;
        display(causedTurnovers,"causedTurnovers");
    }
    public void increaseFouls(View view) {
        fouls++;
        display(fouls,"fouls");

    }
    public void decreaseFouls(View view) {
        if(fouls  == 0)
            return;
        fouls--;
        display(fouls,"fouls");
    }
    public void increaseAssists(View view) {
        assists++;
        display(assists,"assists");

    }
    public void decreaseAssists(View view) {
        if(assists  == 0)
            return;
        assists--;
        display(assists,"assists");
    }
    public void increaseDrawControls(View view) {
        drawControls++;
        display(drawControls,"drawControls");

    }
    public void decreaseDrawControls(View view) {
        if(drawControls  == 0)
            return;
        drawControls--;
        display(drawControls,"drawControls");
    }
    public void increaseGroundBalls(View view) {
        groundBalls++;
        display(groundBalls,"groundBalls");

    }
    public void decreaseGroundBalls(View view) {
        if(groundBalls  == 0)
            return;
        groundBalls--;
        display(groundBalls,"groundBalls");
    }
    public void increaseShots(View view) {
        shots++;
        display(shots,"shots");

    }
    public void decreaseShots(View view) {
        if(shots  == 0)
            return;
        shots--;
        display(shots,"shots");
    }
    public void increaseGoals(View view) {
        goals++;
        display(goals,"goals");

    }
    public void decreaseGoals(View view) {
        if(goals  == 0)
            return;
        goals--;
        display(goals,"goals");
    }
    private void display(int number,String name) {
        FragmentManager fragmentManager = getFragmentManager();
        gameDetailFragment fragment = (gameDetailFragment) fragmentManager.findFragmentById(R.id.fragment_game_detail);
        if (fragment != null) {
            switch(name)
            {
                case "minutesPlayed":
                    TextView displayMinutesPlayed = (TextView) findViewById(R.id.MinutesPlayedNumber);
                    displayMinutesPlayed.setText("" + number);
                    break;
                case "turnovers":
                    TextView displayTurnovers = (TextView) findViewById(R.id.turnoversNumber);
                    displayTurnovers.setText("" + number);
                    break;
                case "causedTurnovers":
                    TextView displayCausedTurnovers = (TextView) findViewById(R.id.causedTurnoversNumber);
                    displayCausedTurnovers.setText("" + number);
                    break;
                case "fouls":
                    TextView displayFouls = (TextView) findViewById(R.id.foulsNumber);
                    displayFouls.setText("" + number);
                    break;
                case "assists":
                    TextView displayAssists = (TextView) findViewById(R.id.assistsNumber);
                    displayAssists.setText("" + number);
                    break;
                case "drawControls":
                    TextView displayDrawControls = (TextView) findViewById(R.id.drawControlsNumber);
                    displayDrawControls.setText("" + number);
                    break;
                case "groundBalls":
                    TextView displayGroundBalls = (TextView) findViewById(R.id.groundBallsNumber);
                    displayGroundBalls.setText("" + number);
                    break;
                case "shots":
                    TextView displayShots = (TextView) findViewById(R.id.shotsNumber);
                    displayShots.setText("" + number);
                    break;
                case "goals":
                    TextView displayGoals = (TextView) findViewById(R.id.goalsNumber);
                    displayGoals.setText("" + number);
                    break;

            }
        }
    }
}

