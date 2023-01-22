package pojos;

import lombok.Data;

@Data
public class CreateUserRequest {
    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    private String name;
    private String job;
}
