package com.lax.laxstats;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;


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
}

