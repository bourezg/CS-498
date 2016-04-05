package com.lax.laxstats;

import android.content.DialogInterface;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    Intent intent;
    int savedPosition;

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
        if (getResources().getConfiguration().orientation == 2) {
            gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
            if (fragment != null) {
                fragment.loadPosition(0);
            }
        }
    }

    @Override
    public void onResume(){
        super.onResume();
        if (getResources().getConfiguration().orientation == 2) {
            gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
            if (fragment != null) {
                fragment.loadPosition(0);
            }
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
