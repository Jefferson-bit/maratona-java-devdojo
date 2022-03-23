package concorrencia.service;

import concorrencia.dominio.Members;

public class EmailDeliveryService implements Runnable {

    private final Members members;

    public EmailDeliveryService(Members members) {
        this.members = members;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " Iniciando entrega de e-mail");
        while (members.isOpen() || members.pendingEmails() > 0) {
            try {
                String email = members.retrieveEmail();
                if (email == null) continue;
                System.out.println(threadName + " Enviando email para " + email);
                Thread.sleep(2000);
                System.out.println(threadName + " enviou com sucesso o e-mail " + email);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Todos os emails foram enviado com sucesso");
    }
}
