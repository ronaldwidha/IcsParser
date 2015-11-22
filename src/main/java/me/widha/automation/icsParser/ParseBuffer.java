package me.widha.automation.icsParser;

/**
 * Created by rsunarno on 11/21/15.
 */
public class ParseBuffer {

    public ParseBuffer() {
        this.VEvent = new VEvent();
        this.isReadyToFlush = false;
    }

    public VEvent getVEvent() {

        return VEvent;
    }

    public void setVEvent(VEvent VEvent) {

        this.VEvent = VEvent;
    }

    private VEvent VEvent;
    private boolean isReadyToFlush;

    public ParseBuffer(VEvent VEvent) {

        this.VEvent = VEvent;
        this.isReadyToFlush = false;
    }

    public boolean isReadyToFlush() {

        return isReadyToFlush;
    }

    public void setReadyToFlush(boolean readyToFlush) {

        isReadyToFlush = readyToFlush;
    }
}
