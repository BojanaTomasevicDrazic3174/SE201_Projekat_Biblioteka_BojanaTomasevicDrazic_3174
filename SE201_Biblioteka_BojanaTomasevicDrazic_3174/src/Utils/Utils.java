package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Bojana
 */
public class Utils {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     *
     * @param string
     * @return
     */
    public static Date napraviDatum(String string) {
		try {
			if(string == null || "".equals(string)){
				return new java.sql.Date(sdf.parse(new Date().toString()).getTime());
			}else{
				return new java.sql.Date(sdf.parse(string).getTime());
			}	
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

}
