package concorrencia.completablefuture;

import java.util.concurrent.*;

public class StoreService {

    private static final ExecutorService ex = Executors.newCachedThreadPool();

    public CompletableFuture<Double> getPrincesAsyncCompetableFuture(String storeName) {
        System.out.printf("Getting prices sync for store %s%n", storeName);
        //supplyAsync, crias as thread usando o framework ForJoinPoll
        //ele que toma conta dos encerramento das thread
        return CompletableFuture.supplyAsync(this::priceGenerator);
    }

    public Future<Double> getPrincesAsyncFuture(String storeName) {
        System.out.printf("Getting prices sync for store %s%n", storeName);
        return ex.submit(this::priceGenerator);
    }

    public double getPriceSync(String storeName) {
        System.out.printf("Getting prices sync for store %s%n", storeName);
        return priceGenerator();
    }

    private double priceGenerator() {
        System.out.printf("%s generating price %n", Thread.currentThread().getName());
        delay();
        return ThreadLocalRandom.current().nextInt(1, 500) * 10;
    }


    public static void shutDown() {
        ex.shutdown();
    }

    private void delay() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
