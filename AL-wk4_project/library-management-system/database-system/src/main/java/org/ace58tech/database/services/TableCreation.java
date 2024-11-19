package org.ace58tech.database.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class TableCreation {
    private static final Logger log = LoggerFactory.getLogger(TableCreation.class);

    public static void createLibraryManagementBookTable(Connection connection) throws SQLException {
        try ( Statement statement =  connection.createStatement()) {
            String query = """
                    CREATE TABLE IF NOT EXISTS Book (
                        id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        name VARCHAR(255) NOT NULL,
                        author VARCHAR(255) NOT NULL,
                        isbn VARCHAR(13) NOT NULL,
                        release_date DATE DEFAULT current_date,
                        availability BOOLEAN NOT NULL DEFAULT true,
                        copies INTEGER NOT NULL DEFAULT 1,
                        price FLOAT,
                        fee FLOAT NOT NULL DEFAULT 50.00,
                        cost FLOAT NOT NULL DEFAULT 00.00,
                        rating FLOAT NOT NULL DEFAULT 0.0
                    )
                    """;
            int status = statement.executeUpdate(query);
            if (status == 0) {
                log.info("Library Management Book table created successfully");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void createLibraryManagementUserTable(Connection connection) throws SQLException {
        try ( Statement statement =  connection.createStatement()) {
            String typeCreation = "DO $$ "
                    + "BEGIN "
                    + "    IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = 'roles') THEN "
                    + "        CREATE TYPE roles AS ENUM ('ADMIN', 'USER', 'GUEST'); "
                    + "    END IF; "
                    + "END $$;";
            String query = """
                    CREATE TABLE IF NOT EXISTS users (
                        id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        name VARCHAR(255) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        email VARCHAR(255) NOT NULL,
                        phone_number VARCHAR(15) NOT NULL,
                        role roles NOT NULL DEFAULT 'CUSTOMER'
                    )
                    """;

            statement.addBatch(typeCreation);
            statement.addBatch(query);

            int[] statuses = statement.executeBatch();
            for (int index = 0; index < statuses.length; index++) {
                if (statuses[index] == 0 && index == 0) {
                    log.info("Library Management custom type ROLE created successfully");
                }
                else if (statuses[index] == 1 && index == statuses.length - 1) {
                    log.info("Library Management User table created successfully");
                }
            }
        }
    }

    public static void createTransactionTable(Connection connection) throws SQLException {
        try ( Statement statement =  connection.createStatement()) {
            String paymentStatusEnum = """
                    do $$
                    begin
                        if not exists (select 1 from pg_type t where typname = 'payment_status') THEN
                            create type payment_status as enum ('FAILED', 'PENDING', 'COMPLETED');
                        end if;
                    end $$
                    """;
            String tableQuery = """
                    CREATE TABLE IF NOT EXISTS transactions (
                        id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        amount FLOAT NOT NULL,
                        status payment_status NOT NULL,
                        reason VARCHAR(255) NOT NULL,
                        user_id INT NOT NULL,
                        book_id INT NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (book_id) REFERENCES book(id)
                    )
                    """;
            statement.addBatch(paymentStatusEnum);
            statement.addBatch(tableQuery);
            int[] statuses = statement.executeBatch();
            for (int index = 0; index < statuses.length; index++) {
                if (statuses[index] == 0 && index == 0) {
                    log.info("Payment Status enum created successfully");
                }
                else if (statuses[index] == 1 && index == statuses.length - 1) {
                    log.info("Transaction table created successfully");
                }
            }
        }
    }

    public static void createBorrowedTable(Connection connection) throws SQLException {
        try ( Statement statement =  connection.createStatement()) {
            String createQuery = """
                    CREATE TABLE IF NOT EXISTS borrowed (
                        id INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                        borrowed_date DATE DEFAULT current_date,
                        due_date DATE NOT NULL,
                        returned BOOLEAN NOT NULL DEFAULT false,
                        user_id INT NOT NULL,
                        book_id INT NOT NULL,
                        FOREIGN KEY (user_id) REFERENCES users(id),
                        FOREIGN KEY (book_id) REFERENCES book(id)
                    )
                    """;
            int status = statement.executeUpdate(createQuery);
            if (status == 0) {
                log.info("Borrowed book table created successfully");
            }
        }
    }
}
