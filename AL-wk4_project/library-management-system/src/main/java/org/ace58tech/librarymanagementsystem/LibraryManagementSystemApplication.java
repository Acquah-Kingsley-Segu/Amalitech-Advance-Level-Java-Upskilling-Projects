package org.ace58tech.librarymanagementsystem;

import org.ace58tech.database.services.BookQueries;
import org.ace58tech.database.services.TableCreation;
import org.ace58tech.database.services.PostgresqlConnect;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Connection;

@SpringBootApplication
public class LibraryManagementSystemApplication {


    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }

    @Bean
    CommandLineRunner init() {
        return args -> {
            PostgresqlConnect postgresqlConnect = new PostgresqlConnect();
            BookQueries bookQueries = new BookQueries();

            Connection connection = postgresqlConnect.connectToDB("localhost", 5432, "library-management-system", "acquah", "acquah_user");

            TableCreation.createLibraryManagementBookTable(connection);
            TableCreation.createLibraryManagementUserTable(connection);
            TableCreation.createTransactionTable(connection);
            TableCreation.createBorrowedTable(connection);

//            String[] createColumns = new String[]{"name", "author", "isbn", "release_date", "availability", "copies", "price", "fee", "cost", "rating"};
//            Object[] bookData = new Object[]{"The Quantum Paradox", "Arthur W. Clarke", "978-0-1234567-1", "2023-05-21", true, 15, 29.99, 2.0, 18.0, 4.6};
//            bookQueries.insertDataIntoTable(connection, bookData);
//            bookQueries.getTableData(connection);
//            bookQueries.getTableDataById(connection, 1);
//            bookQueries.getDataByASingleColumn(connection, "availability", true);
//            bookQueries.deleteDataFromTable(connection, 5);
//            bookQueries.getDataByASingleColumn(connection, "availability", true);
//            bookQueries.updateDataIntoTable(connection, columns, bookData, );

            String[] updateColumns = new String[]{"name", "author", "isbn", "release_date", "availability"};
            Object[] updateValues = new Object[]{"Galactic Voyage", "Emma R. Thompson", "978-1-2345678-2", "2021-11-09", false};
            bookQueries.updateDataIntoTable(connection, updateColumns, updateValues, 6);
        };
    }
}
