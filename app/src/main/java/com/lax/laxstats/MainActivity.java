package com.lax.laxstats;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    int savedPosition;
    static String playerName = "";
    static String playerNumber = "";
    static int playerPosition = 0;
    String playerPositionName;
    static int numGames;
    

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadData();
        refreshName();
        setContentView(R.layout.activity_main);
        if(gameListFragment.pm.getGames().size()>0) {
            TextView btn = (TextView) findViewById(R.id.noGamesHint);
            if (btn != null)
                btn.setVisibility(View.GONE);
            btn = (TextView) findViewById(R.id.noGamesHintLand);
            if (btn != null)
                btn.setVisibility(View.GONE);
            btn = (TextView) findViewById(R.id.gameName);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);

            btn = (TextView) findViewById(R.id.goalsAmount );
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.minutesPlayed);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);

            btn = (TextView) findViewById(R.id.shotsAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.shotsText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.assistsAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.assistsText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.drawControlsAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.drawControlsText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.groundBallsAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.groundBallsText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.causedTurnoversAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.causedTurnoversText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.foulsAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.foulsText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.savesAmount);
            if (btn != null)
                //btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.savesText);
            if (btn != null)
               // btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.minutesplayedAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.minutesPlayedNum);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.turnoversAmount);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.turnoversText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.turnoversText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.HomeScoreNum);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.HomeScoreText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.AwayScoreNum);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            btn = (TextView) findViewById(R.id.AwayScoreText);
            if (btn != null)
                btn.setVisibility(View.VISIBLE);
            Button button = (Button) findViewById(R.id.editGameButton);
            if (getResources().getConfiguration().orientation == 2)
                button.setVisibility(View.VISIBLE);


            gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
            if (fragment != null) {
                fragment.loadPosition(0);
            }
            updateStats(0);
        }
        loadGames();
        if(numGames>0)
            if (getResources().getConfiguration().orientation == 2){
                TextView btn = (TextView) findViewById(R.id.noGamesHintLand);
                btn.setVisibility(View.GONE);}
        else
            {
                TextView btn = (TextView) findViewById(R.id.noGamesHint);
                btn.setVisibility(View.GONE);}
    }



    @Override
    public void onResume(){
        super.onResume();
        refreshName();
        gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
        if(gameListFragment.pm.getGames().size()>0) {
            if (fragment != null) {
                fragment.loadPosition(0);
            }
            updateStats(0);
        }
    }

    void refreshName(){
        switch(playerPosition){
            case 0:
                playerPositionName = "Attack";
                break;
            case 1:
                playerPositionName = "Center";
                break;
            case 2:
                playerPositionName = "Defense";
                break;
            case 3:
                playerPositionName = "Goalie";
                break;
            case 4:
                playerPositionName = "Midfield";
                break;
        }
        if(playerName != "" && playerNumber != "")
            getSupportActionBar().setTitle(playerName + " #" + playerNumber + ", " + playerPositionName);
        else if (playerName != "" && playerNumber == "")
            getSupportActionBar().setTitle(playerName + "'s Stats");
        else if (playerName == "" && playerNumber != "")
            getSupportActionBar().setTitle("#"+playerNumber + "'s Stats");
        else
            getSupportActionBar().setTitle("Lax Stats");
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
                tv = (TextView) findViewById(R.id.HomeScoreNum);
                tv.setText(""+gameListFragment.pList.get(position).homeScore);
                tv = (TextView) findViewById(R.id.AwayScoreNum);
                tv.setText(""+gameListFragment.pList.get(position).awayScore);


        }
    }

    public void onItemClick(int position) {
        savedPosition = position;

        if (findViewById(R.id.activity_game_list) != null) {
            intent = new Intent(this, gameDetailActivity.class);
            intent.putExtra("POSITION", position);
            startActivity(intent);

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
        if(gameListFragment.pm.getGames().size()==1) {
            if (getResources().getConfiguration().orientation == 2){
            TextView btn = (TextView) findViewById(R.id.noGamesHintLand);
            btn.setVisibility(View.GONE);

                btn = (TextView) findViewById(R.id.noGamesHint);
                if (btn != null)
                    btn.setVisibility(View.GONE);
                btn = (TextView) findViewById(R.id.noGamesHintLand);
                if (btn != null)
                    btn.setVisibility(View.GONE);
                btn = (TextView) findViewById(R.id.gameName);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);

                btn = (TextView) findViewById(R.id.goalsAmount );
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.minutesPlayed);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);

                btn = (TextView) findViewById(R.id.shotsAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.shotsText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.assistsAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.assistsText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.drawControlsAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.drawControlsText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.groundBallsAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.groundBallsText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.causedTurnoversAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.causedTurnoversText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.foulsAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.foulsText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.savesAmount);
                if (btn != null)
                    //btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.savesText);
                if (btn != null)
                    //btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.minutesplayedAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.minutesPlayedNum);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.turnoversAmount);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.turnoversText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.HomeScoreNum);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.HomeScoreText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.AwayScoreNum);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                btn = (TextView) findViewById(R.id.AwayScoreText);
                if (btn != null)
                    btn.setVisibility(View.VISIBLE);
                Button button = (Button) findViewById(R.id.editGameButton);
                if (getResources().getConfiguration().orientation == 2)
                    button.setVisibility(View.VISIBLE);


                gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
                if (fragment != null) {
                    fragment.loadPosition(0);
                }
                updateStats(0);

            }
            if (getResources().getConfiguration().orientation == 1){
                TextView btn = (TextView) findViewById(R.id.noGamesHint);
                btn.setVisibility(View.GONE);
            }
        }
    }

    @Override
    public void onDestroy()
    {
        saveData();
        super.onDestroy();
    }

    public void saveData(){
        SharedPreferences db =
                getSharedPreferences("Database",
                        Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = db.edit();
        editor.putString("playerName", playerName);
        editor.putString("playerNumber", playerNumber);
        editor.putInt("playerPosition", playerPosition);
        if(gameListFragment.pm != null)
            editor.putInt("numGames", gameListFragment.pm.getGames().size());

        editor.commit();

    }
    public void loadData(){
        SharedPreferences db =
                getSharedPreferences("Database",
                        Context.MODE_PRIVATE);

        playerName =db.getString("playerName",playerName);
        playerNumber = db.getString("playerNumber", playerNumber);
        playerPosition = db.getInt("playerPosition", playerPosition);
        numGames = db.getInt("numGames",numGames);
    }
    
    public void loadGames(){
        SharedPreferences db =
                getSharedPreferences("Database",
                        Context.MODE_PRIVATE);
        int ng = numGames;
        if(numGames==0)
            return;
        else if(numGames!=0&& gameListFragment.pm.getGames().size()!=0){
            return;
        }
        else if(gameListFragment.pm.getGames().size()==0 && numGames!=0){
            for(int i = 0; i < ng; i++)
            {
                gameListFragment.pm.addAGame(new game("New Game"));
                gameListFragment.pm.getGames().get(i).gameName = db.getString(i+"gameName",playerName);

                gameListFragment.pm.getGames().get(i).gameName  = db.getString(i + "gameNumber", "New Game");
                gameListFragment.pm.getGames().get(i).goals  = db.getInt(i + "goals", 0);
                gameListFragment.pm.getGames().get(i).homeScore  = db.getInt(i + "homeScore", 0);
                gameListFragment.pm.getGames().get(i).drawControls  = db.getInt(i + "drawControls", 0);
                gameListFragment.pm.getGames().get(i).fouls  = db.getInt(i + "fouls", 0);
                gameListFragment.pm.getGames().get(i).groundBalls  = db.getInt(i + "groundBalls", 0);
                gameListFragment.pm.getGames().get(i).causedTurnovers  = db.getInt(i + "causedTurnovers", 0);
                gameListFragment.pm.getGames().get(i).shots  = db.getInt(i + "shots", 0);
                gameListFragment.pm.getGames().get(i).turnovers  = db.getInt(i + "turnovers", 0);
                gameListFragment.pm.getGames().get(i).awayScore  = db.getInt(i + "awayScore", 0);
                gameListFragment.pm.getGames().get(i).assists  = db.getInt(i + "assists", 0);
                gameListFragment.pm.getGames().get(i).minutesPlayed  = db.getInt(i + "minutesPlayed", 0);
                gameListFragment.pm.getGames().get(i).homeScore  = db.getInt(i + "homeScore", 0);
                gameListFragment.pm.getGames().get(i).awayScore  = db.getInt(i + "awayScore", 0);
                gameListFragment.pm.getGames().get(i).timeSaved  = db.getBoolean(i + "timeSaved", false);
                gameListFragment.pm.getGames().get(i).running  = db.getBoolean(i + "running", false);
                gameListFragment.pm.getGames().get(i).timer  = db.getLong(i + "timer", 0);
                gameListFragment.pm.getGames().get(i).C1  = db.getLong(i + "C1", 0);
                gameListFragment.pm.getGames().get(i).C2  = db.getLong(i + "C2", 0);
                
            }
            
        playerName =db.getString("playerName",playerName);
        playerNumber = db.getString("playerNumber", playerNumber);
        playerPosition = db.getInt("playerPosition", playerPosition);
        numGames = db.getInt("numGames",numGames);
    }
    }
}
