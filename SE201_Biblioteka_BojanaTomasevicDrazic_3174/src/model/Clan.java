package model;

public class Clan {
	protected int id;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String adresa;
	
	public Clan(int id, String ime, String prezime, String jmbg, String adresa) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.adresa = adresa;
	}

	public Clan(int id) {
		super();
		this.id = -1;
	}

	public Clan() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	@Override
	public String toString() {
		return "Clan: " + ime + " " +prezime + ", JMBG: " + jmbg + ", Adresa: " + adresa;
	}
	
	
	
	
	

}
