package org.ace58tech.database.services;

import org.ace58tech.database.connectors.DbConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresqlConnect implements DbConnection {
    @Override
    public Connection connectToDB(String hostName, int portNumber, String database, String username, String password) throws SQLException {
        String postgresqlUrl = "jdbc:postgresql://" + hostName + ":" + portNumber + "/" + database;

        try{
            Connection connection = DriverManager.getConnection(postgresqlUrl, username, password);
            return connection;
        }catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }
}
