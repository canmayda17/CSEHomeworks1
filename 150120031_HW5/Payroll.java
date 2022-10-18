/* The purpose of this program is to calculate the revenue, paid salaries and produced 
   total items according to employee's work hour and speed.*/

// Þükrü Can Mayda - 150120031

public class Payroll {

	// Define work hour and item count.
    private int workHour;
    private int itemCount;

    // Payroll method.
    public Payroll (int workHour, int itemCount) {
        this.workHour = workHour;
        this.itemCount = itemCount;
    }

    // Calculating the salary.
    public int calculateSalary() {
        return ((workHour * 3) + (itemCount * 2));
    }

    public String toString() {
        return ("The work hour is " + workHour + " and the produced item count is " + itemCount);
    }
}