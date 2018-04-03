package bus;

import java.io.Serializable;

public class SequenceID implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static int employee_id = 1;

    public static int getEmployee_id() {
		return SequenceID.employee_id++;
	}
	public static void setEmployee_id(int employee_id) {
		SequenceID.employee_id = employee_id;
	}
}
