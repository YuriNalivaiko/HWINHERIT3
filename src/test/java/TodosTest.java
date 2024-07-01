import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void testTaskMatches() {
        Task task = new Task(1);
        assertFalse(task.matches("example"), "Task should not match any query.");
    }

    @Test
    public void testSimpleTaskMatches() {
        SimpleTask simpleTask = new SimpleTask(1, "Write unit tests");
        assertTrue(simpleTask.matches("unit"), "SimpleTask should match query 'unit'.");
        assertFalse(simpleTask.matches("integration"), "SimpleTask should not match query 'integration'.");
    }

    @Test
    public void testMeetingMatches() {
        Meeting meeting = new Meeting(1, "Planning", "ProjectX", "10:00am");
        assertTrue(meeting.matches("Planning"), "Meeting should match query 'Planning'.");
        assertTrue(meeting.matches("ProjectX"), "Meeting should match query 'ProjectX'.");
        assertTrue(meeting.matches("10:00am"), "Meeting should match query '10:00am'.");
        assertFalse(meeting.matches("Lunch"), "Meeting should not match query 'Lunch'.");
    }

    @Test
    public void testTodosMatches() {
        Todos todos = new Todos();
        todos.add(new Task(1));
        todos.add(new SimpleTask(2, "Write unit tests"));
        todos.add(new Meeting(3, "Planning", "ProjectX", "10:00am"));

        assertFalse(todos.matches("example"), "Todos should not match 'example'.");
        assertTrue(todos.matches("unit"), "Todos should match 'unit'.");
        assertTrue(todos.matches("ProjectX"), "Todos should match 'ProjectX'.");
    }

    @Test
    public void testTodosSearch() {
        Todos todos = new Todos();
        todos.add(new Task(1));
        todos.add(new SimpleTask(2, "Write unit tests"));
        todos.add(new Meeting(3, "Planning", "ProjectX", "10:00am"));

        assertFalse(todos.search("example"), "Todos should not match 'example'.");
        assertTrue(todos.search("unit"), "Todos should match 'unit'.");
        assertTrue(todos.search("ProjectX"), "Todos should match 'ProjectX'.");
    }
}