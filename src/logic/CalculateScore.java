/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import extractor.VoteExtractor;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Formation;
import model.Player;

/**
 *
 * @author kix
 */
public class CalculateScore {
    
    private VoteExtractor ve = new VoteExtractor();
    
    public CalculateScore(){
        try {
            ve.extractVotes();
        } catch (IOException ex) {
            Logger.getLogger(CalculateScore.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public double calculate(Formation formation) throws IOException{
        
        Formation f = fixFormation(formation);
        
        double score = 0;
        
      
        
        for (String nome : ve.getVotes().keySet()){
            for(Player p : f.getFormation()){
                
                    
                    double app = 0.0;
                    
                    if(p.getNome().equals("Office")){
                        
                        app += 4.0;
                        
                    }
                    else if(p.getNome().equals("Over")){
                        
                        app += 0.0;
                        
                    }
                    else {
                        
                    app += ve.getVotes().get(p.getNome()).getVote();
                    app +=  3.0 * ve.getVotes().get(p.getNome()).getGf();
                    app += ve.getVotes().get(p.getNome()).getAs();
                    app += -2.0 * ve.getVotes().get(p.getNome()).getAu();
                    app += 3.0 * ve.getVotes().get(p.getNome()).getGr();
                    app += -1.0 * ve.getVotes().get(p.getNome()).getGs();
                    app += 3.0 * ve.getVotes().get(p.getNome()).getRp();
                    app += -3.0 * ve.getVotes().get(p.getNome()).getRs();
                    if(ve.getVotes().get(p.getNome()).isAm())
                        app -= 0.5;
                    if(ve.getVotes().get(p.getNome()).isEs())
                        app -= 1.0;
                    }
                    
                    score += app;

            }
                
        }
        
        
        return score;
        
        
        
    }

    public Formation fixFormation(Formation formation) throws IOException {
        
        Formation fixedForm = new Formation();
        
        int maxSub = 3;
        
    
        
        for (String nome : ve.getVotes().keySet()){
            for(Player p : formation.getFormation()){
                if(ve.getVotes().containsKey(p.getNome())){
                    fixedForm.getFormation().add(p);
                }
                else {
                    if (!ve.getVotes().containsKey(p.getNome()) || ve.getVotes().get(p.getNome()).getVote() == 0.0 ){
                        
                        Player playerIn = subsitute(p,formation,maxSub);
                        fixedForm.getFormation().add(playerIn);
                        formation.getFormation().remove(playerIn);
                        formation.getBench().remove(playerIn);
                        maxSub -= 1;
                    }
                        
                        }
                    
                
            }
        }
        
        return fixedForm;
        
        
    }

    private Player subsitute(Player p, Formation formation, int subs) {
        
        
        String role = p.getRuolo();
        Player playerIn;
        if(subs == 0){
            playerIn = new Player();
            playerIn.setNome("Office");
            
            
        }else if(subs < 0){
            
            playerIn = new Player();
            playerIn.setNome("Over");
            
        }
        
        else{
            
            playerIn = formation.getBench().get(0);
            
            
        }
        
        
        return playerIn;
    }
    
}
