package Utils;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import View.KnjigaGUI;


public class MojTimerTask extends TimerTask {
//	Logger log = LogManager.getLogger(MojTimerTask.class);
	
	@Override
	public void run() {
//		log.info("Tajmerski zadatak se aktivirao u " + new Date());
		KnjigaGUI knjigaGUI = new KnjigaGUI();
		//knjigaGUI.backUpKnjiga();
	}

	
}
