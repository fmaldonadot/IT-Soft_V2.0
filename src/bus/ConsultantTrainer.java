package bus;

public class ConsultantTrainer extends PartTime
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private double hourly_salary;								//POS 31
	private double week_hours;									//POS 32
	
	public double getHourly_salary() {
		return hourly_salary;
	}
	public void setHourly_salary(Double hourly_salary) throws ExceptionHandler 
	{
		Controler.verifyData( hourly_salary.toString() , Controler.patternMoney , new ExceptionHandler("Invalid Hourly Salary.  Must be a number\n") );
		this.hourly_salary = hourly_salary;
	}
	public double getWeek_hours() {
		return week_hours;
	}
	public void setWeek_hours(Double week_hours) throws ExceptionHandler 
	{
		Controler.verifyData( week_hours.toString() , Controler.patternMoney , new ExceptionHandler("Invalid Week's Hours.  Must be a number\n") );
		this.week_hours = week_hours;
	}
	
	public ConsultantTrainer(){}
	public ConsultantTrainer( Employee emp )
    {
    	super(emp); 
    }
	public ConsultantTrainer(double hourly_salary, double week_hours) 
	{
		super();
		this.hourly_salary = hourly_salary;
		this.week_hours = week_hours;
	}
	public ConsultantTrainer(EnumContractType temp_position, int contract_months , double hourly_salary, double week_hours) 
	{
		super(temp_position, contract_months);
		this.hourly_salary = hourly_salary;
		this.week_hours = week_hours;
	}
	public ConsultantTrainer(String fname , String lname , String social_security , EnumDepartment department , 
	                         EnumCategory category , Date hire_date , Date birthday , Address address , Phone home_ph , 
	                         Phone cel_ph , String email , EnumContractType temp_position, int contract_months , 
	                         double hourly_salary, double week_hours) 
	{
		super( fname , lname , social_security , department , category , hire_date , birthday , address , home_ph , 
               cel_ph , email , temp_position, contract_months);
		this.hourly_salary = hourly_salary;
		this.week_hours = week_hours;
	}
	
	// This constructor is made for FileHandler purposes
	public ConsultantTrainer( String id , String fname, String lname, String social_security, String department,
	    		String category, String hire_date, String birthday, String address,
	    		String home_ph, String cel_ph, String email , String temp_position , String contract_months , 
	    		String hourly_salary, String week_hours)
	{
	    super(id , fname, lname, social_security, department, category, hire_date, birthday, address, home_ph, 
	    	cel_ph, email , temp_position , contract_months);
	    this.hourly_salary = Double.parseDouble(hourly_salary);
		this.week_hours = Double.parseDouble(week_hours);
	}
	
	@Override
	public String toString() {
		return super.toString() + "|" + hourly_salary + "|" + week_hours;
	}
	
	@Override
    public double CalculPayment()
    {
		double payment = (this.hourly_salary * this.week_hours) * 2;
		double extra = payment * super.getPerformance();
    	return payment + extra;
    }	
	
}
