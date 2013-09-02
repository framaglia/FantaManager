package model;

public class Player {

	private String nome;
	private String squadra;
	private int quotazione;
	private String ruolo;
        private Statistic statistic;
        private String fantaTeam;
        private int buyPrice;
        private String scadenza;
        private String rinnovabile;

	public Player(String nome, String squadra, int quotazione, String ruolo) {
		
		this.nome = nome;
		this.squadra = squadra;
		this.quotazione = quotazione;
		this.ruolo = ruolo;
	}

        
    
    public String getRinnovabile() {
        return rinnovabile;
    }

    public void setRinnovabile(String rinnovabile) {
        this.rinnovabile = rinnovabile;
    }

	
    public Statistic getStatistic() {
        return statistic;
    }

    public String getFantaTeam() {
        return fantaTeam;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    
    public String getScadenza() {
        return scadenza;
    }

    public void setScadenza(String scadenza) {
        this.scadenza = scadenza;
    }
    public void setStatistic(Statistic statistic) {
        this.statistic = statistic;
    }

    public void setFantaTeam(String fantaTeam) {
        this.fantaTeam = fantaTeam;
    }

    public void setBuyPrice(int buyPrice) {
        this.buyPrice = buyPrice;
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

	public int getQuotazione() {
		return quotazione;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setSquadra(String squadra) {
		this.squadra = squadra;
	}

	public void setQuotazione(int quotazione) {
		this.quotazione = quotazione;
	}

	@Override
	public String toString() {
		return "Giocatore [nome=" + nome + ", squadra=" + squadra
				+ ", quotazione=" + quotazione + ", ruolo=" + ruolo + "]";
	}

	

	
	
}
