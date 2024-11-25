package org.example;

public class Main {
    public static void main(String[] args) {
        BlockingQueue queue = new BlockingQueue();
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();
    }
}