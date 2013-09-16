package socket;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import model.Formation;
import model.Match;
import model.Player;
import model.Team;
import org.json.JSONException;
import org.json.JSONObject;

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
    private List<Team> teamScores;
    private VotesUI vui;
   
    
    
    public LoadFormations(VotesUI vui) {
        
        this.teamLoaded = 0;
        this.allFormations = new HashMap<String, Formation>();
        this.matches = new ArrayList<Match>();
        this.rolePlayers = new ArrayList<Player>();
        this.teamScores = new LinkedList<Team>();
        this.vui = vui;
        this.socket = new Socket(this);
        
        
    
    }
    
    public void calculateRanking(){
        
        for(Team t : this.teamScores){
            for(Match m : this.matches){
                if(t.getName().equals(m.getHomeTeam()) && m.getGolHome() > m.getGolAway()){
                    t.setPunti(t.getPunti() + 3);
                    t.setWin(t.getWin() + 1);
                    t.setGf(t.getGf() + m.getGolHome());
                    t.setGs(t.getGs() + m.getGolAway());
                    t.setDg(t.getGf() - t.getGs());
                    t.setMp(t.getMp() + m.getScoreHome());
                }
                else if(t.getName().equals(m.getHomeTeam()) && m.getGolHome() < m.getGolAway()){
                    
                    t.setLost(t.getLost() + 1);
                    t.setGf(t.getGf() + m.getGolHome());
                    t.setGs(t.getGs() + m.getGolAway());
                    t.setDg(t.getGf() - t.getGs());
                    t.setMp(t.getMp() + m.getScoreHome());
                    
                }
                else if(t.getName().equals(m.getHomeTeam()) && m.getGolHome() == m.getGolAway()){
                    t.setPunti(t.getPunti() + 1);
                    t.setDraw(t.getDraw()+ 1);
                    t.setGf(t.getGf() + m.getGolHome());
                    t.setGs(t.getGs() + m.getGolAway());
                    t.setDg(t.getGf() - t.getGs());
                    t.setMp(t.getMp() + m.getScoreHome());
                }
                else if(t.getName().equals(m.getAwayTeam()) && m.getGolAway() > m.getGolHome()){
                    t.setPunti(t.getPunti() + 3);
                    t.setWin(t.getWin() + 1);
                    t.setGf(t.getGf() + m.getGolAway());
                    t.setGs(t.getGs() + m.getGolHome());
                    t.setDg(t.getGf() - t.getGs());
                    t.setMp(t.getMp() + m.getScoreAway());
                }
                else if(t.getName().equals(m.getAwayTeam()) && m.getGolAway() < m.getGolHome()){
                    
                    t.setLost(t.getLost()+ 1);
                    t.setGf(t.getGf() + m.getGolAway());
                    t.setGs(t.getGs() + m.getGolHome());
                    t.setDg(t.getGf() - t.getGs());
                    t.setMp(t.getMp() + m.getScoreAway());
                }
                else if(t.getName().equals(m.getAwayTeam()) && m.getGolAway() == m.getGolHome()){
                    t.setPunti(t.getPunti() + 1);
                    t.setDraw(t.getDraw()+ 1);
                    t.setGf(t.getGf() + m.getGolAway());
                    t.setGs(t.getGs() + m.getGolHome());
                    t.setDg(t.getGf() - t.getGs());
                    t.setMp(t.getMp() + m.getScoreAway());
                }
                
                else{
                    
                }
                
            }
        }
        
        Collections.sort(teamScores);
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
    
    public void saveResults(int day) throws JSONException {
        String[] results = new String[6];
        int i = 0;
        for(Match m : matches) {
            String res = Integer.toString(m.getGolHome()) + " - " + Integer.toString(m.getGolAway());
            results[i] = res;
            i++;
        }
        
        JSONObject jo = new JSONObject();
        jo.put("day", day);
        jo.put("results", results);
        this.socket.getSocket().emit("saveDayResults", jo);
    }
    
    
    
    public void saveScores(int day) throws JSONException {
        
        String[] teams = new String[12];
        String[][] formation = new String[12][11];
        String[][] bench = new String[12][7];
        String[][] scorePlayTit = new String[12][11];
        String[][] scorePlayPanc = new String[12][7];
        String[] magic = new String[12];
        String[] gol = new String[12];
        String[] mod = new String[12];
        
        int i = 0;
        JSONObject jo = new JSONObject();
        
        for(Match m : matches) {
            int j = 0;
            teams[i] = m.getHomeTeam();
            magic[i] = Double.toString(m.getScoreHome());
            gol[i] = Integer.toString(m.getGolHome());
            mod[i] = Double.toString(m.getModHome());
            for(Player p : m.getUsedFormationHome().getFormation()) {
              formation[i][j] = p.getNome();
              j++;
            }
            j = 0;
            for(Player p : m.getUsedFormationHome().getBench()) {
              bench[i][j] = p.getNome();
              j++;
            }
            
            i++;
            teams[i] = m.getAwayTeam();
            magic[i] = Double.toString(m.getScoreAway());
            gol[i] = Integer.toString(m.getGolAway());
            mod[i] = Double.toString(m.getModAway());
            j = 0;
            for(Player p : m.getUsedFormationAway().getFormation()) {
              formation[i][j] = p.getNome();
              j++;
            }
            j = 0;
            for(Player p : m.getUsedFormationAway().getBench()) {
              bench[i][j] = p.getNome();
              j++;
            }
            i++;
        }
        int k = 0;
        for(Match m : matches){
            int x = 0;
            for(Player p : m.getUsedFormationHome().getFormation()){
                System.out.println(Double.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getVote()));
                String v = Double.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getVote());
                String as = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAs());
                String au = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAu());
                String gf = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGf());
                String gr = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGr());
                String gs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGs());
                String rp = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRp());
                String rs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRs());
                String am = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isAm()) {
                    am = "v";
                }
                
                String es = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isEs()) {
                    es = "v";
                }
                
                scorePlayTit[k][x] = v +" "+ gf+" " + gr + " " + as + " " + gs +" " + au + " " + rp + " " + rs +" "+ am +" "+ es;
                x++;
            }
            x = 0;
            for(Player p : m.getUsedFormationHome().getBench()){
                
                String v = Double.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getVote());
                String as = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAs());
                String au = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAu());
                String gf = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGf());
                String gr = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGr());
                String gs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGs());
                String rp = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRp());
                String rs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRs());
                String am = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isAm()) {
                    am = "v";
                }
                
                String es = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isEs()) {
                    es = "v";
                }
                
                scorePlayPanc[k][x] = v +" "+ gf+" " + gr + " " + as + " " + gs +" " + au + " " + rp + " " + rs +" "+ am +" "+ es;
                x++;
            }
            
            k++;
            x = 0;
            for(Player p : m.getUsedFormationAway().getFormation()){
                
                String v = Double.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getVote());
                String as = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAs());
                String au = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAu());
                String gf = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGf());
                String gr = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGr());
                String gs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGs());
                String rp = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRp());
                String rs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRs());
                String am = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isAm()) {
                    am = "v";
                }
                
                String es = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isEs()) {
                    es = "v";
                }
                
                scorePlayTit[k][x] = v +" "+ gf+" " + gr + " " + as + " " + gs +" " + au + " " + rp + " " + rs +" "+ am +" "+ es;
                x++;
            }
            x = 0;
            for(Player p : m.getUsedFormationAway().getBench()){
                
                String v = Double.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getVote());
                String as = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAs());
                String au = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getAu());
                String gf = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGf());
                String gr = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGr());
                String gs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getGs());
                String rp = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRp());
                String rs = Integer.toString(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).getRs());
                String am = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isAm()) {
                    am = "v";
                }
                
                String es = "x";
                if(this.vui.getCalculateScore().getVe().getVotes().get(p.getNome()).isEs()) {
                    es = "v";
                }
                
                scorePlayPanc[k][x] = v +" "+ gf+" " + gr + " " + as + " " + gs +" " + au + " " + rp + " " + rs +" "+ am +" "+ es;
                x++;
            }
         k++;   
        }
       
        jo.put("day", day);
        jo.put("team", teams);
        jo.put("formation", formation);
        jo.put("bench", bench);
        jo.put("scoreTit", scorePlayTit);
        jo.put("scoreBench", scorePlayPanc);
        jo.put("magicPoints", magic);
        jo.put("gol", gol);
        jo.put("modifier", mod);
        this.socket.getSocket().emit("saveScores", jo);
    }
    
   public void saveRanking() throws JSONException{
       JSONObject jo = new JSONObject();
       String[] ranking = new String[12];
       double[] mp = new double[12];
       int[] scores = new int[12];
       int[] gf = new int[12];
       int[] gs = new int[12];
       int[] dg = new int[12];
       int[] w = new int[12];
       int[] l = new int[12];
       int[] d = new int[12];
       
       int i = 0;
       for(Team t : this.teamScores){
           ranking[i] = t.getName();
           gf[i] = t.getGf();
           gs[i] = t.getGs();
           dg[i] = t.getGf();
           scores[i] = t.getPunti();
           w[i] = t.getWin();
           l[i] = t.getLost();
           d[i] = t.getDraw();
           mp[i] = t.getMp();
           i++;
       }
       jo.put("day", 1);
       jo.put("ranking", ranking);
       jo.put("scores", scores);
       jo.put("mp", mp);
       jo.put("gf", gf);
       jo.put("gs", gs);
       jo.put("dg", dg);
       jo.put("win", w);
       jo.put("lost", l);
       jo.put("draw", d);
       
       this.socket.getSocket().emit("saveClassifica", jo);
       
   }
   
   public void updateCurrentDay(int currentDay){
       this.socket.getSocket().emit("updateCurrentDay", currentDay);
       
   }
    public void getFormationsByDB(){
        this.socket.getSocket().emit("getAllFormations", "ciao");
        this.socket.getSocket().emit("getAllFormations", "ciao");

    }
    
    public void getRankingByDB(){
        socket.getSocket().emit("getRanking", "ciao");
        //socket.getSocket().emit("getRanking", "ciao");
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

    public List<Team> getTeamScores() {
        return teamScores;
    }

    public void setTeamScores(List<Team> teamScores) {
        this.teamScores = teamScores;
    }


    
    
}
