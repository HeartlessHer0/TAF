package tests.ap;

import configuration.Endpoints;
import models.Milestone;
import org.apache.http.HttpStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class MilestoneAPITest extends BaseApiTest{

    @Test
    public void addMilestoneWithDBTest() {
        logger.info("Test is started...");

        ResultSet rs = milestoneTable.getMilestones();

        try {
            while (rs.next()) {
                int projectId = rs.getInt("PROJECT_ID");
                String milestoneName = rs.getString("NAME");
                String description = rs.getString("DESCRIPTION");

                logger.info("milestoneId: " + projectId);
                logger.info("milestoneName: " + milestoneName);
                logger.info("description:" + description);


                Map<String, Object> jsonAsMap = new HashMap<>();
                jsonAsMap.put("project_id", projectId);
                jsonAsMap.put("name", milestoneName);
                jsonAsMap.put("description", description);
                logger.info("Создание тела JSON запроса POST Milestone ");

                Milestone milestone = given()
                        .pathParam("project_id", projectId)
                        .body(jsonAsMap)
                        .when()
                        .post(Endpoints.ADD_MILESTONE)
                        .then()
                        .statusCode(HttpStatus.SC_OK)
                        .extract().as(Milestone.class);
                logger.info("Получение ответа по запросу на создание Milestone");

                Assert.assertEquals(milestone.getProjectId(), jsonAsMap.get("project_id"));
                Assert.assertEquals(milestone.getName(), jsonAsMap.get("name"));
                Assert.assertEquals(milestone.getDescription(), jsonAsMap.get("description"));
            }

        } catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        logger.info("Test is completed...");
    }

}
