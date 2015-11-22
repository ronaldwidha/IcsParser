package me.widha.automation.icsParser;

import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * parser for a single omnysync ics file
 * Created by rsunarno on 11/21/15.
 */
public class OmniSyncIcsParser {

    private static final int MAX_CAP = 999999;
    private final NonBlockingParseBufferResponder responder;

    public OmniSyncIcsParser() {

        this.responder = new SimpleBufferResponder();
    }

    public OmniSyncIcsParser(NonBlockingParseBufferResponder responder) {

        this.responder = responder;
    }

    public void go(String importTargetFilename) throws IOException {

        FileReader fr = new FileReader(importTargetFilename);
        BufferedReader br = new BufferedReader(fr);

        responder.prepare();

        int ID = 1;

        String line = null;
        ParseBuffer buffer = null;

        while ((line = br.readLine()) != null && ID < MAX_CAP) {

            if (line.startsWith("BEGIN:VEVENT")) {
                // START
                buffer = new ParseBuffer();


            } else if (line.startsWith("END:VEVENT")) {
                //END
                buffer.setReadyToFlush(true);

                // do something. fire and forget
                responder.fireAsync(buffer);

                buffer = null; //flush buffer

            } else {
                buffer = parseRow(line, buffer);
            }

            ID++;
        }

        br.close();
        fr.close();

        responder.cleanup();
    }

    private ParseBuffer parseRow(String line, ParseBuffer buffer) {

        DateTimeFormatter fmt = ISODateTimeFormat.basicDateTimeNoMillis();

        if (line.startsWith("DTSTART:")) {
            buffer.getVEvent().setStart(fmt.parseDateTime(line.substring(8)));
        } else if (line.startsWith("DTEND:")) {
            buffer.getVEvent().setEnd(fmt.parseDateTime(line.substring(6)));
        } else if (line.startsWith("DTSTAMP:")) {
            buffer.getVEvent().setTimestamp(fmt.parseDateTime(line.substring(8)));
        } else if (line.startsWith("SUMMARY:Due: ")) {
            buffer.getVEvent().setTitle(line.substring(13));
        } else if (line.startsWith("DESCRIPTION:omnifocus://")) {
            buffer.getVEvent().setAppUri(line.substring(12));
        } else if (line.startsWith("DESCRIPTION:")) {
            //ignored
        } else if (line.startsWith("UID:")) {
            buffer.getVEvent().setUID(line.substring(4));
        } else {
            // ignored
        }

        return buffer;
    }
}
