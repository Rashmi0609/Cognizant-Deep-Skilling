public class TaskLinkedList {

    private Task head;

    // Add Task
    public void addTask(Task task) {

        if (head == null) {
            head = task;
            return;
        }

        Task temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = task;
    }

    // Search Task
    public void searchTask(int id) {

        Task temp = head;

        while (temp != null) {

            if (temp.taskId == id) {
                System.out.println(temp);
                return;
            }

            temp = temp.next;
        }

        System.out.println("Task Not Found");
    }

    // Display Tasks
    public void displayTasks() {

        Task temp = head;

        while (temp != null) {

            System.out.println(temp);

            temp = temp.next;
        }
    }

    // Delete Task
    public void deleteTask(int id) {

        if (head == null)
            return;

        if (head.taskId == id) {

            head = head.next;

            System.out.println("Task Deleted");

            return;
        }

        Task temp = head;

        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }

        if (temp.next != null) {

            temp.next = temp.next.next;

            System.out.println("Task Deleted");

        } else {

            System.out.println("Task Not Found");

        }
    }
}