package com.flipkart.app;

import com.flipkart.restcontroller.CustomerController;
import com.flipkart.restcontroller.HelloController;
import com.flipkart.restcontroller.GymOwnerController;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class App extends Application<Configuration> {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    @Override
    public void initialize(Bootstrap<Configuration> b) {
    }

    @Override
    public void run(Configuration c, Environment e) {
        LOGGER.info("Registering REST resources");

        System.out.println("HERE");
        e.jersey().register(new HelloController());
        e.jersey().register(new GymOwnerController());
        e.jersey().register(new CustomerController());
    }

    public static void main(String[] args) throws Exception {
        new App().run(args);
    }
}