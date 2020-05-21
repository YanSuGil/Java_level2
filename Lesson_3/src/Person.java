public class Person {

    private String surname;
    private String phoneNumber;
    private String email;

    public Person(String surname, String phoneNumber, String email) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
