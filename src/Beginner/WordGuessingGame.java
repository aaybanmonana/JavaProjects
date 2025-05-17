package Beginner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WordGuessingGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<String> words = new ArrayList<String>();
		words.add("acid");
		words.add("laborer");
		words.add("frown");
		words.add("telephone");
		words.add("crown");
		words.add("trustee");
		words.add("attachment");
		words.add("permission");
		words.add("fee");
		words.add("witness");
		
		Random random = new Random();
		int mistake = 0;
		int maxMistakes = 3;
		
		String word = words.get(random.nextInt(words.size()));
		System.out.println("Your word: ");
		int wordLength = word.toCharArray().length;
		char[] letters = new char[wordLength];
		Arrays.fill(letters, '_');
		
		System.out.println(Arrays.toString(letters).replaceAll("[\\[\\],]", ""));
		
		while (mistake < maxMistakes && new String(letters).contains("_")) {
			System.out.println("\nPlease enter a letter: ");
			char letter = scanner.next().charAt(0);
			boolean found = false;
			
			for (int i = 0; i < wordLength; i++) {
				if(letter == word.charAt(i)) {
					letters[i] = letter;
					found = true;
				}
			}
			
			if(!found) {
				mistake++;
				System.out.println("No " + letter + " in your word. Mistakes: " + mistake);
			}
			
			System.out.println(Arrays.toString(letters)); // Display progress
			
		}
		
		if(new String(letters).equals(word)) {
			System.out.println("Congratulations! You have guessed the word: " + word);
		}
		else {
			System.out.println("Game over. The word was " + word);
		}
		scanner.close();
	}

}
