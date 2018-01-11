package model;

import java.util.Date;

public class Vracanje {
	
	private int idIzdavanja;
        private int ostecenje_id;
          private int rad_korisnik_id;
	private Date datumVracanja;
	
	public Vracanje(int idIzdavanja, Date datumVracanja) {
		super();
		this.idIzdavanja = idIzdavanja;
		this.datumVracanja = datumVracanja;
	}
	
	public Vracanje() {
		super();
	}

	public int getIdIzdavanja() {
		return idIzdavanja;
	}

	public void setIdIzdavanja(int idIzdavanja) {
		this.idIzdavanja = idIzdavanja;
	}

	public Date getDatumVracanja() {
		return datumVracanja;
	}

	public void setDatumVracanja(Date datumVracanja) {
		this.datumVracanja = datumVracanja;
	}
	

}
