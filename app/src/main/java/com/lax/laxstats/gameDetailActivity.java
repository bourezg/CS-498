package com.lax.laxstats;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class gameDetailActivity extends Activity implements View.OnClickListener {
    game currGame;
    boolean running = false;
    private Chronometer chronometer;
    private Chronometer chronometer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_detail);

        chronometer = (Chronometer) findViewById(R.id.chronometer);
        chronometer2 = (Chronometer) findViewById(R.id.chronometer2);

        findViewById(R.id.start).setOnClickListener(this);
        findViewById(R.id.stop).setOnClickListener(this);


        FragmentManager fragmentManager = getFragmentManager();
        gameDetailFragment fragment = (gameDetailFragment) fragmentManager.findFragmentById(R.id.fragment_game_detail);
        if (fragment != null) {
            int position = 0;
            position = getIntent().getIntExtra("POSITION",0);
            fragment.loadPosition(position);    
            currGame = fragment.games.get(position);
            updateAll();
            displayName();
        }
    }
    @Override
    public void onPause(){
        super.onPause();
        gameListFragment.adapter.notifyDataSetChanged();

    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        gameListFragment.adapter.notifyDataSetChanged();

    }
    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.start:
                if (running) {
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    currGame.timer = 0;
                    break;
                }
                chronometer2.stop();
                if(currGame.timeSaved)
                    chronometer.setBase(currGame.timer-chronometer2.getBase()+SystemClock.elapsedRealtime());
                else
                    chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                running = true;
                break;

            case R.id.stop:
                currGame.timer = chronometer.getBase();
                currGame.timeSaved = true;
                running = false;
                chronometer.stop();
                chronometer2.setBase(SystemClock.elapsedRealtime());
                chronometer2.start();
                break;
        }
    }

    private void updateAll() {
        display(currGame.fouls, "fouls");
        display(currGame.assists, "assists");
        display(currGame.drawControls, "drawControlls");
        display(currGame.groundBalls,"groundBalls");
        display(currGame.shots,"shots");
        display(currGame.goals,"goals");
        display(currGame.causedTurnovers,"causedTurnovers");
        display(currGame.minutesPlayed,"minutesPlayed");
        display(currGame.turnovers, "turnovers");
        display(currGame.awayScore, "awayScore");
        display(currGame.homeScore, "homeScore");
    }


    public void increaseTurnovers(View view) {
        currGame.turnovers++;
        display(currGame.turnovers, "turnovers");

    }
    public void decreaseTurnovers(View view) {
        if(currGame.turnovers  == 0)
            return;
        currGame.turnovers--;
        display(currGame.turnovers,"turnovers");
    }
    public void increaseMinutesPlayed(View view) {
        currGame.minutesPlayed++;
        display(currGame.minutesPlayed,"minutesPlayed");

    }
    public void decreaseMinutesPlayed(View view) {
        if(currGame.minutesPlayed  == 0)
            return;
        currGame.minutesPlayed--;
        display(currGame.minutesPlayed,"minutesPlayed");
    }
    public void increaseCausedTurnovers(View view) {
        currGame.causedTurnovers++;
        display(currGame.causedTurnovers,"causedTurnovers");

    }
    public void decreaseCausedTurnovers(View view) {
        if(currGame.causedTurnovers  == 0)
            return;
        currGame.causedTurnovers--;
        display(currGame.causedTurnovers,"causedTurnovers");
    }
    public void increaseFouls(View view) {
        currGame.fouls++;
        display(currGame.fouls,"fouls");

    }
    public void decreaseFouls(View view) {
        if(currGame.fouls  == 0)
            return;
        currGame.fouls--;
        display(currGame.fouls,"fouls");
    }
    public void increaseAssists(View view) {
        currGame.assists++;
        display(currGame.assists,"assists");

    }
    public void decreaseAssists(View view) {
        if(currGame.assists  == 0)
            return;
        currGame.assists--;
        display(currGame.assists,"assists");
    }
    public void increaseDrawControls(View view) {
        currGame.drawControls++;
        display(currGame.drawControls,"drawControls");

    }
    public void decreaseDrawControls(View view) {
        if(currGame.drawControls  == 0)
            return;
        currGame.drawControls--;
        display(currGame.drawControls,"drawControls");
    }
    public void increaseGroundBalls(View view) {
        currGame.groundBalls++;
        display(currGame.groundBalls,"groundBalls");

    }
    public void decreaseGroundBalls(View view) {
        if(currGame.groundBalls  == 0)
            return;
        currGame.groundBalls--;
        display(currGame.groundBalls,"groundBalls");
    }
    public void increaseShots(View view) {
        currGame.shots++;
        display(currGame.shots,"shots");

    }
    public void decreaseShots(View view) {
        if(currGame.shots  == 0)
            return;
        currGame.shots--;
        display(currGame.shots,"shots");
    }
    public void increaseGoals(View view) {
        currGame.goals++;
        currGame.shots++;
        currGame.homeScore++;
        display(currGame.goals,"goals");
        display(currGame.shots,"shots");
        display(currGame.homeScore, "homeScore");

    }
    public void decreaseGoals(View view) {
        if(currGame.goals  == 0)
            return;
        currGame.goals--;
        currGame.shots--;
        currGame.homeScore--;

        display(currGame.goals,"goals");
        display(currGame.shots,"shots");
        display(currGame.homeScore, "homeScore");
    }

    public void increaseAwayScore(View view){
        currGame.awayScore++;
        display(currGame.awayScore, "awayScore");
    }
    public void decreaseAwayScore(View view){
        if(currGame.awayScore  == 0)
            return;
        currGame.awayScore--;
        display(currGame.awayScore, "awayScore");
    }
    public void increaseHomeScore(View view){
        currGame.homeScore++;
        display(currGame.homeScore, "homeScore");
    }
    public void decreaseHomeScore(View view){
        if(currGame.homeScore  == 0)
            return;
        currGame.homeScore--;
        display(currGame.homeScore, "homeScore");
    }

    private void displayName()
    {
        FragmentManager fragmentManager = getFragmentManager();
        gameDetailFragment fragment = (gameDetailFragment) fragmentManager.findFragmentById(R.id.fragment_game_detail);
        if (fragment != null) {
            EditText tv = (EditText) findViewById(R.id.editGameName);
            tv.setOnEditorActionListener(new TextView.OnEditorActionListener(){
                public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
                {
                    boolean handled = false;
                    if(i == EditorInfo.IME_ACTION_DONE)
                    {
                        String inputText = textView.getText().toString();
                        currGame.gameName = inputText;
                        Toast.makeText(gameDetailActivity.this,"Changed the game name to: "+ inputText, Toast.LENGTH_SHORT).show();

                        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);

                        handled = true;
                    }
                    return handled;
                }
            });
        }
        gameListFragment.adapter.notifyDataSetChanged();
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
                case "awayScore":
                    TextView displayAwayScore = (TextView) findViewById(R.id.awayScoreNumber);
                    displayAwayScore.setText("" + number);
                    break;
                case "homeScore":
                    TextView displayHomeScore = (TextView) findViewById(R.id.homeScoreNumber);
                    displayHomeScore.setText("" + number);
                    break;
            }
        }
    }
}

