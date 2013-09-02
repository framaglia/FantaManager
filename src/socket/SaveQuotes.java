/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Player;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import ui.QuotazioniUI;

/**
 *
 * @author kix
 */
public class SaveQuotes {
    
    private Socket socket;
    private  ArrayList<ArrayList<Player>> playerList;
    private QuotazioniUI qui;
   
    public SaveQuotes(QuotazioniUI qui) {
        this.playerList = new ArrayList<>();
        
        this.qui = qui;
        this.socket = new Socket(this);
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
    
    public void playersLoaded(){
        this.qui.setListaPlayers(playerList);
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
    
}
