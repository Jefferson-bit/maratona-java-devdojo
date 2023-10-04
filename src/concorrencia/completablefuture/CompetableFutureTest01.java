package concorrencia.completablefuture;

import java.util.concurrent.*;

public class CompetableFutureTest01 {

    public static void main(String[] args) {

        StoreService storeService = new StoreService();
//        searchPricesSync(storeService);
//        searchPricesAsyncFuture(storeService);
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesSync(StoreService storeService) {
        long start = System.currentTimeMillis();
        System.out.println(storeService.getPriceSync("Store 1"));
        System.out.println(storeService.getPriceSync("Store 2"));
        System.out.println(storeService.getPriceSync("Store 3"));
        System.out.println(storeService.getPriceSync("Store 4"));
        long end = System.currentTimeMillis();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
    }


    //future apesar de ser bom, ele possui algumas limitações:
    //ele não consegue ser manualmente completado, exemplo: se uma api está down, vc precisa trabalha com timeout
    private static void searchPricesAsyncFuture(StoreService storeService) {
        //não é recomendado usar o get pq estamos criado a thread e pedindo pra ela pega
        //ou seja, ela fica de forma sincrona
        //storeService.getPrincesAsyncFuture("Store 1").get();
        long start = System.currentTimeMillis();
        Future<Double> princesAsyncFuture2 = storeService.getPrincesAsyncFuture("Store 1");
        Future<Double> princesAsyncFuture1 = storeService.getPrincesAsyncFuture("Store 2");
        Future<Double> princesAsyncFuture3 = storeService.getPrincesAsyncFuture("Store 3");
        Future<Double> princesAsyncFuture4 = storeService.getPrincesAsyncFuture("Store 4");
        try {
            System.out.println(princesAsyncFuture2.get());
            System.out.println(princesAsyncFuture1.get());
            System.out.println(princesAsyncFuture3.get());
            System.out.println(princesAsyncFuture4.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
        StoreService.shutDown();
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {;
        long start = System.currentTimeMillis();
        CompletableFuture<Double> princesAsyncFuture2 = storeService.getPrincesAsyncCompetableFuture("Store 1");
        CompletableFuture<Double> princesAsyncFuture1 = storeService.getPrincesAsyncCompetableFuture("Store 2");
        CompletableFuture<Double> princesAsyncFuture3 = storeService.getPrincesAsyncCompetableFuture("Store 3");
        CompletableFuture<Double> princesAsyncFuture4 = storeService.getPrincesAsyncCompetableFuture("Store 4");
        try {
            //aqui não precisamos da o shutdown, ele para por conta propria
            System.out.println(princesAsyncFuture1.get());
            System.out.println(princesAsyncFuture2.get());
            System.out.println(princesAsyncFuture3.get());
            System.out.println(princesAsyncFuture4.get());
            // a diferença do join para o get é que você não precisa trata as exceções
//            System.out.println(princesAsyncFuture4.join());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
        StoreService.shutDown();
    }
}