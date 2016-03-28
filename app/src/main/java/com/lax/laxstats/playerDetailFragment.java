package com.lax.laxstats;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class playerDetailFragment extends Fragment {
    private playerManager pm = playerManager.getInstance();
    private List<player> players = pm.getPlayers();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_player_detail, container, false);
    }

    public void loadPosition (int position) {
        player p = players.get(position);
        if (p != null) {
            Activity activity = getActivity();
            TextView tv = (TextView) activity.findViewById(R.id.editFirstNameText);
            tv.setText(p.getFirstName());
            tv = (TextView) activity.findViewById(R.id.editLastNameText);
            tv.setText(p.getLastName());
            //add more changing stuff here
        }
    }

}
