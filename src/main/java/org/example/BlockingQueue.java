package org.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class BlockingQueue {

    private final Deque<Integer> queue = new ArrayDeque<Integer>(10);
    int element = 1;

    public synchronized void enqueue() {
        while (queue.size() == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.addLast(element);
        System.out.println("Enqueued: " + element);
        System.out.println("Elements in queue: " + queue.size());
        notify();
    }

    public synchronized void dequeue() {
        while (queue.isEmpty()){
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.removeLast();
        System.out.println("Dequeued: " + element);
        System.out.println("Elements in queue: " + queue.size());
        notify();
    }
}
