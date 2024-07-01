import java.util.Arrays;

public class Todos {
    private Task[] tasks = new Task[0];

    private Task[] addToTaskArray(Task[] current, Task task) {
        Task[] tmp = Arrays.copyOf(current, current.length + 1);
        tmp[tmp.length - 1] = task;
        return tmp;
    }

    public void add(Task task) {
        tasks = addToTaskArray(tasks, task);
    }

    public boolean matches(String query) {
        for (Task task : tasks) {
            if (task.matches(query)) {
                return true;
            }
        }
        return false;
    }

    public boolean search(String query) {
        for (Task task : tasks) {
            if (task.search(query)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Todos todos = new Todos();
        todos.add(new Task(1));
        todos.add(new Task(2));
        System.out.println(todos.matches("Task 1")); // false
        System.out.println(todos.matches("Task 3")); // false
    }
}