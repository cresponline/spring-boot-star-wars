/*package net.birelian.api.controller;

import io.restassured.http.ContentType;
import net.birelian.model.Jedi;
import net.birelian.repository.JediRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("DEV")
public class JediControllerTest {

    private static final List<String> NAMES = Arrays.asList("Obi", "Yoda");

    @Autowired
    private JediRepository repository;

    @LocalServerPort
    int port;

    private List<Jedi> jedis;

    @Before
    public void setUp() throws Exception {

        RestAssured.port = port;
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();

        initializeDatabase();

    }

    private void initializeDatabase() {

        repository.deleteAll();
        jedis = NAMES.stream().map(Jedi::new).collect(Collectors.toList());
        repository.save(jedis);
    }

    @Test
    public void getAllJedisShouldReturnOk() {

        given()

                .when()
                .get(JediController.JEDI_BASE_URL_MAPPING)

                .then()
                .statusCode(200)
                .body("id", hasSize(NAMES.size()))
                .body("name", hasItems(NAMES.toArray()));

    }

    @Test
    public void postANewJediShouldReturnAJediWithId() {

        Jedi jedi = new Jedi("Test");

        given()
                .body(jedi)
                .contentType(ContentType.JSON)

                .when()
                .post(JediController.JEDI_BASE_URL_MAPPING)

                .then()
                .statusCode(200)
                .body("id", notNullValue());
    }

    @Test
    public void deleteAStarFighterShouldReturnOk() {

        Jedi jediToDelete = jedis.get(0);

        given()

                .when()
                .delete(JediController.JEDI_BASE_URL_MAPPING
                        + JediController.JEDI_MAPPING.replace("{JediId}", String.valueOf(jediToDelete.getId())))

                .then()
                .statusCode(200);

    }

}
*/