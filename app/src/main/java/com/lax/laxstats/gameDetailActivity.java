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

import java.util.Calendar;
import java.util.List;


public class gameDetailActivity extends Activity implements View.OnClickListener {
    game p;
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
            p = fragment.games.get(position);
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
                    p.timer = 0;
                    break;
                }
                chronometer2.stop();
                if(p.timeSaved)
                    chronometer.setBase(p.timer-chronometer2.getBase()+SystemClock.elapsedRealtime());
                else
                    chronometer.setBase(SystemClock.elapsedRealtime());
                chronometer.start();
                running = true;
                break;

            case R.id.stop:
                p.timer = chronometer.getBase();
                p.timeSaved = true;
                running = false;
                chronometer.stop();
                chronometer2.setBase(SystemClock.elapsedRealtime());
                chronometer2.start();
                break;
        }
    }

    private void updateAll() {
        display(p.fouls, "fouls");
        display(p.assists, "assists");
        display(p.drawControls, "drawControlls");
        display(p.groundBalls,"groundBalls");
        display(p.shots,"shots");
        display(p.goals,"goals");
        display(p.causedTurnovers,"causedTurnovers");
        display(p.minutesPlayed,"minutesPlayed");
        display(p.turnovers, "turnovers");
    }


    public void increaseTurnovers(View view) {
        p.turnovers++;
        display(p.turnovers, "turnovers");

    }
    public void decreaseTurnovers(View view) {
        if(p.turnovers  == 0)
            return;
        p.turnovers--;
        display(p.turnovers,"turnovers");
    }
    public void increaseMinutesPlayed(View view) {
        p.minutesPlayed++;
        display(p.minutesPlayed,"minutesPlayed");

    }
    public void decreaseMinutesPlayed(View view) {
        if(p.minutesPlayed  == 0)
            return;
        p.minutesPlayed--;
        display(p.minutesPlayed,"minutesPlayed");
    }
    public void increaseCausedTurnovers(View view) {
        p.causedTurnovers++;
        display(p.causedTurnovers,"causedTurnovers");

    }
    public void decreaseCausedTurnovers(View view) {
        if(p.causedTurnovers  == 0)
            return;
        p.causedTurnovers--;
        display(p.causedTurnovers,"causedTurnovers");
    }
    public void increaseFouls(View view) {
        p.fouls++;
        display(p.fouls,"fouls");

    }
    public void decreaseFouls(View view) {
        if(p.fouls  == 0)
            return;
        p.fouls--;
        display(p.fouls,"fouls");
    }
    public void increaseAssists(View view) {
        p.assists++;
        display(p.assists,"assists");

    }
    public void decreaseAssists(View view) {
        if(p.assists  == 0)
            return;
        p.assists--;
        display(p.assists,"assists");
    }
    public void increaseDrawControls(View view) {
        p.drawControls++;
        display(p.drawControls,"drawControls");

    }
    public void decreaseDrawControls(View view) {
        if(p.drawControls  == 0)
            return;
        p.drawControls--;
        display(p.drawControls,"drawControls");
    }
    public void increaseGroundBalls(View view) {
        p.groundBalls++;
        display(p.groundBalls,"groundBalls");

    }
    public void decreaseGroundBalls(View view) {
        if(p.groundBalls  == 0)
            return;
        p.groundBalls--;
        display(p.groundBalls,"groundBalls");
    }
    public void increaseShots(View view) {
        p.shots++;
        display(p.shots,"shots");

    }
    public void decreaseShots(View view) {
        if(p.shots  == 0)
            return;
        p.shots--;
        display(p.shots,"shots");
    }
    public void increaseGoals(View view) {
        p.goals++;
        p.shots++;
        display(p.goals,"goals");
        display(p.shots,"shots");

    }
    public void decreaseGoals(View view) {
        if(p.goals  == 0)
            return;
        p.goals--;
        p.shots--;

        display(p.goals,"goals");
        display(p.shots,"shots");

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
                        p.gameName = inputText;
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

            }
        }
    }
}

