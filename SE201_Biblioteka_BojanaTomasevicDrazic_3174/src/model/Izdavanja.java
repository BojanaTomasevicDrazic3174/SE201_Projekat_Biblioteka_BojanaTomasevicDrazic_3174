package model;

import java.util.Date;

public class Izdavanja {
	protected int id;
	protected Knjiga knjiga;
	protected Clan clan;
	protected Date datumIzdavanja;
	protected int brojDanaIzdavanja;
	
	public Izdavanja(int id, Knjiga knjiga, Clan clan, Date datumIzdavanja,
			int brojDanaIzdavanja) {
		super();
		this.id = id;
		this.knjiga = knjiga;
		this.clan = clan;
		this.datumIzdavanja = datumIzdavanja;
		this.brojDanaIzdavanja = brojDanaIzdavanja;
	}

	public Izdavanja() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Knjiga getKnjiga() {
		return knjiga;
	}

	public void setKnjiga(Knjiga knjiga) {
		this.knjiga = knjiga;
	}

	public Clan getClan() {
		return clan;
	}

	public void setClan(Clan clan) {
		this.clan = clan;
	}

	public Date getDatumIzdavanja() {
		return datumIzdavanja;
	}

	public void setDatumIzdavanja(Date datumIzdavanja) {
		this.datumIzdavanja = datumIzdavanja;
	}

	public int getBrojDanaIzdavanja() {
		return brojDanaIzdavanja;
	}

	public void setBrojDanaIzdavanja(int brojDanaIzdavanja) {
		this.brojDanaIzdavanja = brojDanaIzdavanja;
	}

	@Override
	public String toString() {
		return "Knjiga: " + knjiga.getNaziv()+ ", Izdata clanu: " + clan.ime + " " + clan.prezime+ " , Datum izdavanja: "+
	            datumIzdavanja + " na "+brojDanaIzdavanja+ " dana.";
	}
	
	
	
	

}
