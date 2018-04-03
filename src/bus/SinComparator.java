package bus;
import java.util.Comparator;

public class SinComparator implements  Comparator<Employee>
{	
	public int compare(Employee e1, Employee e2) 
	{
		if ( e1.getSocial_security().compareTo(e2.getSocial_security()) > 0)
			return 1;
		else if ( e1.getSocial_security().compareTo(e2.getSocial_security()) < 0)
			return -1;
	
		return 0;
	}	
}
	

	

