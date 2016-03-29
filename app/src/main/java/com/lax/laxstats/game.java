package com.lax.laxstats;

public class game {
    private int gameNumber,goals,shots,assists,drawControls,
            groundBalls,causedTurnovers,fouls,saves,minutesPlayed,turnovers;

    public game(int gameNumber) {
        this.gameNumber = gameNumber;
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
    public String toString(){return "Game" + " " + gameNumber;}
    public int getGameNumber(){return gameNumber;}
    public int getShots() {return shots;}
    public int getGoals() {return goals;}
    public int getAssists() {return assists;}
    public int getDrawControls() {return drawControls;}
    public int getGroundBalls() {return groundBalls;}
    public int getCausedTurnovers() {return causedTurnovers;}
    public int getFouls() {return fouls;}
    public int getSaves() {return saves;}
    public int getMinutesPlayed() {return minutesPlayed;}
    public int getTurnovers() {return turnovers;}

}
