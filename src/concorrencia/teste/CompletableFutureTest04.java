package concorrencia.teste;

import concorrencia.dominio.Quote;
import concorrencia.service.StoreServiceWithDiscount;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class CompletableFutureTest04 {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        StoreServiceWithDiscount storeServiceWithDiscount = new StoreServiceWithDiscount();
        searchPricesWithDiscountAsync(storeServiceWithDiscount);
    }

    private static void searchPricesWithDiscount(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();

        List<String> stores = List.of("store 1", "store 2", "store 3", "store 4");

        stores.stream()
                .map(service::getPriceSync)
                .map(Quote::newQuote)
                .map(service::applyDiscount)
                .forEach(System.out::println);
        long end = System.currentTimeMillis();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
    }

    private static void searchPricesWithDiscountAsync(StoreServiceWithDiscount service) {
        long start = System.currentTimeMillis();

        List<String> stores = List.of("store 1", "store 2", "store 3", "store 4");

        List<CompletableFuture<String>> collect = stores.stream()
                // pegando um preço assincrono
                .map(s -> CompletableFuture.supplyAsync(() -> service.getPriceSync(s)))
                //instanciando um novo Quote de String que gero o getprice
                //quando queremos encadear chamadas sincronas e assincrona. O thenApply é usado
                //em funções de mapeamento sincrono. Nesse caso o Quote queremos executa sincrono
                .map(cf -> cf.thenApply(Quote::newQuote))
                //them compose retorna um novo estado de completado com o valor que a gente passa na função
                // você pode utilizar o themCompose de forma assincrona. Isso significa que você vai utiliza a mesma thread q vc uso
                // no supplyAsync acima, será a mesma thread do thenCompose. Ele compoe o primeiro completableFuture
                .map(cf -> cf.thenComposeAsync(quote -> CompletableFuture.supplyAsync(() -> service.applyDiscount(quote))))
                .collect(Collectors.toList());


        collect.stream()
                .map(CompletableFuture::join)
                .forEach(System.out::println);

        long end = System.currentTimeMillis();
        System.out.printf("time passed to searchPricesSync %dms%n", (end - start));
    }

}
