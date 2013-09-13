/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package extractor;

import model.Vote;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author kix
 */
public class VoteExtractor {

    private HashMap<String, Vote> votes = new HashMap<String, Vote>();
    private String pathToFile;

    public VoteExtractor(String path){
        this.pathToFile = path;
        
    }
    
    public String getPathToFile() {
        return pathToFile;
    }

    public void setPathToFile(String pathToFile) {
        this.pathToFile = pathToFile;
    }
    
    public HashMap<String, Vote> getVotes() {
        return votes;
    }
    
    
    public void extractVotes() throws IOException {


        File fileToParse = new File(this.pathToFile);

        

            Document document2parse = Jsoup.parse(fileToParse, "UTF-8");
            Elements allVotes = document2parse.getElementsByTag("tbody");

            for (Element el : allVotes) {
                for (Element tr : el.getElementsByTag("tr")) {

                    boolean redCarded = isRedCarded(tr);
                    boolean yellowCarded = isYellowCarded(tr);
                    
                    

                    String name;
                    String gf;
                    String gr;
                    String gs;
                    String rp;
                    String rs;
                    String au;
                    String as;
                    String vi;
                    String ruolo = "";
                    
                    Vote vote = new Vote();
                    vote.setAm(yellowCarded);
                    vote.setEs(redCarded);
                    
                    String[] cleaned = cleanElement(tr.text());
                    
                    if (cleaned != null) {
                        if (cleaned.length == 31) {
                            
                            if(cleaned[0].equals("P"))
                                ruolo = "portiere";
                            else if(cleaned[0].equals("D"))
                                ruolo = "difensore";
                            else if(cleaned[0].equals("C"))
                                ruolo = "centrocampista";
                            else if(cleaned[0].equals("A"))
                                ruolo = "attaccante";
                            
                            name = cleaned[1].toString()+" ";
                            gf = cleaned[3].toString();
                            gr = cleaned[4].toString();
                            gs = cleaned[5].toString();
                            rp = cleaned[6].toString();
                            rs = cleaned[7].toString();
                            au = cleaned[8].toString();
                            as = cleaned[9].toString();
                            vi = cleaned[26].replace(',', '.').toString();
                            
                            vote.setRuolo(ruolo);
                            
                            if (!gf.equals("-")) {
                                vote.setGf(Integer.parseInt(gf));
                            } else {
                                vote.setGf(0);
                            }

                            if (!gr.equals("-")) {
                                vote.setGr(Integer.parseInt(gr));
                            } else {
                                vote.setGr(0);
                            }

                            if (!gs.equals("-")) {
                                vote.setGs(Integer.parseInt(gs));
                            } else {
                                vote.setGs(0);
                            }

                            if (!rp.equals("-")) {
                                vote.setRp(Integer.parseInt(rp));
                            } else {
                                vote.setRp(0);
                            }

                            if (!rs.equals("-")) {
                                vote.setRs(Integer.parseInt(rs));
                            } else {
                                vote.setRs(0);
                            }

                            if (!au.equals("-")) {
                                vote.setAu(Integer.parseInt(au));
                            } else {
                                vote.setAu(0);
                            }

                            if (!as.equals("-")) {
                                vote.setAs(Integer.parseInt(as));
                            } else {
                                vote.setAs(0);
                            }

                            if (!vi.equals("-")) {

                                vote.setVote(Double.parseDouble(vi.substring(0, 3)));
                            } else {
                                vote.setVote(0.0);
                            }

                            votes.put(name, vote);
                        } else {
                            
                            if(cleaned[0].equals("P"))
                                ruolo = "portiere";
                            else if(cleaned[0].equals("D"))
                                ruolo = "difensore";
                            else if(cleaned[0].equals("C"))
                                ruolo = "centrocampista";
                            else if(cleaned[0].equals("A"))
                                ruolo = "attaccante";
                            
                            name = cleaned[1].concat(" " + cleaned[2].toString()).toString() + " ";
                            gf = cleaned[4].toString();
                            gr = cleaned[5].toString();
                            gs = cleaned[6].toString();
                            rp = cleaned[7].toString();
                            rs = cleaned[8].toString();
                            au = cleaned[9].toString();
                            as = cleaned[10].toString();
                            vi = cleaned[27].replace(',', '.').toString();

                            vote.setRuolo(ruolo);
                            if (!gf.equals("-")) {
                                vote.setGf(Integer.parseInt(gf));
                            } else {
                                vote.setGf(0);
                            }

                            if (!gr.equals("-")) {
                                vote.setGr(Integer.parseInt(gr));
                            } else {
                                vote.setGr(0);
                            }

                            if (!gs.equals("-")) {
                                vote.setGs(Integer.parseInt(gs));
                            } else {
                                vote.setGs(0);
                            }

                            if (!rp.equals("-")) {
                                vote.setRp(Integer.parseInt(rp));
                            } else {
                                vote.setRp(0);
                            }

                            if (!rs.equals("-")) {
                                vote.setRs(Integer.parseInt(rs));
                            } else {
                                vote.setRs(0);
                            }

                            if (!au.equals("-")) {
                                vote.setAu(Integer.parseInt(au));
                            } else {
                                vote.setAu(0);
                            }

                            if (!as.equals("-")) {
                                vote.setAs(Integer.parseInt(as));
                            } else {
                                vote.setAs(0);
                            }

                            if (!vi.equals("-")) {
                                vote.setVote(Double.parseDouble(vi.substring(0, 3)));
                            } else {
                                vote.setVote(0.0);
                            }
                            votes.put(name, vote);
                        }
                    }



                }
            }

        



    }

    public String[] cleanElement(String tr) {

        String[] s = null;
        if (tr.length() > 25 && !tr.contains("class=")) {

            s = tr.split("\\s");
        }

        return s;

    }

    private boolean isYellowCarded(Element tr) {
        
        boolean isCarded = false;
        
        for (Element el : tr.getAllElements()){
            if(el.hasClass("vamm"))
                isCarded = true;
        }
        
        return isCarded;
       
    }
    
    private boolean isRedCarded(Element tr) {
        
        boolean isCarded = false;
        
        for (Element el : tr.getAllElements()){
            if(el.hasClass("vesp"))
                isCarded = true;
        }
        
        return isCarded;
       
    }
}
