package org.ramonboza.pocs.serversentevents;

import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.SseFeature;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

/**
 * Created by ramon.boza on 3/12/15.
 */

@Path("stats")
public class StatsResource {

    private StatService statService = new StatService();

    private EventOutput eventOutput = new EventOutput();

    @GET
    @Produces(SseFeature.SERVER_SENT_EVENTS)
    public EventOutput getMessageQueue() {
        System.out.println("Getting message Output");
        statService.bindEvent(eventOutput);
        return eventOutput;
    }

    @DELETE
    public void close() throws IOException {
        eventOutput.close();
        eventOutput = new EventOutput();
    }
}
