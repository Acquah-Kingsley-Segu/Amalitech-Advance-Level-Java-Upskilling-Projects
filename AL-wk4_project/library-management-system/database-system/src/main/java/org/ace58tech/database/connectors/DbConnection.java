package org.ace58tech.database.connectors;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbConnection {
    Connection connectToDB(String hostName, int portNumber, String database, String username, String password) throws SQLException;
    void closeConnection(Connection connection) throws SQLException;
}
