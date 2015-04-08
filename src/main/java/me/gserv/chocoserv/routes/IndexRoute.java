package me.gserv.chocoserv.routes;

import me.gserv.chocoserv.storage.StorageManager;
import org.rythmengine.Rythm;
import spark.Request;
import spark.Response;
import spark.Route;

public class IndexRoute implements Route {
    private StorageManager storageManager;

    public IndexRoute() {
        this.storageManager = StorageManager.getInstance();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return Rythm.render(
                "index.html",
                this.storageManager.incrementHits("home")
        );
    }
}
