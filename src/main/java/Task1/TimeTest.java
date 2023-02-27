package Task1;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TimeTest  {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(1);
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(2);
        executorService.scheduleAtFixedRate(
                () -> System.out.println(count.getAndIncrement()),
                0,
                1,
                TimeUnit.SECONDS
        );
        executorService.scheduleAtFixedRate(
                () -> System.out.println("Passed 5 seconds"),
                4,
                5,
                TimeUnit.SECONDS
        );
    }

}
