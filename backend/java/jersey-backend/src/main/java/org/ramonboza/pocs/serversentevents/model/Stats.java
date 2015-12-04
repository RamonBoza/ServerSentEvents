package org.ramonboza.pocs.serversentevents.model;

/**
 * Created by ramon.boza on 3/12/15.
 */
public class Stats {

    private String hostname;
    private String type;
    private String platform;
    private String arch;
    private String release;
    private String uptime;
    private String loadaverage;
    private String totalmem;
    private String freemem;


    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getArch() {
        return arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }

    public String getRelease() {
        return release;
    }

    public void setRelease(String release) {
        this.release = release;
    }

    public String getUptime() {
        return uptime;
    }

    public void setUptime(String uptime) {
        this.uptime = uptime;
    }

    public String getLoadaverage() {
        return loadaverage;
    }

    public void setLoadaverage(String loadaverage) {
        this.loadaverage = loadaverage;
    }

    public String getTotalmem() {
        return totalmem;
    }

    public void setTotalmem(String totalmem) {
        this.totalmem = totalmem;
    }

    public String getFreemem() {
        return freemem;
    }

    public void setFreemem(String freemem) {
        this.freemem = freemem;
    }
}
