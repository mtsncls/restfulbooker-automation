package api.models;

public class Booking {

    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    public Booking(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public static class Builder {
        private String firstName;
        private String lastName;
        private String email;
        private String phone;

        public Builder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public Booking build() {
            return new Booking(firstName, lastName, email, phone);
        }
    }
}
