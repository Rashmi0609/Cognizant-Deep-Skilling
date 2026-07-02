public class Main {

    public static void main(String[] args) {

        EmployeeManagement emp = new EmployeeManagement();

        emp.addEmployee(new Employee(101, "Rahul", "Manager", 60000));
        emp.addEmployee(new Employee(102, "Priya", "Developer", 50000));
        emp.addEmployee(new Employee(103, "Aman", "Tester", 40000));

        System.out.println("\nEmployee List");
        emp.displayEmployees();

        System.out.println("\nSearch Employee");
        System.out.println(emp.searchEmployee(102));

        System.out.println("\nDelete Employee");
        emp.deleteEmployee(103);

        System.out.println("\nUpdated Employee List");
        emp.displayEmployees();
    }
}