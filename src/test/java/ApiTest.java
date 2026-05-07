import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;

public class ApiTest {

    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetStatus() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200);
    }

    @Test
    public void testGetResponseBody() {
        given()
                .when()
                .get("/posts/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("userId", equalTo(1));
    }

    @Test
    public void testPostRequest() {
        JSONObject request = new JSONObject();
        request.put("title", "Pranav");
        request.put("body", "Testing API");
        request.put("userId", 1);

        given()
                .header("Content-Type", "application/json")
                .body(request.toString())
                .when()
                .post("/posts")
                .then()
                .statusCode(201);
    }

    @Test
    public void testDeleteRequest() {
        given()
                .when()
                .delete("/posts/1")
                .then()
                .statusCode(200);
    }
}