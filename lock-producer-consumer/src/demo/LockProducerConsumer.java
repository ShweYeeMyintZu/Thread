package demo;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockProducerConsumer {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private static final int LIMIT = 1;

    private ArrayList<Integer> list = new ArrayList<>();

    public void producer() {
        int value = 0;
        try {
            lock.lock();
            for (int i = 0; i <= 10; i++) {
                while (this.list.size() == LIMIT) {
                    condition.await();
                }
                this.list.add(value);
                System.out.println(String.format("Producer put %d", value));
                value++;
                condition.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consumer() {

        try {
            lock.lock();
            for (int i = 0; i <= 10; i++) {
                while (this.list.size() == 0) {
                    condition.await();
                }
                int value=this.list.remove(0);
                System.out.println(String.format("Consumer consume %d", value));

                condition.signal();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockProducerConsumer lockProducerConsumer=new LockProducerConsumer();
        new Thread(lockProducerConsumer::producer).start();
        new Thread(lockProducerConsumer::consumer).start();
    }
}
