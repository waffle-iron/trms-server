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

    public Connection getConnection() throws SQLException {
        if (Config.ENVIRONMENT.equals("Testing")) {
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

    public boolean createTables() {
        return doQueries(createFilename);
    }

    public boolean dropTables() {
        return doQueries(dropFilename);
    }

    private boolean doQueries(String filename) {
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

        try (Connection c = getConnection()) {
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
