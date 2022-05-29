import java.util.ArrayList;
import java.util.Scanner;

public class main {
	
	
	
	
	
	//declare all variables used to determine overall happiness 

	static ArrayList<Integer> exerciseTime = new ArrayList<Integer>();
	static ArrayList<Integer> sleepTime = new ArrayList<Integer>();
	static ArrayList<Integer> socialTime = new ArrayList<Integer>();
	static ArrayList<Integer> workTime = new ArrayList<Integer>();
	static ArrayList<Integer> selfTime = new ArrayList<Integer>();
	

	
	//happiness variables
	static String name = ""; 
	static ArrayList<Integer> energy = new ArrayList<Integer>();
	static ArrayList<Integer> pleasant = new ArrayList<Integer>();
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		askHappiness();
		askTimes();
	}

	//function asking pleasant and energy levels
	public static void askHappiness() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello, I am Baymax: Your peresonal Happiness Bot. Before we begin, what is your name?");
		String name = sc.nextLine();
		
		System.out.println("Pleasure to meet you " + name + ". On a scale of 0-100, what are your pleasant levels today?");
		
		boolean vars = false; 
		int pleasantLevel = sc.nextInt();
		
		// keep on taking a pleasant level until it pleasant is a number between 0 and 100
		while (vars == false) {
			
			if (pleasantLevel < 40 & pleasantLevel >= 0) {
				System.out.println("I'm sorry to hear that.");
				pleasant.add(pleasantLevel);
				vars = true; 
			}
			else if (pleasantLevel >= 40 & pleasantLevel <= 70) {
				System.out.println("Awesome!");
				vars = true;
				pleasant.add(pleasantLevel);
			}
			else if (pleasantLevel > 70 & pleasantLevel <= 100) {
				System.out.println("That's great to hear!");
				vars = true;
				pleasant.add(pleasantLevel);

			}
			else { 
				System.out.println("That is an invalid number, please input a number between 0 - 100");
				pleasantLevel = sc.nextInt();
			}			
		}
		System.out.println("On a scale of 0-100, what are your energy levels today?");
		
		boolean vars2 = false; 
		int energyLevel = sc.nextInt();
		
		while (vars2 == false) {
			
			if (energyLevel <= 50 & energyLevel >= 0) {
				System.out.println("Okay, let's see why that is.");
				vars2 = true;
				energy.add(energyLevel);
			}
			else if (energyLevel >= 40 & energyLevel < 70) {
				System.out.println("Great, let's determine why that is");
				vars = true;
				energy.add(pleasantLevel);
			}
			else if (energyLevel >= 70 & energyLevel <= 100) {
				System.out.println("Perfect! That's great!");
				vars2 = true;
				energy.add(energyLevel);
			}
			else { 
				System.out.println("That is an invalid number, please input a number between 0 - 100");
				energyLevel = sc.nextInt();
			}			
		}
		
	}
	
	//variable to get all time inputs
	public static void askTimes(){
		Scanner sc = new Scanner(System.in);
		
		//scanner asking for the time spent sleeping
		System.out.println("How long did you sleep last night? (mins)");
		
		boolean vars = false; 
		int timeOfSleep = sc.nextInt();
		
		// keep on taking a pleasant level until it pleasant is a number between 0 and 100
		while (vars == false) {
			
			if (timeOfSleep <= 0 & timeOfSleep >= 1440) {
				System.out.println("Perfect, thanks");
				sleepTime.add(timeOfSleep);
				vars = true; 

			}
			else { 
				System.out.println("That is an invalid number, please input a number between 0 - 100");
				timeOfSleep = sc.nextInt();
			}			
		}
		
		// asking for the time spent working
		System.out.println("How long did you sleep last night? (mins)");
		
		boolean vars2 = false; 
		int timeOfWork = sc.nextInt();
		
		// keep on taking a work level until it is a number between 0 and 100
		while (vars2 == false) {
			if (timeOfWork <= 0 & timeOfWork >= (1440-timeOfSleep)) {
				System.out.println("Perfect, thanks");
				workTime.add(timeOfWork);
				vars2 = true; 

			}
			else { 
				System.out.println("That is an invalid number, please input a number between 0 - 100");
				timeOfWork = sc.nextInt();
			}			
		}
		
		// asking for the time spent exercising
		System.out.println("How long did you sleep last night? (mins)");
		
		boolean vars3 = false; 
		int timeOfSocial = sc.nextInt();
		
		// keep on taking a social level until it pleasant is a number between 0 and 100
		while (vars3 == false) {
			if (timeOfSocial <= 0 & timeOfSocial >= (1440-timeOfSleep)) {
				System.out.println("Perfect, thanks");
				socialTime.add(timeOfSocial);
				vars3 = true; 

			}
			else { 
				System.out.println("That is an invalid number, please input a number between 0 - 100");
				timeOfSocial = sc.nextInt();
			}			
		}
	}
	
	
	
	
	
	
	
	
	
}
