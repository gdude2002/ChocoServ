package me.gserv.chocoserv;

import com.beust.jcommander.JCommander;
import me.gserv.chocoserv.routes.*;
import me.gserv.chocoserv.storage.StorageManager;
import org.rythmengine.Rythm;
import spark.Spark;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String ... args) {
        Args commandLineArgs = new Args();
        new JCommander(commandLineArgs, args);

        StorageManager storageManager = StorageManager.getInstance();
        storageManager.setUp(
                commandLineArgs.hibernateDialect,
                commandLineArgs.driverClass,
                commandLineArgs.url,
                commandLineArgs.username,
                commandLineArgs.password
        );

        Map<String, Object> rythmSettings = new HashMap<>();

        rythmSettings.put("home.template", "templates/");

        Rythm.init(rythmSettings);

        // Set location of static files
        Spark.staticFileLocation("/static");

        // Simple "Hello World" route
        Spark.get("/", new IndexRoute());
        Spark.get("/addresses", new AddressesRoute());
        Spark.get("/comments", new CommentsRoute());
        Spark.get("/store", new StoreRoute());
        Spark.get("/hello", new HelloRoute());
    }
}
