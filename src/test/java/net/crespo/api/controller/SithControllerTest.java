package net.crespo.api.controller;

import io.restassured.http.ContentType;
import net.crespo.model.Sith;
import net.crespo.repository.SithRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("DEV")
public class SithControllerTest {

    private static final List<String> NAMES = Arrays.asList("Darth Vader", "Darth Sidius");

    @Autowired
    private SithRepository repository;

    @LocalServerPort
    int port;

    private List<Sith> siths;

    @Before
    public void setUp() throws Exception {

        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        initializeDatabase();

    }

    private void initializeDatabase() {

        repository.deleteAll();

        siths = new ArrayList<>();
        siths.add(new Sith("Darth Sidius", "Red"));
        siths.add(new Sith("Darth Vader", "Red"));
        repository.save(siths);
    }

    @Test
    public void getAllSithsShouldReturnOk() {

        given()

                .when()
                .get(SithController.JEDI_BASE_URL_MAPPING)

                .then()
                .statusCode(200)
                .body("id", hasSize(NAMES.size()))
                .body("name", hasItems(NAMES.toArray()));

    }

    @Test
    public void postANewSithShouldReturnASithWithId() {

        Sith sith = new Sith("Darth Vader", "Red");

        given()
                .body(sith)
                .contentType(ContentType.JSON)

                .when()
                .post(SithController.JEDI_BASE_URL_MAPPING)

                .then()
                .statusCode(200)
                .body("id", notNullValue());
    }

    @Test
    public void deleteAJediShouldReturnOk() {

        Sith sithToDelete = siths.get(0);

        given()

                .when()
                .delete(SithController.JEDI_BASE_URL_MAPPING
                        + SithController.JEDI_MAPPING.replace("{sithId}", String.valueOf(sithToDelete.getId())))

                .then()
                .statusCode(200);

    }

}