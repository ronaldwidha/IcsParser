package me.widha.automation.icsParser;

/**
 * Created by rsunarno on 11/21/15.
 */
public class SimpleBufferResponder implements NonBlockingParseBufferResponder {

    /**
     * preparation work
     */
    public void prepare() {

        //String outputCSV = "/home/exec/Downloads/tasks/output.csv";
        //FileWriter fw = new FileWriter(outputCSV);
        //BufferedWriter bw = new BufferedWriter(fw);
        //bw.write("ID;task;ListID;Status;LastUpdate;CreationDate;DueDate;Duration;Priority;Note");
        //bw.newLine();

    }

    public void fireAsync(ParseBuffer buffer) {
        if (!buffer.isReadyToFlush()) return;

        // make sure do something quick or asynchronous here
        // don't block the loop!

        System.out.println(buffer.getVEvent().getUID() + " " + buffer.getVEvent().getTitle());

        //bw.write(String.valueOf(ID)+";"+"\""+line+"\""+";1"+";1"+";"+System.currentTimeMillis()+";"+System.currentTimeMillis()+";0"+";0"+";3");
        //bw.newLine();

    }


    public void cleanup() {
        //bw.close();
        //fw.close();

    }
}
