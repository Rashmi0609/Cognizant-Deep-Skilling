public class Main {

    public static void main(String[] args) {

        Student model = new Student("Rahul", "101", "A");

        StudentView view = new StudentView();

        StudentController controller = new StudentController(model, view);

        controller.updateView();

        System.out.println();

        controller.setStudentName("Aman");
        controller.setStudentGrade("A+");

        controller.updateView();
    }
} 