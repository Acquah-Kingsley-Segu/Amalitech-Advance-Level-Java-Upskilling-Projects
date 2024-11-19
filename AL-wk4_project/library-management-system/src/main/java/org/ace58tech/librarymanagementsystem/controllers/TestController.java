package org.ace58tech.librarymanagementsystem.controllers;

import org.ace58tech.database.services.PostgresqlConnect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class TestController {
    @GetMapping("/db-connection")
    public void dbConnection() throws SQLException {
        PostgresqlConnect connect = new PostgresqlConnect();
        connect.connectToDB("localhost", 5432, "library-management-system", "acquah", "acquah_user");
    }
}
