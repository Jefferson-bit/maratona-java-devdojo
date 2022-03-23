package Threads.teste;


class ThreadExampleRunnable2 implements Runnable {

    private String c;

    public ThreadExampleRunnable2(String c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 300; i++) {
            System.out.print(c);
            if (i % 100 == 0)
                System.out.println();

        }
        //yield é um método que diz pra thread que está em execução, da uma pausa
        //basicamente é dizer pra dar a vez pra outras pessoas
        // a propria thread decide isso. É garantido? NÃO, é apenas uma dica pra scheduler
        // porém o scheduler pode simplesmente ignora-lo
        Thread.yield();
    }
}

public class ThreadTest02 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new ThreadExampleRunnable2("KA"));
        Thread t2 = new Thread(new ThreadExampleRunnable2("ME"));


        t1.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        //join bloqueia a thread, impossibilitando  a t2 startar enquanto ela n finalziar
        t1.join();
        t2.start();

    }
}
