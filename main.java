import java.util.ArrayList;
import java.util.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


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

		fill(sleepTime, 300, 500, 400, 700, 500, 700);
		fill(energySleep, 20, 30, 50, 60, 40, 50);
		fill(pleasantSleep, 40, 50, 70, 80, 60, 70);
		
		fill(workTime, 20, 50, 30, 60, 10, 40);
		fill(energyWork, 70, 85, 44, 55, 60, 70);
		fill(pleasantWork, 40, 50, 60, 80, 20, 30);
		
		fill(exerciseTime, 20, 40, 30, 50, 30, 72);
		fill(energyExercise, 50, 60, 80, 90, 10, 30);
		fill(pleasantExercise, 40, 50, 60, 70, 30, 40);
		
		fill(relaxTime, 10, 40, 15, 35, 30, 60);
		fill(energyRelax, 40, 50, 50, 60, 60, 70);
		fill(pleasantRelax, 60, 70, 70, 80, 45, 50);
		
		fill(socialTime, 10, 40, 15, 35, 35, 70);
		fill(energySocial, 60, 65, 70, 80, 20, 30);
		fill(pleasantSocial, 45, 55, 55, 80, 20, 30);
		introduction();
		
		
		System.out.println("\nSleep:\nsleepTime:" + sleepTime);
		System.out.println("energySleep:" + energySleep);
		System.out.println("pleasantSleep:" + pleasantSleep);
		System.out.println("\nWork:\nworkTime:" + workTime);
		System.out.println("energyWork:" + energyWork);
		System.out.println("pleasantWork:" + pleasantWork);
		System.out.println("\nExercise:\nexerciseTime:" + exerciseTime);
		System.out.println("energyExercise:" + energyExercise);
		System.out.println("pleasantExercise:" + pleasantExercise);
		System.out.println("\nSocial:\nsocialTime:" + socialTime);
		System.out.println("energySocial:" + energySocial);
		System.out.println("pleasantSocial:" + pleasantSocial);
		System.out.println("\nRelax:\nrelaxTime:" + relaxTime);
		System.out.println("energyRelax:" + energyRelax);
		System.out.println("pleasantRelax:" + pleasantRelax);
	
	}
		
	public static void fill(ArrayList<Integer> a, int min1, int max1, int min2, int max2, int min3, int max3) {
		Random rand = new Random();
		for (int i = 0; i < 30; i++) {
			int random_int = ThreadLocalRandom.current().nextInt(min1, max1 + 1);
			a.add(random_int);
		}
		for (int i = 0; i < 40; i++) {
			int random_int = ThreadLocalRandom.current().nextInt(min2, max2 + 1);
			a.add(random_int);
		}
		for (int i = 0; i < 50; i++) {
			int random_int = ThreadLocalRandom.current().nextInt(min3, max3 + 1);
			a.add(random_int);
		}
	}
		
	public static void introduction() {
		boolean ready = false; 
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello, I am Baymax: Your personal Happiness Bot. Before we begin, what is your name?");
		String name = sc.nextLine();
		
		System.out.println("Pleasure to meet you " + name + ". Here are the Instructions:\n\nPlease document your time IN MINS of each activity as well as your energy and pleasantness levels out of 100 after the activity has been completed and input into the program.\nDaily activities can be categorized into exercise, sleep, social, relax, and work. \r\n" + 
				"\n\tClarifications for activities:\r\n" + 
				"\tExercise - any physical activity or recreations\r\n" + 
				"\tSleep - night time sleep, rather than nap time\r\n" + 
				"\tSocial - time spent socializing and hanging out with friends or other people\r\n" + 
				"\tRelax - self-care time, such as gaming, reading, etc. \r\n" + 
				"\tWork - time spent doing schoolwork, homework, etc not including school or work itself :)\n\nType 'ready' when you are ready. ");
		String yesOrNo = sc.nextLine();
		while (ready == false) {
			if (yesOrNo.equals("ready")) {
				System.out.println("Great, lets begin! \n");
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
						outlier(sleepTime, pleasantSleep, energySleep);
						outlier(workTime, pleasantWork, energyWork);
						outlier(exerciseTime, pleasantExercise, energyExercise);
						outlier(socialTime, pleasantSocial, energySocial);
						outlier(relaxTime, pleasantRelax, energyRelax);


						System.out.println("Here are the ideal durations (in mins) for all the activities to attain maximum PLEASANTNESS:\r\n");
						compile(sleepTime, pleasantSleep, "sleeping");
						compile(workTime, pleasantWork, "working");
						compile(exerciseTime, pleasantExercise, "exercising");
						compile(socialTime, pleasantSocial, "socializing");
						compile(relaxTime, pleasantRelax, "relaxing");
						
						System.out.println("\nHere are the ideal durations (in mins) for all the activities to attain maximum ENERGY:\r\n");
						compile(sleepTime, energySleep, "sleeping");
						compile(workTime, energyWork, "working");
						compile(exerciseTime, energyExercise, "exercising");
						compile(socialTime, energySocial, "socializing");
						compile(relaxTime, energyRelax, "relaxing");
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
					System.out.println("That is an invalid number, please input a number between 0 - 1440");
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
					System.out.println("That is an invalid number, please input a number between 0 - 1440");
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
					System.out.println("That is an invalid number, please input a number between 0 - 1440");
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
					System.out.println("That is an invalid number, please input a number between 0 - 1440");
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
			
			if (energyLevel < 40 & energyLevel >= 0) {
				System.out.println("Okay, let's see why that is.");
				vars2 = true;
				energyChooseList(activity, energyLevel);
			}
			else if (energyLevel >= 40 & energyLevel < 70) {
				System.out.println("Great, let's determine why that is");
				vars2 = true;
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
	
	public static void outlier(ArrayList<Integer> realTime, ArrayList<Integer> pleasant, ArrayList<Integer> energy) {
		//take out outlier 
		ArrayList<Integer> time = new ArrayList<>(realTime.size());
		for (int i = 0; i < realTime.size(); i++) {	
			time.add(realTime.get(i));
		}
		Collections.sort(time);
		
		int quartile = time.get((time.size()/4));
		int thirdQuartile = time.get(time.size()-(time.size()/4));
		int IQR = thirdQuartile - quartile;
		double max = thirdQuartile+(1.5*IQR);
		double min = quartile-(1.5*IQR);
		
		for (int i = 0; i < realTime.size(); i++) {
			if (realTime.get(i) > max || realTime.get(i) < min) {
				realTime.remove(i);
				pleasant.remove(i);
				energy.remove(i);
				i--;
			}
		}
	}
	//determine ideal
	public static double ideal(ArrayList<Integer> time, ArrayList<Integer> value) {
		//take out outlier 
		double valueSum = 0;
		double ideal = 0;
		for (int i = 0; i < value.size(); i++) {
			valueSum += value.get(i);
		}
		for (int b = 0; b < value.size(); b++) {
			if (value.size() != time.size()) {
				System.out.println("Different SIZE");
			}
			ideal += (value.get(b) / valueSum)*time.get(b);
		}
		return ideal;
	}	
		
	public static void compile(ArrayList<Integer> time, ArrayList<Integer> value, String action) {
		double ideal = ideal(time, value);
		double roundIdeal = Math.round(ideal*100.0)/100.0;
		
		String idealString = String.valueOf(roundIdeal);
		System.out.println("Ideal duration of " + action + ": " + idealString + " minutes");
		
	}
	
	
}
