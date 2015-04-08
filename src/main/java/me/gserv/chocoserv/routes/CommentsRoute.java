package me.gserv.chocoserv.routes;

import me.gserv.chocoserv.storage.StorageManager;
import org.rythmengine.Rythm;
import spark.Request;
import spark.Response;
import spark.Route;

public class CommentsRoute implements Route {
    private StorageManager storageManager;

    public CommentsRoute() {
        this.storageManager = StorageManager.getInstance();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        return Rythm.render(
                "comments.html",
                this.storageManager.incrementHits("comments"),
                this.storageManager.getComments()
        );
    }
}
