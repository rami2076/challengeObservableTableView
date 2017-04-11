package logic.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

//SUMMARY:: LocalDateからStringへの変換とStringからLocalDateへの変換また、String型をLocalDateに変換できるか確認する。 LocalDateからの変換の確認は不要。



/**
 * Helper functions for handling dates.
 *
 *@author nyx
 */
public class DateUtil {
	//** the date pattern that  is used for conversion. charge as you wish.
	private static final String DATE_PARTTERN = "yyyy.MM.dd";

	//**the date formatter.
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PARTTERN);

	/**
	 * @param date the date to be returned  as String. the above defined.
	 * @return formated  String
	 */
	public static String format(LocalDate date){
		if (date ==null){
			return null;
		}else{
			return DATE_FORMATTER.format(date);
		}
	}

	/**
	 *
	 * converts a String in the format of the  defined {@ink DateUtil#DATE_PATTERN}
	 * to a{@ink LocalDate} object.
	 *
	 * @param dateString the date as String.
	 * @return the date object or null if  it could not be converted.
	 */
	public static LocalDate parse(String dateString){
		try{
			return DATE_FORMATTER.parse(dateString,LocalDate::from);
		}catch(DateTimeParseException e){
			e.printStackTrace();
			return null;
		}
	}

/**
 *
 * check the String whether it is a vaild date.
 * @param dateString
 * @return turn if the String is a vaild date.
 */
public static boolean vaildDate(String dateString ){
	//try to parse the String.
		return 	DateUtil.parse(dateString) !=null;//Q:: Why explicitly describe Class.
	}



}
