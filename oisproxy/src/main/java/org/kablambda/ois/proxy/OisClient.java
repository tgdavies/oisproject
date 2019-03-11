package org.kablambda.ois.proxy;

public interface OisClient {
    void send(String text);
    String getEvent() throws InterruptedException;
}
