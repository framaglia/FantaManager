/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kix
 */
public class Calendar {
    
    private Map<Integer,Match> day;

    public Map<Integer, Match> getDay() {
        return day;
    }

    public Calendar() {
        this.day = new HashMap<>();
    }
    
    
    
}
