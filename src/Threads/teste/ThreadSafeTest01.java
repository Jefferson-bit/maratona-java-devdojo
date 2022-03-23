package Threads.teste;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ThreadSafeNames {
    private final List<String> names = Collections.synchronizedList(new ArrayList<>());

    public synchronized void add(String name) {
        names.add(name);
    }

    //tem que tomar cuidado aqui. Apensar de estamor falando q a lista é thread safe
    // que possui os synchronized nos metodos dela
    // a gente sempre tem que olhar um degrau acima. Nossos metodos também precisar estar com modificador synchronized
    // se não, entra no mesmo esquema dos objetos account. teremos uma exceção
    public  void removeFirst() {
        if (names.size() > 0) {
            System.out.println(Thread.currentThread().getName());
            System.out.println(names.remove(0));
        }
    }
}

public class ThreadSafeTest01 {
    public static void main(String[] args) {
        ThreadSafeNames threadSafeNames = new ThreadSafeNames();
        threadSafeNames.add("Junkrat");
        Runnable r = threadSafeNames::removeFirst;
        new Thread(r).start();
        new Thread(r).start();
    }
}