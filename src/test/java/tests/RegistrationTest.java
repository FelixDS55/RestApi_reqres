package tests;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojos.BadRegistrationData;
import pojos.RegistrationRequest;
import pojos.RegistrationResponse;
import spec.Specifications;

import static io.restassured.RestAssured.given;

public class RegistrationTest {
    private final static String URL = "https://reqres.in/";
    @Test
    public void registrationTest(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.requestSpec200());
        Integer id = 4;
        String token = "QpwL5tke4Pnpja7X4";
        RegistrationRequest user = new RegistrationRequest("eve.holt@reqres.in", "pistol");
        RegistrationResponse registrationResponse = given()
                .body(user)
                .when()
                .post("api/register")
                .then().log().all()
                .extract().as(RegistrationResponse.class);
        Assertions.assertNotNull(registrationResponse.getId());
        Assertions.assertNotNull(registrationResponse.getToken());
        Assertions.assertEquals(id, registrationResponse.getId());
        Assertions.assertEquals(token, registrationResponse.getToken());
    }

    @Test
    public void badRegistration(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.requestSpec400());

        RegistrationRequest user = new RegistrationRequest("sydney@fife", "");
        BadRegistrationData badRegistrationData = given()
                .body(user)
                .post("api/register")
                .then().log().all()
                .extract().as(BadRegistrationData.class);

        Assertions.assertEquals("Missing password", badRegistrationData.getError());
    }
}
