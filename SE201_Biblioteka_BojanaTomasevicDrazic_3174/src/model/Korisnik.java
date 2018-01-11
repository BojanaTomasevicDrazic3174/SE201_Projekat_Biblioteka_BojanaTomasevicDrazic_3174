
package model;

import java.util.Date;

/**
 *
 * @author Bojana
 */
public class Korisnik {
 
                   
    protected int id;
	protected String ime;
	protected String prezime;
	protected String jmbg;
	protected String username,password,privilegija;

    /**
     *
     */
    public Korisnik() {
    }

    public Korisnik(int id, String ime, String prezime, String jmbg, String username, String password, String privilegija) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.username = username;
        this.password = password;
        this.privilegija = privilegija;
    }

    public Korisnik(String ime, String prezime, String jmbg, String username, String password, String privilegija) {
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.username = username;
        this.password = password;
        this.privilegija = privilegija;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPrivilegija() {
        return privilegija;
    }

    public void setPrivilegija(String privilegija) {
        this.privilegija = privilegija;
    }



}
   