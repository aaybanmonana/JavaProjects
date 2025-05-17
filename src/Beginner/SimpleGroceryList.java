package Beginner;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class SimpleGroceryList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<String, Integer> items = new HashMap<>();
		Scanner scanner = new Scanner(System.in);
		boolean proceed = true;
		
		System.out.println("SimpleGroceryList");
		
		do {
			System.out.println("What do you want to do? \n");
			System.out.println(">> Add items to list");
			System.out.println(">> Remove items to list");
			System.out.println(">> View items in list");
			System.out.println(">> Close list");
			
			String choice = scanner.nextLine().toLowerCase();
			
			switch (choice) {
			case "add":
				System.out.println("What item should be added?");
				String additem = scanner.nextLine();
				System.out.println("Input quantity: ");
				int addcount = scanner.nextInt();
				int totalCount;
				
				if(items.containsKey(additem)) {
					totalCount = items.get(additem) + addcount;
					items.replace(additem, totalCount);
					System.out.println("Added " + addcount + " more " + additem + " to the list. Total of " +additem + ": " + totalCount + "\n");
				} 
				else
				{
				items.put(additem, addcount);
				System.out.println("Added " + addcount + " " + additem + " to the list. \n");
				}
				proceed = true;
				break;
				
			case "remove":
				System.out.println("What item should be removed?");
				String delItem = scanner.nextLine();
				System.out.println("Input quantity: ");
				int delCount = scanner.nextInt();
				
				
				if (items.containsKey(delItem)) {
					int itemcount = items.get(delItem);
					int finalcount = itemcount - delCount;
				if (itemcount > delCount) {
					items.replace(delItem, finalcount);
					System.out.println("Removed " + delCount + " " + delItem + " to the list. Remaining " + delItem + ": " + finalcount + " \n");
				}
				else {
					items.remove(delItem);
					System.out.println("Removed " + delItem + " to the list. \n");
				}
				}
				else {
					System.out.println("There is no " + delItem + " in the list. \n");
				}
				proceed = true;
				break;
				
			case "view":
				System.out.println("Items on the Grocery List are:");
				for (Entry<String, Integer> hm: items.entrySet()) {
					System.out.println(hm.getKey() + ": " + hm.getValue());
				}
				proceed = true;
				break;
				
			case "close":
				System.out.println("Closing the Grocery List.");
				proceed = false;
				break;
				
			default: 
				System.out.println("Invalid action: Please select a valid action. \n");
				proceed = true;
				
			}
		}
		while(proceed);
		scanner.close();
	}

}
