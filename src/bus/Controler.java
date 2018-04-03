package bus;

public class Controler 
{
	public final static String patternSIN = "^[0-9]{3}[-]{0,1}[0-9]{3}[-]{0,1}[0-9]{3}$"; // SIN must be 999-999-999 or 999999999
	public final static String patternDay = "([0-2]*[1-9]|[3][0-1])";              // Day must be a value between 1 and 31
	public final static String patternMonth = "([1-9]|[1][0-2])";                 // Month must be a value between 1 and 12
	public final static String patternYear = "([1][9][0-9]{2}|[2][0][0-9]{2})";   // Year must be a value between 1900 and 2099
	public final static String patternMoney = "([0-9]+|[0-9]+[.]{1}[0-9]+)";// Money must be a number 
	public final static String patternCountcode = "[+]{0,1}[1-9]{2}";     // Country Code must be a 2 digits number with "+" or not
	public final static String patternCitycode = "[0-9]{3}";        // City Code must be a 3 digits number
	public final static String patternLocalcode = "[0-9]{7}";        // City Code must be a 7 digits number
	public final static String patternExtention = "[0-9]{3}";        // City Code must be a 3 digits number
	public final static String patternEmail = "[0-9a-zA-Z]+[@]{1}[0-9a-zA-Z]+[.]{1}[a-zA-Z]{3}"; // email pattern
	public final static String patternStreetno = "[0-9]{2,4}"; // Street Number between 2 and 4 digits number
	public final static String patternApt = "[0-9]+"; // Appartament must be digits number
	public final static String patternZipcode = "[A-Z][0-9][A-Z]([-]{0,1}|[ ]{0,1})[0-9][A-Z][0-9]"; // Zip Code X9X-9X9
	public final static String patternHours = "[0-9]+"; // Hours must be digits number
	public final static String patterNumber = "[0-9]+"; // Must be a number
	
	public static void verifyData( String str , String pattern , ExceptionHandler ex ) throws ExceptionHandler
    {
        if (!str.matches(pattern))
            throw (ex);
    }
}
