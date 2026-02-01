package com.example;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {

    private static final Logger LOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) throws Exception {

        Calculator calc = new Calculator();
        if (LOGGER.isLoggable(Level.INFO)) {
            LOGGER.log(Level.INFO, "Result: {0}", calc.add(10, 5));
        }

        UserService service = new UserService();
        service.findUser("admin");
        service.deleteUser("admin");
    }
}