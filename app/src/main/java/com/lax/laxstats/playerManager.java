package com.lax.laxstats;

import java.util.List;
import java.util.Vector;

/**
 * Created by Austin on 3/27/16.
 */
public class playerManager {
    private static playerManager pm = null;
    private List<player> players;


    public static playerManager getInstance() {
        if (pm == null) {
            pm = new playerManager();
        }
        return pm;
    }

    public playerManager() {
        player p0 = new player("The", "Goalie","G",0);
        player p1 = new player("First", "Defender","RD",1);
        player p2 = new player("Second", "Defender","CD",2);
        player p3 = new player("Third", "Defender","CD",3);
        player p4 = new player("Forth", "Defender", "LD", 4);
        player p5 = new player("First", "Mid", "RM", 5);
        player p6 = new player("Second", "Mid", "CM", 6);
        player p7 = new player("Third", "Mid", "CM", 7);
        player p8 = new player("First", "Forward", "LF", 8);
        player p9 = new player("Second", "Forward", "CF", 9);
        player p10 = new player("Third", "Forward", "CF", 10);
        player p11 = new player("Forth", "Forward", "RF", 11);


        players = new Vector<player>();
        players.add(p0);
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        players.add(p5);
        players.add(p6);
        players.add(p7);
        players.add(p8);
        players.add(p9);
        players.add(p10);
        players.add(p11);

    }


    public List<player> getPlayers() {return players;}

}