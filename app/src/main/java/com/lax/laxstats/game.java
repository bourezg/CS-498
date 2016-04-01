package com.lax.laxstats;

public class game {
     String gameName;
    boolean timeSaved;
     long timer;
     int goals,shots,assists,drawControls,
            groundBalls,causedTurnovers,fouls,saves,minutesPlayed,turnovers;

    public game(String gameName) {
        this.gameName = gameName;
        this.timeSaved = false;
        this.timer = 0;
        this.goals = 0;
        this.shots = 0;
        this.assists = 0;
        this.drawControls = 0;
        this.groundBalls = 0;
        this.causedTurnovers = 0;
        this.fouls = 0;
        this.saves= 0;
        this.minutesPlayed = 0;
        this.turnovers =0;
    }
    public String toString(){return gameName;}
    public String getGameNumber(){return gameName;}


}
