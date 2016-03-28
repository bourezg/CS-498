package com.lax.laxstats;

import java.util.List;
import java.util.Vector;

/**
 * Created by Austin on 3/27/16.
 */
public class gameManager {
    private static gameManager pm = null;
    private List<game> games;


    public static gameManager getInstance() {
        if (pm == null) {
            pm = new gameManager();
        }
        return pm;
    }

    public gameManager() {
        game p0 = new game(0);
        game p1 = new game(1);
        game p2 = new game(2);
        game p3 = new game(3);
        game p4 = new game(4);


        games = new Vector<game>();
        games.add(p0);
        games.add(p1);
        games.add(p2);
        games.add(p3);
        games.add(p4);


    }


    public List<game> getGames() {return games;}

}