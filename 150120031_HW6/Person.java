public class Person {

    private int id;
    private String firstName, lastName;
    private byte gender, maritalStatus;
    private boolean hasDriverLicense;
    private java.util.Calendar birthDate;

    public Person(int id, String firstName, String lastName, String gender, java.util.Calendar birthDate, String maritalStatus, String hasDriverLicense) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        if (gender.equals("Woman")) {
            this.gender = 1;
        }
        else if (gender.equals("Man")) {
            this.gender = 2;
        }
        try {
            if (maritalStatus.equals("Single")) {
                this.maritalStatus = 1;
            } else if (maritalStatus.equals("Married")) {
                this.maritalStatus = 2;
            }
        }
        catch(NullPointerException e) {

        }
        if (hasDriverLicense.equals("Yes")) {
            this.hasDriverLicense = true;
        }
        else if (hasDriverLicense.equals("No")) {
            this.hasDriverLicense = false;
        }
        this.birthDate = birthDate;
    }

    public Person() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        if (gender.equals("Woman")) {
            this.gender = 1;
        }
        else if (gender.equals("Man")) {
            this.gender = 2;
        }
    }

    public String getGender() {
            if (this.gender == 1) {
                return "Woman";
            } else if (this.gender == 2)
                return "Man";
            else
        return "It should be 1 or 2";
    }

    public void setMaritalStatus(String status) {
        if (status == "Single") {
            this.maritalStatus = 1;
        }
        else if (status == "Married") {
            this.maritalStatus = 2;
        }
    }

    public String getMaritalStatus() {
            if (this.maritalStatus == 1) {
                return "Single";
            } else if (this.maritalStatus == 2) {
                return "Married";
            }
        return null;
    }

    public void setHasDriverLicense(String info) {
        if (info == "Yes") {
            this.hasDriverLicense = true;
        }
        else if (info == "No") {
            this.hasDriverLicense = false;
        }
    }

    public String getHasDriverLicense() {
        if (this.hasDriverLicense) {
            return "Yes";
        }
        else
            return "No";
    }

    public java.util.Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(java.util.Calendar birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "\t\t\t\tPerson Info[id=" + id +
                ", firstName=" + firstName +
                ", lastName=" + lastName +
                ", gender=" + getGender() +
                ']';
    }
}
