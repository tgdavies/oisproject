package org.kablambda.ois.proxy;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class OisClient {
    private final OisEventListener oisEventListener;
    private InputStream in;
    private OutputStream out;
    private Thread reader = new Thread(new Runnable() {
        @Override
        public void run() {
            char[] chars = new char[1024];
            int i = 0;
            for (;;) {
                try {
                    int ch = in.read();
                    if (ch == -1) {
                        return;
                    }
                    if (ch == '\n') {
                        String message = new String(chars, 0, i);
                        if (message.equals("452")) {
                            oisEventListener.onHandshakeComplete(OisClient.this);
                        } else {
                            oisEventListener.onEvent(OisClient.this, message);
                        }
                        i = 0;
                    } else {
                        chars[i++] = (char)ch;
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });

    public OisClient(String devicePath, OisEventListener oisEventListener) {
        this.oisEventListener = oisEventListener;
        try {
            in = new FileInputStream(devicePath);
            out = new FileOutputStream(devicePath);
            reader.start();
            send("451");
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

    public interface OisEventListener {
        void onHandshakeComplete(OisClient client);
        void onEvent(OisClient client, String event);
    }
}
