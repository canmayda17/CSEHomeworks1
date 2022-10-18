import java.util.ArrayList;

public class Customer extends Person{

    private ArrayList<Product> products = new ArrayList<Product>();

    public Customer(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate,
                    String maritalStatus, String hasDriverLicense, ArrayList<Product> products) {
        super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicense);
        this.products = products;
    }

    public Customer(Person person, ArrayList<Product> products) {
        super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicense());
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "products=" + products +
                '}';
    }
}
