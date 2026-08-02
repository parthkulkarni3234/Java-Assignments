import java.util.ArrayList;

class TaskDisplay {

    public String showTasks(ArrayList<String> tasks) {
        StringBuffer sb = new StringBuffer();
        sb.append("--- To-Do List ---\n");

        for (int i = 0; i < tasks.size(); i++) {
            sb.append((i + 1) + ". " + tasks.get(i) + "\n");
        }

        return sb.toString();
    }
}

// Main class
public class ToDoList {

    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();
        TaskDisplay display = new TaskDisplay();

        // Adding tasks to the list
        tasks.add("Complete Java assignment");
        tasks.add("Buy groceries");
        tasks.add("Attend project meeting");

        // Displaying tasks using StringBuffer
        System.out.println(display.showTasks(tasks));

        // Removing a task
        tasks.remove("Buy groceries");

        System.out.println("After removing 'Buy groceries':");
        System.out.println(display.showTasks(tasks));
    }
}