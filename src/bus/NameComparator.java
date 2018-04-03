package bus;

import java.util.Comparator;

public class NameComparator implements Comparator <Employee>
{
	public int compare(Employee e1, Employee e2) 
	{
		String name1 = e1.getFname() + e1.getLname();
		String name2 = e2.getFname() + e1.getLname();
		
		if ( name1.compareTo(name2) > 0)
			return 1;
		else if ( name1.compareTo(name2) < 0)
			return -1;
		
		return 0;
	}

}
