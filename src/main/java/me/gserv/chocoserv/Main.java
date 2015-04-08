package me.gserv.chocoserv;

import spark.Spark;

import me.gserv.chocoserv.routes.HelloRoute;

public class Main {
    public static void main(String ... args) {
        // Set location of static files
        Spark.staticFileLocation("/static");

        // Simple "Hello World" route
        Spark.get("/hello", new HelloRoute());
    }
}
