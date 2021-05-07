package java_assignment2.asgn7;

import java.util.*;

class Store {
    private int item;
    private boolean empty = true;
    public Store() {    // default constructor
        item = 0;
    }
    public Store(int i) {   // parameterized constructor
        item = i;
    }
    synchronized int get() throws InterruptedException {    // synchronized getter function
        while(empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        empty = true;
        notifyAll();
        Thread.sleep(1000);
        return item;
    } 
    synchronized void set(int k) throws InterruptedException {  // synchronized setter function
        while(!empty) {
            try {
                wait();
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
        item = k;
        empty = false;
        notifyAll();
        Thread.sleep(1000);
    }
}

class Producer implements Runnable {
    Store s;
    public Producer() { // default constructor
        s = null;
    }
    public Producer(Store st) { // copy constructor
        s = st;
    }
    @Override
    public void run() { // overriding the run function
        int i = 1;
        while (true) {
            try {
                s.set(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Producer produced - " + i);
            ++i;
        }
    }
}

class Consumer implements Runnable {
    Store s;
    public Consumer() { // default constructor
        s = null;
    }
    public Consumer(Store st) { // copy constructor
        s = st;
    }
    @Override
    public void run() { // overriding the run function
        while (true) {
            try {
                System.out.println("Consumer consumed - " + s.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ProducerConsumer {
    public static void main(String args[]) throws Exception {
        Store s = new Store();
        Producer p = new Producer(s);
        Consumer c = new Consumer(s);
        Thread pt = new Thread(p);
        Thread ct = new Thread(c);

        pt.start();
        ct.start();

        try {
            if (pt.isAlive())
                pt.join();
            if (ct.isAlive())
                pt.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }   
}
