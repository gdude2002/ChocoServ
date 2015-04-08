package me.gserv.chocoserv;

import static spark.Spark.*;

import me.gserv.chocoserv.routes.HelloRoute;

public class Main {
    public static void main(String ... args) {
        get("/hello", new HelloRoute());
    }
}
