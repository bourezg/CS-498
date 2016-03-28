package com.lax.laxstats;

import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onItemClick(int position) {
        if (findViewById(R.id.activity_player_list) != null) {
            Intent intent = new Intent(this, playerDetailActivity.class);
            intent.putExtra("POSITION", position);
            startActivity(intent);
        } else {
            //Running in large screen mode.
            playerDetailFragment fragment = (playerDetailFragment) getFragmentManager().findFragmentById(R.id.fragment_player_detail);
            if (fragment != null) {
                fragment.loadPosition(position);
            }
        }
    }
}
