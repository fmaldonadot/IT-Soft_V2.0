package bus;

public abstract class PartTime extends Employee
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	EnumContractType temp_position;									//POS 29
	private int contract_months;									//POS 30

    public EnumContractType getTemp_position() {
		return temp_position;
	}
	public void setTemp_position(EnumContractType temp_position) {
		this.temp_position = temp_position;
	}
	public int getContract_months() {
		return contract_months;
	}
	public void setContract_months(Integer contract_months) throws ExceptionHandler 
	{
		Controler.verifyData( contract_months.toString() , Controler.patterNumber , new ExceptionHandler("Invalid Contract Months.  Must be a number\n") );
		this.contract_months = contract_months;
	}
	
	public PartTime(){}
	public PartTime( Employee emp )
    {
    	super(emp); 
    }
	public PartTime(EnumContractType temp_position, int contract_months) {
		super();
		this.temp_position = temp_position;
		this.contract_months = contract_months;
	}
	public PartTime( String fname , String lname , String social_security , EnumDepartment department , 
			         EnumCategory category , Date hire_date , Date birthday , Address address , Phone home_ph , Phone cel_ph ,
			         String email , EnumContractType temp_position, int contract_months ) 
	{
		super(fname , lname , social_security , department , category , hire_date , birthday , address , home_ph , 
			  cel_ph , email );
		this.temp_position = temp_position;
		this.contract_months = contract_months;
	}
	
	// This constructor is made for FileHandler purposes
	public PartTime( String id , String fname, String lname, String social_security, String department,
    		String category, String hire_date, String birthday, String address,
    		String home_ph, String cel_ph, String email , String temp_position , String contract_months )
    {
    	super(id , fname, lname, social_security, department, category, hire_date, birthday, address, home_ph, 
    		  cel_ph, email);
    	this.temp_position = EnumContractType.valueOf(temp_position);
		this.contract_months = Integer.parseInt(contract_months);
    }
	
	public String toString()
    {
        return super.toString() + "|" + temp_position + "|" + contract_months;
    }

    @Override
    public double CalculPayment()
    {
    	return 0;
    }
}
