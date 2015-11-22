package me.widha.automation.icsParser;


import org.joda.time.DateTime;

/**
 * Created by rsunarno on 11/21/15.
 */
public class VEvent {

    private DateTime start;
    private String title;
    private DateTime timestamp;
    private DateTime end;
    private String UID;
    private String appUri;

    public DateTime getStart() {

        return start;
    }

    public void setStart(DateTime start) {

        this.start = start;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public DateTime getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(DateTime timestamp) {

        this.timestamp = timestamp;
    }

    public DateTime getEnd() {

        return end;
    }

    public void setEnd(DateTime end) {

        this.end = end;
    }

    public String getUID() {

        return UID;
    }

    public void setUID(String UID) {

        this.UID = UID;
    }

    public String getAppUri() {

        return appUri;
    }

    public void setAppUri(String appUri) {

        this.appUri = appUri;
    }
}
