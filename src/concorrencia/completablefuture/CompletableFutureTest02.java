package concorrencia.completablefuture;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class CompletableFutureTest02 {


    public static void main(String[] args) {
        StoreService storeService = new StoreService();
        searchPricesAsyncCompletableFuture(storeService);
    }

    private static void searchPricesAsyncCompletableFuture(StoreService storeService) {
        long start = System.currentTimeMillis();
        List<String> stores = List.of("store 1", "store 2", "store 3", "store 4");

        //dessa forma você ainda tem o mesmo problema de está executando de forma sincrona
        // isso acontece pq as operações intermediarias do stream, são operações lazy
        //isso se aplica tbm a future, então cuidado.
//        var streamLazy = stores.stream()
//                .map(storeService::getPrincesAsyncCompetableFuture)
//                .map(CompletableFuture::join)
//                .collect(Collectors.toList());


        //dessa forma aqui, é como se estivessemos fazendo a msm coisa que tá na classe CompletableFutureTest01
        // estamos separando a chamada do completableFuture do join
        // ou seja, quando ele executa a função abaixo, ele já vai ter passado por todos os getPrice
        var streamAsync = stores.stream()
                .map(storeService::getPrincesAsyncCompetableFuture)
                .collect(Collectors.toList());

        var collect = streamAsync.stream()
                .map(CompletableFuture::join)
                .collect(Collectors.toList());

        long end = System.currentTimeMillis();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
        StoreService.shutDown();
    }

}
