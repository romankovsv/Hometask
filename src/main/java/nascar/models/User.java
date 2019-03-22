package nascar.models;

public class User {

    private String email;
    private String password;
    private String zip;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getZip() {
        return zip;
    }

    public User(String email, String password, String zip){
        this.email = email;
        this.password = password;
        this.zip = zip;

    }
}
