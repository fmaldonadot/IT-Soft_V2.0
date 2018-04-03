package bus;

public class ExceptionHandler extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public static String exmsg = "Invalid Value \n";

    public ExceptionHandler()
    {
    	super(exmsg); 
    }
    public ExceptionHandler(String mymsg)
    { 
    	 super(mymsg); 
    }
}
