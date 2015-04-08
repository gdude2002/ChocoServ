package me.gserv.chocoserv;

import java.io.InputStream;
import java.util.Scanner;

public class Utils {
    public static String getTemplate(String path) {
        path = String.format("/templates/%s", path);
        InputStream stream = Main.class.getResourceAsStream(path);

        if (stream == null) {
            return String.format("<h1>Unknown template: %s</h1>", path);
        }

        Scanner scanner = new Scanner(stream).useDelimiter("\\A");
        return scanner.next();
    }
}
