package TaskManager_OOP;

public class Task {

	private String task;
	private String duedate;
	int priority;
	private boolean markComplete;
	
	public Task (String task, String duedate, int priority) {
		this.task = task;
		this.duedate = duedate;
		this.priority = priority;
		this.markComplete = false;
	}
	
	public void markCompleted() {
		this.markComplete = true;
	}
	
	@Override
	public String toString() {
		return "Task: " + task + " Duedate : " + duedate + " Priority: " + priority + " Completed: " + markComplete;
	}

	public String getTitle() {
		return task;
	}
	
}
