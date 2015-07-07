package ocja2015;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		System.out.println("Pick a random number between 1 and 20");

		Random rand = new Random();                    // Declares random generator
		int rnd = rand.nextInt(21);					   // Generates random number between 1-20

		Scanner scan = new Scanner(System.in);         // Declares Scanner
		int input;
		boolean isGameOn = true;

		int attemptCount = 0;
		int counter = 1;
		boolean[] check = new boolean[100];


		while(isGameOn){

			System.out.println(rnd);
			for(int i = 0;counter != 0; ++i){

				input = scan.nextInt();

				if(check[input - 1] == true){
					System.out.println("You've guessed that number already");
					attemptCount--;

				}
				if(input < 1 || input > 20){
					System.out.println("Wrong input. Please pick number within range 1- 20:");
				}else{
					if(input != rnd){
						System.out.print("Wrong answer! Guess again: ");
						check[input - 1] = true;
						attemptCount++;			
					}else{
						System.out.println("Congrats you've won!");
						System.out.print("Your total attempts were: " + (attemptCount  + 1)+ "\n");
						System.out.println("Do you want to play again?? Y/N");
						String choice = scan.next().toUpperCase();
						if(choice.equals("Y")){
							System.out.println("Pick a random number between 1 and 20");
							rnd = rand.nextInt(21);
							isGameOn = true;
							attemptCount = 0;
							break;
						}else{
							isGameOn = false;
							System.out.println("Thanks for playing!");
						}

						counter = 0;	
					}
				}
			}
		}
	}
}

