package src.main;

import java.util.concurrent.locks.ReentrantLock;

public class Demo18 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();

        try{
            reentrantLock.lock();
        }finally {
            reentrantLock.unlock();
        }
    }
}
