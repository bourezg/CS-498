package com.lax.laxstats;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    Intent intent;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(gameListFragment.pm.getGames().size()>0) {
            TextView btn = (TextView) findViewById(R.id.noGamesHint);
            if (btn != null)
                btn.setVisibility(View.GONE);
        }
        gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
        if (fragment != null) {
            fragment.loadPosition(0);
        }
    }


    @Override
    public void onResume(){
        super.onResume();
        //UPDATES TEXTVIEW TO NEW GAME NAME

    }
    

    public void onItemClick(int position) {
        if (findViewById(R.id.activity_game_list) != null) {
            intent = new Intent(this, gameDetailActivity.class);
            intent.putExtra("POSITION", position);
            startActivity(intent);

        }else {
            //Running in large screen mode.
            gameDetailFragment fragment = (gameDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_game_detail);
            if (fragment != null) {
                fragment.loadPosition(position);
            }
        }


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
