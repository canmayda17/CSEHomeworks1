import java.util.ArrayList;

public class SalesEmployee extends RegularEmployee{

    private ArrayList<Product> sales = new ArrayList<Product>();
    public int numberOfSalesEmployees;

    public SalesEmployee(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus,
                         String hasDriverLicense, double salary, java.util.Calendar hireDate, Department department, double pScore, ArrayList<Product> s) {
        super(id, firstName, lastName, gender, birthDate, hasDriverLicense, maritalStatus, salary, hireDate, department, pScore);
        this.sales = s;
        numberOfSalesEmployees++;
    }

    public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
        super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getHasDriverLicense(),
                re.getMaritalStatus(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
        this.sales = s;
        numberOfSalesEmployees++;
    }

    public boolean addSale(Product s) {
        return sales.add(s);
        }

    public boolean removeSale(Product s) {
        return sales.remove(s);
        }

    public ArrayList<Product> getSales() {
        return sales;
    }

    public void setSales(ArrayList<Product> sales) {
        this.sales = sales;
    }

    public int getNumberOfSalesEmployees() {
        return numberOfSalesEmployees;
    }

    public void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
        this.numberOfSalesEmployees = numberOfSalesEmployees;
    }

    @Override
    public String toString() {
        return "SalesEmployee{" +
                "numberofEmployees=" + numberofEmployees +
                ", sales=" + sales +
                ", numberOfSalesEmployees=" + numberOfSalesEmployees +
                '}';
    }
}

