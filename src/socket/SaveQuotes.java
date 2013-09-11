/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cash;
import model.Formation;
import model.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ui.QuotazioniUI;
import ui.VotesUI;

/**
 *
 * @author kix
 */
public class SaveQuotes {
    
    private Socket socket;
    private  ArrayList<ArrayList<Player>> playerList;
    private HashMap<String, Cash> cashes;
   
    private QuotazioniUI qui;
 
   
    public SaveQuotes(QuotazioniUI qui) {
        
        this.playerList = new ArrayList<ArrayList<Player>>();
        this.cashes = new HashMap<String, Cash>();
        this.qui = qui;
        this.socket = new Socket(this);
    }
    
    

    
    public void saveCashes(HashMap<String, Cash> casse){
        JSONArray jarray = new JSONArray();
        for(String team : casse.keySet()){
            JSONObject json = new JSONObject();
            try {
                json.append("team", team);
                json.append("cash", casse.get(team).getCash());
                json.append("charge", casse.get(team).getCharge());
                
                jarray.put(json);
            } catch (JSONException ex) {
                Logger.getLogger(SaveQuotes.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        socket.getSocket().emit("saveCashes", jarray);
        
    }
   
    public void saveQuotes(ArrayList<ArrayList<Player>> playerList){
        
        JSONArray jarray = new JSONArray();
        for(List<Player> l : playerList){
            for(Player p : l){
                JSONObject json = new JSONObject();
                try {
                    json.append("name", p.getNome());
                    json.append("squadra", p.getSquadra());
                    json.append("quotazione", p.getQuotazione());
                    json.append("ruolo", p.getRuolo());
                    json.append("prezzo", p.getBuyPrice());
                    json.append("fantaTeam", p.getFantaTeam());
                    json.append("scadenza", p.getScadenza());
                    json.append("rinnovo", p.getRinnovabile());
                    
                    jarray.put(json);
                    
                        
                    
                    
                    
                } catch (JSONException ex) {
                    Logger.getLogger(QuotazioniUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        socket.getSocket().emit("saveQuot", jarray);
    }
    
    public void deleteQuotes(){
        
        this.socket.getSocket().emit("removePlayers", new JSONObject());
    }
    
 
    public void loadPlayers(){
        
        this.socket.getSocket().emit("loadPlayers", new JSONObject());
        this.socket.getSocket().emit("loadPlayers", new JSONObject());

    }
    
    public void loadCash(){
        this.socket.getSocket().emit("loadCash", new JSONObject());
        this.socket.getSocket().emit("loadCash", new JSONObject());
    }
    
    public void playersLoaded(){
        this.qui.setListaPlayers(playerList);
    }
    
    
    
    public void cashesLoaded(){
        this.qui.setCassaSquadre(cashes);
        this.qui.loadCashTeam();
    }

    public void systemOK(){
        
        this.qui.getjTextFieldSystem().setText("System OK");
        Color green = new Color(123, 255, 74);
        this.qui.getjTextFieldSystem().setBackground(green);
    }
    
    public void systemFail(){
        
        this.qui.getjTextFieldSystem().setText("Connection Error");
        Color red = new Color(253, 67, 67);
        this.qui.getjTextFieldSystem().setBackground(red);
    }
    
    public ArrayList<ArrayList<Player>> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(ArrayList<ArrayList<Player>> playerList) {
        this.playerList = playerList;
    }
    
    
    public HashMap<String, Cash> getCashes() {
        return cashes;
    }

    public void setCashes(HashMap<String, Cash> cashes) {
        this.cashes = cashes;
    }

}
