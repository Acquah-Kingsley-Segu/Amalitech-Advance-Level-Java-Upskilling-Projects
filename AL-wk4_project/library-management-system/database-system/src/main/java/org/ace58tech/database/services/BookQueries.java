package org.ace58tech.database.services;

import org.ace58tech.database.connectors.DbQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class BookQueries implements DbQuery {

    private static final Logger log = LoggerFactory.getLogger(BookQueries.class);

    @Override
    public void getTableData(Connection connection) throws SQLException {
        String sql = "SELECT * FROM book";

        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            readQueryResult(resultSet);
        }catch (SQLException exception){
            log.error(exception.getMessage());
        }
    }

    @Override
    public void getTableDataById(Connection connection, int id) {
        String sql = "SELECT id, name, author, isbn, release_date, availability, copies, price, fee, cost, rating FROM book WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            readQueryResult(resultSet);
        }catch (SQLException exception){
            log.error(exception.getMessage());
        }
    }

    private void readQueryResult(ResultSet resultSet) throws SQLException {
        while (resultSet.next()) {
            System.out.printf("Book(id: %d, title: %s, author: %s, isbn: %s," +
                            "release_date: %s, availability: %b, copies: %d, price: %.2f, fee: %.2f," +
                            "cost: %.2f, rating: %.1f)\n", resultSet.getInt("id"), resultSet.getString("name"),
                    resultSet.getString("author"), resultSet.getString("isbn"), resultSet.getDate("release_date").toString(),
                    resultSet.getBoolean("availability"), resultSet.getInt("copies"), resultSet.getDouble("price"),
                    resultSet.getDouble("fee"), resultSet.getDouble("cost"), resultSet.getDouble("rating"));
        }
    }

    @Override
    public void getDataByASingleColumn(Connection connection, String columnName, Object value) {
        String sql = "SELECT id, name, author, isbn, release_date, availability, copies, price, fee, cost, rating FROM book WHERE " + columnName +  " = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setObject(1, value);
            ResultSet resultSet = preparedStatement.executeQuery();
            readQueryResult(resultSet);
        }catch (SQLException exception){
            log.error(exception.getMessage());
        }
    }

    @Override
    public void insertDataIntoTable(Connection connection, Object[] data) throws SQLException {
        String sql = "INSERT INTO book" + " (name, author, isbn, release_date, availability, copies, price, fee, cost, rating) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1, data[0].toString());
            preparedStatement.setString(2, data[1].toString());
            preparedStatement.setString(3, data[2].toString());
            preparedStatement.setDate(4, Date.valueOf(data[3].toString()));
            preparedStatement.setBoolean(5, Boolean.parseBoolean(data[4].toString()));
            preparedStatement.setInt(6, Integer.parseInt(data[5].toString()));
            preparedStatement.setDouble(7, Double.parseDouble(data[6].toString()));
            preparedStatement.setDouble(8, Double.parseDouble(data[7].toString()));
            preparedStatement.setDouble(9, Double.parseDouble(data[8].toString()));
            preparedStatement.setDouble(10, Double.parseDouble(data[9].toString()));

            int status = preparedStatement.executeUpdate();
            if (status > 0){
                log.info("Data inserted into book table successfully");
            }
        }
    }

    @Override
    public void updateDataIntoTable(Connection connection, String[] columns, Object[] data, int id) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE book SET ");
        if (columns.length != data.length) {
            log.error("Number of columns doesn't match the number of values in the table");
            return;
        }
        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i]).append(" = ?");
            if (i != columns.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(" WHERE id = ?;");
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql.toString())){
            for(int i = 0; i < data.length; i++){
                if (columns[i].equals("release_date")) {
                    preparedStatement.setDate(i + 1, Date.valueOf(data[i].toString()));
                    continue;
                }
                preparedStatement.setObject(i + 1, data[i]);
            }
            preparedStatement.setInt(data.length + 1, id);
            int status = preparedStatement.executeUpdate();
            if (status > 0){
                log.info("Data with id = {} in book table has been updated successfully", id);
            }
        }
    }

    @Override
    public void deleteDataFromTable(Connection connection, int value) throws SQLException {
        String sql = "DELETE FROM book WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1, value);
            preparedStatement.executeUpdate();
            if (preparedStatement.getUpdateCount() > 0){
                log.info("Data with id = {} deleted from the book table successfully", value);
            }
        }
    }
}
