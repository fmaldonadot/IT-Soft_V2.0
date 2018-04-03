package bus;

import java.io.Serializable;

public class Phone implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String countryCode = "00";
	private String cityCode = "000";
	private String localCode = "0000000";
	private String ext = "00";
	
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) throws ExceptionHandler 
	{
		Controler.verifyData( countryCode , Controler.patternCountcode , new ExceptionHandler("Invalid Country Code.  Must be must be a 2 digits number with '+' or not\n") );
		this.countryCode = countryCode;
	}
	public String getCityCode() {
		return cityCode;
	}
	public void setCityCode(String cityCode) throws ExceptionHandler 
	{
		Controler.verifyData( cityCode , Controler.patternCitycode , new ExceptionHandler("Invalid City Code.  Must be must be a 3 digits number\n") );
		this.cityCode = cityCode;
	}
	public String getLocalCode() {
		return localCode;
	}
	public void setLocalCode(String localCode) throws ExceptionHandler 
	{
		Controler.verifyData( localCode , Controler.patternLocalcode , new ExceptionHandler("Invalid Local Code.  Must be must be a 7 digits number\n") );
		this.localCode = localCode;
	}
	public String getExt() {
		return ext;
	}
	public void setExt(String ext) {
		this.ext = ext;
	}
	
	public Phone(){}
	public Phone(String countryCode, String cityCode, String localCode, String ext) {
		super();
		this.countryCode = countryCode;
		this.cityCode = cityCode;
		this.localCode = localCode;
		this.ext = ext;
	}
	public Phone(String countryCode, String cityCode, String localCode) {
		super();
		this.countryCode = countryCode;
		this.cityCode = cityCode;
		this.localCode = localCode;
	}
	
	@Override
	public String toString() {
		return countryCode + "|-" + cityCode + "|-" + localCode + "|- ext: " + ext;
	}
	
	
}
