
package controler;

import View.ApplicationUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.Korisnik;

import model.Radnik;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author bojana
 *
 */
public class KorisnikDAO {
	private static Logger log = LogManager.getLogger(ApplicationUI.class.toString());

	/**
	 * Metoda za proveru korisnika pri logovanju
	 * @param conn
	 * @param korisnickoK
	 * @param lozinkaK
	 * @return
	 * @throws Exception
	 */
	public Radnik login(Connection conn, String korisnickoK, String lozinkaK) throws Exception {

		Radnik k = new Radnik();
		try {
			String sql = "Select * from korisnik where username ='" + korisnickoK + "' and password ='"
					+ lozinkaK + "'    ";
			Statement stmt = conn.createStatement();
			ResultSet rsP = stmt.executeQuery(sql);

			if (rsP.next()) {

				k.setPrivilegija(rsP.getString("privilegija"));
			} else {
				throw new Exception("Korisnicki nalog  Nije Pronadjen!!!");
			}

			rsP.close();
			stmt.close();
		} catch (Exception e) {
			throw new Exception();
		}
		return k;
	}                           
	
	/**
	 * Provera korisnika po username
	 * @param conn
	 * @param username
	 * @return
	 * @throws Exception
	 */
	public int proveraKorisnika(Connection conn, String username) throws Exception {
		int id = 0;
		try {
			String idProvera = "Select * from korisnick where username = '" + username + "'";
			Statement stmt = conn.createStatement();
			ResultSet rsID = stmt.executeQuery(idProvera);
			if (rsID.next()) {
				id = rsID.getInt("ID_RADNIKA");
			}

			rsID.close();
			stmt.close();
		} catch (Exception e) {
			throw new Exception("Pogresan username - " + username);
		}
		return id;
	}
          public boolean  kreirajClana(Connection conn, Korisnik k) {        
             boolean retVal = false;
            
        try
        {
            String update  = "Insert into korisnik(IME,PREZIME,JMBG,USERNAME,PASSWORD,PRIVILEGIJA) values (?, ?, ?, ?, ?,?)";
            PreparedStatement pstmt = conn.prepareStatement(update);
           
                        pstmt.setString(1, k.getIme());
			pstmt.setString(2, k.getPrezime());
			pstmt.setString(3, k.getJmbg());
			pstmt.setString(4, k.getUsername());
			pstmt.setString(5, k.getPassword());
                        pstmt.setString(6, k.getPrivilegija());
                        if(pstmt.executeUpdate() == 1){
				retVal = true;
				k.setId(getInsertedId(conn));   //id - koji je za ubacenog studenta
			}
			pstmt.close();
        }
        catch (SQLException e) {
			log.fatal(e);
			log.fatal("Ne moze se dodati novi clan: " + k);
		}

            return retVal;
    }  
          
          
          public int getInsertedId(Connection conn) throws SQLException {
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
    
}
