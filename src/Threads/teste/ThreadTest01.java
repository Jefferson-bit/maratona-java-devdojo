package Threads.teste;


//Thread tem duas definições: Pode ser um objeto(Classe Thread)
// e temos um processo(Linha de execução)
// BASICAMente não temos tanto controle sobre a mesma
// temos Threads do tipo DAEMON e USER
//USER: java encerra todos os programas quando threads do tipo user são terminada
//DAEMON: elas não tem tanta prioridade. Por exemplo threads responsaveis por fazer limpeza de memoria
//vou usar o garbage collector, que remove/limpa os objetos. A diferença é que se a thread user finalizar
//a daemon é finalizada tbm, mesmo que o processo não for concluído
public class ThreadTest01 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        Thread t1 = new Thread( new ThreadExampleRunnable('A'), "T1A");
        Thread t2 = new Thread( new ThreadExampleRunnable('B'), "T2B");
        Thread t3 = new Thread( new ThreadExampleRunnable('C'), "T3C");
        Thread t4 = new Thread( new ThreadExampleRunnable('D'), "T4D");
        //run ele starta na mesma thread, ou seja a main
//        t1.run();
        //start ele abre uma nova thread, deixa de ser a main
//        t1.start();

        //prioridade 10 isso significa que estamos solicitando ao scheduled pra ele da uma prioridade maxima a thread t4
        // significa que vai ter prioridade? NÃO, não é garantido. Isso depende muito a implementação da JVM

        t4.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        System.out.println("################################### " + Thread.currentThread().getName());
        /*
            estado das threads
                         waiting/blocking
                       //                \\
            new ---> runnable -----> running ----> dead


         */
    }
}


class ThreadExampleRunnable implements Runnable{

    private char c;

    public ThreadExampleRunnable(char c) {
        this.c = c;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        for (int i = 0; i < 300; i++) {
            System.out.print(c);
            if (i % 100 == 0)
                System.out.println();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


class ThreadExemplo extends Thread {
    private char c;

    public ThreadExemplo(char c) {
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
    }
}