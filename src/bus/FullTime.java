package bus;

public class FullTime extends Employee
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private EnumPosition position = EnumPosition.Undefined;				//POS 29
    private double annual_salary;										//POS 30
    
    public EnumPosition getPosition() {
		return position;
	}
	public void setPosition(int position) 
	{
		switch (position)
		{
		case 1:
			this.position = EnumPosition.Undefined;
			break;
		case 2:
			this.position = EnumPosition.Managers;
			break;
		case 3:
			this.position = EnumPosition.Secretary;
			break;
		case 4:
			this.position = EnumPosition.Analists_Programmers;
			break;
		}
	}
    public double getAnnual_salary() {
		return annual_salary;
	}
	public void setAnnual_salary(Double annual_salary) throws ExceptionHandler 
	{
		Controler.verifyData( annual_salary.toString() , Controler.patternMoney , new ExceptionHandler("Invalid Annual Salary.  Must be a number\n") );
		this.annual_salary = annual_salary;
	}
	
	public FullTime() { }
	public FullTime( Employee emp )
    {
    	super(emp); 
    }
    public FullTime( EnumPosition position , double asalary )
    {
    	this.position = position;
        this.annual_salary = asalary; 
    }
    
    public FullTime( String fname, String lname, String social_security, EnumDepartment department,
	        EnumCategory category, Date hire_date, Date birthday, Address address,
	        Phone home_ph, Phone cel_ph, String email , EnumPosition position , double asalary )
    {
    	super(fname, lname, social_security, department, category, hire_date, birthday, address, home_ph, 
    		  cel_ph, email);
    	this.position = position;
        this.annual_salary = asalary; 
    }
    
 // This constructor is made for FileHandler purposes
    public FullTime( String id , String fname, String lname, String social_security, String department,
    		String category, String hire_date, String birthday, String address,
    		String home_ph, String cel_ph, String email , String position , String asalary )
    {
    	super(id , fname, lname, social_security, department, category, hire_date, birthday, address, home_ph, 
    		  cel_ph, email);
    	this.position = EnumPosition.valueOf(position);
        this.annual_salary = Double.parseDouble(asalary); 
    }
    
    public String toString()
    {
        String state = super.toString() + "|" + position + "|" + annual_salary;

        return state;
    }
    
    @Override
    public double CalculPayment()
    {
        double payment = (this.annual_salary / 52)*2;
        double extra = payment * super.getPerformance();

        return payment + extra;
    }
}
