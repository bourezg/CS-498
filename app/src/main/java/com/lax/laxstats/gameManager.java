package com.lax.laxstats;

import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Vector;

/**
 * Created by Austin on 3/27/16.
 */
public class gameManager {
    private static gameManager pm = null;
    private  List<game> games;


    public static gameManager getInstance() {
        if (pm == null) {
            pm = new gameManager();
        }
        return pm;
    }

    public gameManager() {
        //game g0 = new game("Game #0");
        //game g1 = new game("Game #1");
        //game g2 = new game("Game #2");
        //game g3 = new game("Game #3");
        //game g4 = new game("Game #4");

        games = new Vector<>();
        //games.add(g0);
        //games.add(g1);
        //games.add(g2);
        //games.add(g3);
        //games.add(g4);


    }

    public void addAGame(game newGameToAdd){
        games.add(newGameToAdd);
    }


    public List<game> getGames() {return games;}

}