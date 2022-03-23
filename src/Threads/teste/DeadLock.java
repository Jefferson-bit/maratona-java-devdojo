package Threads.teste;

public class DeadLock {


    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        Runnable r1 = () ->{
            synchronized (obj1){
                System.out.println("Thread 1: Segurando lock de 1");
                System.out.println("Thread 1: esperando lock de 2");
                synchronized (obj2){
                    System.out.println("Thread 1: Segurando lock de 2");
                }
            }
        };

        Runnable r2 = () ->{
            synchronized (obj2){
                System.out.println("Thread 2: Segurando lock de 2");
                System.out.println("Thread 2: esperando lock de ");
                synchronized (obj1){
                    System.out.println("Thread 2: Segurando lock de 1");
                }
            }
        };

        new Thread(r1).start();
        new Thread(r2).start();
    }
}
