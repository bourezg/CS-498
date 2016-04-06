package com.lax.laxstats;

import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    Intent intent;
    int savedPosition;
    static String playerName = "";
    static String playerNumber = "";
    static int playerPosition = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(gameListFragment.pm.getGames().size()>0) {
            TextView btn = (TextView) findViewById(R.id.noGamesHint);
            if (btn != null)
                btn.setVisibility(View.GONE);
        }
        else
            return;
        gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
        if (fragment != null) {
            fragment.loadPosition(0);
        }
        updateStats(0);
    }

    @Override
    public void onResume(){
        super.onResume();
        gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
        if (fragment != null) {
            fragment.loadPosition(0);}
        updateStats(0);
    }

    public void updateStats(int position)
    {
        if (getResources().getConfiguration().orientation == 2) {
                TextView tv = (TextView) findViewById(R.id.gameName);
                tv.setText(gameListFragment.pList.get(position).gameName);
                tv = (TextView) findViewById(R.id.goalsAmount );
                tv.setText(""+gameListFragment.pList.get(position).goals);
                tv = (TextView) findViewById(R.id.shotsAmount);
                tv.setText(""+gameListFragment.pList.get(position).shots);
                tv = (TextView) findViewById(R.id.assistsAmount);
                tv.setText(""+gameListFragment.pList.get(position).assists);
                tv = (TextView) findViewById(R.id.drawControlsAmount);
                tv.setText(""+gameListFragment.pList.get(position).drawControls);
                tv = (TextView) findViewById(R.id.groundBallsAmount);
                tv.setText(""+gameListFragment.pList.get(position).groundBalls);
                tv = (TextView) findViewById(R.id.causedTurnoversAmount);
                tv.setText(""+gameListFragment.pList.get(position).causedTurnovers);
                tv = (TextView) findViewById(R.id.foulsAmount);
                tv.setText(""+gameListFragment.pList.get(position).fouls);
                tv = (TextView) findViewById(R.id.minutesplayedAmount);
                tv.setText(""+gameListFragment.pList.get(position).minutesPlayed);
                tv = (TextView) findViewById(R.id.turnoversAmount);
                tv.setText(""+gameListFragment.pList.get(position).turnovers);

        }
    }

    public void onItemClick(int position) {
        if (findViewById(R.id.activity_game_list) != null) {
            intent = new Intent(this, gameDetailActivity.class);
            intent.putExtra("POSITION", position);
            startActivity(intent);
            savedPosition = position;

        }
        else {
            gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
            if (fragment != null) {
                fragment.loadPosition(position);
            }
            updateStats(position);

        }

    }

    public void enterEditGame(View view){
        intent = new Intent(this, gameDetailActivity.class);
        intent.putExtra("POSITION", savedPosition);
        startActivity(intent);
    }

    public void createNewGame(View view){
        game newGame = new game("New Game");
        gameListFragment.pm.addAGame(newGame);
        gameListFragment.adapter.notifyDataSetChanged();
        if(gameListFragment.pm.getGames().size()==1){
            TextView btn = (TextView) findViewById(R.id.noGamesHint);
            btn.setVisibility(View.GONE);}
    }
}
