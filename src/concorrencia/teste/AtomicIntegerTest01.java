package concorrencia.teste;


import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Count {
    private int count;

    //no caso do count, a contagem vai ser diferente já que temos duas threads
    // entrando no método increment. Quando esse código vai pra uma linguagem de maquina,(count++) ele tera mais de uma linha
    //n temos controle já que o processador que toma conta. Teriamos que usar synchronized pra uma thread pegar o lock e finalizar
    // sua execução. Porém isso custa na perfomance, pq só temos uma thread acessando esse método e estamos trabalhando com linguagem de baixo nivel

    //atomicInteger foi criado para fazer contagens de forma atomica, e n precisamos nos preocupar com o lock
    // pq ele utiliza um mecanismo chamado compare And Swap
    private AtomicInteger atomicInteger = new AtomicInteger();

    //diferença entre synchronized e o ReentrantLock
    // quando usamos synchronized o lock é totalmente gerenciado pela JVM
    // quando usamos essa classe ReentrantLock temos algumas vantagens
    //no construtor de ReetrantLock, o fair se vc de um true nele, ele vai tentar passar
    // o lock pra thread q está esperando a mais tempo
    // a gente pode tentar obter o lock com o lock.tryLock
    //também pdemos interromper a thread q está esperando pelo lock
    // aqui estamos trabalhando manualmente com o lock, então a tendência é que o codigo fique feio
    private Lock lock = new ReentrantLock();

    void increment() {
        //possa seer q aq mno meio haja uma exceção
        try {
            //pega o lock
            lock.lock();
            count++;
            atomicInteger.incrementAndGet();

        } finally {
            //libera o lock
            // pode ser q haja uma exceção aq também. Uma thread tentar soltar o lock, sendo q ela n tem o lock
            lock.unlock();
        }
    }

    public int getCount() {
        return count;
    }

    public AtomicInteger getAtomicInteger() {
        return atomicInteger;
    }
}

public class AtomicIntegerTest01 {


    public static void main(String[] args) throws InterruptedException {
        Count count = new Count();
        Runnable r = () -> {
            for (int i = 0; i < 10000; i++) {
                count.increment();
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count.getCount());
        System.out.println(count.getAtomicInteger());
    }
}
