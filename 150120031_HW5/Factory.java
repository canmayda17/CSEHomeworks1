/* The purpose of this program is to calculate the revenue, paid salaries and produced 
   total items according to employee's work hour and speed.*/

// Þükrü Can Mayda - 150120031

public class Factory {

	// Defining.
    private String name;
    private Employee[] employees;
    private Storage storage;
    private Payroll[] payrolls;
    private double itemPrice;

    // Collecting factory data.
    public Factory (String name, int capacity, double itemPrice) {
        this.name = name;
        this.itemPrice = itemPrice;

        storage = new Storage(capacity);
        employees = new Employee[0];
        payrolls = new Payroll[0];
    }

    // Getting revenue.
    public double getRevenue() {
        return (storage.getItems().length * itemPrice);
    }

    // Getting paid salaries.
    public double getPaidSalaries() {
        double total = 0;

        for (int i = 0; i < employees.length; i++) {
            total += payrolls[i].calculateSalary();
        }

        return total;
    }

    // Adding employee
    public void addEmployee (Employee employee) {
        Employee[] tempEmployee = employees;
        employees = new Employee[tempEmployee.length + 1];

        Item[] items = employee.startShift();

        for (int i = 0; i < employees.length - 1; i++) {
            employees[i] = tempEmployee[i];
        }

        employees[employees.length - 1] = employee;

        for (int i = 0; i < items.length; i++) {
            storage.addItem(items[i]);
        }
    }

    // Removing employee
    public Employee removeEmployee (int id) {
        boolean isEmployee = false;
        int employeeIndex = 0;

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                isEmployee = true;
                employeeIndex = i;
            }
        }

        if (employees.length == 0) {
            System.out.println("There are no employees!");
            return null;
        }
        else if (!(isEmployee)) {
            System.out.println("Employee does not exit!");
            return null;
        }
        else {
            Employee[] tempEmployee = employees;
            employees = new Employee[employees.length - 1];

            for (int i = 0; i < employees.length; i++) {

                if (i < employeeIndex) {
                    employees[i] = tempEmployee[i];
                }
                else {
                    employees[i] = tempEmployee[i + 1];
                }

            }

            addPayroll(tempEmployee[employeeIndex].endShift());
            return tempEmployee[employeeIndex];
        }

    }

    // Adding payroll.
    private void addPayroll (Payroll payroll) {

        Payroll[] tempPayroll = payrolls;
        payrolls = new Payroll[tempPayroll.length + 1];

        for (int i = 0; i < tempPayroll.length; i++) {
            tempPayroll[i] = payrolls[i];
        }

        payrolls[payrolls.length - 1] = payroll;
    }


}
