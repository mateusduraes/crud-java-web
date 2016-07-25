package util;

import java.sql.Date;
import java.util.Calendar;

public class Utilitarios {

	public static Date converteDataParaSQL(Calendar dataCadastro) {		
		return new Date(dataCadastro.getTimeInMillis());
	}

	public static Calendar converteSQLParaCalendar(Date date) {
		Calendar data = Calendar.getInstance();
		data.setTime(date);		
		return data;
	}

}
