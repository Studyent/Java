
package projet;

import java.text.ParseException;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;

import balade.Vehicules;
import lasauvegarde.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GestionDates implements Serializable{
	private String date;
	private final String format = "dd/MM/yyyy";
	private SimpleDateFormat dateformat;

	public GestionDates(String dates) throws ParseException {

		dateformat = new SimpleDateFormat(format);
		try {
			Date ladate = dateformat.parse(dates);
			this.date = dateformat.format(ladate);
		} catch (ParseException e) {
			throw new ParseException("Merci de saisir la date dans le format dd/MM/yyyy",e.getErrorOffset());

		}	


	}


	public String getDate(){

		return date;

	}

	public void setDate(String dates) {

		this.date = dates;

	}



	@Override
	public String toString() {

		return "Date:" + getDate();

	}

}
