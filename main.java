import java.util.Scanner;

public class main {
	
	
	
	//declare all variables used to determine overall happiness 
	static int exerciseTime = 0;
	static int sleepTime = 0;
	static int socialTime = 0;
	static int workTime = 0;
	static int schoolTime = 0;
	
	//happiness variables
	static String name = " "; 
	static int energy = 0;
	static int pleasant = 0;
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		askHappiness();
	}

	
	public static void askHappiness() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Hello, I am Happiness Bot. Before we begin, what is your name?");
		String name = sc.nextLine();
		
		System.out.println("Pleasure to meet you " + name + ". On a scale of 0-100, what are your pleasant levels today?");

		int pleasant = sc.nextInt();
		
		if (pleasant <= 50 & pleasant >= 0) {
			System.out.println("I'm sorry to hear that, let's try to improve that");
		}
		else if (pleasant >= 50 & pleasant <= 100) {
			System.out.println("That's great to hear!");
		}
		else {
			System.out.println("That is an invalid number, please input a number between ");

			int pleasant = sc.nextInt();
		}

	}
		
}
