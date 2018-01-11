package controler;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Knjiga;
import View.ApplicationUI;
import javax.swing.JOptionPane;

public class KnjigaDAO {
	
	private static Logger log = LogManager.getLogger(ApplicationUI.class.toString());

	
	public Knjiga getKnjigaById(Connection conn , int id){
		Knjiga knjiga = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
					.executeQuery("SELECT naziv, autor, izdavac, godinaIzdanja,brojPrimeraka FROM knjiga WHERE knjiga_id = " + id);

			if (rset.next()) {              //****************if petlja jer samo jedan red mozemo dobiti sa trazenim id-om , primarni kljuc
				String naziv = rset.getString(1);
				String autor = rset.getString(2);
				String izdavac = rset.getString(3);
				int godinaIzdanja = rset.getInt(4);
				int brojPrimeraka = rset.getInt(5);

				
				knjiga = new Knjiga(id, naziv, autor, izdavac, godinaIzdanja,brojPrimeraka);
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			log.info("Ne moze se ucitati knjiga sa id: " + id);
		}
		return knjiga;
		
	}
	
	public List<Knjiga> getAll(Connection conn) {
		List<Knjiga> retVal = new ArrayList<Knjiga>();
		try {
			String query = "SELECT knjiga_id, naziv, autor, izdavac, godinaIzdanja,brojPrimeraka FROM knjiga ";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query.toString());
			while (rset.next()) {
				int id = rset.getInt(1);
				String naziv = rset.getString(2);
				String autor = rset.getString(3);
				String izdavac = rset.getString(4);
				int godinaIzdanja = rset.getInt(5);
				int brojPrimeraka = rset.getInt(6);

				
				Knjiga knjiga = new Knjiga(id, naziv, autor, izdavac, godinaIzdanja,brojPrimeraka);
				retVal.add(knjiga);
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			log.fatal(ex);
			log.fatal("Ne mogu se ucitati knjige");
		}
		return retVal;
	}
	
	public List<Knjiga> getAll(Connection conn, String orderClause) {  ///asc za rastuce sortiranje , desc ya opadajuce sortiranje
		List<Knjiga> retVal = new ArrayList<Knjiga>();
		try {
			String query = "SELECT knjiga_id, naziv, autor, izdavac, godinaIzdanja,brojPrimeraka FROM knjiga ORDER BY " + orderClause;
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query.toString());
			while (rset.next()) {
				int id = rset.getInt(1);
				String naziv = rset.getString(2);
				String autor = rset.getString(3);
				String izdavac = rset.getString(4);
				int godinaIzdanja = rset.getInt(5);
				int brojPrimeraka = rset.getInt(6);

				
				Knjiga knjiga = new Knjiga(id, naziv, autor, izdavac, godinaIzdanja,brojPrimeraka);
				retVal.add(knjiga);
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Ne mogu se ucitati Knjige");
		}
		return retVal;
	}
	
	public boolean add(Connection conn, Knjiga knjiga){
		boolean retVal = false;
		try {
			String update = "INSERT INTO knjiga (naziv, autor, izdavac, godinaIzdanja, brojPrimeraka) values (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, knjiga.getNaziv());
			pstmt.setString(2, knjiga.getAutor());
			pstmt.setString(3, knjiga.getIzdavac());
			pstmt.setInt(4, knjiga.getGodinaIzdanja());
			pstmt.setInt(5, knjiga.getBrojPrimeraka());

			if(pstmt.executeUpdate() == 1){
				retVal = true;
				knjiga.setId(getInsertedId(conn));   //id - koji je za ubacenog studenta
			}
			pstmt.close();
		} catch (SQLException e) {
			log.fatal(e);
			log.fatal("Ne moze se dodati knjiga: " + knjiga);
		}
		return retVal;
	}
	
	protected int getInsertedId(Connection conn) throws SQLException {
		String query = "SELECT LAST_INSERT_ID();";    ///poslednji dodeljeni id 
		Statement stmt = conn.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		int retVal = -1;
		if (rset.next())
			retVal = rset.getInt(1);
		rset.close();
		stmt.close();
		return retVal;
	}
	
	public void backUp(Connection conn){
		List<Knjiga> sveKnjige = new ArrayList<Knjiga>();
		sveKnjige.addAll(getAll(conn));
		
		try {
			String sP = System.getProperty("file.separator");
			Date d = new Date();
			File bibliotekari = new File("."+sP+"materijali"+sP+d.getTime()+"backup.txt"); 
			PrintWriter out = new PrintWriter(new FileWriter(bibliotekari));
			out.println("********************* BACKUP - Bibliotekari *********************");
			out.println(Utils.DateConverter.DateFormat());
			out.println();
			for (Knjiga knjiga : sveKnjige) {
				out.println(knjiga.getId() +","+knjiga.getNaziv()+","+knjiga.getAutor()+","+knjiga.getIzdavac()+","+
			         knjiga.getGodinaIzdanja());
			
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<Integer> getAllKnjigaIds(Connection conn) {  ///asc za rastuce sortiranje , desc ya opadajuce sortiranje
		List<Integer> listIdeva = new ArrayList<>();
		try {
			String query = "SELECT *   FROM knjiga where KNJIGA_ID ";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query.toString());
			while (rset.next()) {
				int id = rset.getInt(1);
				listIdeva.add(id);
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Ne mogu se ucitati Knjige");
		}
		return listIdeva;
	}
        public boolean izmeniNazivKnjige(Connection conn,Knjiga knjiga,int selektovano){
                  boolean retVal = false;
            try {
                 String update = "UPDATE knjiga SET naziv=?, autor=?, izdavac=?, godinaIzdanja=?, brojPrimeraka=? WHERE KNJIGA_ID='"+selektovano+"'";
                 
			PreparedStatement pstmt = conn.prepareStatement(update);
			pstmt.setString(1, knjiga.getNaziv());
			pstmt.setString(2, knjiga.getAutor());
			pstmt.setString(3, knjiga.getIzdavac());
			pstmt.setInt(4, knjiga.getGodinaIzdanja());
			pstmt.setInt(5, knjiga.getBrojPrimeraka());
                        if(pstmt.executeUpdate() == 1){
				retVal = true;
				knjiga.setId(getInsertedId(conn));   //id - koji je za ubacenog studenta
			}
                 
                return retVal;
                
            } catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Ne mogu se promeniti podaci");
		}
            return retVal;
        }

        	public Knjiga getNazivAutorIzdavac(Connection conn) {
                    System.out.println("Zdravo jos jednom");
		Knjiga retVal = new Knjiga();
		try {
			String query = "SELECT knjiga_id, naziv, autor, izdavac FROM knjiga ";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query.toString());
			while (rset.next()) {
				//int id = rset.getInt(1);
				String naziv = rset.getString(2);
				String autor = rset.getString(3);
				String izdavac = rset.getString(4);
//				int godinaIzdanja = rset.getInt(5);
//				int brojPrimeraka = rset.getInt(6);

				
//				Knjiga knjiga = new Knjiga(id, naziv, autor, izdavac, godinaIzdanja,brojPrimeraka);
                                //Knjiga knjiga = new Knjiga(id, naziv, autor, izdavac);
                                 //Knjiga knjiga = new Knjiga(naziv, autor, izdavac);
                               retVal.setNaziv(naziv);
                               retVal.setAutor(autor);
                               retVal.setIzdavac(izdavac);
                               
                                 
				
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			log.fatal(ex);
			log.fatal("Ne mogu se ucitati knjige");
		}
		return retVal;
	}

}
