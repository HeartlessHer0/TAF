package dbEntities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.DataBaseService;

import java.sql.ResultSet;

public class MilestoneTable {

        Logger logger = LoggerFactory.getLogger(DataBaseService.class);

        DataBaseService dataBaseService;

        public MilestoneTable(DataBaseService dataBaseService) {
            this.dataBaseService = dataBaseService;
        }

        public void dropTable() {
            logger.info("Удаляем Milestone таблицу");
            String dropMilestoneTableSQL = "DROP TABLE MilestoneTable;";

            dataBaseService.executeSQL(dropMilestoneTableSQL);
        }

        public void createMilestoneTable() {
            logger.info("Создаем Milestone таблицу");

            String createTableSQL = "CREATE TABLE MilestoneTable (" +
                    "ID SERIAL PRIMARY KEY, " +
                    "PROJECT_ID CHARACTER VARYING(10), " +
                    "NAME CHARACTER VARYING(30), " +
                    "DESCRIPTION CHARACTER VARYING(30) " +
                    ");";

            dataBaseService.executeSQL(createTableSQL);
        }


        public void addMilestone(int projectId, String name, String description) {
            logger.info("Добавляем запись в таблицу");

            String insertTableSQL = "INSERT INTO public.MilestoneTable(" +
                    "PROJECT_ID, NAME, DESCRIPTION)" +
                    "VALUES ('" + projectId + "','" + name + "', '" + description + "');";

            dataBaseService.executeSQL(insertTableSQL);
        }

        public ResultSet getMilestones() {
            String selectSQL = "SELECT * FROM public.MilestoneTable ORDER BY id ASC;";

            return dataBaseService.executeQuery(selectSQL);
        }

        public ResultSet getMilestoneById(int id) {
            String selectSQL = "SELECT * FROM public.MilestoneTable  WHERE ID="+ id +" ORDER BY id ASC;";

            return dataBaseService.executeQuery(selectSQL);
        }
    }
