package socket;

import java.net.MalformedURLException;

import io.socket.IOAcknowledge;
import io.socket.IOCallback;
import io.socket.SocketIO;
import io.socket.SocketIOException;

import java.util.ArrayList;
import java.util.Collections;

import java.util.logging.Level;
import java.util.logging.Logger;
import model.Player;
import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import extractor.NameComparatorByRole;




public class Socket implements IOCallback {
	
	private SocketIO socket;
        private SaveQuotes saveQuotes;

	public Socket()  {
        
		socket = new SocketIO();
		
		try {
			socket.connect("http://simpleservice.eu01.aws.af.cm", this);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	} 

	public Socket(SaveQuotes saveQuotes)  {
                this.saveQuotes = saveQuotes;
		socket = new SocketIO();
                
		
		try {
			socket.connect("http://simpleservice.eu01.aws.af.cm", this);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	} 

	public SocketIO getSocket() {
		return socket;
	}

	public void setSocket(SocketIO socket) {
		this.socket = socket;
	}

	@Override
	public void onMessage(JSONObject json, IOAcknowledge ack) {
		
                System.out.println("Server said:" + json.toString());
		
	}

        
        
	@Override
	public void onMessage(String data, IOAcknowledge ack) {
		System.out.println("Server said: " + data);
		
	}

	@Override
	public void onError(SocketIOException socketIOException) {
		System.out.println("an Error occured");
		socketIOException.printStackTrace();
                this.saveQuotes.systemFail();
                
	}

	@Override
	public void onDisconnect() {
		System.out.println("Connection terminated.");
	}

	@Override
	public void onConnect() {
		System.out.println("Connection established");
                this.saveQuotes.systemOK();
	}

	@Override
	public void on(String event, IOAcknowledge ack, Object... args) {
		
		if (event.equals("startStorm")){
			try {
				JSONObject json = ((JSONObject) args[0]);
				System.out.println(event + " " + json.getString("cat"));
				try {
					
					String category = json.getString("cat");
					
				
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
                
                else if(event.equals("deleted")){
                    
                    System.out.println("Players deleted");
                }
                //
                else if(event.equals("players")){
                    System.out.println("players arrived");
                    
                    ArrayList<ArrayList<Player>> players = new ArrayList<>();
                    ArrayList<Player> portieri = new ArrayList<>();
                    ArrayList<Player> difensori = new ArrayList<>();
                    ArrayList<Player> centro = new ArrayList<>();
                    ArrayList<Player> attaccanti = new ArrayList<>();
                    
                    JSONArray jsonArray = ((JSONArray) args[0]);
                    for (int i = 0; i < jsonArray.length(); i++){
                        try {
                            System.out.println(jsonArray.getJSONObject(i).getString("ruolo").toString());
                            switch (jsonArray.getJSONObject(i).getString("ruolo")) {
                                case "["+'"'+"portiere"+'"'+"]":
                                    {
                                        Player p = new Player();
                                        p.setNome(stringClean(jsonArray.getJSONObject(i).getString("name")));
                                        p.setSquadra(stringClean(jsonArray.getJSONObject(i).getString("squadra")));
                                        p.setQuotazione(integerClean(jsonArray.getJSONObject(i).getString("quotazione")));
                                        p.setRuolo(stringClean(jsonArray.getJSONObject(i).getString("ruolo")));
                                        p.setBuyPrice(integerClean(jsonArray.getJSONObject(i).getString("prezzo")));
                                        p.setFantaTeam(stringClean(jsonArray.getJSONObject(i).getString("fantaTeam")));
                                        p.setScadenza(stringClean(jsonArray.getJSONObject(i).getString("scadenza")));
                                        p.setRinnovabile(stringClean(jsonArray.getJSONObject(i).getString("rinnovo")));
                                        portieri.add(p);
                                        break;
                                    }
                                case "["+'"'+"difensore"+'"'+"]":
                                    {
                                        Player p = new Player();
                                        p.setNome(stringClean(jsonArray.getJSONObject(i).getString("name")));
                                        p.setSquadra(stringClean(jsonArray.getJSONObject(i).getString("squadra")));
                                        p.setQuotazione(integerClean(jsonArray.getJSONObject(i).getString("quotazione")));
                                        p.setRuolo(stringClean(jsonArray.getJSONObject(i).getString("ruolo")));
                                        p.setBuyPrice(integerClean(jsonArray.getJSONObject(i).getString("prezzo")));
                                        p.setFantaTeam(stringClean(jsonArray.getJSONObject(i).getString("fantaTeam")));
                                        p.setScadenza(stringClean(jsonArray.getJSONObject(i).getString("scadenza")));
                                        p.setRinnovabile(stringClean(jsonArray.getJSONObject(i).getString("rinnovo")));
                                        difensori.add(p);
                                        break;
                                    }
                                case "["+'"'+"centrocampista"+'"'+"]":
                                    {
                                        Player p = new Player();
                                        p.setNome(stringClean(jsonArray.getJSONObject(i).getString("name")));
                                        p.setSquadra(stringClean(jsonArray.getJSONObject(i).getString("squadra")));
                                        p.setQuotazione(integerClean(jsonArray.getJSONObject(i).getString("quotazione")));
                                        p.setRuolo(stringClean(jsonArray.getJSONObject(i).getString("ruolo")));
                                        p.setBuyPrice(integerClean(jsonArray.getJSONObject(i).getString("prezzo")));
                                        p.setFantaTeam(stringClean(jsonArray.getJSONObject(i).getString("fantaTeam")));
                                        p.setScadenza(stringClean(jsonArray.getJSONObject(i).getString("scadenza")));
                                        p.setRinnovabile(stringClean(jsonArray.getJSONObject(i).getString("rinnovo")));
                                        centro.add(p);
                                        break;
                                    }
                                case "["+'"'+"attaccante"+'"'+"]":
                                    {
                                         Player p = new Player();
                                        p.setNome(stringClean(jsonArray.getJSONObject(i).getString("name")));
                                        p.setSquadra(stringClean(jsonArray.getJSONObject(i).getString("squadra")));
                                        p.setQuotazione(integerClean(jsonArray.getJSONObject(i).getString("quotazione")));
                                        p.setRuolo(stringClean(jsonArray.getJSONObject(i).getString("ruolo")));
                                        p.setBuyPrice(integerClean(jsonArray.getJSONObject(i).getString("prezzo")));
                                        p.setFantaTeam(stringClean(jsonArray.getJSONObject(i).getString("fantaTeam")));
                                        p.setScadenza(stringClean(jsonArray.getJSONObject(i).getString("scadenza")));
                                        p.setRinnovabile(stringClean(jsonArray.getJSONObject(i).getString("rinnovo")));
                                        attaccanti.add(p);
                                        break;
                                    }
                            }
                        } catch (JSONException ex) {
                            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        
                    }
                    
                    
                    Collections.sort(portieri,new NameComparatorByRole());
                    Collections.sort(difensori,new NameComparatorByRole());
                    Collections.sort(centro,new NameComparatorByRole());
                    Collections.sort(attaccanti,new NameComparatorByRole());
                    players.add(portieri);
                    players.add(difensori);
                    players.add(centro);
                    players.add(attaccanti);
                    this.saveQuotes.setPlayerList(players);
                    this.saveQuotes.playersLoaded();
                    
                }
                
                
                
		
		
	}
        
        public String stringClean(String toClean){
                    
                    String cleaned = toClean.substring(2, toClean.length()-2);
                    
                    return cleaned;
                }
        
      public int integerClean(String toClean){
                    
                    String cleanedString = toClean.substring(1, toClean.length()-1);
                    int cleaned = Integer.parseInt(cleanedString);
                    return cleaned;
                }
   
        
}
	
	