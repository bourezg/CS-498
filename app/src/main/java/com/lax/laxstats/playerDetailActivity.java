package com.lax.laxstats;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;


public class playerDetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_detail);

        FragmentManager fragmentManager = getFragmentManager();
        playerDetailFragment fragment = (playerDetailFragment) fragmentManager.findFragmentById(R.id.fragment_player_detail);
        if (fragment != null) {
            int position = 0;
            position = getIntent().getIntExtra("POSITION",0);
            fragment.loadPosition(position);
        }
    }
}

