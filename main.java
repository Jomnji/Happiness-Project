import java.util.ArrayList;
import java.util.*;


import java.util.Scanner;

public class main {
	
	//declare all variables used to determine overall happiness 

	
	static ArrayList<Integer> sleepTime = new ArrayList<Integer>();
	
	
	
	
	static ArrayList<Integer> energySleep = new ArrayList<Integer>();
	static ArrayList<Integer> pleasantSleep = new ArrayList<Integer>();
	
	static ArrayList<Integer> workTime = new ArrayList<Integer>();
	static ArrayList<Integer> energyWork = new ArrayList<Integer>();
	static ArrayList<Integer> pleasantWork = new ArrayList<Integer>();

	static ArrayList<Integer> exerciseTime = new ArrayList<Integer>();
	static ArrayList<Integer> energyExercise = new ArrayList<Integer>();
	static ArrayList<Integer> pleasantExercise = new ArrayList<Integer>();
	
	static ArrayList<Integer> socialTime = new ArrayList<Integer>();
	static ArrayList<Integer> energySocial = new ArrayList<Integer>();
	static ArrayList<Integer> pleasantSocial = new ArrayList<Integer>();
	
	static ArrayList<Integer> relaxTime = new ArrayList<Integer>();
	static ArrayList<Integer> energyRelax = new ArrayList<Integer>();
	static ArrayList<Integer> pleasantRelax = new ArrayList<Integer>();
	

	
	
	static int sumOfTimes = 0; 
	
	//happiness variables
	static String name = ""; 
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//introduction();
		
		
		
		
		for(int i = 0; i < 7; i++) {   
			sleepTime.add(7-i); 
		}
		
		ArrayList sleepTimeCopy = (ArrayList)sleepTime.clone();
		
		System.out.println(sleepTimeCopy);
		
		Collections.sort(sleepTimeCopy); 
		
		System.out.println(sleepTimeCopy);
		
	}
		
		
		
	public static void introduction() {
		boolean ready = false; 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello, I am Baymax: Your personal Happiness Bot. Before we begin, what is your name?");
		String name = sc.nextLine();
		
		System.out.print("Pleasure to meet you " + name + ". Here are the Instructions:\n\tPlease document your time of each activity as well as your energy and pleasantness level out of 100 after the activity has been completed and input into the program. Daily activities can be categorized into exercise, sleep, social, relax, and work. \r\n" + 
				"\tClarifications for activities:\r\n" + 
				"\tExercise - any physical activity or recreations\r\n" + 
				"\tSleep - night time sleep, rather than nap time\r\n" + 
				"\tSocial - time spent socializing and hanging out with friends or other people\r\n" + 
				"\tRelax - self-care time, such as gaming, reading, etc. \r\n" + 
				"Work - time spent doing schoolwork, homework, etc :)\nType 'ready' when you are ready.");
		String yesOrNo = sc.nextLine();
		while (ready == false) {
			if (yesOrNo.equals("ready")) {
				System.out.println("Great, lets begin!");
				ready = true;
				askTimes();
				//start next function that begins asking for times
				boolean iOrC = true;
				while (iOrC == true) {
					System.out.println ("Would you like to input again or compile results? i - input c - compile");
					String desire = sc.nextLine();
					if (desire.equals("i")) {
						askTimes();
					}
					else if (desire.equals("c")) {
						iOrC = false;
						System.out.println("FAKE RESULTS");
					}
					else {
						System.out.println ("Please type either i to enter a new input of activity or c to compile the results");
						desire = sc.nextLine();
						
					}
				}
			}
			else {
				System.out.println("Type 'ready' when you are ready");
				yesOrNo = sc.nextLine();
			}
		}
	}
	

	//variable to get all time inputs
	public static void askTimes(){
		
		Scanner sc = new Scanner(System.in);
		
		//ask which value they want to interview 
		System.out.println("What activity did you just complete (type the coresponding two letters)? \nsl - sleep\nwo - work\nex - exercise\nso - socialize\nre - relax");
		String activity = sc.nextLine();
		
		if (activity.equals("sl")) {
			//scanner asking for the time spent sleeping
			System.out.println("How long did you sleep for?");
			
			boolean sleepVar = false; 
			int timeOfSleep = sc.nextInt();
			
			// keep on taking a pleasant level until it pleasant is a number between 0 and 100
			while (sleepVar == false) {
				
				if (timeOfSleep >= 0 & timeOfSleep <= 1440-sumOfTimes) {
					System.out.println("Perfect, thanks");
					sleepTime.add(timeOfSleep);
					sleepVar = true; 
					sumOfTimes += timeOfSleep; 
					askHappiness("sleeping");
				}
				else { 
					System.out.println("That is an invalid number, please input a number between 0 - 1440");
					timeOfSleep = sc.nextInt();
				}			
			}
		}
		else if (activity.equals("wo")){
			// asking for the time spent working
			System.out.println("How long did you work for?");
			
			boolean workVar = false; 
			int timeOfWork = sc.nextInt();
			
			// keep on taking a work level until it is a number between 0 and 100
			while (workVar == false) {
				if (timeOfWork >= 0 & timeOfWork <= (1440-sumOfTimes)) {
					System.out.println("Okay perfect");
					workTime.add(timeOfWork);
					workVar = true; 
					sumOfTimes += timeOfWork; 
					askHappiness("working");

				}
				else { 
					System.out.println("That is an invalid number, please input a number between 0 - 100");
					timeOfWork = sc.nextInt();
				}			
			}
		}
		else if (activity.equals("ex")){
			// asking for the time spent exercising 
			System.out.println("How long did you exercise for?");
			
			boolean exerciseVar = false; 
			int timeOfExercise = sc.nextInt();
			
			while (exerciseVar == false) {
				if (timeOfExercise >= 0 & timeOfExercise <= (1440-sumOfTimes)) {
					System.out.println("Okay perfect");
					exerciseTime.add(timeOfExercise);
					exerciseVar = true; 
					sumOfTimes += timeOfExercise; 
					askHappiness("exercising");

				}
				else { 
					System.out.println("That is an invalid number, please input a number between 0 - 100");
					timeOfExercise = sc.nextInt();
				}			
			}			
		}
		else if (activity.equals("so")){
			// asking for the time spent socializing 
			System.out.println("How long did you socialize for?");
			
			boolean socialVar = false; 
			int timeOfSocial = sc.nextInt();
			
			// keep on taking a social level until it is a number between 0 and 100
			while (socialVar == false) {
				if (timeOfSocial >= 0 & timeOfSocial <= (1440-sumOfTimes)) {
					System.out.println("Okay perfect");
					socialTime.add(timeOfSocial);
					socialVar = true; 
					sumOfTimes += timeOfSocial; 
					askHappiness("socializing");

				}
				else { 
					System.out.println("That is an invalid number, please input a number between 0 - 100");
					timeOfSocial = sc.nextInt();
				}			
			}			
		}
		else if (activity.equals("re")){
			// asking for the time spent socializing 
			System.out.println("How long did you relax for?");
			
			boolean relaxVar = false; 
			int timeOfRelax = sc.nextInt();
			
			while (relaxVar == false) {
				if (timeOfRelax >= 0 & timeOfRelax <= (1440-sumOfTimes)) {
					System.out.println("Okay perfect");
					relaxTime.add(timeOfRelax);
					relaxVar = true; 
					sumOfTimes += timeOfRelax; 
					askHappiness("relaxing");

				}
				else { 
					System.out.println("That is an invalid number, please input a number between 0 - 100");
					timeOfRelax = sc.nextInt();
				}			
			}			
		}
		sumOfTimes = 0;
	}	
	
	//function asking pleasant and energy levels
	public static void askHappiness(String activity) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("On a scale of 0-100, what are your pleasant levels after " + activity + "?");
		
		boolean vars = false; 
		int pleasantLevel = sc.nextInt();
		
		// keep on taking a pleasant level until it pleasant is a number between 0 and 100
		while (vars == false) {
			
			if (pleasantLevel < 40 & pleasantLevel >= 0) {
				System.out.println("I'm sorry to hear that.");
				pleasantChooseList(activity, pleasantLevel);
				vars = true; 
			}
			else if (pleasantLevel >= 40 & pleasantLevel <= 70) {
				System.out.println("Awesome!");
				vars = true;
				pleasantChooseList(activity, pleasantLevel);
			}
			else if (pleasantLevel > 70 & pleasantLevel <= 100) {
				System.out.println("That's great to hear!");
				vars = true;
				pleasantChooseList(activity, pleasantLevel);

			}
			else { 
				System.out.println("That is an invalid number, please input a number between 0 - 100");
				pleasantLevel = sc.nextInt();
			}			
		}
		System.out.println("On a scale of 0-100, what are your energy levels after " + activity + "?");
		
		boolean vars2 = false; 
		int energyLevel = sc.nextInt();
		
		while (vars2 == false) {
			
			if (energyLevel <= 50 & energyLevel >= 0) {
				System.out.println("Okay, let's see why that is.");
				vars2 = true;
				energyChooseList(activity, energyLevel);
			}
			else if (energyLevel >= 40 & energyLevel < 70) {
				System.out.println("Great, let's determine why that is");
				vars = true;
				energyChooseList(activity, energyLevel);
			}
			else if (energyLevel >= 70 & energyLevel <= 100) {
				System.out.println("Perfect! That's great!");
				vars2 = true;
				energyChooseList(activity, energyLevel);
			}
			else { 
				System.out.println("That is an invalid number, please input a number between 0 - 100");
				energyLevel = sc.nextInt();
			}			
		}	
	}
	
	// these two functions are used to determine which energy and pleasant arrayList should the value be inputted into
	public static void pleasantChooseList(String key, int value) {
		if (key.equals("sleeping")) {
			energySleep.add(value);
		}
		else if (key.equals("working")) {
			energyWork.add(value);
		}
		else if (key.equals("exercising")) {
			energyExercise.add(value);
		}
		else if (key.equals("socializing")) {
			energySocial.add(value);
		}
		else if (key.equals("relaxing")) {
			energyRelax.add(value);
		}
	}
	
	public static void energyChooseList(String key, int value) {
		if (key.equals("sleeping")) {
			pleasantSleep.add(value);
		}
		else if (key.equals("working")) {
			pleasantWork.add(value);
		}
		else if (key.equals("exercising")) {
			pleasantExercise.add(value);
		}
		else if (key.equals("socializing")) {
			pleasantSocial.add(value);
		}
		else if (key.equals("relaxing")) {
			pleasantRelax.add(value);
		}
	}	
	public static void compile() {
		//make a sorted copy
		ArrayList sleepTimeCopy = (ArrayList)sleepTime.clone();
				
		Collections.sort(sleepTimeCopy); 
		
		
		//take out outliar 
		for (int i = 0; i = sleepTimeCopy.size()
		
	}
	
	
	
	
	
	
	
	
}
