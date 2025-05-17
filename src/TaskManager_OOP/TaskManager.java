package TaskManager_OOP;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskManager {

	private List<Task> tasks = new ArrayList<>();
	
	public void addTask(String task, String due, int prio) {
		tasks.add(new Task(task, due, prio));
	}
	
	public void showTasks() {
		tasks.stream().sorted(Comparator.comparingInt(task -> task.priority)).forEach(System.out::println);
	}
	
	public boolean taskExist(String exist) {
		return tasks.stream().anyMatch(task -> task.getTitle().equalsIgnoreCase(exist));
	}
	
	public void completeTask (String tasked) {
		if(taskExist(tasked)) {
		tasks.stream().filter(task -> task.getTitle().equals(tasked)).findFirst().ifPresent(Task:: markCompleted);
		System.out.println(tasked + " completed!");
		}
		else {
			System.out.println("No " + tasked + " in your tasks!");
		}
	}
}
