package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pojos.ListUserData;
import spec.Specifications;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;

public class ListUsersTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkUsersData(){
        Specifications.installSpecification(Specifications.requestSpec(URL), Specifications.requestSpec200());
        List<ListUserData> users = given()
                .when()
                .get("api/users?page=2")
                .then().log().all()
                .extract().body().jsonPath().getList("data", ListUserData.class);

        List<String> firstNames = users.stream().map(ListUserData::getFirst_name).collect(Collectors.toList());
        for(int i = 0; i < firstNames.size(); i++){
            Assertions.assertTrue(firstNames.get(i).contains(firstNames.get(i)));
        }
    }
}
