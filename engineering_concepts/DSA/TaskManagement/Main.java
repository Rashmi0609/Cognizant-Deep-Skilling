public class Main {

    public static void main(String[] args) {

        TaskLinkedList list = new TaskLinkedList();

        list.addTask(new Task(101, "Design UI", "Pending"));
        list.addTask(new Task(102, "Develop Backend", "In Progress"));
        list.addTask(new Task(103, "Testing", "Pending"));

        System.out.println("Task List");
        list.displayTasks();

        System.out.println("\nSearch Task");
        list.searchTask(102);

        System.out.println("\nDelete Task");
        list.deleteTask(103);

        System.out.println("\nUpdated Task List");
        list.displayTasks();
    }
}