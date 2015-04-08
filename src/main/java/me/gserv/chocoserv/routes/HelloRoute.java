package me.gserv.chocoserv.routes;

import me.gserv.chocoserv.storage.StorageManager;
import org.rythmengine.Rythm;
import spark.Request;
import spark.Response;
import spark.Route;

public class HelloRoute implements Route {
    private StorageManager storageManager;

    public HelloRoute() {
        this.storageManager = StorageManager.getInstance();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return Rythm.render(
                "hello.html",
                "world",
                this.storageManager.incrementHits("hello")
        );
    }
}
