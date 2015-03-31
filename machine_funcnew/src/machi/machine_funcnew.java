package machi;

import java.util.InputMismatchException;
import java.util.Scanner;

public class machine_funcnew {

	
		// TODO Auto-generated method stub

		//method to take input from user and check type mismatch
		public static int input_from_user()  
		{	int i;
			Scanner user= new Scanner(System.in);
			try
			{ 
				i=user.nextInt();
				return i;
			}
			catch(InputMismatchException ex)
			{
				System.out.println("Error Input Mismatch");
				System.exit(0);
				return 0;
			}
		}
		//method to check withdrawal amount entered is valid or not
		public static void check_withdrawal_deduction(int with,int avl_bal)
		{
				if(with<=0)
					System.out.println("Invalid.amount entered is negative"); //if withdrawal amount is negative
				else
					if(with>10000)
						System.out.println(" withdrawal amount greater than 10000"); //  greater than 10000
				else
					if(with>avl_bal)
						System.out.println("not enough balance");  //if withdrawal greater than available amount
		
		}
		//method to deduct withdrawal amount from available balance
		public static void deduct_withdrawal(int with,int avl_bal)
		{
			if(with<avl_bal && with<=10000 && with>0)        // check whether input is non-negative,less than the available balance and less than 10000
			{
				avl_bal=avl_bal-with;                        //deduct withdrawal amount from available balance
				System.out.println("Balance after withdrawal is"+ avl_bal);
			}
		}
		//method to check length of pin
		public static void check_pin_length(int pin)
		{	int div,count=0;
			div=pin;
			while(div>0)  
			{
				div=div/10;
				count++;
			}
			if(count!=4)    ////check the length of pin
			{   System.out.println("Incorrect pin.Length of pin more than 4 numbers");
				System.exit(0);
			}
		}
		//method to print menu
		public static void print_menu()
		{
			System.out.println("======WELCOME======"); 
			System.out.println("1.Available Balance");
			System.out.println("2.Cash withdrawal");
			System.out.println("3.Exit Menu");
			System.out.println("Enter your choice:  ");
		}
		//method to execute all cases in the menu
		public static void work_according_to_choice(int ch,int avl_bal)
		{	int with;
			switch(ch)
			{
			case 1: System.out.println("Available Balanace= "+ avl_bal);   //Print available balance
					break;
			case 2:	System.out.println("Enter withdrawal amount"); // Take withdrawal input from user
					with=input_from_user();
					check_withdrawal_deduction(with,avl_bal);
					deduct_withdrawal(with,avl_bal);
					break;
			case 3: System.out.println("You have successfully exited your account.Thank you.");
					System.exit(0);
			}
		}
		//method to check pin and assign available balance of that pin to avl_bal.Here for 3 accounts
		public static int check_pin_assign_bal(int p)
		{	int avl_bal;
			if(p==3454)
			{
				avl_bal=350000; //available balance for pin 3454 is assigned to avl_bal after pin found to be correct
				return avl_bal;
			}
			else
				if(p==1234)   
				{
					avl_bal=23000; //available balance for pin 1234 is assigned to avl_bal after pin found to be correct
					return avl_bal;
				}
			else
				if(p==2208)
				{
					avl_bal=10000000;  //available balance for pin 2208 is assigned to avl_bal after pin found to be correct
					return avl_bal;
				}
			else
				System.out.println("Incorrect Pin!");    // if user entered incorrect pin display message
				System.exit(0);
				return 0;
		}
		public static void main(String[] args) {
			int pin=0, avl_bal,choice=0; //variable declaration: pin, available balance,user's choice,count to check pin length
			System.out.println("----WELCOM TO XYZ BANK----");
			System.out.println("Enter pin");
			pin=input_from_user();                      //user input using input module
			check_pin_length(pin);      //check pin length
			avl_bal=check_pin_assign_bal(pin);
					while(true)
					{
						print_menu();
						choice=input_from_user();
						if(choice!=1 && choice!=2 && choice!=3)       //check if user entered a valid choice               
							System.out.println("Invalid choice entered! Enter a valid choice");
						else
							work_according_to_choice(choice,avl_bal);    
					}
				
		
	}

}
