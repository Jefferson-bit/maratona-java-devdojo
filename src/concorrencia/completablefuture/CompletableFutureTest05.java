package concorrencia.completablefuture;

import concorrencia.dominio.Quote;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest05 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        StoreServiceWithDiscount storeServiceWithDiscount = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(storeServiceWithDiscount);
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();

        List<String> stores = List.of("store 1", "store 2", "store 3", "store 4");

        var completableFutures = stores.stream()
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                .map(cf -> cf.thenApply(Quote::newQuote))
                .map(cf -> cf.thenCompose(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                //thenAccept realiza uma ação
                .map(cf -> cf.thenAccept(store -> System.out.printf("%s finished in %d%n", store, (System.currentTimeMillis() - start))))
                .toArray(CompletableFuture[]::new);

        Arrays.stream(completableFutures).map(CompletableFuture::join)
                .forEach(System.out::println);
        //retorna um novo completableFuture: Digamos que você está fazendo um calculo pesado, efetuando 10 ou 20 chamadas
        //assincronas e vc precisa saber quando que todas essas chamdasa terminaram. É só passar todos os completablefuture
        //para ele. então quando todos terminarem independente de ter exceção ou não, ele vai termina de forma excepcional
        // vc tera uma flag dizendo que to_do mundo termino
        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.allOf(completableFutures);
        //AnyOf é um completablefuture que considera terminado quando uma das tarefas finaliza
        //no allOf ele printas todas as threads, já no anyOf ele printa somente uma e acaba.
        // é util quando vc tem uma cotação de preço e quer saber a cotação do dolar e digamos q vc vai fazer uma chamda
        // para 5 lugares e se vc sempre tiver o msm resultado e para vc só interessa 1 resultado, então vc vai  e finaliza
        // pq os outros 4 resultado não importa pra vc
        var anyOfCompletableFuture = CompletableFuture.anyOf(completableFutures);
//        voidCompletableFuture.join();
        System.out.printf("Finihsed? %b", voidCompletableFuture.isDone());

        long end = System.currentTimeMillis();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
    }

}
