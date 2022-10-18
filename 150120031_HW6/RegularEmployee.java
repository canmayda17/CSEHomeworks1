import java.util.ArrayList;

public class RegularEmployee extends Employee{

    private double performanceScore, bonus;

    public RegularEmployee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus,
                           String hasDriverLicense, double salary, java.util.Calendar hireDate, Department department, double performanceScore) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department);
        this.performanceScore = performanceScore;
    }

    public RegularEmployee(Employee employee, double perfScore){
        super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(),
                employee.getHasDriverLicense(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
        this.performanceScore = perfScore;
    }

    public RegularEmployee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus,
                           String hasDriverLicense, double salary, java.util.Calendar hireDate, Department department) {
    super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department);
    }

    public RegularEmployee(RegularEmployee re) {
    }

    public double getPerformanceScore() {
        return performanceScore;
    }

    public void setPerformanceScore(double performanceScore) {
        this.performanceScore = performanceScore;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "RegularEmployee{" +
                "performanceScore=" + performanceScore +
                ", bonus=" + bonus +
                '}';
    }
}

