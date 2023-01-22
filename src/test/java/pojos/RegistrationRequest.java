package pojos;

public class RegistrationRequest {
    private String email;
    private String password;

    public RegistrationRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public RegistrationRequest(){

    }
}
