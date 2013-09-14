/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author kix
 */
public class Vote {
    
    
    private int gf;
    private int gr;
    private int gs;
    private int rp;
    private int rs;
    private int au;
    private int as;
    private boolean am;
    private boolean es;
    private double vote;
    
    
    public Vote(){
        
    }

    

    public boolean isAm() {
        return am;
    }

    public void setAm(boolean am) {
        this.am = am;
    }

    public boolean isEs() {
        return es;
    }

    public void setEs(boolean es) {
        this.es = es;
    }

    public int getGf() {
        return gf;
    }

    public int getGr() {
        return gr;
    }

    public int getGs() {
        return gs;
    }

    public int getRp() {
        return rp;
    }

    public int getRs() {
        return rs;
    }

    public int getAu() {
        return au;
    }

    public int getAs() {
        return as;
    }

    public double getVote() {
        return vote;
    }


    public void setGf(int gf) {
        this.gf = gf;
    }

    public void setGr(int gr) {
        this.gr = gr;
    }

    public void setGs(int gs) {
        this.gs = gs;
    }

    public void setRp(int rp) {
        this.rp = rp;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public void setAu(int au) {
        this.au = au;
    }

    public void setAs(int as) {
        this.as = as;
    }

    public void setVote(double vote) {
        this.vote = vote;
    }
    
    
    
}

