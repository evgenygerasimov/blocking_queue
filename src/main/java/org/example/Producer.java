package org.example;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Producer implements Runnable {

    private BlockingQueue queue;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            queue.enqueue();
        }
    }
}
