package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static ThreadSafeSingleton thread;

    private ThreadSafeSingleton() {
    }

    public static synchronized ThreadSafeSingleton getInstance() {
        if (thread == null) {
            thread = new ThreadSafeSingleton();
        }
        return thread;
    }
}
