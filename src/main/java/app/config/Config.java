package app.config;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {

    private Dotenv dotEnv;

    private String db;
    private String username;
    private String password;
    private String testDb;
    private String testdbusername;
    private String testdbpassword;

    public Config() {
        dotEnv = Dotenv
                .configure()
                .directory("./")
                .ignoreIfMalformed()
                .ignoreIfMissing()
                .load();
    }

    public static Config env() {
        return new Config();
    }

    public String getDb() {
        return dotEnv.get("DBURL");
    }

    public String getUsername() {
        return dotEnv.get("DBUSERNAME");
    }

    public String getPassword() {
        return dotEnv.get("DBPASSWORD");
    }

    public String getTestDb() {
        return dotEnv.get("TESTDBURL");
    }

    public String getTestdbusername() {
        return dotEnv.get("TESTDBUSERNAME");
    }

    public String getTestdbpassword() {
        return dotEnv.get("TESTDBPASSWORD");
    }
}
