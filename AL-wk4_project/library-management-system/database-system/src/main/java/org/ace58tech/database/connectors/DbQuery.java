package org.ace58tech.database.connectors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbQuery {
    void getTableData(Connection connection) throws SQLException;
    void getTableDataById(Connection connection,int id);
    void getDataByASingleColumn(Connection connection, String columnName, Object value);
    void insertDataIntoTable(Connection connection,Object[] data) throws SQLException;
    void updateDataIntoTable(Connection connection, String[] columns,Object[] data, int id) throws SQLException;
    void deleteDataFromTable(Connection connection, int value) throws SQLException;
}
