package pojos;

public class BadRegistrationData {
    private String error;

    public BadRegistrationData(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public BadRegistrationData(){

    }
}
