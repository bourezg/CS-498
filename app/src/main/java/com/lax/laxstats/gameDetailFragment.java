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

    gameManager pm = gameManager.getInstance();
    List<game> games = pm.getGames();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game_detail, container, false);
    }

    public void loadPosition (int position) {
        game p = games.get(position);
        if (p != null) {
          Activity activity = getActivity();
            EditText ev = (EditText) activity.findViewById(R.id.editGameName);
            ev.setText(p.getGameNumber());
            TextView tv = (TextView) activity.findViewById(R.id.goalsNumber );
            tv.setText(""+p.goals);
            tv = (TextView) activity.findViewById(R.id.homeScoreNumber);
            tv.setText(""+p.homeScore);
            tv = (TextView) activity.findViewById(R.id.shotsNumber);
            tv.setText(""+p.shots);
            tv = (TextView) activity.findViewById(R.id.assistsNumber);
            tv.setText(""+p.assists);
            tv = (TextView) activity.findViewById(R.id.drawControlsNumber);
            tv.setText(""+p.drawControls);
            tv = (TextView) activity.findViewById(R.id.groundBallsNumber);
            tv.setText(""+p.groundBalls);
            tv = (TextView) activity.findViewById(R.id.causedTurnoversNumber);
            tv.setText(""+p.causedTurnovers);
            tv = (TextView) activity.findViewById(R.id.foulsNumber);
            tv.setText(""+p.fouls);
            tv = (TextView) activity.findViewById(R.id.MinutesPlayedNumber);
            tv.setText(""+p.minutesPlayed);
            tv = (TextView) activity.findViewById(R.id.turnoversNumber);
            tv.setText(""+p.turnovers);
            tv = (TextView) activity.findViewById(R.id.awayScoreNumber);
            tv.setText(""+p.awayScore);}

    }
}
