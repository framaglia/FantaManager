/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import extractor.VoteExtractor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Calendar;
import model.Formation;
import model.Match;
import model.Player;
import model.Vote;

/**
 *
 * @author kix
 */


public class CalculateScore {

	private Calendar cal;
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



		for(Player p : f.getFormation()){


			double app = 0.0;

			if(p.getNome().equals("Office")){

				app += 4.0;

			}
			else if (p.getNome().equals("OfficeP")) {
				app += 3.0;
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
                double mod = modifier(f);
		score += mod;


		//		if(bonusCasa(cal, 1, f))
		//			score += 2;

		return score;



	}

	public Formation fixFormation(Formation formation) throws IOException {

		Formation fixedForm = new Formation();
		boolean officeIn = false;
		int maxSub = 2;


		for(Player panchinaro : formation.getBench()){
			if(ve.getVotes().containsKey(panchinaro.getNome()) && ve.getVotes().get(panchinaro.getNome()).getVote() != 0.0){
				for(Player titolare : formation.getFormation()) {
					if(titolare.getRuolo().equals(panchinaro.getRuolo()) && !fixedForm.getFormation().contains(panchinaro)) {
						if(!ve.getVotes().containsKey(titolare.getNome()) || ve.getVotes().get(titolare.getNome()).getVote() == 0.0) {
							if(maxSub > 0){
								fixedForm.getFormation().add(panchinaro);
								fixedForm.getBench().add(titolare);
								//								formation.getFormation().add(panchinaro);
								//								formation.getFormation().remove(titolare);

								maxSub -= 1;

							}
						}	
					}
				}
			}

		}


		for(Player p : formation.getFormation()){
			if(ve.getVotes().containsKey(p.getNome()) && ve.getVotes().get(p.getNome()).getVote() != 0.0){
				fixedForm.getFormation().add(p);
			}
			else if(!fixedForm.getBench().contains(p)){

				Player playerIn = subsitute(p,formation,fixedForm,maxSub,officeIn);
				try {
					if(playerIn.getNome().equals("Office"))
						officeIn = true;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					officeIn = true;
				}
				fixedForm.getFormation().add(playerIn);
				fixedForm.getBench().add(p);
				//				formation.getFormation().add(playerIn);
				//				formation.getFormation().remove(p);
				//				formation.getBench().remove(playerIn);
				//				formation.getBench().add(p);
				maxSub -= 1;


			}


		}

		for(Player p : formation.getBench()){
			fixedForm.getBench().add(p);
		}

		for(Player p : fixedForm.getFormation()){
			System.out.println(p.getNome());

		}
		System.out.println("Panchine");
		for(Player p : fixedForm.getBench()){
			System.out.println(p.getNome());

		}

		return fixedForm;


	}

	private Player subsitute(Player p, Formation formation,Formation fixed, int subs, boolean officeIn) {


		String role = p.getRuolo();
		Player playerIn = new Player();
		boolean found = false;


		if(subs < 0){

			playerIn = new Player();
			playerIn.setNome("Over");

		}

		else{ 


			int i = 0;
			//			while (!found && i < formation.getBench().size()) {
			//				if(formation.getBench().get(i).getRuolo().equals(role) && ve.getVotes().get(formation.getBench().get(i).getNome()).getVote() != 0.0) {
			//					playerIn = formation.getBench().get(i);
			//					found = true;
			//
			//				}
			//				else i++;
			//			}

			for (i = 0; !found && i < formation.getBench().size(); i++) {
				if(role.equals("portiere")) {
					playerIn = new Player();
					playerIn.setNome("OfficeP");
                                        playerIn.setRuolo("portiere");
					found = true;
					officeIn = true;
				}
				else if(ve.getVotes().containsKey(formation.getBench().get(i).getNome()) && ve.getVotes().get(formation.getBench().get(i).getNome()).getVote() != 0.0 ) {

					if(!formation.getBench().get(i).getRuolo().equals("portiere") && !fixed.getFormation().contains(formation.getBench().get(i))) {

						int conta = countByRole(formation, formation.getBench().get(i).getRuolo());

						if(formation.getBench().get(i).getRuolo().equals("difensore") && conta < 5) {
							playerIn = formation.getBench().get(i);	
							found = true;
						}
						else if(formation.getBench().get(i).getRuolo().equals("centrocampista") && conta < 5) {
							playerIn = formation.getBench().get(i);	
							found = true;
						}

						else if(formation.getBench().get(i).getRuolo().equals("attaccante") && conta < 3)  {
							playerIn = formation.getBench().get(i);
							found = true;
						}
						else if(!officeIn){
							playerIn = new Player();
							playerIn.setNome("Office");
                                                        playerIn.setRuolo(p.getRuolo());
							found = true;
							officeIn = true;
						}
						else{
							playerIn = new Player();
							playerIn.setNome("Over");
							found = true;
						}
					}
				}
			}
		}

		if(!found && !officeIn){

			playerIn = new Player();
			playerIn.setNome("Office");
		}
		else if(!found && officeIn){
			playerIn = new Player();
			playerIn.setNome("Over");
		}
		return playerIn;
	}

	public int countByRole(Formation formation, String ruolo) {
		int cont = 0;
		for(Player p : formation.getFormation()) {
			if(p.getRuolo().equals(ruolo)) {
				cont++;
			}
		}
		return cont;
	}

/*	public boolean bonusCasa(Calendar calendar, int i, Formation f) {
		boolean isHome = false;
		for(int j : cal.getDay().keySet()) {
			if(i == j) {
				for (ArrayList<Match> m : cal.getDay().values()) {
					for (Match x : m) {
						if(x.getHomeTeam().getName().equals(f.getTeam().getName())) {
							isHome = true;
						}
					}

				}
			}
		}

		return isHome;
	}*/

    private double modifier(Formation f) {
        double mod = 0;
        boolean found = false;
        ArrayList<Player> difensori = new ArrayList<Player>();
        
        
        for(Player p : f.getFormation()){
            if(p.getRuolo().equals("portiere") && p.getNome().equals("Office")){
                mod = 0.0;
                found = true;
            }
                
        }
        
        if(countByRole(f, "difensore") >= 4 && !found) {
			
			double keeperVote = 0;
			for (Player d : f.getFormation()) {
				if(d.getRuolo().equals("difensore") && !d.getNome().equals("Office")) {
					difensori.add(d);
					
				}
				if(d.getRuolo().equals("portiere")) {
					keeperVote = ve.getVotes().get(d.getNome()).getVote();

				}
				
			}
				
				minimumList(difensori);
				double avg = (ve.getVotes().get(difensori.get(0).getNome()).getVote() +  ve.getVotes().get(difensori.get(1).getNome()).getVote() +ve.getVotes().get(difensori.get(2).getNome()).getVote() + keeperVote)/4;
				if(avg >= 6.0 && avg < 6.5) 
					mod = 1;
				else if(avg >= 6.5 && avg < 7)
					mod = 3;
				else if(avg >= 7)
					mod = 6;
				else mod = 0;
		}
        return mod;
    }

    private void minimumList(ArrayList<Player> difensori) {
        
        while(difensori.size() > 3){
            Player min = difensori.get(0);
            for(Player p : difensori){
                if(ve.getVotes().get(min.getNome()).getVote() > ve.getVotes().get(p.getNome()).getVote()){
                    min = p;
                }
            }
            difensori.remove(min);
        }
    }


}
