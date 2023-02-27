package Task2;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzbuzzTest {
    private final int n = 15;
    public static volatile AtomicInteger number = new AtomicInteger(1);

    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(4);
        FizzbuzzTest fizzbuzz = new FizzbuzzTest();
        executorService.submit(fizzbuzz::fizz);
        executorService.submit(fizzbuzz::buzz);
        executorService.submit(fizzbuzz::fizzbuzz);
        executorService.submit(fizzbuzz::getNumber);


    }

    public synchronized void fizz() {
        while (number.get() <= n) {
            if (number.get() % 3 == 0 && number.get() % 5 != 0) {
                System.out.println("fizz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void buzz() {
        while (number.get() <= n) {
            if (number.get() % 3 != 0 && number.get() % 5 == 0) {
                System.out.println("buzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }

    public synchronized void fizzbuzz() {
        while (number.get() <= n) {
            if (number.get() % 3 == 0 && number.get() % 5 == 0) {
                System.out.println("fizzbuzz");
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public synchronized void getNumber() {
        while (number.get() <= n) {
            if (number.get() % 3 != 0 && number.get() % 5 != 0) {
                System.out.println(number);
                number.incrementAndGet();
                notifyAll();
            } else {
                try {
                    wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}

