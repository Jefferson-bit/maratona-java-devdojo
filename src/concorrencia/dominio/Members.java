package concorrencia.dominio;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Members {

    private final Queue<String> emails = new ArrayBlockingQueue<>(10);
    private boolean open = true;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition condition = lock.newCondition();

    public boolean isOpen() {
        return open;
    }

    public int pendingEmails() {
            try {
                lock.lock();
                return emails.size();
            }finally {
                lock.unlock();
            }
    }

    public void addMembers(String email) {
        try {
            lock.lock();
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " adicionando email na lista");
            this.emails.add(email);
            //notifyAll irá notificar todas as threads que estão em espera, e informa que possui emails
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String retrieveEmail() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Verificando se temos e-mails");
        try {
            lock.lock();
            while (this.emails.size() == 0) {
                if (!open) return null;
                System.out.println(Thread.currentThread().getName() + " Nao tem email disponivel na lista de entrada, entrando em modo de espera");
                //só podemos chamar o wait, se tivermos o lock do objeto
                this.condition.await();
            }
            return this.emails.poll();
        }finally {
            lock.unlock();
        }
    }

    public void close() {
        open = false;
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " notificando todo mundo que nao estamos pegando email");
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
}
