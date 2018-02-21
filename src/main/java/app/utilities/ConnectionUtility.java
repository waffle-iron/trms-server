package app.utilities;

import app.config.Config;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionUtility {

    private String createFilename = "src/main/resources/create.sql";
    private String dropFilename = "src/main/resources/drop.sql";

    private static ConnectionUtility ourInstance = new ConnectionUtility();

    public static ConnectionUtility getInstance() {
        return ourInstance;
    }

    private ConnectionUtility() {
    }

    public Connection getConnection(boolean testing) throws SQLException {
        if (!testing) {
            return DriverManager.getConnection(
                    Config.env().getDb(),
                    Config.env().getUsername(),
                    Config.env().getPassword()
            );
        }

        return DriverManager.getConnection(
                Config.env().getTestDb(),
                Config.env().getTestdbusername(),
                Config.env().getTestdbpassword()
        );
    }

    public boolean createTables(boolean testing) {
        return doQueries(createFilename, testing);
    }

    public boolean dropTables(boolean testing) {
        return doQueries(dropFilename, testing);
    }

    private boolean doQueries(String filename, boolean testing) {
        List<String> queries = new ArrayList<>();
        String line = null;

        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                queries.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

        try (Connection c = getConnection(testing)) {
            for (String query : queries) {
                PreparedStatement ps = c.prepareStatement(query);
                ps.execute();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }
}
