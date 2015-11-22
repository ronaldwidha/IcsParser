package me.widha.automation.icsParser;

/**
 * Created by rsunarno on 11/21/15.
 */
public interface NonBlockingParseBufferResponder {

    public void prepare();

    public void fireAsync(ParseBuffer buffer);

    public void cleanup();
}
