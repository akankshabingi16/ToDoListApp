import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Task {
    private String taskName;
    private String dueDate;
    private boolean isCompleted;

    public Task(String taskName, String dueDate) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.isCompleted = false; // Initialize as not completed
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDueDate() {
        return dueDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void markAsCompleted() {
        this.isCompleted = true;
    }
}

class ToDoList {
    private List<Task> tasks;

    public ToDoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void displayTasks() {
        System.out.println("To-Do List:");
        for (Task task : tasks) {
            System.out.println(task.getTaskName() + " (Due: " + task.getDueDate() + ")");
        }
    }

    public void completeTask(String taskName) {
        for (Task task : tasks) {
            if (task.getTaskName().equals(taskName)) {
                task.markAsCompleted();
                System.out.println("Task marked as completed: " + task.getTaskName());
                return;
            }
        }
        System.out.println("Task not found: " + taskName);
    }
}

public class ToDoListApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList toDoList = new ToDoList();

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Display Tasks");
            System.out.println("3. Complete Task");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task name: ");
                    String taskName = scanner.nextLine();
                    System.out.print("Enter due date: ");
                    String dueDate = scanner.nextLine();
                    Task newTask = new Task(taskName, dueDate);
                    toDoList.addTask(newTask);
                    System.out.println("Task added successfully!");
                    break;

                case 2:
                    toDoList.displayTasks();
                    break;

                case 3:
                    System.out.print("Enter task name to mark as completed: ");
                    String taskToComplete = scanner.nextLine();
                    toDoList.completeTask(taskToComplete);
                    break;

                case 4:
                    System.out.println("Exiting To-Do List Application. Goodbye!");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}