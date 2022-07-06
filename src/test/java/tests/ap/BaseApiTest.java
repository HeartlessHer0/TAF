package tests.ap;

import configuration.ReadProperties;
import dbEntities.MilestoneTable;
import helpers.ProjectHelper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import models.Project;
import models.ProjectType;
import org.apache.http.protocol.HTTP;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import services.DataBaseService;
import tests.db.BaseDBTest;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApiTest {

    Logger logger = LoggerFactory.getLogger(BaseDBTest.class);

    MilestoneTable milestoneTable;

    public DataBaseService dataBaseService;

    @BeforeTest
    public void setupEnv() {
//        RestAssured.baseURI = ReadProperties.getUrl();
//
//        RestAssured.requestSpecification = given()
//                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
//                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
    }

    @AfterTest
    public void closeConnection() {
        dataBaseService.closeConnection();
    }

    //todo remove it
    public static final int BASE_TEST_PROJECT_ID = 76;

    public Project baseProject;
    public ProjectHelper projectHelper = new ProjectHelper();

    @BeforeClass
    public void setupBaseTestProject() {
        //todo test with it in final
        RestAssured.baseURI = ReadProperties.getUrl();

        RestAssured.requestSpecification = given()
                .header(HTTP.CONTENT_TYPE, ContentType.JSON)
                .auth().preemptive().basic(ReadProperties.username(), ReadProperties.password());
        logger.info("Подключение REST Assured");

        Map<String, Object> jsonAsMap = new HashMap<>();
        jsonAsMap.put("name", "Sergey_Z");
        jsonAsMap.put("announcement", "API and DB Test");
        jsonAsMap.put("show_announcement", true);
        jsonAsMap.put("suite_mode", ProjectType.SINGLE_SUITE_MODE);
        logger.info("Создание проекта");

        baseProject = projectHelper.addProject(jsonAsMap);

        dataBaseService = new DataBaseService();


        milestoneTable = new MilestoneTable(dataBaseService);
        milestoneTable.dropTable();
        milestoneTable.createMilestoneTable();
        logger.info("Создание таблицы Milestone");

        milestoneTable.addMilestone(baseProject.projectId,"Test MST One", "Some Test Description 1");
        milestoneTable.addMilestone(baseProject.projectId, "Test MST Two", "Some Test Description 2");
        milestoneTable.addMilestone(baseProject.projectId, "Test MST Three", "Some Test Description 3");
        logger.info("Заполнение таблицы Milestone строками");
    }

    @AfterClass
    public void deleteBaseTestProject() {
        //todo test with it in final
       projectHelper.deleteProject(baseProject.getProjectId());
       logger.info("Удаление созданного проекта");
    }

    @AfterTest
    public void teardownEnv() {
        RestAssured.reset();
        dataBaseService.closeConnection();
    }
}

