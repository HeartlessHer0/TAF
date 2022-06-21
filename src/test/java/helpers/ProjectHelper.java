package helpers;

import configuration.Endpoints;
import models.Project;
import org.apache.http.HttpStatus;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class ProjectHelper {

    public Project addProject(Map<String, Object> request) {
        return given()
                .body(request)
                .post(Endpoints.ADD_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .extract().as(Project.class);
    }

    public void deleteProject(int projectId) {
        given()
                .pathParam("project_id", projectId)
                .post(Endpoints.DELETE_PROJECT)
                .then()
                .statusCode(HttpStatus.SC_OK);
    }
}
