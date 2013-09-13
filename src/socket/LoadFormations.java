package socket;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Formation;
import model.Match;
import model.Player;

import ui.VotesUI;


/**
 *
 * @author kix
 */
public class LoadFormations {
    
    private Socket socket;
    private int teamLoaded;
    private HashMap<String, Formation> allFormations; 
    private List<Match> matches;
    private List<Player> rolePlayers;
    private VotesUI vui;
   
    
    
    public LoadFormations(VotesUI vui) {
        
        this.teamLoaded = 0;
        this.allFormations = new HashMap<String, Formation>();
        this.matches = new ArrayList<Match>();
        this.rolePlayers = new ArrayList<Player>();
        this.vui = vui;
        this.socket = new Socket(this);
        
        
    
    }

    public void getrolePlayersByDB(){
        this.socket.getSocket().emit("getRolePlayers", "acybris");
        //this.socket.getSocket().emit("getRolePlayers", "acybris");
        this.socket.getSocket().emit("getRolePlayers", "acdc");
        //this.socket.getSocket().emit("getRolePlayers", "acdc");
        this.socket.getSocket().emit("getRolePlayers", "dlc");
        //this.socket.getSocket().emit("getRolePlayers", "dlc");
        this.socket.getSocket().emit("getRolePlayers", "fanfulla");
        //this.socket.getSocket().emit("getRolePlayers", "fanfulla");
        this.socket.getSocket().emit("getRolePlayers", "fantaroma");
        //this.socket.getSocket().emit("getRolePlayers", "fantaroma");
        this.socket.getSocket().emit("getRolePlayers", "gpsundergland");
        //this.socket.getSocket().emit("getRolePlayers", "gpsundergland");
        this.socket.getSocket().emit("getRolePlayers", "cska");
        //this.socket.getSocket().emit("getRolePlayers", "cska");
        this.socket.getSocket().emit("getRolePlayers", "felix");
        ///this.socket.getSocket().emit("getRolePlayers", "felix");
        this.socket.getSocket().emit("getRolePlayers", "vts");
        //this.socket.getSocket().emit("getRolePlayers", "vts");
        this.socket.getSocket().emit("getRolePlayers", "tccfc");
        //this.socket.getSocket().emit("getRolePlayers", "tccfc");
        this.socket.getSocket().emit("getRolePlayers", "paris");
        //this.socket.getSocket().emit("getRolePlayers", "paris");
        this.socket.getSocket().emit("getRolePlayers", "astronzo");
        //this.socket.getSocket().emit("getRolePlayers", "astronzo");
    }
    
   
    public void getFormationsByDB(){
        this.socket.getSocket().emit("getAllFormations", "ciao");
        this.socket.getSocket().emit("getAllFormations", "ciao");

    }
    
    public void teamLoaded(){
        if(this.teamLoaded > 11){
            this.vui.setRolePlayers(rolePlayers);
            this.vui.rolePlayersLoaded();
        }
    }
    public void formationsLoaded(){
        this.vui.setFormationsMap(allFormations);
        this.vui.formationLoaded();
    }
    
    public void getCalendarDay(int day){
        this.socket.getSocket().emit("getCalendarDay", day);
        this.socket.getSocket().emit("getCalendarDay", day);
    }
   
    public void matchesLoaded(){
        this.vui.setMatches(matches);
        this.vui.matchesLoaded();
    }

    public HashMap<String, Formation> getAllFormations() {
        return allFormations;
    }

    public void setAllFormations(HashMap<String, Formation> allFormations) {
        this.allFormations = allFormations;
    }

    public List<Match> getMatches() {
        return matches;
    }

    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }

    public List<Player> getRolePlayers() {
        return rolePlayers;
    }

    public void setRolePlayers(List<Player> rolePlayers) {
        this.rolePlayers = rolePlayers;
    }

    public int getTeamLoaded() {
        return teamLoaded;
    }

    public void setTeamLoaded(int teamLoaded) {
        this.teamLoaded = teamLoaded;
    }
    
}
