package com.mjc.stage2.impl;

import com.mjc.stage2.ConnectionFactory;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class H2ConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() {
        Connection connection = null;
        Properties props = new Properties();
        try (InputStream in = Files.newInputStream(Paths.get("h2database.properties"))) {
            props.load(in);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        String driver = props.getProperty("jdbc_driver");
        String url = props.getProperty("db_url");
        String user = props.getProperty("user");
        String password = props.getProperty("password");
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
