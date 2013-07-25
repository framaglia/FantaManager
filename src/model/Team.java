/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author kix
 */
public class Team {
    
    private String name;
    private String owner;
    private List<Player> team;

    public Team() {
    }

    public String getName() {
        return name;
    }

    public String getOwner() {
        return owner;
    }

    public List<Player> getTeam() {
        return team;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setTeam(List<Player> team) {
        this.team = team;
    }
    
    
}
