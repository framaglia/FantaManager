/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kix
 */
public class Match {
    
    private String homeTeam;
    private String awayTeam;
    private int golHome;
    private int golAway;
    private double scoreHome;
    private double scoreAway;
    private Formation usedFormationHome;
    private Formation usedFormationAway;
    private double modHome;
    private double modAway;
    
    public Match() {
        this.homeTeam = "";
        this.awayTeam = "";
        this.golHome = 0;
        this.golAway = 0;
        this.scoreHome = 0.0;
        this.scoreAway = 0.0;
        this.usedFormationHome = new Formation();
        this.usedFormationAway = new Formation();
        this.modAway = 0.0;
        this.modHome = 0.0;
    }

    public double getModHome() {
        return modHome;
    }

    public void setModHome(double modHome) {
        this.modHome = modHome;
    }

    public double getModAway() {
        return modAway;
    }

    public void setModAway(double modAway) {
        this.modAway = modAway;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getGolHome() {
        return golHome;
    }

    public void setGolHome(int golHome) {
        this.golHome = golHome;
    }

    public int getGolAway() {
        return golAway;
    }

    public void setGolAway(int golAway) {
        this.golAway = golAway;
    }

    public double getScoreHome() {
        return scoreHome;
    }

    public void setScoreHome(double scoreHome) {
        this.scoreHome = scoreHome;
    }

    public double getScoreAway() {
        return scoreAway;
    }

    public void setScoreAway(double scoreAway) {
        this.scoreAway = scoreAway;
    }

    public Formation getUsedFormationHome() {
        return usedFormationHome;
    }

    public void setUsedFormationHome(Formation usedFormationHome) {
        this.usedFormationHome = usedFormationHome;
    }

    public Formation getUsedFormationAway() {
        return usedFormationAway;
    }

    public void setUsedFormationAway(Formation usedFormationAway) {
        this.usedFormationAway = usedFormationAway;
    }
    
    
    
    
    
}
