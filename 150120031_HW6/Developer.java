import java.util.ArrayList;

public class Developer extends RegularEmployee{

    private ArrayList<Project> projects = new ArrayList<Project>();
    public int numberOfDevelopers;

    public Developer(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus,
                     String hasDriverLicense, double salary, java.util.Calendar hireDate, Department department, double pScore, ArrayList<Project> p) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense, salary, hireDate, department, pScore);
        this.projects = p;
        numberOfDevelopers++;
    }

    public Developer(RegularEmployee re, ArrayList<Project> p) {
        super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicense(),
                re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
        this.projects = p;
        numberOfDevelopers++;
    }

    public boolean addProject(Project s) {
        projects.add(s);
        return true;
    }

    public boolean removeProject(Product s) {
        projects.remove(s);
        return true;
    }

    public ArrayList<Project> getProjects() {
        return projects;
    }

    public void setProjects(ArrayList<Project> projects) {
        this.projects = projects;
    }

    public int getNumberOfDevelopers() {
        return numberOfDevelopers;
    }

    public void setNumberOfDevelopers(int numberOfDevelopers) {
        this.numberOfDevelopers = numberOfDevelopers;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "projects=" + projects +
                ", numberOfDevelopers=" + numberOfDevelopers +
                ", numberofEmployees=" + numberofEmployees +
                '}';
    }
}
