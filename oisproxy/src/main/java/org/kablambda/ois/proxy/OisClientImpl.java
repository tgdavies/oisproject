package org.kablambda.ois.proxy;

import com.google.common.annotations.VisibleForTesting;

import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class OisClientImpl implements OisClient {
    private final OutputStream out;
    private final BlockingQueue<String> events = new LinkedBlockingQueue<>();
    private final Thread thread;
    private volatile boolean stopping = false;

    public OisClientImpl(String devicePath) throws FileNotFoundException {
        this(new FileInputStream(devicePath), new FileOutputStream(devicePath));
    }

    @VisibleForTesting
    OisClientImpl(InputStream in, OutputStream out) {

        this.out = out;
        thread = new Thread(() -> {
            char[] chars = new char[1024];
            int i = 0;
            for (; ; ) {
                if (stopping) {
                    return;
                }
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
        thread.start();
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
    public String getEvent() {
        for (; ; ) {
            if (stopping) {
                return null;
            }
            try {
                String s = events.poll(1, TimeUnit.SECONDS);
                if (s != null) {
                    return s;
                }
            } catch (InterruptedException e) {
                // ignore
            }
        }
    }

    @Override
    public void stop() {
        stopping = true;
        thread.interrupt();
    }
}
