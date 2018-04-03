package bus;

import java.io.Serializable;
import java.util.StringTokenizer;

public abstract class Employee implements Serializable 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id = SequenceID.getEmployee_id();					//POS 0
	private String fname;												//POS 1
    private String lname;												//POS 2
    private String social_security;										//POS 3
    private EnumDepartment department = EnumDepartment.Undefined;		//POS 4
    private EnumCategory category;										//POS 5
    private Date hire_date;												//POS 6 - 7 - 8
    private Date birthday;												//POS 9 - 10 - 11
    private Address address;											//POS 12 - 13 - 14 - 15 - 16 - 17 - 18
    private Phone home_ph;												//POS 19 - 20 - 21 - 22
    private Phone cel_ph;												//POS 23 - 24 - 25 - 26
    private String email;												//POS 27
    private Double twoWeeks_salary;										//POS 28
    private EnumPerformance performance;
  
	public Double getPerformance() 
	{
		Double value = 0.00;
		if (performance == EnumPerformance.Low)
			value = 0.00;
		else if (performance == EnumPerformance.Medium_low)
			value = 0.25;
		if (performance == EnumPerformance.Medium_high)
			value = 0.50;
		if (performance == EnumPerformance.High)
			value = 0.50;
		
		return value;
	}
	public void setPerformance(int performance) 
	{
		switch (performance)
		{
		case 1:
			this.performance = EnumPerformance.Low;
			break;
		case 2:
			this.performance = EnumPerformance.Medium_low;
			break;
		case 3:
			this.performance = EnumPerformance.Medium_high;
			break;
		case 4:
			this.performance = EnumPerformance.High;
			break;
		}
	}
	public int getId() 
	{
		return this.id;
	}
	public void setId(Integer id) throws ExceptionHandler 
	{
		Controler.verifyData( id.toString() , Controler.patterNumber , new ExceptionHandler("Invalid ID.  Must be a Number\n") );
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) 
	{
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) 
	{
		this.lname = lname;
	}
	public String getSocial_security() 
	{
		return social_security;
	}
	public void setSocial_security(String social_security) throws ExceptionHandler 
	{
		Controler.verifyData( social_security , Controler.patternSIN , new ExceptionHandler("Invalid SIN.  Must be in format 999-999-999 or 999999999\n") );
		this.social_security = social_security;
	}
	public EnumDepartment getDepartment() {
		return department;
	}
	public void setDepartment(int department) 
	{
		switch (department)
		{
		case 1:
			this.department = EnumDepartment.Undefined;
			break;
		case 2:
			this.department = EnumDepartment.Human_Resources;
			break;
		case 3:
			this.department = EnumDepartment.Technical_Support;
			break;
		case 4:
			this.department = EnumDepartment.IT;
			break;
		case 5:
			this.department = EnumDepartment.Research_and_Development;
			break;
		case 6:
			this.department = EnumDepartment.Finance;
			break;
		default:
			this.department = EnumDepartment.Undefined;
			break;
			
		}
		
	}
	public EnumCategory getCategory() {
		return category;
	}
	public void setCategory(EnumCategory category) {
		this.category = category;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Phone getHome_ph() {
		return home_ph;
	}
	public void setHome_ph(Phone home_ph) {
		this.home_ph = home_ph;
	}
	public Phone getCel_ph() {
		return cel_ph;
	}
	public void setCel_ph(Phone cel_ph) {
		this.cel_ph = cel_ph;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws ExceptionHandler 
	{
		Controler.verifyData( email , Controler.patternEmail , new ExceptionHandler("Invalid Email.\n") );
		this.email = email;
	}
	public Double getTwoWeeks_salary() 
	{
		this.setTwoWeeks_salary();
		return twoWeeks_salary;
	}
	
	public void setTwoWeeks_salary() {
		this.twoWeeks_salary = CalculPayment();
	}
	
	public Employee(){}
	public Employee(Employee emp) 
	{ 
		this.fname = emp.fname;
		this.lname = emp.lname;
		this.social_security = emp.social_security;
		this.department = emp.department;
		this.category = emp.category;
		this.hire_date = emp.hire_date;
		this.birthday = emp.birthday;
		this.address = emp.address;
		this.home_ph = emp.home_ph;
		this.cel_ph = emp.cel_ph;
		this.email = emp.email;
	}   
	public Employee(String fname, String lname, String social_security, EnumDepartment department,
			        EnumCategory category, Date hire_date, Date birthday, Address address,
			        Phone home_ph, Phone cel_ph, String email ) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.social_security = social_security;
		this.department = department;
		this.category = category;
		this.hire_date = hire_date;
		this.birthday = birthday;
		this.address = address;
		this.home_ph = home_ph;
		this.cel_ph = cel_ph;
		this.email = email;
	}
	public Employee(int id , String fname, String lname, String social_security, EnumDepartment department,
			        EnumCategory category, Date hire_date, Date birthday, Address address,
			        Phone home_ph, Phone cel_ph, String email ) {
		super();
		this.id = id;
		this.fname = fname;
		this.lname = lname;
		this.social_security = social_security;
		this.department = department;
		this.category = category;
		this.hire_date = hire_date;
		this.birthday = birthday;
		this.address = address;
		this.home_ph = home_ph;
		this.cel_ph = cel_ph;
		this.email = email;
	}
	// This constructor is made for FileHandler purposes
    public Employee(String id , String fname , String lname , String social_security, String department , 
    		        String category , String hire_date , String  birthday , String address , String home_ph , 
    		        String cel_ph , String email )
    {
    	   	
    	this.id = Integer.parseInt(id);
    	this.fname = fname;
		this.lname = lname;
		this.social_security = social_security;
		this.department = EnumDepartment.valueOf(department);
		this.category = EnumCategory.valueOf(category);
		StringTokenizer token1 = new StringTokenizer(hire_date , "/");
		this.hire_date = new Date ( token1.nextToken() , token1.nextToken() , token1.nextToken() );
		StringTokenizer token2 = new StringTokenizer(birthday , "/");
		this.birthday = new Date ( token2.nextToken() , token2.nextToken() , token2.nextToken() );
		StringTokenizer token3 = new StringTokenizer(address , ", ");
		this.address = new Address ( token3.nextToken() , token3.nextToken() , token3.nextToken() , token3.nextToken() ,
									 token3.nextToken() , token3.nextToken() , token3.nextToken());
		StringTokenizer token4 = new StringTokenizer(home_ph , "-");
		this.home_ph = new Phone(token4.nextToken() , token4.nextToken() , token4.nextToken());
		StringTokenizer token5 = new StringTokenizer(cel_ph , "-");
		this.cel_ph = new Phone(token5.nextToken() , token5.nextToken() , token5.nextToken());;
		this.email = email;    	
    }
  
	
	public void InitEmployeeID ( int id )
	{
		SequenceID.setEmployee_id(id);
	}
	
	public String toString()
    {
        return this.id + "|" + fname + "|" + lname + "|" + social_security + "|" + department + "|" + 
        	   category + "|" + hire_date + "|" + birthday + "|" + address + "|" + home_ph + "|" + cel_ph + "|" + 
        	   email + "|" + String.format("%.2f",this.getTwoWeeks_salary()) + "|" + performance;

        
   }
	
	public double CalculPayment() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
