package me.widha.automation.omnisyncdb;

/**
 * Created by rsunarno on 11/21/15.
 */
public class ParseBuffer {

    public ParseBuffer() {
        this.ofItem = new OFItem();
        this.isReadyToFlush = false;
    }

    public OFItem getOfItem() {

        return ofItem;
    }

    public void setOfItem(OFItem ofItem) {

        this.ofItem = ofItem;
    }

    private OFItem ofItem;
    private boolean isReadyToFlush;

    public ParseBuffer(OFItem ofItem) {

        this.ofItem = ofItem;
        this.isReadyToFlush = false;
    }

    public boolean isReadyToFlush() {

        return isReadyToFlush;
    }

    public void setReadyToFlush(boolean readyToFlush) {

        isReadyToFlush = readyToFlush;
    }
}
