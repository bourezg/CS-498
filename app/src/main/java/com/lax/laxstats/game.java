package com.lax.laxstats;

public class game {
    String gameName;
    boolean timeSaved;
    boolean running = false;
    long timer=0;
    long displayTime = 0;
    public long C1 = 0;
    public long C2 = 0;
    int goals, shots, assists, drawControls, groundBalls, causedTurnovers, fouls, saves, minutesPlayed, turnovers, homeScore, awayScore;

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
        this.saves = 0;
        this.minutesPlayed = 0;
        this.turnovers = 0;
        this.homeScore = 0;
        this.awayScore = 0;
    }

    public String toString() {
        return gameName;
    }

    public String getGameNumber() {
        return gameName;
    }


}
