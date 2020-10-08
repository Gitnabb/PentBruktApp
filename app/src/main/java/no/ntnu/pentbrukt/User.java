package no.ntnu.pentbrukt;

public class User {

    private String firstName;
    private String lastName;
    private String username;
    private String password;

    private String jwtToken;

    public User(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }
}
