package com.example;

import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws java.sql.SQLException {
        Calculator calc = new Calculator();
        LOGGER.info(() -> String.valueOf(calc.calculate(10, 5, "add")));

        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin");
    }
}