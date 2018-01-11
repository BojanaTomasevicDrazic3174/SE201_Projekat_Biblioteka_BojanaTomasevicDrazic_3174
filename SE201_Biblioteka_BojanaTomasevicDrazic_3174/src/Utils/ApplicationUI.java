package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;




 




/**
 *
 * @author Bojana
 */


public class ApplicationUI {
	
	private static Logger logger = LogManager.getLogger(ApplicationUI.class.toString());

    /**
     *
     */
    public static Connection conn;	

	static {
		
		try {
			// ucitavanje MySQL drajvera
			Class.forName("com.mysql.jdbc.Driver");

			// konekcija
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/bibliotekauml", "root", "");
			
		} catch (ClassNotFoundException e) {
			logger.error(e);
		} catch (SQLException e) {
			logger.error(e);
		}
	}
}
