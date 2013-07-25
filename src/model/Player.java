package model;

public class Player {

	private String nome;
	private String squadra;
	private double quotazione;
	private String ruolo;
        private Statistic statistic;
        private Team fantaTeam;
        private int buyPrice;
	
	public Player(String nome, String squadra, int quotazione, String ruolo) {
		
		this.nome = nome;
		this.squadra = squadra;
		this.quotazione = quotazione;
		this.ruolo = ruolo;
	}
	
	public String getRuolo() {
		return ruolo;
	}

	public void setRuolo(String ruolo) {
		this.ruolo = ruolo;
	}

	public Player () {
		
	}

	public String getNome() {
		return nome;
	}

	public String getSquadra() {
		return squadra;
	}

	public double getQuotazione() {
		return quotazione;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public void setQuotazione(double quotazione) {
		this.quotazione = quotazione;
	}

	@Override
	public String toString() {
		return "Giocatore [nome=" + nome + ", squadra=" + squadra
				+ ", quotazione=" + quotazione + ", ruolo=" + ruolo + "]";
	}

	

	
	
}
