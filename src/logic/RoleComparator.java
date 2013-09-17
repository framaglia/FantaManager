/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.Comparator;
import model.Player;

/**
 *
 * @author kix
 */
public class RoleComparator implements Comparator<Player>{

   

    @Override
    public int compare(Player t, Player t1) {
        
        int comp;
        
        if(t.getNome().equals("Over") || t.getNome().equals("OfficeP") || t.getNome().equals("Office") || t1.getNome().equals("Over") || t1.getNome().equals("OfficeP") || t1.getNome().equals("Office"))
            comp = 0;
        else if (t.getRuolo().equals("portiere") && t1.getRuolo().equals("difensore"))
            comp = -1;
        else if(t.getRuolo().equals("portiere") && t1.getRuolo().equals("centrocampista"))
            comp = -1;
        else if(t.getRuolo().equals("portiere") && t1.getRuolo().equals("attaccante"))
            comp = -1;
        else if(t.getRuolo().equals("difensore") && t1.getRuolo().equals("portiere"))
            comp = 1;
        else if(t.getRuolo().equals("difensore") && t1.getRuolo().equals("centrocampista"))
            comp = -1;
        else if(t.getRuolo().equals("difensore") && t1.getRuolo().equals("attaccante"))
            comp = -1;
        else if(t.getRuolo().equals("centrocampista") && t1.getRuolo().equals("difensore"))
            comp = 1;
        else if(t.getRuolo().equals("centrocampista") && t1.getRuolo().equals("portiere"))
            comp = 1;
        else if(t.getRuolo().equals("centrocampista") && t1.getRuolo().equals("attaccante"))
            comp = -1;
        else if(t.getRuolo().equals("attaccante"))
            comp = 1;
        else comp = 0;
        
        
        return comp;
    }
    
}
