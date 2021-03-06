package com.lax.laxstats;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import java.util.List;


public class gameDetailFragment extends Fragment {
    Activity activity;
    gameManager pm = gameManager.getInstance();
    List<game> games = pm.getGames();
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_game_detail, container, false);
        return view;

    }

    public void loadData(){

    }

    public void loadPosition (int position) {
        game p = games.get(position);
        if (p != null) {
            activity = getActivity();
            EditText ev = (EditText) activity.findViewById(R.id.editGameName);
            ev.setText(p.getGameNumber());
            TextView tv = (TextView) activity.findViewById(R.id.goalsNum );
            tv.setText(""+p.goals);
            tv = (TextView) activity.findViewById(R.id.homeScoreNumber);
            tv.setText(""+p.homeScore);
            tv = (TextView) activity.findViewById(R.id.drawControllNum);
            tv.setText(""+p.drawControls);
            tv = (TextView) activity.findViewById(R.id.foulsNum);
            tv.setText(""+p.fouls);
            tv = (TextView) activity.findViewById(R.id.groundBallsNum);
            tv.setText(""+p.groundBalls);
            tv = (TextView) activity.findViewById(R.id.causedTurnoversNum);
            tv.setText(""+p.causedTurnovers);
            tv = (TextView) activity.findViewById(R.id.foulsNum);
            tv.setText(""+p.fouls);
            tv = (TextView) activity.findViewById(R.id.shotsNum);
            tv.setText(""+p.shots);
            tv = (TextView) activity.findViewById(R.id.turnoversNum);
            tv.setText(""+p.turnovers);
            tv = (TextView) activity.findViewById(R.id.awayScoreNumber);
            tv.setText(""+p.awayScore);
            tv = (TextView) activity.findViewById(R.id.assistsNum);
            tv.setText(""+p.assists);
            tv = (TextView) activity.findViewById(R.id.minutesPlayedNum);
            tv.setText(""+p.minutesPlayed);}


    }
}
