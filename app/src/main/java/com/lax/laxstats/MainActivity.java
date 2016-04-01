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

    }

    @Override
    public void onResume(){
        super.onResume();
        //UPDATES TEXTVIEW TO NEW GAME NAME
        gameListFragment.adapter.notifyDataSetChanged();

    }
    

    public void onItemClick(int position) {
        if (findViewById(R.id.activity_game_list) != null) {
            intent = new Intent(this, gameDetailActivity.class);
            intent.putExtra("POSITION", position);
            startActivity(intent);

        }


    }

    public void createNewGame(View view){
        game newGame = new game("New Game");
        gameListFragment.pm.addAGame(newGame);
        gameListFragment.adapter.notifyDataSetChanged();
    }

}
