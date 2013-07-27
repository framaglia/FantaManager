/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

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

    public SaveQuotes() {
        this.socket = new Socket();
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
    
}
