package BANKINGAPPLICATION;

//SERVER1 class already have the information of user

public class Server1 {
	private long mobile;
	 private int mpin;
	
	Server1(long mobile,int mpin){
		this.mobile = mobile;
		this.mpin = mpin;
	}
	
	public long getMobile() {
		return mobile;
	}
	public long getMpin() {
		return mpin;
	}	
}

//SERVER2 class already have the information of user

import java.util.*;

public class Server2 {
	static long mobile;
	static int mpin;
	static Scanner ad = new Scanner(System.in);
	
	public Server2(){
		System.out.println("Enter your mobile number");
		mobile = ad.nextLong();
		System.out.println("Enter your mpin");
		mpin = ad.nextInt();		
	}
	
	public static boolean isMatch(ArrayList<Server1> ser1,ArrayList<Server2> ser2) {
		boolean sra = false; 
		for(Server1 se:ser1) {
			if(se.getMobile() == Server2.mobile && se.getMpin() == Server2.mpin) {
				System.out.println("1");
				sra = true;
			}
		}
		return sra;
	}
}

//UserInterface starts the main funtion

import java.util.*;

public class UserInterface {
	
	static Scanner ad = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
				
		System.out.println("\tWelcome to our bank");
		System.out.println();
		System.out.println("\t\tSBI");
		System.out.println();
		frontPage();
	}
		public static void frontPage() throws Exception {
			
			ArrayList<Server1> ser1 = new ArrayList<Server1>();
			
			ArrayList<Server2> ser2 = new ArrayList<Server2>();
			
			ser1.add(new Server1(6381275724L,123456));       
	        ser1.add(new Server1(8608226805L,123457));
	        ser1.add(new Server1(6381275725L,123458));
			
	        OtpPage otp = new OtpPage();
			
			
		System.out.println("1.Existing User/Sing In\n\n2.New User/Sing Up");
        int wel = ad.nextInt();
        if(wel==1) {
        	Server2 server2 = new Server2();  
   			if(Server2.isMatch(ser1,ser2)) {
   				ser2.add(server2);
   				System.out.println("Your Username and Password is correct");
   				otp.otpPage();
   			}
   			else {
   				System.out.println("Your Username or Password is incorrect");
   				worngInput();
   			}
   			}  
   		if(wel==2) {
   				Server2 server3 = new Server2();  
   	   			if(Server2.isMatch(ser1,ser2)) {
   	   				ser2.add(server3);
   	   			System.out.println("Your Username and Password is correct");
   	   		
   	   	    otp.otpPage();
         }
   	   		else {
   				System.out.println("Your Username or Password is incorrect");
   				worngInput();
   			}
   			}      
        
	}
		public static void worngInput() throws Exception {
			frontPage();
		}
}

//OtpPage class gives otp for conformation

import java.util.Scanner;

public class OtpPage {
	
	static Scanner ad = new Scanner(System.in);	
	
	public static void otpPage() throws Exception {
        
        System.out.println("\t\tEnter the OTP");
    	
    	int sys_otp=(int) (Math. random()*9999+9999);
    	
    	System.out.println(sys_otp);
    	
    	int user_enter_otp=ad.nextInt();
		
    	if(user_enter_otp==sys_otp) {
    		System.out.println("OTP is correct");
    	}
        else {
        	System.out.println("OTP is incorrect");
        }		
    
     LoginPage.loginPage();
	}
}

//LoginPage class shows information about user

import java.util.*;

public class LoginPage {
	static Scanner ad=new Scanner(System.in);
     static String name,account_type,email_add;
	 static long account_no,mobilee;
	 
	 public static void loginPage() throws Exception {
		 Display dis = new Display();
		name = "Sridharan";
		account_no = 12345678911L;
		account_type = "Saving Account";
		//mobilee = Server.mobile;
		email_add = "abc@gmail.com";
		
		System.out.println("\t\t\tYou are successfully logged in ");
		System.out.println();
		System.out.println("\t\t\t\tWELCOME: "+name);
		System.out.println("\t\t\t\tyour account number: "+account_no);
		System.out.println("\t\t\t\tYour account type: "+account_type);
		//System.out.println("Your mobile number: "+mobilee);
		System.out.println("\t\t\t\tYour Email Id: "+email_add);
		dis.display();
	 }
}

//Display class shows options to the user

import java.util.Scanner;

public class Display {
	   static Scanner ad=new Scanner(System.in);
	   
	 public void side() throws Exception {
		 display();
	 }
		    
	

	public void display() throws Exception  {
		Balance bal = new Balance();
		SendMoney sem = new SendMoney();
	    AtmCard atm = new AtmCard();
	    Loan lo = new Loan();
	    Insurance in = new Insurance();
	    ContactUs con = new ContactUs();
	    System.out.println("Choose your option");
		System.out.println("1.BALANCE\n2.SEND MONEY\n3.ATM DETAILS\n4.LOANS\n5.INSURANCE\n6.MONEY DEPOSIIE\n7.CONTACT US");
	    int cho = ad.nextInt();
	    if(cho==1) {
	    	 int c = bal.getbalance();
	    	 System.out.println("Your available balance is: "+c);
	    	 side();
	    }	
	    else if(cho==2) {
	    	 sem.sendMoney();
	    } 

	    else if(cho==3) {
	    	 atm.atmFuntion();
	    } 
	    else if(cho==4) {
	    	 lo.loan();
	    } 
	    else if(cho==5) {
	    	 in.insurance();
	    } 
	    else if(cho==7) {
	    	 con.contactUs();
	    } 
		
	}
}

//Balance class shows balance of the user

public class Balance {
	private int balance = 20000;
	
	public int getbalance() {
		return balance;
	}
	public void setbalance(int bbal ) {
		balance = bbal;
	}
	public void balance() throws Exception {
		Display dis = new Display();
		dis.display();
	}
}

//SendMoney class send money to the another account

import java.util.Scanner;

public class SendMoney {
	
	static Scanner ad = new Scanner(System.in);
	
	
	public void sendMoney() throws Exception {
		Display dis = new Display();
		Balance bal = new Balance();
		int b = bal.getbalance();
		int c = Server.mpin;
		System.out.println("PRESS 1 TO SEND MONEY\n\nPRESS 2 TO EXIT");
		int inp = ad.nextInt();
		if(inp==1) {
		System.out.println("Enter your account number");
		long acc = ad.nextLong();
		System.out.println("Enter receiver account number");
		long rec = ad.nextLong();
		System.out.println("Enter the MPIN");
		int mpi = ad.nextInt();
		if(mpi==c) {
			System.out.println("Entered account number and MPIN is correct");
		}
		System.out.println("Enter the amount to be sent to another account");
		int amo = ad.nextInt();		
		if(amo<b) {
			bal.setbalance(b-amo);
			System.out.println("Amount sccessfully sent to "+rec);
			int c1 = bal.getbalance();
			System.out.println("your current balance is "+c1);
			dis.display();
		}		
	}
		if(inp==2) {
			dis.display();
		}
}
}

//AtmCard class shows atm card information of the user 

import java.util.Scanner;

public class AtmCard
{
	static Scanner sc=new Scanner(System.in);
	static int db_atm_pin=1234;
	static long db_contact=12345678911L;
	static long db_contact2;

	
	public void atmFuntion()throws Exception {
		Display dis = new Display();
	System.out.println("\tSelect the Input");

	System.out.println("1.Change Pin\n2.Add Contact\n3.Details Of Account Holder\n4.Exit");
	
	int button=sc.nextInt();
	{
	if (button==1)
	{
	System.out.println("\t\tEnter the Contact");
	long user_enter_contact=sc.nextLong();
	if(user_enter_contact==db_contact)
	{
	System.out.println("\t\tEnter the OTP");
	Thread.sleep( 2008);
	int sys_otp=(int) (Math. random()*9999+9999);
	System.out.println(sys_otp);
	int user_enter_otp=sc.nextInt();
	if(user_enter_otp==sys_otp)
	{
	System.out.println("\t\tPlease Enter the New Pin");
	db_atm_pin=sc.nextInt();
	System.out.println("\t\tPin Modified Succesfully :"+db_atm_pin);
	}
	else
	{
	System.out.println("\t\t\tVerification Failed");
	}
	}
	}
	else if(button==2)
	{
		System.out.println("Please enter the second number");
		db_contact2=sc.nextLong();
		System.out.println("Number updated sucessfully: "+db_contact2);
	}

	else if (button==3)
	{
	System.out.println("Pin :"+db_atm_pin);
	System.out.println("Contact :"+db_contact);
	}
	else if (button==4)
	{
	System.out.println("THANK YOU, VISIT AGAIN");
	dis.display();
	}
	else if(button>4 || button<1)
	{
		 wrongInput();		
}	
}
}
	public void wrongInput() throws Exception {
		System.out.println("Please select from the given option");
		atmFuntion();
		
	}	
}

//Loan class shows options to apply loan

import java.util.Scanner;

public class Loan {
	static Scanner ad=new Scanner(System.in);
	Display dis = new Display();
	public void loan() throws Exception {
		
		System.out.println("Welcome to the loan section");
		System.out.println("choose your type of your loan");
		System.out.println("1.PERSONAL LOAN\n2.STUDENT LOAN\n3.HOME LOAN\n4.VECHICLE LOAN\n5.RETURN TO MAIN MENU");
		int in = ad.nextInt();
		if(in==1) {
			personalLoan();
		}
		if(in==2) {
			studentLoan();
		}
		if(in==3) {
			homeLoan();
		}
		if(in==4) {
			vechicleLoan();
		}
		if(in==5) {
			 mainMenu();
		}
		
	}
	public void personalLoan() {
		System.out.println("Welcome to personal loan");
		System.out.println("The intrest rate for personal loan is 14%");
		System.out.println("Enter your age");
		int age = ad.nextInt();
		if(age>=21 && age>=60) {
			System.out.println("Enter your full name");
			String name = ad.next();
			System.out.println("Enter your pancard number");
			String pan = ad.next();
			System.out.println("Enter your Aadharcard number");
			long aadhar = ad.nextLong();
			System.out.println("Enter your Account number");
			long acc = ad.nextLong();
			System.out.println("Enter your Monthly salary");
			int sal = ad.nextInt();
			System.out.println("your application has been approved");
			System.out.println("please visit our nearest bank branch for further process");
		}
	}
	public void studentLoan() {
		System.out.println("Welcome to student loan");
		System.out.println("The intrest rate for personal loan is 12%");
		System.out.println("Enter your age");
		int age = ad.nextInt();
		if(age>=18 && age>=30) {
			System.out.println("Enter your full name");
			String name = ad.next();
			System.out.println("Enter your pancard number");
			String pan = ad.next();
			System.out.println("Enter your Aadharcard number");
			long aadhar = ad.nextLong();
			System.out.println("Enter your Account number");
			long acc = ad.nextLong();
			System.out.println("Enter your SSLC marksheet number");
			int sal = ad.nextInt();
			System.out.println("Enter your college admission number");
			int add = ad.nextInt();
			System.out.println("your application has been approved");
			System.out.println("please visit our nearest bank branch for further process");
	}	
}
	public void homeLoan() {
		System.out.println("Welcome to Home loan");
		System.out.println("The intrest rate for personal loan is 10%");
		System.out.println("Enter your age");
		int age = ad.nextInt();
		if(age>=21 && age>=65) {
			System.out.println("Enter your full name");
			String name = ad.next();
			System.out.println("Enter your pancard number");
			String pan = ad.next();
			System.out.println("Enter your Aadharcard number");
			long aadhar = ad.nextLong();
			System.out.println("Enter your Account number");
			long acc = ad.nextLong();				
			System.out.println("Enter your Monthly salary");
			int sal = ad.nextInt();
			System.out.println("your application has been approved");
			System.out.println("please visit our nearest bank branch for further process");
	}
	}
	public void vechicleLoan() {
		System.out.println("Welcome to Home loan");
		System.out.println("The intrest rate for personal loan is 10%");
		System.out.println("Enter your age");
		int age = ad.nextInt();
		if(age>=21 && age>=65) {
			System.out.println("Enter your full name");
			String name = ad.next();
			System.out.println("Enter your pancard number");
			String pan = ad.next();
			System.out.println("Enter your Aadharcard number");
			long aadhar = ad.nextLong();
			System.out.println("Enter your Account number");
			long acc = ad.nextLong();	
			System.out.println("Enter your Monthly salary");
			int sal = ad.nextInt();
			System.out.println("your application has been approved");
			System.out.println("please visit our nearest bank branch for further process");
	}
}
	public void mainMenu() throws Exception {
		dis.side();
	}
	
}

//MoneyDeposite class shows option to deposite money

import java.util.Scanner;

public class MoneyDeposite {
	
	static Scanner ad = new Scanner(System.in);
      
	public void moneyDeposite() throws Exception {
		Display dis = new Display();
		Balance bal = new Balance();
		int b = bal.getbalance();
		int c = Server.mpin;
		System.out.println("PRESS 1 FOR FIXED DEPOSITE\n\nPRESS 2 FOR RECURSSION DEPOSITE\\nPRESS 3 TO EXIT");
		int inp = ad.nextInt();
		if(inp==1) {
			System.out.println("Enter your account number");
			long acc = ad.nextLong();
			System.out.println("Enter the MPIN");
			int mpi = ad.nextInt();
			if(mpi==c) {
				System.out.println("Entered account number and MPIN is correct");
			}
			System.out.println("Enter the amount to be sent to FD");
			int amo = ad.nextInt();		
			if(amo<b) {
				bal.setbalance(b-amo);
				System.out.println("Amount sccessfully sent to FD");
				int c1 = bal.getbalance();
				System.out.println("your current balance is "+c1);			
	}
}
		if(inp==2) {
			System.out.println("Enter your account number");
			long acc = ad.nextLong();
			System.out.println("Enter the MPIN");
			int mpi = ad.nextInt();
			if(mpi==c) {
				System.out.println("Entered account number and MPIN is correct");
			}
			System.out.println("Enter the amount to be sent to RD");
			int amo = ad.nextInt();		
			if(amo<b) {
				bal.setbalance(b-amo);
				System.out.println("Amount sccessfully sent to RD");
				int c1 = bal.getbalance();
				System.out.println("your current balance is "+c1);			
	}
}
		if(inp==3) {
			dis.display();
		}
}
}

//Insurance class shows options to apply insurance

import java.util.Scanner;

public class Insurance {
	static Scanner ad =new Scanner(System.in);
	Display dis = new Display(); 
	
	public void insurance() throws Exception {
		System.out.println("Welcome to the Insurance section");
		System.out.println("choose your type of your Insurance");
		System.out.println("1.HEALTH INSURANCE\n2.MOTOR INSURANCE\n3.HOME INSURANCE\n4.RETURN TO MAIN MENU");
		int in = ad.nextInt();
		if(in==1) {
			healthInsurance();
		}
		if(in==2) {
			motorInsurance();
		}
		if(in==3) {
			homeInsurance();
		}
		if(in==4) {
			 mainMenu();
		}
	}
	public void healthInsurance() {
		System.out.println("Welcome to Health Insurance");
		System.out.println("1.Insurance for your children press one\n2.Insurance for adults press two");
		int op = ad.nextInt();
		if(op==1) {
			System.out.println("Enter your child age");
			int age = ad.nextInt();
			if(age<18) {
				System.out.println("Enter your child name");
				String name = ad.next();
				System.out.println("Enter parent/guardian name");
				String name1 = ad.next();
				System.out.println("Enter your child's birth certificate number");
				int bc = ad.nextInt();
				System.out.println("Enter your pancard number");
				String pan = ad.next();
				System.out.println("Enter your Aadharcard number");
				long aadhar = ad.nextLong();
				System.out.println("your application has been approved");
				System.out.println("please visit our nearest bank branch for further process");
			}
		}
		if(op==2) {
			System.out.println("Enter your age");
			int age = ad.nextInt();
			if(age>18 && age<65) {
				System.out.println("Enter your full name");
				String name = ad.next();
				System.out.println("Enter your pancard number");
				String pan = ad.next();
				System.out.println("Enter your Aadharcard number");
				long aadhar = ad.nextLong();
				System.out.println("Enter your Account number");
				long acc = ad.nextLong();
				System.out.println("Enter your Monthly salary");
				int sal = ad.nextInt();
				System.out.println("your application has been approved");
				System.out.println("please visit our nearest bank branch for further process");
			}
		}
	}
	public void motorInsurance() {
		System.out.println("Welcome to Motor Insurance");
		System.out.println("1.Insurance for two wheeler press one\n2.Insurance for four wheeler press two");
		int op = ad.nextInt();
		if(op==1 || op==2) {
			System.out.println("Enter your age");
			int age = ad.nextInt();
			if(age>18 && age<65) {
				System.out.println("Enter your full name");
				String name = ad.next();
				System.out.println("Enter your pancard number");
				String pan = ad.next();
				System.out.println("Enter your Aadharcard number");
				long aadhar = ad.nextLong();
				System.out.println("Enter your licence number");
				String lic = ad.next();
				System.out.println("Enter your vechile number");
				int ve = ad.nextInt();
				System.out.println("Enter your RC number");
				String rc = ad.next();
				System.out.println("your application has been approved");
				System.out.println("please visit our nearest bank branch for further process");
			}
	}		
}
	public void homeInsurance() {
		System.out.println("Welcome to Home Insurance");
		System.out.println("Enter your age");
		int age = ad.nextInt();
		if(age>18 && age<65) {
			System.out.println("Enter your full name");
			String name = ad.next();
			System.out.println("Enter exact value of your property");
			int val = ad.nextInt();
			System.out.println("Enter your pancard number");
			String pan = ad.next();
			System.out.println("Enter your Aadharcard number");
			long aadhar = ad.nextLong();
			System.out.println("Enter your Account number");
			long acc = ad.nextLong();				
			System.out.println("Enter your Monthly salary");
			int sal = ad.nextInt();
			System.out.println("your application has been approved");
			System.out.println("please visit our nearest bank branch for further process");
		}
	}
	public void mainMenu() throws Exception {
		dis.side();
	}
}

//ContactUs shows contact information of bank

import java.util.Scanner;

public class ContactUs {
      
	static Scanner ad = new Scanner(System.in);
	Display dis = new Display();
	public void contactUs() throws Exception {
		System.out.println("PRESS 1 TO WRITE YOUR PROBLEMS\nPRESS 2 TO GET CONTACT DETAILS\nPRESS 3 TO EXIT");
		int s = ad.nextInt();
		if(s==1) {
			System.out.println("Enter your problem here");
			String sc = ad.next();
		}
		if(s==2) {
			System.out.println("Consumer Helpline number : 9874563835");
			System.out.println("Call timing [MON-SAT] : 10:00AM to 06:00PM");
			System.out.println("Office working days : MONDAY-SATURDAY");
		}
		if(s==3) {
			dis.display();
		}
	}
}
