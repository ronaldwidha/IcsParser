package me.widha.automation.icsParser;

/**
 * Created by rsunarno on 11/21/15.
 */
public class OmniSyncIcsParserTest {

    private OmniSyncIcsParser SUT;

    @org.junit.Before
    public void setUp() throws Exception {
        SUT = new OmniSyncIcsParser();
    }

    @org.junit.After
    public void tearDown() throws Exception {

    }

    @org.junit.Test
    public void testGo() throws Exception {
        SUT.go("/User/x/Desktop/test.ics");
    }
}