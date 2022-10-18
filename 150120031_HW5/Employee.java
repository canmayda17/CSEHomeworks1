/* The purpose of this program is to calculate the revenue, paid salaries and produced 
   total items according to employee's work hour and speed.*/

// Þükrü Can Mayda - 150120031

public class Employee {

	// Defining.
    private int id;
    private String name;
    private String surname;
    private int workHour;
    private int speed;
    private Item[] items;
    private Payroll payroll;

    // Collecting information.
    public Employee(int id, String name, String surname, int workHour, int speed) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.workHour = workHour;
        this.speed = speed;

        items = new Item[0];
    }

    public int getId() {
        return id;
    }

    public Item[] startShift() {
        items = new Item[workHour * speed];

        for (int i = 0; i < items.length; i++) {
            items[i] = new Item((int)(Math.random() * 100 + 1));
        }
        return items;
    }

    public Payroll endShift() {
        payroll = new Payroll (workHour, items.length);
        return payroll;
    }

    // Writing string that explain work hour and speed.
    public String toString() {
        return "This is the employee with id " + id + " speed " + speed + ". The work hour is " + workHour + " and the produced item count is " + items.length + ".";
    }
}