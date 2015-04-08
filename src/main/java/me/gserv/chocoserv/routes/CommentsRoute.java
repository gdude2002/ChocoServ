package me.gserv.chocoserv.routes;

import org.rythmengine.Rythm;
import spark.Request;
import spark.Response;
import spark.Route;

public class CommentsRoute implements Route {
    @Override
    public Object handle(Request request, Response response) throws Exception {
        return Rythm.render(
                "comments.html"
        );
    }
}
