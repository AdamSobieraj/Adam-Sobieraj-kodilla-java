package Task2.ProgramData;

public class UserOfOrder {

    private final int id;
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String email;

    public UserOfOrder(final int id, final String firstName,
                final String lastName, final String address,
                final String email) {
        userDataValidation(id, firstName, lastName, address, email);

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
    }

    private void userDataValidation(int id, String firstName,
                                    String lastName, String address, String email) {
        if (id <= 0) {
            throw new IllegalArgumentException("incorrect ID");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("Missing firstName");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Missing lastName");
        }
        if (address == null || address.isEmpty()) {
            throw new IllegalArgumentException("Missing address");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Missing email");
        }

    }

    @Override
    public String toString() {
        return  " ID= " + id +
                ", firstName= '" + firstName + '\'' +
                ", lastName= '" + lastName + '\'' +
                ", address= '" + address + '\'' +
                ", email= '" + email ;
    }
}
