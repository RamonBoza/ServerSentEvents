package org.ramonboza.pocs.serversentevents;


import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.media.sse.SseFeature;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final URI BASE_URI = URI.create("http://localhost:12000/");
    public static final String ROOT_PATH = "stats";


    public static void main(String[] args) {
        try {
            System.out.println("\"Server-Sent Events\" Jersey Example App");

            final ResourceConfig resourceConfig = new ResourceConfig(StatsResource.class, SseFeature.class);

            final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI, resourceConfig);

            System.out.println(String.format("Application started.\nTry out %s%s\nHit enter to stop it...",
                    BASE_URI, ROOT_PATH));
            System.in.read();
            server.shutdownNow();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
