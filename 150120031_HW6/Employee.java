
public class Employee extends Person{
    private double salary;
    private java.util.Calendar hireDate;
    private Department department;
    public int numberofEmployees;

    public Employee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus,
                    String hasDriverLicense, double salary, java.util.Calendar hireDate, Department department) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
        numberofEmployees++;
    }

    public Employee(Person person, double salary, java.util.Calendar hireDate, Department department) {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicense());
        this.salary = salary;
        this.hireDate = hireDate;
        this.department = department;
        numberofEmployees++;
    }

    public Employee(){
        super();
    }

    public double raiseSalary(double percent) {
        if (percent >= 0 && percent <= 1) {
            this.salary = this.salary * (1.0 + percent);
        }
        else
            System.exit(1);
        return 0;
    }

    public int raiseSalary(int amount){
        this.salary = this.salary + amount;
        return (int)this.salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public java.util.Calendar getHireDate() {
        return hireDate;
    }

    public void setHireDate(java.util.Calendar hireDate) {
        this.hireDate = hireDate;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public int getNumberofEmployees() {
        return numberofEmployees;
    }

    public void setNumberofEmployees(int numberofEmployees) {
        this.numberofEmployees = numberofEmployees;
    }


    @Override
    public String toString() {
        return "Employee Info [id=" + getId() +
                ", hireDate=" + getHireDate() +
                ']';
    }
}
