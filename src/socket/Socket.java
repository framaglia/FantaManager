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
import java.util.HashMap;
import java.util.List;
import model.Cash;
import model.Formation;
import model.Match;
import model.Team;




public class Socket implements IOCallback {
	
	private SocketIO socket;
        private SaveQuotes saveQuotes;
        private LoadFormations loadFormations;
        
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
        
        public Socket(LoadFormations saveFormations)  {
                
            this.loadFormations = saveFormations;
                
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
                //this.saveQuotes.systemFail();
                
	}

	@Override
	public void onDisconnect() {
		System.out.println("Connection terminated.");
	}

	@Override
	public void onConnect() {
		System.out.println("Connection established");
                //this.saveQuotes.systemOK();
	}

	@Override
	public void on(String event, IOAcknowledge ack, Object... args) {
		
		if(event.equals("deleted")){
                    
                    System.out.println("Players deleted");
                }
                
                else if(event.equals("cashes")){
                    System.out.println("cashes arrived");
                    
                    HashMap<String, Cash> cashes = new HashMap<String, Cash>();
                    JSONArray jsonArray = ((JSONArray) args[0]);
                    try {
                        System.out.println(jsonArray.getJSONObject(0).getString("cash"));
                    } catch (JSONException ex) {
                        Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    for (int i = 0; i < jsonArray.length(); i++){
                        try {
                            System.out.println(jsonArray.getJSONObject(i).getString("team").toString());
                            String team = jsonArray.getJSONObject(i).getString("team");
                            int cash = jsonArray.getJSONObject(i).getInt("cash");
                            int charge = jsonArray.getJSONObject(i).getInt("charge");
                            Cash c = new Cash();
                            c.setCash(cash);
                            c.setCharge(charge);
                            cashes.put(team, c);
                        } catch (JSONException ex) {
                            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    this.saveQuotes.setCashes(cashes);
                    this.saveQuotes.cashesLoaded();
                }
                
                //
                else if(event.equals("players")){
                    System.out.println("players arrived");
                    
                    ArrayList<ArrayList<Player>> players = new ArrayList<ArrayList<Player>>();
                    ArrayList<Player> portieri = new ArrayList<Player>();
                    ArrayList<Player> difensori = new ArrayList<Player>();
                    ArrayList<Player> centro = new ArrayList<Player>();
                    ArrayList<Player> attaccanti = new ArrayList<Player>();
                    
                    JSONArray jsonArray = ((JSONArray) args[0]);
                    for (int i = 0; i < jsonArray.length(); i++){
                        try {
                            String attRole = jsonArray.getJSONObject(i).getString("ruolo").toString();
                            if (attRole.equals("portiere")) {
                                
                                    
                                        Player p = new Player();
                                        p.setNome(jsonArray.getJSONObject(i).getString("name"));
                                        p.setSquadra(jsonArray.getJSONObject(i).getString("squadra"));
                                        p.setQuotazione(jsonArray.getJSONObject(i).getInt("quotazione"));
                                        p.setRuolo(jsonArray.getJSONObject(i).getString("ruolo"));
                                        p.setBuyPrice(jsonArray.getJSONObject(i).getInt("prezzo"));
                                        p.setFantaTeam(jsonArray.getJSONObject(i).getString("fantaTeam"));
                                        p.setScadenza(jsonArray.getJSONObject(i).getString("scadenza"));
                                        p.setRinnovabile(jsonArray.getJSONObject(i).getString("rinnovo"));
                                        portieri.add(p);
                                       
                                    }
                                    else if(attRole.equals("difensore"))
                                    {
                                        Player p = new Player();
                                        p.setNome(jsonArray.getJSONObject(i).getString("name"));
                                        p.setSquadra(jsonArray.getJSONObject(i).getString("squadra"));
                                        p.setQuotazione(jsonArray.getJSONObject(i).getInt("quotazione"));
                                        p.setRuolo(jsonArray.getJSONObject(i).getString("ruolo"));
                                        p.setBuyPrice(jsonArray.getJSONObject(i).getInt("prezzo"));
                                        p.setFantaTeam(jsonArray.getJSONObject(i).getString("fantaTeam"));
                                        p.setScadenza(jsonArray.getJSONObject(i).getString("scadenza"));
                                        p.setRinnovabile(jsonArray.getJSONObject(i).getString("rinnovo"));
                                        difensori.add(p);
                                        
                                    }
                                else if(attRole.equals("centrocampista"))
                                    {
                                        Player p = new Player();
                                        p.setNome(jsonArray.getJSONObject(i).getString("name"));
                                        p.setSquadra(jsonArray.getJSONObject(i).getString("squadra"));
                                        p.setQuotazione(jsonArray.getJSONObject(i).getInt("quotazione"));
                                        p.setRuolo(jsonArray.getJSONObject(i).getString("ruolo"));
                                        p.setBuyPrice(jsonArray.getJSONObject(i).getInt("prezzo"));
                                        p.setFantaTeam(jsonArray.getJSONObject(i).getString("fantaTeam"));
                                        p.setScadenza(jsonArray.getJSONObject(i).getString("scadenza"));
                                        p.setRinnovabile(jsonArray.getJSONObject(i).getString("rinnovo"));
                                        centro.add(p);
                                        
                                    }
                                else if(attRole.equals("attaccante"))
                                    {
                                        Player p = new Player();
                                        p.setNome(jsonArray.getJSONObject(i).getString("name"));
                                        p.setSquadra(jsonArray.getJSONObject(i).getString("squadra"));
                                        p.setQuotazione(jsonArray.getJSONObject(i).getInt("quotazione"));
                                        p.setRuolo(jsonArray.getJSONObject(i).getString("ruolo"));
                                        p.setBuyPrice(jsonArray.getJSONObject(i).getInt("prezzo"));
                                        p.setFantaTeam(jsonArray.getJSONObject(i).getString("fantaTeam"));
                                        p.setScadenza(jsonArray.getJSONObject(i).getString("scadenza"));
                                        p.setRinnovabile(jsonArray.getJSONObject(i).getString("rinnovo"));
                                        attaccanti.add(p);
                                        
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
                else if(event.equals("allFormations")){
                    
                    HashMap<String, Formation> allFormations = new HashMap<String, Formation>();
                    JSONArray jsonArray = ((JSONArray) args[0]);
                    for (int i = 0; i < jsonArray.length(); i++){
                        Formation f = new Formation();
                        try {
                            String team = jsonArray.getJSONObject(i).getString("user");
                            
                           
                            JSONArray arr = jsonArray.getJSONObject(i).getJSONArray("formation");
                            
                            for(int cont = 0; cont < arr.length(); cont++){
                                Player p = new Player();
                                p.setNome(arr.getString(cont));
                                
                                if(cont < 11){
                                    f.getFormation().add(p);
                                }
                                else{
                                    f.getBench().add(p);
                                }
                            }
                                              
                        allFormations.put(team, f);
                       
                        } catch (JSONException ex) {
                            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
                    this.loadFormations.setAllFormations(allFormations);
                    this.loadFormations.formationsLoaded();
                }
                
                else if(event.equals("calendarDay")){
                    JSONArray jsonArray = ((JSONArray) args[0]);
                    ArrayList<Match> matches = new ArrayList<Match>();
                    for (int i = 0; i < jsonArray.length(); i++){
                        try {
                            JSONArray arr = jsonArray.getJSONObject(i).getJSONArray("matches");
                            for(int cont = 0; cont < arr.length(); cont++){
                                
                                String[] s = arr.getString(cont).split("-");
                                String home = s[0];
                                home = stringTeamClean(home);
                                String visitor = s[1];
                                visitor = stringTeamClean(visitor);
                                Match m = new Match();
                                m.setHomeTeam(home);
                                m.setAwayTeam(visitor);
                                matches.add(m);
                        }
                            this.loadFormations.setMatches(matches);
                            this.loadFormations.matchesLoaded();
                        } catch (JSONException ex) {
                            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
                
                else if(event.equals("rolePlayers")){
                    //System.out.println("arrivati");
                    
                    JSONArray jsonArray = ((JSONArray) args[0]);
                    //System.out.println(jsonArray.toString());
                    for (int i = 0; i < jsonArray.length(); i++){
                        try {
                            String role = jsonArray.getJSONObject(i).getString("ruolo").toString();
                            String name = jsonArray.getJSONObject(i).getString("name").toString();
                            String fantaTeam = jsonArray.getJSONObject(i).getString("fantaTeam").toString();
                            Player p = new Player();
                            p.setNome(name);
                            p.setRuolo(role);
                            p.setFantaTeam(fantaTeam);
                            this.loadFormations.getRolePlayers().add(p);
                            
                            
                        } catch (JSONException ex) {
                            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    this.loadFormations.setTeamLoaded(this.loadFormations.getTeamLoaded()+1);
                    this.loadFormations.teamLoaded();
                }
                
                else if(event.equals("ranking")){
                    JSONArray jsonArray = ((JSONArray) args[0]);
                    for(int i = 0; i < jsonArray.length(); i++){
                        try {
                            JSONArray arrNames = jsonArray.getJSONObject(i).getJSONArray("ranking");
                            JSONArray arrScores = jsonArray.getJSONObject(i).getJSONArray("scores");
                            JSONArray arrGf = jsonArray.getJSONObject(i).getJSONArray("gf");
                            JSONArray arrGs = jsonArray.getJSONObject(i).getJSONArray("gs");
                            JSONArray arrMp = jsonArray.getJSONObject(i).getJSONArray("mp");
                            JSONArray arrWin = jsonArray.getJSONObject(i).getJSONArray("win");
                            JSONArray arrLost = jsonArray.getJSONObject(i).getJSONArray("lost");
                            JSONArray arrDraw = jsonArray.getJSONObject(i).getJSONArray("draw");
                            JSONArray arrDg = jsonArray.getJSONObject(i).getJSONArray("dg");
                            for(int j = 0; j < arrNames.length(); j++){
                                Team t = new Team();
                                t.setName(stringTeamScoresClean(arrNames.getString(j)));
                                t.setDg(arrDg.getInt(j));
                                t.setDraw(arrDraw.getInt(j));
                                t.setGf(arrGf.getInt(j));
                                t.setGs(arrGs.getInt(j));
                                t.setLost(arrLost.getInt(j));
                                t.setMp(arrMp.getDouble(j));
                                t.setPunti(arrScores.getInt(j));
                                t.setWin(arrWin.getInt(j));
                                
                                    this.loadFormations.getTeamScores().add(t);
                               
                               
                            }
                        } catch (JSONException ex) {
                            Logger.getLogger(Socket.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    
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
      
      public String stringTeamClean(String toClean){
          String copy = toClean;
          String trimmed = copy.trim();
          String cleaned;
          cleaned = trimmed.toLowerCase();
          String matched;
          if (cleaned.startsWith("acd"))
              matched = "acdc";
          else if(cleaned.startsWith("y"))
              matched = "acybris";
          else if(cleaned.startsWith("cs"))
              matched = "cska";
          else if(cleaned.startsWith("dl"))
              matched = "dlc";
          else if(cleaned.startsWith("gp"))
              matched = "gpsundergland";
          else if(cleaned.startsWith("par"))
              matched = "paris";
          else if(cleaned.startsWith("fel"))
              matched = "felix";
          else if(cleaned.startsWith("tcc"))
              matched = "tccfc";
          else if(cleaned.startsWith("vt"))
              matched = "vts";
          else if(cleaned.startsWith("tro"))
              matched = "astronzo";
          else if(cleaned.startsWith("fanf"))
              matched = "fanfulla";
          else matched = "fantaroma";
          
          return matched;
      }
       
      
      public String stringTeamScoresClean(String toClean){
          String copy = toClean;
          String trimmed = copy.trim();
          String cleaned;
          cleaned = trimmed.toLowerCase();
          String matched;
          if (cleaned.startsWith("acd"))
              matched = "acdc";
          else if(cleaned.startsWith("acy"))
              matched = "acybris";
          else if(cleaned.startsWith("cs"))
              matched = "cska";
          else if(cleaned.startsWith("dl"))
              matched = "dlc";
          else if(cleaned.startsWith("gp"))
              matched = "gpsundergland";
          else if(cleaned.startsWith("par"))
              matched = "paris";
          else if(cleaned.startsWith("fel"))
              matched = "felix";
          else if(cleaned.startsWith("tcc"))
              matched = "tccfc";
          else if(cleaned.startsWith("vt"))
              matched = "vts";
          else if(cleaned.startsWith("astro"))
              matched = "astronzo";
          else if(cleaned.startsWith("fanf"))
              matched = "fanfulla";
          else matched = "fantaroma";
          
          return matched;
      }
        
}
	
	