package org.ramonboza.pocs.serversentevents;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.glassfish.jersey.media.sse.EventOutput;
import org.glassfish.jersey.media.sse.OutboundEvent;
import org.ramonboza.pocs.serversentevents.model.Stats;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Random;

/**
 * Created by ramon.boza on 3/12/15.
 */
public class StatService {
    private String stockInfo = "";
    private EventOutput eventOutput;
    private long startedServerMillis=0;

    public StatService() {
        startedServerMillis = System.currentTimeMillis();
        new Thread() {
            public void run() {
                while (true) {
                    if (eventOutput != null) {
                        try {
                            eventOutput.write(new OutboundEvent.Builder().name("message").data(String.class, getStockInfo()).build());
                            Thread.sleep(new Random().nextInt(5) * 1000);
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }.start();
    }

    public String getStockInfo() {
        Stats stats = new Stats();
        try {
            stats.setHostname(
                    InetAddress.getLocalHost().getHostName());
            stats.setUptime(Long.toBinaryString(getServerUptime()));

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        ObjectMapper mapper = new ObjectMapper();
        String result = null;
        try {
            result = mapper.writeValueAsString(stats);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return result;
    }

    private long getServerUptime() {
        long currentServerUptimeMillis = System.currentTimeMillis() - startedServerMillis;
        return currentServerUptimeMillis / 1000;
    }

    public void bindEvent(EventOutput eventOutput) {
        this.eventOutput = eventOutput;
    }
}
