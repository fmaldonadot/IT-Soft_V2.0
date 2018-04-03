package bus;

public class Internship extends PartTime
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Double trimester_salary;							//POS 31

	public Double getTrimester_salary() {
		return trimester_salary;
	}
	public void setTrimester_salary(Double trimester_salary) throws ExceptionHandler 
	{
		Controler.verifyData( trimester_salary.toString() , Controler.patternMoney , new ExceptionHandler("Invalid Trimester Salary.  Must be a number\n") );
		this.trimester_salary = trimester_salary;
	}
	
	public Internship(){}
	public Internship( Employee emp )
    {
    	super(emp); 
    }
	public Internship(Double trimester_salary) {
		super();
		this.trimester_salary = trimester_salary;
	}
	public Internship(String fname , String lname , String social_security , EnumDepartment department , 
            EnumCategory category , Date hire_date , Date birthday , Address address , Phone home_ph , 
            Phone cel_ph , String email , EnumContractType temp_position, int contract_months , Double trimester_salary) {
		
		super(fname , lname , social_security , department , category , hire_date , birthday , address , home_ph , 
              cel_ph , email , temp_position, contract_months);
		this.trimester_salary = trimester_salary;
	}
	
	// This constructor is made for FileHandler purposes
	public Internship( String id , String fname, String lname, String social_security, String department,
		    		String category, String hire_date, String birthday, String address,
		    		String home_ph, String cel_ph, String email , String temp_position , String contract_months , 
		    		String trimester_salary)
	{
		super(id , fname, lname, social_security, department, category, hire_date, birthday, address, home_ph, 
		    	cel_ph, email , temp_position , contract_months);
		this.trimester_salary = Double.parseDouble(trimester_salary);
	}
		
	@Override
	public String toString() {
		return super.toString() + "|" + trimester_salary;
	}
	
	@Override
    public double CalculPayment()
    {
		double payment = (this.trimester_salary /12)*2;
		double extra = payment*super.getPerformance();
    	return payment + extra;
    }		
	
}
