package pojos;

public class RegistrationResponse {
    private Integer id;
    private String token;

    public RegistrationResponse(Integer id, String token) {
        this.id = id;
        this.token = token;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public RegistrationResponse(){

    }
}
