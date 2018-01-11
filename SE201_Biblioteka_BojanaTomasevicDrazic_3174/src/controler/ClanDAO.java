package controler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import model.Clan;
import View.ApplicationUI;



public class ClanDAO {
	
	private static Logger log = LogManager.getLogger(ApplicationUI.class.toString());

	
	public Clan getClanById(Connection conn, int id) {
		Clan clan = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt
					.executeQuery("SELECT ime, prezime, jmbg, adresa FROM clan WHERE student_id = " + id);

			if (rset.next()) {              //****************if petlja jer samo jedan red mozemo dobiti sa trazenim id-om , primarni kljuc
				String ime = rset.getString(1);
				String prezime = rset.getString(2);
				String jmbg = rset.getString(3);
				String adresa = rset.getString(4);
				
				clan = new Clan(id, ime, prezime, jmbg, adresa);
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			log.fatal(ex);
			log.fatal("Ne moze se ucitati clan sa id: " + id);
		}
		return clan;
	}
	
	public List<Clan> getAll(Connection conn) {
		List<Clan> retVal = new ArrayList<Clan>();
		try {
			String query = "SELECT clan_id , ime, prezime, jmbg, adresa FROM clan ";
			Statement stmt = conn.createStatement();
			ResultSet rset = stmt.executeQuery(query.toString());
			while (rset.next()) {
				int id = rset.getInt(1);
				String ime = rset.getString(2);
				String prezime = rset.getString(3);
				String jmbg = rset.getString(4);
				String adresa = rset.getString(5);

				
				Clan clan = new Clan(id, ime, prezime, jmbg, adresa);
				retVal.add(clan);
			}
			rset.close();
			stmt.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			log.fatal(ex);
			log.fatal("Ne mogu se ucitati clanovi");
		}
		return retVal;
	}
	

	

}
