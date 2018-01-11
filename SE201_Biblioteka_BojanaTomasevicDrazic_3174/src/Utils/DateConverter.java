package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateConverter {

	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static Date napraviDatum(String string) {
		try {
			return new java.sql.Date(sdf.parse(string).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static String DateFormat(){
		java.text.DateFormat df = new SimpleDateFormat("d MMM yyyy HH:mm:ss");
		Date today = Calendar.getInstance().getTime(); 
		String reportDate = df.format(today);
		return "Report Date: " + reportDate;
		
	}

}
