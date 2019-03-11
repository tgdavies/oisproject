package org.kablambda.ois.proxy;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class OisClientImpl implements OisClient {
    private final InputStream in;
    private final OutputStream out;
    private final BlockingQueue<String> events = new LinkedBlockingQueue<>();

    public OisClientImpl(String devicePath) {
        try {
            in = new FileInputStream(devicePath);
            out = new FileOutputStream(devicePath);
            Thread reader = new Thread(() -> {
                char[] chars = new char[1024];
                int i = 0;
                for (; ; ) {
                    try {
                        int ch = in.read();
                        if (ch == -1) {
                            return;
                        }
                        if (ch == '\n') {
                            String message = new String(chars, 0, i);
                            events.put(message);
                            i = 0;
                        } else {
                            chars[i++] = (char) ch;
                        }
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            reader.start();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public void send(String line) {
        try {
            out.write(line.getBytes());
            out.write('\n');
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getEvent() throws InterruptedException {
        return events.take();
    }
}
