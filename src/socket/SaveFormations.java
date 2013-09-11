package socket;


import java.util.HashMap;

import model.Formation;

import ui.VotesUI;


/**
 *
 * @author kix
 */
public class SaveFormations {
    
    private Socket socket;
    
    private HashMap<String, Formation> allFormations; 
    
    private VotesUI vui;
   
    
    
    public SaveFormations(VotesUI vui) {
        
        this.allFormations = new HashMap<String, Formation>();
        
        this.vui = vui;
        this.socket = new Socket(this);
        
        
    
    }

    
    
   
    public void getFormationsByDB(){
        this.socket.getSocket().emit("getAllFormations", "ciao");
        this.socket.getSocket().emit("getAllFormations", "ciao");

    }
    
  
    public void formationsLoaded(){
        this.vui.setFormationsMap(allFormations);
        this.vui.formationLoaded();
    }
    
   

    public HashMap<String, Formation> getAllFormations() {
        return allFormations;
    }

    public void setAllFormations(HashMap<String, Formation> allFormations) {
        this.allFormations = allFormations;
    }
    
}
