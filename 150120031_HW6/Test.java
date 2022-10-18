import java.io.*;
import java.util.*;

public class Test {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\canma\\Pictures\\CSE1242_spring2022_homework_1_input.txt");
        if (file.exists()) {
            System.out.println("There is a file.");
        }
        else
            System.out.println("There is no file!");

        Scanner input = new Scanner(file);
        ArrayList<Department> departments = new ArrayList<>();
        ArrayList<Project> projects = new ArrayList<>();
        ArrayList<Product> products = new ArrayList<>();
        ArrayList<Person> people = new ArrayList<>();

        while (input.hasNextLine()) {
            String letter = input.next();

            if (letter.equals("Department")) {
                int departmentID = input.nextInt();
                String departmentName = input.next();

                departments.add(new Department(departmentID, departmentName));
            }
            else if (letter.equals("Project")) {
                String projectName = input.next();
                String date = input.next();
                String state = input.next();

                projects.add(new Project(projectName, getCalendar(date), state));
            }
            else if (letter.equals("Product")) {
                String productName = input.next();
                String saleDate = input.next();
                double price = input.nextDouble();

                products.add(new Product(productName, getCalendar(saleDate), price));
            }
            else if (letter.equals("Person")) {
                String firstName = input.next();
                String lastName = input.next();
                int id = input.nextInt();
                String gender = input.next();
                String birthDate = input.next();
                String maritalStatus = input.next();
                String hasDriverLicense = input.next();

                people.add(new Person(id, firstName, lastName, gender, getCalendar(birthDate), maritalStatus, hasDriverLicense));
            }
            else if (letter.equals("Employee")) {
                int id = input.nextInt();
                Person person1 = new Person();
                for (Person p : people) {
                    if (p.getId() == id) {
                        person1 = p;
                    }
                }
                double salary = input.nextDouble();
                String hireDate = input.next();
                Department department = new Department(111,"departmentName");
                String department1 = input.next();
                for (Department d : departments) {
                    if (d.getDepartmentName().equals(department1)) {
                        department.setDepartmentId(d.getDepartmentId());
                        department.setDepartmentName(d.getDepartmentName());
                    }
                }

                people.add(new Employee(person1, salary, getCalendar(hireDate), department));
            }
            else if (letter.equals("RegularEmployee")) {
                int id = input.nextInt();
                Employee employee = new Employee();
                double performanceScore = input.nextDouble();
                for (Person e : people) {
                        if (e instanceof Employee){
                            if (e.getId() == id) {
                                people.add(new RegularEmployee((Employee) e, performanceScore));
                                people.remove(e);
                            }
                    }
                }

                people.add(new RegularEmployee(employee, performanceScore));
            }
            else if (letter.equals("Developer")) {
                int id = input.nextInt();
                Project project = new Project(input.next(), Calendar.getInstance(), "Open");
                try {
                    while (input.next() != "Department" && input.next() != "Person" && input.next() != "Employee" && input.next() != "Manager" && input.next() != "RegularEmployee" &&
                            input.next() != "Developer" && input.next() != "SalesEmployee" && input.next() != "Customer") {
                        for (Project p : projects) {
                            if (p.getProjectName() == project.getProjectName()) {
                                project = p;
                            }
                        }
                        projects.add(project);
                        ArrayList<Project> projects1 = new ArrayList<>();
                        projects1.add(project);
                        for (Person r : people) {
                            if (r instanceof RegularEmployee) {
                                if (r.getId() == id) {
                                    people.add(new Developer((RegularEmployee) r, projects1));
                                    people.remove(r);
                                    break;
                                }
                            }
                        }
                    }
                }
                catch (NoSuchElementException e) {

                }
            }
            else if (letter.equals("Manager")) {
                int id = input.nextInt();
                Employee employee = new Employee();
                double bonusBudget = input.nextDouble();
                for (Person e : people) {
                    if (e instanceof Employee){
                        if (e.getId() == id) {
                            people.add(new Manager((Employee) e, bonusBudget));
                            ((Employee) e).setNumberofEmployees(people.size());
                            people.remove(e);
                        }
                    }
                }

            }
            else if (letter.equals("SalesEmployee")) {
                int id = input.nextInt();
                Product product = new Product("productName", Calendar.getInstance(), 5000);

                    for (Product p : products) {
                        if (p.getProductName() == product.getProductName()) {
                            product = p;
                        }
                        products.add(product);
                        ArrayList<Product> products1 = new ArrayList<>();
                        products1.add(product);
                        for (Person r : people) {
                            if (r instanceof RegularEmployee) {
                                if (r.getId() == id) {
                                    people.add(new SalesEmployee((RegularEmployee) r, products1));
                                    people.remove(r);
                            }
                        }
                    }
                }
            }
            else if (letter.equals("Customer")) {
                int id = input.nextInt();
                Person person = new Person();
                for (Person p : people) {
                    if (p.getId() == person.getId()) {
                        person = p;
                    }
                }
                Product product = new Product("productName", Calendar.getInstance(), 5000);
                while (input.next() != "Department" && input.next() != "Person" && input.next() != "Employee" && input.next() != "Manager" && input.next() != "RegularEmployee" &&
                        input.next() != "Developer" && input.next() != "SalesEmployee" && input.next() != "Customer") {
                    for (Product p : products) {
                        if (p.getProductName() == product.getProductName()) {
                            product = p;
                        }
                        products.add(product);
                        ArrayList<Product> products1 = new ArrayList<>();
                        products1.add(product);
                        people.add(new Customer(person, products1));
                    }
                }
            }
        }
        for (Person m : people) {
            if (m instanceof Manager) {
                ((Manager) m).distributeBonusBudget();
                ((Manager) m).raiseSalary(0.2);
            }
        }
        for (Person r : people) {
            if (r instanceof RegularEmployee && !(r instanceof Developer)) {
                ((RegularEmployee) r).raiseSalary(0.3);
            }
        }
        for (Person d : people) {
            if (d instanceof Developer) {
                ((Developer) d).raiseSalary(0.23);
            }
        }
        for (Person s : people) {
            if (s instanceof SalesEmployee) {
                ((SalesEmployee) s).raiseSalary(0.18);
                ((SalesEmployee) s).raiseSalary(1000);
            }
        }

        for (int i=0; i < departments.size(); i++) {
            System.out.println("************************************************");
            System.out.println(departments.get(i).toString());
            for (Person m : people) {
                if (m instanceof Manager) {
                    System.out.println(m.toString());
                }
            }
            for (Person d : people) {
                if (d instanceof Developer) {
                    System.out.println("\t\t\t1. Developer");
                    System.out.println(people.get(i).toString());
                    System.out.println("\t\t\t\tEmployee Info [salary=" + ((Developer) d).getSalary() + ", hireDate="  + "/"  + "/" +   "]");
                    System.out.println("\t\t\t\tRegularEmployee Info [performanceScore=" + ((Developer) d).getPerformanceScore() + ", bonus=" );
                    System.out.println("\t\t\t\t[Project [projectName=" + projects.get(i).getProjectName() + ", startDate=" + "/" + "/" + ", state= false]" + "[Project [projectName=" + projects.get(i+1).getProjectName() + ", startDate=" + "/" + "/" + ", state= true]");
                }
            }
            for (Person s : people) {
                if (s instanceof SalesEmployee) {
                    System.out.println("\t\t\t2. Sales Employee");
                    System.out.println(people.get(i).toString());
                    System.out.println("\t\t\t\tEmployee Info [salary=" + ((SalesEmployee) s).getSalary() + ", hireDate="  + "/"  + "/" +   "]");
                    System.out.println("\t\t\t\tRegularEmployee Info [performanceScore=" + ((SalesEmployee) s).getPerformanceScore() + ", bonus=" );
                    System.out.print("\t\t\t\t[Product [productName=" + products.get(i).getProductName() + ", transactionDate=" + "/" + "/" + ", state= false]" );
                    System.out.print("[Product [productName=" + products.get(i+1).getProductName() + ", startDate=" + "/" + "/" + ", state= true]" );
                    System.out.println();
                }
            }
            for (Person r : people) {
                if (r instanceof RegularEmployee && r.getId() == 156) {
                    System.out.println("\t\t\t3. RegularEmployee");
                    System.out.println("\t\t\t\tPerson Info[id=" + r.getId() + ", firstName="  + r.getFirstName() + ", lastName=" + r.getLastName() + ", gender=" + r.getGender() + "]");
                    System.out.println("\t\t\t\tEmployee Info [salary=" + ((RegularEmployee) r).getSalary() + ", hireDate="  + "/"  + "/" +   "]");
                    System.out.println("\t\t\t\tRegularEmployee Info [performanceScore=" + ((RegularEmployee) r).getPerformanceScore() + ", bonus=" + ((RegularEmployee) r).getBonus());
                }
            }
        }
    }



    private static Calendar getCalendar(String date) {
        var splittedDate = date.split("/");
        var day = Integer.parseInt(splittedDate[0]);
        var month = Integer.parseInt(splittedDate[1]) - 1;
        var year = Integer.parseInt(splittedDate[2]);
        var calendar = Calendar.getInstance();
        calendar.set(day,month,year);
        return calendar;
    }

    /*private static void convertCalendar(String date) {
        String str = ""
        for (int i = 0; i < date.length(); i++) {
            if (date.charAt(i) != '/') {
                str += date.charAt(i);
            }
        }
        int day = (str.charAt(0) + str.charAt(1));
        int month = (str.charAt(2) + str.charAt(3));
        int year = (str.charAt(4) + str.charAt(5) + str.charAt(6) + str.charAt(7));
    }

     */
}
