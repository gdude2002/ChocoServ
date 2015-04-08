package me.gserv.chocoserv.routes;

import me.gserv.chocoserv.storage.StorageManager;
import org.rythmengine.Rythm;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.Map;

public class CommentsPostRoute implements Route {
    private StorageManager storageManager;

    public CommentsPostRoute() {
        this.storageManager = StorageManager.getInstance();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Map<String, String[]> params = request.queryMap().toMap();

        if (! params.containsKey("name")) {
            return Rythm.render(
                    "comments.html",
                    this.storageManager.incrementHits("comments"),
                    this.storageManager.getComments(),
                    true
            );
        } else if (! params.containsKey("comment")) {
            return Rythm.render(
                    "comments.html",
                    this.storageManager.incrementHits("comments"),
                    this.storageManager.getComments(),
                    true
            );
        } else if (params.get("name")[0].length() < 1) {
            return Rythm.render(
                    "comments.html",
                    this.storageManager.incrementHits("comments"),
                    this.storageManager.getComments(),
                    true
            );
        } else if (params.get("comment")[0].length() < 1) {
            return Rythm.render(
                    "comments.html",
                    this.storageManager.incrementHits("comments"),
                    this.storageManager.getComments(),
                    true
            );
        }

        this.storageManager.addComment(
                params.get("name")[0],
                params.get("comment")[0]
        );

        return Rythm.render(
                "comments.html",
                this.storageManager.incrementHits("comments"),
                this.storageManager.getComments(),
                false
        );
    }
}
