package com.lax.laxstats;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class gameDetailFragment extends Fragment {
    private gameManager pm = gameManager.getInstance();
    private List<game> games = pm.getGames();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_detail, container, false);
    }

    public void loadPosition (int position) {
        game p = games.get(position);
        if (p != null) {
          Activity activity = getActivity();
            TextView tv = (TextView) activity.findViewById(R.id.editGameNumberField);
            tv.setText(Integer.toString(p.getGameNumber()));
            //add more changing stuff here
        }
    }

}
