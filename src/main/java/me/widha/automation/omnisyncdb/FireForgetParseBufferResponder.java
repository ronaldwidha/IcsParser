package me.widha.automation.omnisyncdb;

/**
 * Created by rsunarno on 11/21/15.
 */
public interface FireForgetParseBufferResponder {

    public void prepare();

    public void fireAsync(ParseBuffer buffer);

    public void cleanup();
}
