package extractor;

import model.Player;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;



public class PlayerExtractor {

    public ArrayList<ArrayList<Player>> extract() throws IOException {


        ArrayList<ArrayList<Player>> players = new ArrayList<>();
        File dir = new File("/home/kix/Documenti/fantaDoc/quotazioni");

        for (File child : dir.listFiles()) {

            ArrayList<Player> rolePlayers = new ArrayList<>();
            Document document2parse = Jsoup.parse(child, "UTF-8");
            String ruolo = child.getName().replace(".html", "");

            Elements tbody = document2parse.getElementsByTag("tbody");


            for (Element e : tbody) {

                for (Element tr : e.getElementsByTag("tr")) {

                    Player g = new Player();
                    g.setRuolo(ruolo);
                    double quotazione = (Math.round(Double.parseDouble(tr.getElementsByTag("td").get(1).text().replace(',', '.'))));
                    g.setQuotazione(quotazione);
                    for (Element td : tr.getElementsByTag("td")) {
                        if (td.getElementsByTag("a").attr("title").contains("Visualizza le statistiche di")) {
                            String nome = td.getElementsByTag("a").text();
                            g.setNome(nome);
                        }
                        if (td.getElementsByTag("a").attr("title").contains("Visualizza le statistiche squadra")) {
                            String squadra = td.getElementsByTag("a").text();
                            g.setSquadra(squadra);
                        }

                    }
                    rolePlayers.add(g);
                }
            }


            Collections.sort(rolePlayers, new NameComparatorByRole());
            players.add(rolePlayers);


        }
        return players;



    }
}