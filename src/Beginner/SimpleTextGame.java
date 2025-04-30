package Beginner;

import java.util.Random;
import java.util.Scanner;

public class SimpleTextGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		boolean sword = false, orb = false;
		System.out.println("Please input player name: ");
		String name = scanner.nextLine();
		System.out.println("Welcome to the Dragon Quest " + name + "! Hope you enjoy!");
		start(scanner, sword, orb);
	}

	public static void start(Scanner scanner, boolean sword, boolean orb) {
		System.out.println(
				"You find yourself in the main dungeon. There are three doors in front of you: What do you do?");
		System.out.println("Do you go Left, Center, or Right?");
		String choice = scanner.nextLine().toLowerCase();

		switch (choice) {
		case "left":
			if(orb) {
				System.out.println("The corpse of the dragon was reduced to ash! the room is filled with emptiness. There is nothing more here");
				start(scanner, sword, orb);
				break;
			}
			else {
			dragonRoom(scanner, sword, orb);
			break;
			}
		case "center":
			if (sword) {
				System.out.println("You already have the treasured sword! There's nothing more in here...");
				start(scanner, sword, orb);
				break;
			}
			else {
				chestRoom(scanner);
				break;
			}
		case "right":
			susRoom(scanner, sword, orb);
			break;

		default:
			System.out.println("Invalid choice. Try again!");
			start(scanner, sword, orb);
			break;
		}

	}

	public static void dragonRoom(Scanner scanner, boolean hasSword, boolean orb) {
		System.out.println("There is a DRAGON!!! It looks very dangerous as it stares at you! What do you do?!");
		System.out.println("Fight or go back?");
		String choice = scanner.nextLine().toLowerCase();

		switch (choice) {
		case "fight":
			if (hasSword) {
				System.out.println(
						"You used the Legendary sword to fight the Dragon! with one swift move, the Dragon was decapitated!");
				behindDragon(scanner, true);
				break;
			} else {
				System.out.println("You were powerless against the mighty Dragon... you have died without honor.");
				tryagain(scanner);
				break;
			}
		case "go back":
			start(scanner, hasSword, orb);
			break;
		default:
			System.out.println("Wrong move! the DRAGON spits a FIREBALL at you!!! You died..");
			tryagain(scanner);
			break;
		}
	}

	public static void chestRoom(Scanner scanner) {
		System.out.println(
				"There are three chests in front of you, and a sign that says 'one contains a treasure, two of them are MIMICS!!'. What do you do?");
		System.out.println("Pick chest1, chest2, chest3, or go back?");
		String choice = scanner.nextLine().toLowerCase();
		Random random = new Random();
		int luck = random.nextInt(1, 4);
//		System.out.println("chest" + luck);
//		System.out.println(choice);

		if (choice.equals("chest" + luck)) {
			System.out.println("You just found a Legendary Sword!!! It only takes one slash to finish off enemies!");
			System.out.println("You returned to the main dungeon with the Legendary Sword");
			start(scanner, true, false);
		} else {
			System.out.println(choice + " was a MIMIC!!! It attacks you fiercely, you have died...");
			luck = 0;
			tryagain(scanner);
		}

	}

	public static void behindDragon(Scanner scanner, boolean orb) {
		System.out.println("As you watch the dragon fall, you have noticed a hidden room behind the dragon's corpse...");
		System.out.println("You explored the hidden room and found a Mystical Orb floating in the middle of the room!");
		System.out.println("You tried to touch the Orb and you can feel the presensce of the stars!");
		System.out.println("You have collected the Orb and returned to the main dungeon");
		start(scanner, true, orb);
	}
	
	public static void susRoom(Scanner scanner,boolean sword,  boolean orb) {
		System.out.println("There is a suspicious hole in the middle of the room. Other than that, there is nothing in here...");
		System.out.println("What do you do?");
		System.out.println("approach or leave?");
		String choice = scanner.nextLine().toLowerCase();
		
		if (choice.equals("approach") && orb) {
			System.out.println("The Mystical Orb starts glowing brighter and BRIGHTER! the Orb was sucked by the suspicious hole and fits perfectly!");
			System.out.println("You gaze at the glowing Orb in the hole as it flashes brightly!");
			System.out.println("As you open your eyes, you see a massive crowd cheering and clapping as they celebrate you as their new King!!!");
			ending();
			return;
		}
		if(choice.equals("leave")) {
			start(scanner, sword, orb);
		}
		else {
			System.out.println("The suspicious hole suddenly starts absorbing everything around it!");
			System.out.println("You got sucked inside the hole, breaking your bones that caused your death...");
			tryagain(scanner);
		}
	}
	public static void ending() {
		System.out.println("Thanks for playing!");
		System.out.println("Hope you enjoy my mini game!");
		return;
	}

	public static void tryagain(Scanner scanner) {
		System.out.println("Do you want to try again? Y/N");
		char opt = scanner.nextLine().charAt(0);
		if (opt == 'y' || opt == 'Y') {
			start(scanner, false, false);
		} else {
			ending();
		}
	}

}
