package Beginner;

import java.util.Scanner;

public class BasicCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Basic Calculator");
		Scanner scan = new Scanner(System.in);
		
		char operand;
		boolean valid = false;
		
		do {
			System.out.println("input operator: ");
			operand = scan.next().charAt(0);
			
			if (operand == '+' || operand == '-'|| operand == '*' || operand == '/') {
				valid = true;
			}
			else {
				System.out.println("Invalid operator. Please provide a valid operator (+ , - , * , /)");
			}
		}
		while(!valid);
		
		System.out.println("Please input 1st number: \n");
		int firstNumber = scan.nextInt();
		
		System.out.println("Please input the 2nd number: \n");
		int secondNumber = scan.nextInt();
		
		
		int answer = 0;
		switch (operand) {
		case '+': answer = firstNumber + secondNumber; break;
		case '-': answer = firstNumber - secondNumber; break;
		case '*': answer = firstNumber * secondNumber; break;
		case '/': if (secondNumber == 0) {
			System.out.println("cannot divide using zero");
			break;
		}
			answer = firstNumber / secondNumber; break;
		default: System.out.println("Please enter a valid operand"); break;
		
		}
		System.out.println("Result: " + answer);
		scan.close();
	}

}
