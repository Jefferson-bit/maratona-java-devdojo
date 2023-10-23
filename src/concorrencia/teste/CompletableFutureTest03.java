package concorrencia.teste;

import concorrencia.service.StoreServiceDeprecated;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureTest03 {

    public static void main(String[] args) {
        var storeService = new StoreServiceDeprecated();
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesAsyncCompletableFuture(StoreServiceDeprecated storeService) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("store 1", "store 2", "store 3", "store 4");

        var executor = Executors.newFixedThreadPool(10);
        //aqui podemos troca o comportamento das thread
        //assim elas não são mais definidas pelo framework ForkJoinPoll
        var threadFactory = Executors.newFixedThreadPool(10, runnable ->{
            Thread thread = new Thread(runnable);
            thread.setDaemon(true);
            return thread;
        });

        //aqui estamos executando metodo sincrono de forma assincrona
        //você também pode utilizar um executor customizado no completablefuture
        var collect = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> storeService.getPriceSync(s), threadFactory))
                .collect(Collectors.toList());

        var collect1 = collect.stream().map(CompletableFuture::join)
                .collect(Collectors.toList());


        System.out.println(collect1);
        long end = System.currentTimeMillis();
        executor.shutdown();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
    }

}
