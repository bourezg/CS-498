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
        games = new Vector<>();
    }

    public void addAGame(game newGameToAdd){
        games.add(newGameToAdd);
    }


    public List<game> getGames() {return games;}

}