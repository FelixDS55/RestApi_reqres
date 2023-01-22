package tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import pojos.CreateUserRequest;
import pojos.CreateUserResponse;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserRestApiTests {
    @Test
    public void createUser(){
        CreateUserRequest rq = new CreateUserRequest();
        rq.setName("morpheus");
        rq.setJob("leader");

        CreateUserResponse rs = given()
                .baseUri("https://reqres.in/api")
                .basePath("/users")
                .contentType(ContentType.JSON)
                .body(rq)
                .when().post()
                .then().log().all().extract().as(CreateUserResponse.class);

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getName)
                .isEqualTo(rq.getName());

        assertThat(rs)
                .isNotNull()
                .extracting(CreateUserResponse::getJob)
                .isEqualTo(rq.getJob());
    }
}
