package org.kablambda.ois.proxy;

/**
 * Communicates with OiS at the lowest level of lines of text sent and received
 */
public interface OisClient {
    /**
     * Send text, this method adds line termination.
     *
     * @param text a string to be sent as a single line
     */
    void send(String text);

    /**
     * Get the next line written by OiS, stripped of terminating characters.
     * This method blocks indefinitely.
     *
     * @return a string sent by OiS, or null if the LOisClient has been stopped.
     */
    String getEvent() throws InterruptedException;

    /**
     * Stop the client. This method waits until the client has stopped
     */
    void stop();
}
