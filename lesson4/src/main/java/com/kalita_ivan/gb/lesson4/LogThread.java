package com.kalita_ivan.gb.lesson4;

import java.io.Writer;

class LogThread extends Thread {

    private final String data;
    private final Writer writer;

    LogThread(String data, Writer writer) {
        super();
        this.data = data;
        this.writer = writer;
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 10; i++) {
            try {
                writer.write(String.format("LogThread: %s\n", data));
                Thread.sleep(20);
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
}
