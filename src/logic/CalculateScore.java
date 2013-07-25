/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import extractor.VoteExtractor;
import java.io.IOException;
import model.Formation;
import model.Player;

/**
 *
 * @author kix
 */
public class CalculateScore {
    
    public double calculate(Formation formation) throws IOException{
        
        Formation f = fixFormation(formation);
        
        double score = 0;
        
        VoteExtractor ve = new VoteExtractor();
        ve.extractVotes();
        
        for (String nome : ve.getVotes().keySet()){
            for(Player p : f.getFormation()){
                
                   
                    double app = ve.getVotes().get(p.getNome()).getVote();
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
                    
                    score += app;

            }
                
        }
        
        
        return score;
        
        
        
    }

    public Formation fixFormation(Formation formation) throws IOException {
        
        Formation fixedForm = new Formation();
        
        int maxSub = 3;
        
        
        VoteExtractor ve = new VoteExtractor();
        ve.extractVotes();
        
        for (String nome : ve.getVotes().keySet()){
            for(Player p : formation.getFormation()){
                if(ve.getVotes().containsKey(p.getNome())){
                    fixedForm.getFormation().add(p);
                }
                else {
                    if (!ve.getVotes().containsKey(p.getNome()) || ve.getVotes().get(p.getNome()).getVote() == 0.0 ){
                        
                        Player playerIn = subsitute(p,formation);
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

    private Player subsitute(Player p, Formation formation) {
        
        String role = p.getRuolo();
        Player playerIn = null;
        
        
        
        
        return playerIn;
    }
    
}
