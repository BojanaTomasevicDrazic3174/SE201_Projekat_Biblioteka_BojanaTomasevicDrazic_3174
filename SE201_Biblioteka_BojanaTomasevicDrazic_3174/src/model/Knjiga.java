package model;

public class Knjiga {
	protected int id;
	protected String naziv;
	protected String autor;
	protected String izdavac;
	protected int godinaIzdanja;
	protected int brojPrimeraka;
	
	public Knjiga(int id, String naziv, String autor, String izdavac,
			int godinaIzdanja, int brojPrimeraka) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.autor = autor;
		this.izdavac = izdavac;
		this.godinaIzdanja = godinaIzdanja;
		this.brojPrimeraka = brojPrimeraka;
	}
	

	public Knjiga(String naziv, String autor, String izdavac, int godinaIzdanja, int brojPrimeraka) {
		super();
		this.naziv = naziv;
		this.autor = autor;
		this.izdavac = izdavac;
		this.godinaIzdanja = godinaIzdanja;
		this.brojPrimeraka = brojPrimeraka;
	}

    public Knjiga(String naziv, String autor, String izdavac) {
        this.naziv = naziv;
        this.autor = autor;
        this.izdavac = izdavac;
    }

    public Knjiga(int id, String naziv, String autor, String izdavac) {
        this.id = id;
        this.naziv = naziv;
        this.autor = autor;
        this.izdavac = izdavac;
    }
    


	public Knjiga() {
		super();
		this.id = -1;
	}

	public int getId() {
		return id;
	}
	

	public int getBrojPrimeraka() {
		return brojPrimeraka;
	}


	public void setBrojPrimeraka(int brojPrimeraka) {
		this.brojPrimeraka = brojPrimeraka;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getIzdavac() {
		return izdavac;
	}

	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}

	public int getGodinaIzdanja() {
		return godinaIzdanja;
	}

	public void setGodinaIzdanja(int godinaIzdanja) {
		this.godinaIzdanja = godinaIzdanja;
	}

	@Override
	public String toString() {
		return "ID: knjige: " +id + ", Naziv: "+ naziv + ", Autor: " + autor + ", Izdavac: "+ izdavac +
				", Godina Izdanja: " + godinaIzdanja + ", Broj Primeraka u Biblioteci: " + brojPrimeraka;
	}
	
	

}
