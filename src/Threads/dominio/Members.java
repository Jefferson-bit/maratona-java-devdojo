package Threads.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Members {

    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;


    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
        synchronized (emails) {
            return emails.size();
        }
    }

    public void addMembers(String email) {
        synchronized (this.emails) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionando email na lista");
            this.emails.add(email);
            //notifyAll irá notificar todas as threads que estão em espera, e informa que possui emails
            this.emails.notifyAll();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Verificando se temos e-mails");
        synchronized (this.emails) {
            while (this.emails.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Nao tem email disponivel na lista de entrada, entrando em modo de espera");
                //só podemos chamar o wait, se tivermos o lock do objeto
                this.emails.wait();
            }
            return this.emails.poll();
        }
    }

    public void close() {
        open = false;
        synchronized (this.emails) {
            System.out.println(Thread.currentThread().getName() + " notificando todo mundo que nao estamos pegando email");
            emails.notifyAll();
        }
    }
}
