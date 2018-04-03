package prod;
import java.io.IOException;
import java.util.*;

import bus.*;
import bus.Date;
public class IT_Soft_Main 
{

	private static Scanner cin;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws IOException 
	{
		boolean flag = true , flag2 = false;;
		int temp_cat = 0;
		int temp_position = 0;
		int aux = 0 , size = 0;
		String str_aux;
		Employee emp;
		
		
		DataHandler list_employees = new DataHandler();
		ArrayList<Employee> sorted = new ArrayList();
		@SuppressWarnings("resource")
		Scanner cin = new Scanner(System.in);
		int option = 0;
		
		// *********************************** THIS FUNCTION IS ONLY FOR TEST PURPOSES *************************
		//OnlyForTesting( list_employees );
		// *****************************************************************************************************
		
		while (flag)
		{
			System.out.println( "\n********************** VER 2.0 ****************************");
			System.out.println( "***********************************************************");
			System.out.println( "*********** IT-Soft Company Employees System **************");
			System.out.println( "***********************************************************");
			System.out.println( "1. Add a new Employee.");
			System.out.println( "2. Remove an Employee by Social Security.");
			System.out.println( "3. Remove an Employee by ID.");
			System.out.println( "4. Search Employee by Social Security. ");
			System.out.println( "5. Search Employees by ID. ");
			System.out.println( "6. Modify Employee's information. ");
			System.out.println( "7. Sort Employees by Social Security. ");
			System.out.println( "8. Sort Employees by Name ");
			System.out.println( "9. Show all Employees. ");
			System.out.println( "10. Save Employee's list in a bin file. ");
			System.out.println( "11. Download Employee's list from a file. ");
			System.out.println( "12. Get the quantity of the employees. ");
			System.out.println( "13. Exit.\n");
			System.out.print( "Choise an option: ");
			option = cin.nextInt();

			switch (option)
			{
			case 1:
				
				System.out.print( "*******************************************************************\n");
				System.out.print( "**************** Add a new Employee. ******************************\n");
				System.out.print( "*******************************************************************\n\n");
				System.out.print( "Enter the Category of the Employee: \n");
				System.out.print( "1. Full Time.\n");
				System.out.print( "2. Part Time.\n");
				temp_cat = cin.nextInt();
				
				switch (temp_cat)
				{
				case 1:
					FullTime temp_emp = new FullTime();
					temp_emp.setCategory(EnumCategory.FullTime); 
					// Validation of the SIN
					do
					{
						try
						{
							System.out.print( "\nEnter Social Security: ");
							temp_emp.setSocial_security(cin.next());
							flag2 = true;
						}
						catch (ExceptionHandler ex)
						{
							System.out.println(ex.getMessage());
							flag2 = false;
						}
						
													
					}while (!flag2);
					
					temp_emp = (FullTime) FillEmployee( temp_emp );
					
										
					// Full Time settings
					do
					{
						System.out.println( "\nEnter the Full Time Position: \n"); 
						System.out.print( "1.Undefined. \n"); 
						System.out.print( "2.Managers. \n"); 
						System.out.print( "3.Secretary. \n"); 
						System.out.print( "4.Analists_Programmers. \n"); 
						aux = cin.nextInt();
						if ((aux<1)||(aux>4))
							System.out.print( "Wrong Value!...\n"); 
					}while ((aux<1)||(aux>4));					
					temp_emp.setPosition(aux);
					
					System.out.print( "\n-----Annual Salary: -----\n"); 
					try 
					{
						temp_emp.setAnnual_salary(cin.nextDouble());
					} 
					catch (ExceptionHandler e) 
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	
					
					temp_emp.setTwoWeeks_salary();   // Setting two week's payment
					
					// Add employee to list
					list_employees.add(temp_emp.getId() , temp_emp);
					
					System.out.print( "\n***************** Employee Added ***********************\n"); 
					
					break;
				case 2:
					System.out.print( "\n***************** Part Time Information ***********************\n"); 
					System.out.print( "Select employee's contract type\n"); 
					System.out.print( "1.Consultant Trainers. \n"); 
					System.out.print( "2.Internship Student. \n"); 
					temp_position = cin.nextInt();
					
					switch (temp_position)
					{
					case 1:
						System.out.print( "\n***************** Consultant Trainers ***********************\n"); 
						ConsultantTrainer temp_emp1 = new ConsultantTrainer();
						temp_emp1.setCategory(EnumCategory.ParTime); 
						
						// Validation of the SIN
						do
						{
							System.out.print( "\nEnter Social Security: ");
							try
							{
								temp_emp1.setSocial_security(cin.next());
								flag2 = true;
							}
							catch (ExceptionHandler ex)
							{
								System.out.println(ex.getMessage());
								flag2 = false;
							}						
								
						}while (!flag2);
						
						temp_emp1 = (ConsultantTrainer) FillEmployee( temp_emp1 );
						
						// Consultant Trainers's Settings
						try
						{
							System.out.print( "\nEnter a number of contract's months: ");
							temp_emp1.setContract_months(cin.nextInt());
							System.out.print( "\nEnter the week hours of work: ");
							temp_emp1.setWeek_hours(cin.nextDouble());
							System.out.print( "\nEnter the hourly salary: ");
							temp_emp1.setHourly_salary(cin.nextDouble());
							
							temp_emp1.setTwoWeeks_salary();   // Setting two week's payment
							
							// Add employee to list
							list_employees.add(temp_emp1.getId() , temp_emp1);
						}
						catch (ExceptionHandler ex)
						{
							System.out.println(ex.getMessage());
						}	
												
						break;
					case 2:
						System.out.print( "\n***************** Internship Student ***********************\n"); 
						Internship temp_emp2 = new Internship();
						temp_emp2.setCategory(EnumCategory.ParTime); 
						
						// Validation of the SIN
						do
						{
							try
							{
								
								System.out.print( "\nEnter Social Security: ");
								temp_emp2.setSocial_security(cin.next());
								flag2 = list_employees.isUnique(temp_emp2.getSocial_security());
								if (flag2)
									System.out.print( "Social Security exist in the list...Try Again\n");
							}
							catch (ExceptionHandler ex)
							{
								System.out.println(ex.getMessage());
								flag2 = true;
							}	
								
						}while (flag2);
						
						temp_emp2 = (Internship) FillEmployee( temp_emp2 );
						
						try
						{
							// Internship's Settings
							temp_emp2.setContract_months(3);   // Fixed Three Months Contract for Internship
							
							System.out.print( "\nEnter the fixed payment for three months: ");
							temp_emp2.setTrimester_salary(cin.nextDouble());
							
							temp_emp2.setTwoWeeks_salary();   // Setting two week's payment
							
							// Add employee to list
							list_employees.add(temp_emp2.getId() , temp_emp2);
							
							System.out.print( "\n***************** Employee Added ***********************\n"); 
							
						}
						catch (Exception ex)
						{
							System.out.println(ex.getMessage());
						}						
						
						break;			
						}	
					break;					
				}					
				break;

			case 2:
				System.out.print( "*******************************************************************\n");
				System.out.print( "************ Remove an employee by Social Security ****************\n");
				System.out.print( "*******************************************************************\n\n");
				System.out.print( "Enter employee's social security: \n");
				str_aux = cin.next();
				
				size = list_employees.remove(str_aux);
				
				if ( size == -1 )
					System.out.print( "\nEmployee not found...\n\n");
				else
					System.out.print( "\n------- Employee with SIN: " + str_aux + " was removed. --------\n\n");
				break;

			case 3:
				System.out.print( "*******************************************************************\n");
				System.out.print( "****************** Remove an employee by ID ***********************\n");
				System.out.print( "*******************************************************************\n\n");
				System.out.print( "Enter employee's ID: ");
				aux = cin.nextInt();
												
				if ( list_employees.remove(aux) == null )
					System.out.print( "\nEmployee not found...\n\n");
				else
					System.out.print( "\n------- Employee with ID: " + aux + " was removed. --------\n\n");
				break;
				
			case 4:
				System.out.print( "*******************************************************************\n");
				System.out.print( "************** Search Employee by Social Security *****************\n");
				System.out.print( "*******************************************************************\n\n");
				System.out.print( "Enter employee's SIN: ");
				str_aux = cin.next();
				emp = (Employee) list_employees.search(str_aux);	
				
				if ( emp != null )
					System.out.print( emp + "\n" );
				else
					System.out.print( "Employee not found...\n\n" );
				
				break;
			case 5:
				System.out.print( "*******************************************************************\n");
				System.out.print( "********************* Search Employee by ID ***********************\n");
				System.out.print( "*******************************************************************\n\n");
				System.out.print( "Enter employee's ID: ");
				aux = cin.nextInt();
				emp = (Employee) list_employees.get(aux);	
				
				if ( emp != null )
					System.out.print( emp + "\n" );
				else
					System.out.print( "Employee not found...\n\n" );
				
				break;
			case 6:
				System.out.print( "*******************************************************************\n");
				System.out.print( "************** Modify Employee's information. *********************\n");
				System.out.print( "*******************************************************************\n\n");
				System.out.print( "Enter employee's SIN: ");
				str_aux = cin.next();
				emp = (Employee) list_employees.search(str_aux);	// Search Employee
				if ( emp != null )
				{
					System.out.print( "Enter the Category of the Employee: \n");
					System.out.print( "1. Full Time.\n");
					System.out.print( "2. Part Time/Consultant Trainers.\n");
					System.out.print( "3. Part Time/Internship.\n");
					temp_cat = cin.nextInt();   // Select employee's category
					
					if ((temp_cat >=1)&&(temp_cat <=3))
					{
						emp = ModifyMenu( emp , temp_cat);  // Menu of modifications
						
						list_employees.modify(emp, str_aux);  // Execute the modification
						
						System.out.print( "Information of Employee " + emp.getSocial_security() + " was modified\n\n");
					}
					else
						System.out.print( "Bad Option... Abort\n\n");
				}
				else
					System.out.print( "Employee not found...\n\n" );
				
				
				break;

			case 7:
				System.out.print( "*******************************************************************\n");
				System.out.print( "************ Sort Employees by Social Security. *******************\n");
				System.out.print( "*******************************************************************\n\n");
				sorted.clear();
				sorted = list_employees.returnList();
				Collections.sort( sorted , new SinComparator() );
				
				for ( Employee curr : sorted )
					System.out.println(curr);
				
				break;
			case 8:
				System.out.print( "*******************************************************************\n");
				System.out.print( "***************** Sort Employees by Name. *************************\n");
				System.out.print( "*******************************************************************\n\n");
				sorted.clear();
				sorted = list_employees.returnList();
				Collections.sort(sorted , new NameComparator() );
				
				for ( Employee curr : sorted )
					System.out.println(curr);
				
				break;
				
			case 9:
				if ( list_employees.size() > 0)
				{
					System.out.print( "*******************************************************************\n");
					System.out.print( "******************** Show all Employees. **************************\n");
					System.out.print( "*******************************************************************\n");
																
					list_employees.display();;
				}
				else
					System.out.print( "\nThere is no employees in the list\n\n");
				
				break;
			case 10:
				if ( list_employees.size() > 0)
				{
					System.out.print( "\n*******************************************************************\n");
					System.out.print( "Employees list Saved in " + FileHandler.filePath );
					System.out.print( "\n*******************************************************************\n\n");
					FileHandler.writeData(list_employees);			
				}
				else
					System.out.print( "\nThere is no employees in the list to save in a file\n\n");
				break;
			case 11:
				try
				{
					System.out.print( "\n*******************************************************************\n");
					System.out.print( "Loading List of Employees from " + FileHandler.filePath );
					System.out.print( "\n*******************************************************************\n\n");
					list_employees = FileHandler.readData();
				}
				catch (Exception ex)
				{
					System.out.println(ex + "\nFile in path " + FileHandler.filePath + " not found...");
				}
				break;
			case 12:
				System.out.print( "\n===================================================================\n");
				System.out.println("There are " + list_employees.size() + " employees in IT-Soft Company");
				System.out.print( "===================================================================\n");
				
				break;
			
			case 13:
				flag = false;
				break;

			default:
				System.out.print( "Invalid option. \n");
				break;
			}

		}
	}
	
	// Static functions
	public static Employee FillEmployee( Employee temp_emp )
	{
		boolean flag = false;
		int temp_dept = 0;
		Date aux_date = new Date();
		Address aux_address = new Address();
		Phone aux_phone = new Phone();
		cin = new Scanner(System.in);
		
		System.out.print( "Enter First Name: ");
		temp_emp.setFname(cin.nextLine());
		System.out.print( "\nEnter Last Name: ");
		temp_emp.setLname(cin.nextLine());
				
		do
		{
			System.out.println( "\nEnter the Department: "); 
			System.out.print( "1.Undefined. \n"); 
			System.out.print( "2.Human Resources. \n"); 
			System.out.print( "3.Technical Support. \n"); 
			System.out.print( "4.IT. \n"); 
			System.out.print( "5.Research and Development. \n"); 
			System.out.print( "6.Finance. \n"); 	
			temp_dept = cin.nextInt();
			if ((temp_dept<1)||(temp_dept>6))
				System.out.print( "Wrong Value!...\n"); 
		}while ((temp_dept<1)||(temp_dept>6));
		
		temp_emp.setDepartment(temp_dept); 
		
		
		System.out.print( "\n-----Hire Date: -----\n"); 
		do
		{
			try
			{
				System.out.print( "Day: "); 
				aux_date.setDay(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
			
			
		}while(!flag);
		
		do
		{
			try
			{
				System.out.print( "Month: "); 
				aux_date.setMonth(cin.next());
				flag = true;
			}			
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		
		do
		{
			try
			{
				System.out.print( "Year: "); 
				aux_date.setYear(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		
		temp_emp.setHire_date(aux_date);
		
		System.out.print( "\n-----Birthday: -----\n"); 
		
		do
		{
			try
			{
				System.out.print( "Day: "); 
				aux_date.setDay(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		
		do
		{
			try
			{
				System.out.print( "Month: "); 
				aux_date.setMonth(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		
		do
		{
			try
			{
				System.out.print( "Year: "); 
				aux_date.setYear(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		temp_emp.setBirthday(aux_date);
		
		System.out.print( "\n-----Address: -----\n"); 
		do
		{
			try
			{
				System.out.print( "Street No: "); 
				aux_address.setStreet_number(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		
		System.out.print( "Street Name: "); 
		aux_address.setStreet_name(cin.next());
		
		do
		{
			try
			{
				System.out.print( "House/Apt. No.: "); 
				aux_address.setHouse_number(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		
		System.out.print( "City: "); 
		aux_address.setCity(cin.next());
		System.out.print( "State: "); 
		aux_address.setState(cin.next());
		System.out.print( "Country: "); 
		aux_address.setCountry(cin.next());
		
		do
		{
			try
			{
				System.out.print( "Zip Code: "); 
				aux_address.setZipcode(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		
		temp_emp.setAddress(aux_address);
		
		System.out.print( "\n-----Phone (Home): -----\n"); 
		do
		{
			try
			{
				System.out.print( "Country Code: "); 
				aux_phone.setCountryCode(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		do
		{
			try
			{
				System.out.print( "City Code: "); 
				aux_phone.setCityCode(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		do
		{
			try
			{
				System.out.print( "LocalCode: "); 
				aux_phone.setLocalCode(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);			
		temp_emp.setHome_ph(aux_phone);
		
		System.out.print( "\n-----Cel Phone: -----\n");
		do
		{
			try
			{
				System.out.print( "Country Code: "); 
				aux_phone.setCountryCode(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		do
		{
			try
			{
				System.out.print( "City Code: "); 
				aux_phone.setCityCode(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);
		do
		{
			try
			{
				System.out.print( "LocalCode: "); 
				aux_phone.setLocalCode(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);	
		temp_emp.setCel_ph(aux_phone);
		
		do
		{
			try
			{
				System.out.print( "\n-----email: -----\n"); 
				temp_emp.setEmail(cin.next());
				flag = true;
			}
			catch (ExceptionHandler ex)
			{
				System.out.println(ex.getMessage());
				flag = false;
			}
		}while(!flag);	
		
		// Ver 2.0 Set Performance
		do
		{
			System.out.println( "\nEnter Performance: "); 
			System.out.print( "1.Low. \n"); 
			System.out.print( "2.Medium Low. \n"); 
			System.out.print( "3.Medium High. \n"); 
			System.out.print( "4.High. \n"); 
			temp_dept = cin.nextInt();
			if ((temp_dept<1)||(temp_dept>4))
				System.out.print( "Wrong Value!...\n"); 
		}while ((temp_dept<1)||(temp_dept>6));
				
		temp_emp.setPerformance(temp_dept); 
				
		
		return temp_emp;
	}

	public static Employee ModifyMenu( Employee temp_emp , int temp_cat)
	{
		int temp_dept = 0 , aux = 0;
		Double auxperform = 0.00;
		String str_aux="";
		boolean flag;
		Date aux_date = new Date();
		Address aux_address = new Address();
		Phone aux_phone = new Phone();
		cin = new Scanner(System.in);
		
		System.out.print( "Change First Name " + temp_emp.getFname() + " ? (Press only Enter if dont): " );
		str_aux = (cin.nextLine());
		if ( !str_aux.isEmpty() )
			temp_emp.setFname(str_aux);
		System.out.print( "\nChange First Name " + temp_emp.getLname() + " ? (Press only Enter if dont): ");
		str_aux = (cin.nextLine());
		if ( !str_aux.isEmpty() )
			temp_emp.setLname(str_aux);
		
		System.out.print( "\nChange Department " + temp_emp.getDepartment() + " ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			do
			{
				System.out.println( "\nEnter the Department: "); 
				System.out.print( "1.Undefined. \n"); 
				System.out.print( "2.Human Resources. \n"); 
				System.out.print( "3.Technical Support. \n"); 
				System.out.print( "4.IT. \n"); 
				System.out.print( "5.Research and Development. \n"); 
				System.out.print( "6.Finance. \n"); 	
				temp_dept = cin.nextInt();
				if ((temp_dept<1)||(temp_dept>6))
					System.out.print( "Wrong Value!...\n"); 
			}while ((temp_dept<1)||(temp_dept>6));
		
		temp_emp.setDepartment(temp_dept); 
		}
		
		System.out.print( "\nChange Hire Date " + temp_emp.getHire_date() + " ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			System.out.print( "\n-----Hire Date: -----\n");  
			do
			{
				try
				{
					System.out.print( "Day: "); 
					aux_date.setDay(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}
			}while(!flag);
			
			do
			{
				try
				{
					System.out.print( "Month: "); 
					aux_date.setMonth(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}
			}while(!flag);
			
			do
			{
				try
				{
					System.out.print( "Year: "); 
					aux_date.setYear(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}
			}while(!flag);
			temp_emp.setHire_date(aux_date);
		}
		
		System.out.print( "\nChange Birthday " + temp_emp.getBirthday() + " ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			System.out.print( "\n-----Birthday: -----\n"); 
			do
			{
				try
				{
					System.out.print( "Day: "); 
					aux_date.setDay(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);
			
			do
			{
				try
				{
					System.out.print( "Month: "); 
					aux_date.setMonth(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);
			
			do
			{
				try
				{
					System.out.print( "Year: "); 
					aux_date.setYear(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);
			temp_emp.setBirthday(aux_date);
		}
		
		System.out.print( "\nChange Address " + temp_emp.getAddress() + " ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			System.out.print( "\n-----Address: -----\n"); 
			do
			{
				try
				{
					System.out.print( "Street No: "); 
					aux_address.setStreet_number(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);
			System.out.print( "Street Name: "); 
			aux_address.setStreet_name(cin.next());
			do
			{
				try
				{
					System.out.print( "House/Apt. No.: "); 
					aux_address.setHouse_number(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);
			System.out.print( "City: "); 
			aux_address.setCity(cin.next());
			System.out.print( "State: "); 
			aux_address.setState(cin.next());
			System.out.print( "Country: "); 
			aux_address.setCountry(cin.next());
			do
			{
				try
				{
					System.out.print( "Zip Code: "); 
					aux_address.setZipcode(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);
			temp_emp.setAddress(aux_address);
		}
		
		System.out.print( "\nChange Home Phone " + temp_emp.getHome_ph() + " ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			System.out.print( "\n-----Phone (Home): -----\n"); 
			do
			{
				try
				{
					System.out.print( "Country Code: "); 
					aux_phone.setCountryCode(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}  
			}while(!flag);
			do
			{
				try
				{
					System.out.print( "City Code: "); 
					aux_phone.setCityCode(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}  
			}while(!flag);
			do
			{
				try
				{
					System.out.print( "LocalCode: "); 
					aux_phone.setLocalCode(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}  
			}while(!flag);		
			temp_emp.setHome_ph(aux_phone);
		}
		
		System.out.print( "\nChange Cel Phone " + temp_emp.getCel_ph() + " ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			System.out.print( "\n-----Cel Phone: -----\n"); 
			do
			{
				try
				{
					System.out.print( "Country Code: "); 
					aux_phone.setCountryCode(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}  
			}while(!flag);
			do
			{
				try
				{
					System.out.print( "City Code: "); 
					aux_phone.setCityCode(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}  
			}while(!flag);
			do
			{
				try
				{
					System.out.print( "LocalCode: "); 
					aux_phone.setLocalCode(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}  
			}while(!flag);		
			temp_emp.setCel_ph(aux_phone);
		}
		
		System.out.print( "\nChange email " + temp_emp.getEmail() + " ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			do
			{
				try
				{
					System.out.print( "\n-----email: -----\n"); 
					temp_emp.setEmail(cin.next());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);	
		}
		
		// Ver 2.0 Set Performance
		auxperform = temp_emp.getPerformance() * 100;
		System.out.print( "\nChange Performance " + auxperform.toString() + "% ? (Type (N)or(n) for NO or (Y)or (y) if YES): ");
		str_aux = cin.next();
		if ((str_aux.charAt(0)!= 'N')&&(str_aux.charAt(0)!= 'n'))
		{
			do
			{
				System.out.println( "\nEnter Performance: "); 
				System.out.print( "1.Low. \n"); 
				System.out.print( "2.Medium Low. \n"); 
				System.out.print( "3.Medium High. \n"); 
				System.out.print( "4.High. \n"); 
				temp_dept = cin.nextInt();
				if ((temp_dept<1)||(temp_dept>4))
					System.out.print( "Wrong Value!...\n"); 
			}while ((temp_dept<1)||(temp_dept>6));
		
		temp_emp.setPerformance(temp_dept); 
		}		
		
		// Keep the same ID
		aux = temp_emp.getId();
		switch (temp_cat)
		{
		case 1:
			FullTime temp_emp1 = new FullTime(temp_emp);
			temp_emp1.setCategory(EnumCategory.FullTime); 
			try {
				temp_emp1.setId(aux);
			} catch (ExceptionHandler e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Full Time settings
			do
			{
				System.out.println( "\nEnter the Full Time Position: \n"); 
				System.out.print( "1.Undefined. \n"); 
				System.out.print( "2.Managers. \n"); 
				System.out.print( "3.Secretary. \n"); 
				System.out.print( "4.Analists_Programmers. \n"); 
				aux = cin.nextInt();
				if ((aux<1)||(aux>4))
					System.out.print( "Wrong Value!...\n"); 
			}while ((aux<1)||(aux>4));					
			temp_emp1.setPosition(aux);
			
			do
			{
				try
				{
					System.out.print( "\n-----Annual Salary: -----\n"); 
					temp_emp1.setAnnual_salary(cin.nextDouble());	
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				} 
			}while(!flag);	
						
			temp_emp1.setTwoWeeks_salary();   // Setting two week's payment
			
			return temp_emp1;		
		case 2:
			
			System.out.print( "\n***************** Consultant Trainers ***********************\n"); 
			ConsultantTrainer temp_emp2 = new ConsultantTrainer(temp_emp);
			temp_emp2.setCategory(EnumCategory.ParTime); 
			try {
				temp_emp2.setId(aux);
			} catch (ExceptionHandler e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			// Consultant Trainers's Settings
			do
			{
				try
				{
					System.out.print( "\nEnter a number of contract's months: ");
					temp_emp2.setContract_months(cin.nextInt());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}
			}while(!flag);
			
			do
			{
				try
				{
					System.out.print( "\nEnter the week hours of work: ");
					temp_emp2.setWeek_hours(cin.nextDouble());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}
			}while(!flag);	
			
			do
			{
				try
				{
					System.out.print( "\nEnter the hourly salary: ");
					temp_emp2.setHourly_salary(cin.nextDouble());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}
			}while(!flag);	
			
				
			temp_emp2.setTwoWeeks_salary();   // Setting two week's payment
				
			return temp_emp2;									
		case 3:
			System.out.print( "\n***************** Internship Student ***********************\n"); 
			Internship temp_emp3 = new Internship(temp_emp);
			temp_emp3.setCategory(EnumCategory.ParTime); 
			try {
				temp_emp3.setId(aux);
			} catch (ExceptionHandler e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			// Internship's Settings
			try {
				temp_emp3.setContract_months(3);
			} catch (ExceptionHandler e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}   // Fixed Three Months Contract for Internship
			
			do
			{
				try
				{
					System.out.print( "\nEnter the fixed payment for three months: ");
					temp_emp3.setTrimester_salary(cin.nextDouble());
					flag = true;
				}
				catch (ExceptionHandler ex)
				{
					System.out.println(ex.getMessage());
					flag = false;
				}
			}while(!flag);	
			
				
			temp_emp3.setTwoWeeks_salary();   // Setting two week's payment
			
			return temp_emp3;	
		}
		
		return null;
				
	}
	// *********************************** THIS FUNCTION IS ONLY FOR TEST PURPOSES *************************
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void OnlyForTesting( DataHandler list)
	{
		Employee e1 = new FullTime("Francisco", "Maldonado", "514-555-844" , EnumDepartment.Research_and_Development , 
        		EnumCategory.FullTime , new Date ( "15" , "01" , "1999") , new Date( "15" , "01" , "1975") ,
        		new Address( "500" , "Francois" , "611" , "Verdun" , "QC" , "Canada" , "H3E 1G4 ") , 
        		new Phone( "+1" , "514" , "5627181" ) , new Phone( "+1" , "514" , "5627181" ) , "fmtchicho@gmail.com" , 
        		EnumPosition.Managers , 85000.98 );
				e1.setPerformance(1);
				e1.setTwoWeeks_salary();
				list.add(e1.getId(),e1);
        
        Employee e2 = new ConsultantTrainer("Wendy", "Cahuano", "788-654-123", EnumDepartment.Finance , EnumCategory.ParTime , 
        		new Date ( "15" , "01" , "1999") , new Date( "15" , "01" , "1975") ,
        		new Address( "888" , "WENCHU" , "233" , "GATINEAU" , "QC" , "Canada" , "HW4 1G7 ") , 
        		new Phone( "+1" , "514" , "5627181" ) , new Phone( "+1" , "514" , "5627181" ) , "WENDY@gmail.com" , 
        		EnumContractType.Consultant_Trainers , 8 , 25 , 37.5 );
        		e1.setPerformance(2);
        		e2.setTwoWeeks_salary();
        		list.add(e2.getId(),e2);
        
        Employee e3 = new FullTime("Carlos", "Maldonado", "838-654-899" , EnumDepartment.Human_Resources , 
        		EnumCategory.FullTime , new Date ( "10" , "03" , "1999") , new Date( "22" , "04" , "2000") ,
        		new Address( "999" , "CHARLEVOIX" , "888" , "ILE DES SOEURS" , "QC" , "Canada" , "H4U 1Y9 ") , 
        		new Phone( "+1" , "514" , "6969544" ) , new Phone( "+1" , "514" , "5447788" ) , "CARLOS@gmail.com" , 
        		EnumPosition.Managers , 120000.45 );
        		e3.setPerformance(3);
        		e3.setTwoWeeks_salary();
        		list.add(e3.getId(),e3);
        
        Employee e4 = new Internship("Agustin", "Cahuano", "314-553-314", EnumDepartment.Finance , EnumCategory.ParTime , 
        		new Date ( "26" , "01" , "2014") , new Date( "31" , "12" , "1985") ,
        		new Address( "122" , "TERREFF" , "611" , "BROSSARD" , "QC" , "Canada" , "J8U 5T6 ") , 
        		new Phone( "+1" , "514" , "8749966" ) , new Phone( "+1" , "514" , "7894563" ) , "AGUSTIN@gmail.com" , 
        		EnumContractType.Internship_Student , 3 , 1800.55 );
        		e4.setPerformance(4);
        		e4.setTwoWeeks_salary();
        		list.add(e4.getId(),e4);
	}
}
