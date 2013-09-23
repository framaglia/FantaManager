/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author kix
 */
public class Formation {
    
    
    
    private List<Player> formation;
    private List<Player> bench;

    public List<Player> getBench() {
        return bench;
    }

    public void setFormation(List<Player> formation) {
        this.formation = formation;
    }

    public void setBench(List<Player> bench) {
        this.bench = bench;
    }

   

    public List<Player> getFormation() {
        return formation;
    }

    public Formation() {
        this.formation = new ArrayList<Player>();
        this.bench = new ArrayList<Player>();
    }
    
    
    
}
