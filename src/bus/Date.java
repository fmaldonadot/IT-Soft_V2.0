package bus;

import java.io.Serializable;

public class Date implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String day;
	private String month;
	private String year;
	
	public String getDay() {
		return day;
	}
	public void setDay(String day) throws ExceptionHandler 
	{
		Controler.verifyData( day , Controler.patternDay , new ExceptionHandler("Invalid day.  Must be between 1 - 31\n") );
		this.day = day;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) throws ExceptionHandler 
	{
		Controler.verifyData( month , Controler.patternMonth , new ExceptionHandler("Invalid month.  Must be between 1 - 12\n") );
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) throws ExceptionHandler 
	{
		Controler.verifyData( year , Controler.patternYear , new ExceptionHandler("Invalid year.  Must be between 1900 - 2099\n") );
		this.year = year;
	}
	
	public Date(){}
	public Date(String day, String month, String year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}
	@Override
	public String toString() {
		return day + "|/" + month + "|/" + year;
	}
}
