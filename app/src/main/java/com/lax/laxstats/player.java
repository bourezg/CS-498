package com.lax.laxstats;

public class player {
    private String firstName, lastName,position;
    private int number,goals,shots,assists,drawControls,drawPossesions,
            groundBalls,causedTurnovers,fouls,saves,minutesPlayed,clears;

    public player(String firstName, String lastName, String position,int number ) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.position = position;
        this.number = number;
        this.goals = 0;
        this.shots = 0;
        this.assists = 0;
        this.drawControls = 0;
        this.drawPossesions = 0;
        this.groundBalls = 0;
        this.causedTurnovers = 0;
        this.fouls = 0;
        this.saves= 0;
        this.minutesPlayed = 0;
        this.clears = 0;
    }

    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public String toString() {return firstName + " " + lastName;}
    public String getPosition() {return position;}
    public int getNumber() {return number;}
    public int getShots() {return shots;}
    public int getGoals() {return goals;}
    public int getAssists() {return assists;}
    public int getDrawControls() {return drawControls;}
    public int getPossesions() {return drawPossesions;}
    public int getGroundBalls() {return groundBalls;}
    public int getCausedTurnovers() {return causedTurnovers;}
    public int getFouls() {return fouls;}
    public int getSaves() {return saves;}
    public int getMinutesPlayed() {return minutesPlayed;}
    public int getClears() {return clears;}

}
