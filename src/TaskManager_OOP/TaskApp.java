package TaskManager_OOP;

import java.util.Scanner;

public class TaskApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		TaskManager TM = new TaskManager();

		while (true) {
			System.out.println("\n Task Manager:");
			System.out.println("1. Add Task");
			System.out.println("2. Complete Task");
			System.out.println("3. View Tasks");
			System.out.println("4. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1 -> {
				System.out.println("Input new Task");
				String task = scanner.nextLine();
				System.out.println("When is it due?");
				String due = scanner.nextLine();
				System.out.println("Priority Level:");
				int prio = scanner.nextInt();
				scanner.nextLine();

				TM.addTask(task, due, prio);
			}
			case 2 -> {
				System.out.println("Which Task was fulfilled?");
				String tasked = scanner.nextLine();
				
				TM.completeTask(tasked);
				
			}

			case 3 -> {
				TM.showTasks();
			}

			case 4 -> {
				System.out.println("Exitting....");
				return;
			}
			default -> {
				System.out.println("Invalid selection. Try again");
			}
			}
		}

	}

}
